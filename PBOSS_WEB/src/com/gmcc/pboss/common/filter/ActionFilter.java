package com.gmcc.pboss.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.bean.URLAuthority;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.context.ContextUtil;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.dictionary.JSONKey;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

/**
 * ���˹�˾��������ҵ��
 * 
 * @author tangzhu
 * @date 2009-8-4 ������Ŀ�� ����ģ�飺 
 * �������������������м��ص��п⣬�ж�ÿ�������Ƿ���Ҫ��¼��
 */
public class ActionFilter extends BaseFilter {
	protected static final Log logger = LogFactory.getLog(ActionFilter.class);
	
	/**
	 * ��ʼ��ʱ��ʼ���������ļ���
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			FileConfigAdapter.init();
			//@@ yuwenjun 20100301��ʹ�ú�����ļ�
			//PNRGLoader.init(FileConfigAdapter.getCommonPath());
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Load Exception ");
		}
		super.init(filterConfig);
	}
	/**
	 * ����Ĭ�ϱ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void setDefEncoding(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding(HttpDictionary.ENCODE);
			response.setCharacterEncoding(HttpDictionary.ENCODE);
	}
	
	/**
	 * ������jQuery��ajax�������ת��UTF-8��GBK
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void encodeRequest(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException{
		//����jQuery��ajax����
        String requestedWith = req.getHeader("x-requested-with");   
//      String type = req.getContentType();   
        if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)   
        		//@@ȡ����ContentType�����ƣ��������XMLHttpRequest����ת��Ϊ UTF-8
//                && null != type && "application/x-www-form-urlencoded".equals(type) 
                ) {
            logger.info("This's ajax post.set encode is UTF-8.");   
            req.setCharacterEncoding("UTF-8");   
            resp.setCharacterEncoding("UTF-8");   
            req.getParameterMap();
        }
		setDefEncoding(req,resp);
	}
	/**
	 * ����uri����δ��¼����URL
	 * @param uri
	 * @param urlAuthority
	 * @return
	 */
	private String getUnloginConfigPath(String uri, URLAuthority urlAuthority){
		String configPath = "";
		if (uri.endsWith("jsp")) {
			configPath = urlAuthority.getUnLoginJSP();
		} 
		else {
			configPath = urlAuthority.getUnLoginAction();
		}
		return configPath;
	}
	
	/**
	 * ����
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
				throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//ת��
		encodeRequest(req, resp);

		//�������������м��ص��п�
		setSessionFactoryContext(req, resp);
		
		//����uri
		String uri = req.getRequestURI();
		logger.info("In filter, request uri: " + uri);
		
		//���ʵ�¼JSP��ֱ�ӷ���action
		if(uri.equals(LOGIN_JSP)){
			this.redirectURL(LOGIN_DO, resp, req);
		}
		
		//��ȡ������Ϣ
		URLAuthority urlAuthority = ConfigUtil.getURLAuthority();
		//���õ�¼������
		String path = getUnloginConfigPath(uri, urlAuthority);
		
		boolean isAjax = isAjaxRequest(req);
		boolean isOnline = isOnline(req);
		boolean isNeedLogin = !isEqualsConfig(uri, path, -1);
		
		//�û�������
		if(!isOnline ){
			
			StringBuffer info = new StringBuffer();
			info.append("Not login or overtime this uri is need login ? ")
				.append(isNeedLogin);
			logger.info(info.toString());
			
			if(isNeedLogin){
				// ����ΪAJAX JSON
				if (isAjax) {
					writeJSONRsp(resp, ServiceRetCode.NOT_LOGIN, INDEX);
					return;
				} 
				else {
					String queryString = req.getQueryString();
					if (StringUtils.isNotBlank(queryString)) uri += "?"+queryString;
					setSessionAttribute(req,HttpDictionary.BACK_URL, uri);
					redirectURL(LOGIN, resp, req);
					return;
				}
			}
		}
		
		//�û����ߣ��Ҹ�������Ҫ��¼
		else if(isNeedLogin){
			LoginMember member = this.getMember(req);
			
			//�õ��ý�ɫ��ʹ�õ�URL
			int role = member.getIsnet().intValue();
			String url = getURLAuthorityByRole(role, urlAuthority);
			
			//�뵱ǰURI�ȶ�
			boolean isRight = isEqualsConfig(uri, url, role);
			StringBuffer info = new StringBuffer();
			info.append("WayId[").append(member.getWayid()).append(']');
			info.append("OfficeTel[").append(member.getOfficetel()).append(']');
			info.append("Role[").append(member.getRoleName()).append(']')
				.append(" has right use this URL[").append(isRight).append(']');
			logger.info(info.toString());
			
			//û��Ȩ��
			if(!isRight){
				// ����ΪAJAX JSON
				if (isAjax) {
					writeJSONRsp(resp, ServiceRetCode.NOT_AUTHOR, getBackURLByRole(role));
					return;
				}
				else {
					req.setAttribute(HttpDictionary.MESSAGE, ConfigUtil.getMessage(ServiceCode.COMMON, ServiceRetCode.NOT_AUTHOR));
					req.setAttribute(HttpDictionary.BACK_URL, getBackURLByRole(role));
					setReplyPage(req, resp, MESSAGE);
					return;
				}
			}
			
		}

		//ע�� Request����
		ContextUtil.getContext().setRequest(request);
		super.doFilter(request, response, chain);
	}
	/**
	 * ���ݽ�ɫ���ص�ַ
	 * @param rolse
	 * @return
	 */
	private String getBackURLByRole(int role){
		String url = "";
		switch(role){
			case Role.SHOP_ASSISTANT : 
				url = INDEX;
				break;
			case Role.SHOP_MASTER:
				url = INDEX;
				break;
			case Role.MISSIONER:
				url = MISSIONER_PAGE;
				break;
			case Role.DELIVERY_MAN:
				url = DELIVERY_PAGE;
				break;
			case Role.MANAGER:
				url = MANAGER_PAGE;
				break;
			case Role.GD_MANAGER:
				url = GD_MANAGER_PAGE;
				break;
			case Role.CITY_MANAGER:
				url = CITY_MANAGER_PAGE;
				break;
		}
		return url;
	}
	/**
	 * �ȵ���ɫ����
	 * @param rolse
	 * @return
	 */
	private String getURLAuthorityByRole(int role, URLAuthority urlAuthority){
		String url = "";
		switch(role){
			case Role.SHOP_ASSISTANT : 
				url = urlAuthority.getShopAssistant();
				break;
			case Role.SHOP_MASTER:
				url = urlAuthority.getShopMaster();
				break;
			case Role.MISSIONER:
				url = urlAuthority.getMissioner();
				break;
			case Role.DELIVERY_MAN:
				url = urlAuthority.getDeliveryMan();
				break;
			case Role.MANAGER:
				url = urlAuthority.getManager();
				break;
			case Role.GD_MANAGER:
				url = urlAuthority.getGdmanager();
				break;
			case Role.CITY_MANAGER:
				url = urlAuthority.getCitymanager();
				break;
		}
		return url;
	}
	/**
	 * ��һ�������ض���
	 * @param url
	 */
	private void redirectURL(String url, HttpServletResponse resp,HttpServletRequest req)throws IOException,ServletException{
		logger.info("Redirect for this response: " + url);
		resp.sendRedirect(url);
	}
	/**
	 * ��AJAX���󷵻�JSON����
	 */
	private void writeJSONRsp(HttpServletResponse resp,int retCode, String backUrl){
		
		logger.info("Request by AJAX,write JSON for response");
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(retCode);
		result.setMessage(ConfigUtil.getMessage(ServiceCode.COMMON, retCode));
		result.setRetObject(backUrl);

		this.writeJSON(result, resp);
	}
	/**
	 * �ж������ַ�Ƿ������õĵ�ַһ��
	 * 
	 * @param uri
	 * @param path
	 * @return
	 */
	private boolean isEqualsConfig(String uri, String path,int role) {
		boolean yes = false;
		String[] t = path.split(Regex.UPRIGHT);
		for (int i = 0; i < t.length; i++) {
			int allLoaction = t[i].indexOf("*");
			//System.out.println(t[i] + " "+(role > 0 && role == Role.SHOP_MASTER && t[i].equals(DELIVERY_PAGE)));
			if(t[i].equals(uri) || t[i].equals("/*")) {
				yes = true;
				break;
			}else if(allLoaction>0){
				String upPath = t[i].substring(0,allLoaction);
				if (uri.indexOf(upPath)==0){
					yes = true;
					break;
				}//if
			}
		}
		//�жϵ�������������Ϊ�����̵���ҳ
		if(role > 0 && role == Role.SHOP_MASTER ){
			//��ȡ�����̵���Ϣ

			URLAuthority urlAuthority = ConfigUtil.getURLAuthority();
			String deliveryAuthority = urlAuthority.getDeliveryMan();

			String[] daDtl  = deliveryAuthority.split(Regex.UPRIGHT);
			for (int i = 0; i < daDtl.length; i++) {
				int allLoaction = daDtl[i].indexOf("*");
				//System.out.println(t[i] + " "+(role > 0 && role == Role.SHOP_MASTER && t[i].equals(DELIVERY_PAGE)));
				if(daDtl[i].equals(uri)) {
					yes = false;
					break;
				}else if(allLoaction>0){
					String upPath = daDtl[i].substring(0,allLoaction);
					if (uri.indexOf(upPath)==0){
						yes = false;
						break;
					}//if
				}
			}
		} 
		return yes;
	}
	/**
	 * дJSON����ҵ�����
	 * 
	 * @param serviceResult
	 * @return
	 */
	private void writeJSON(ServiceResult serviceResult, HttpServletResponse resp) {

		JSONObject jsonObject = new JSONObject();
		// �Ƿ�ɹ�
		jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult.isSuccess()));
		// ������
		jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult.getRetCode()));
		// ������Ϣ
		jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());

		jsonObject.put(JSONKey.OBJECT, serviceResult.getRetObject());
		try {
			// resp.setContentType("GBK");
			resp.setContentType("text/plain;charset=" + HttpDictionary.ENCODE);
			resp.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * ת������
	 * 
	 * @param request
	 * @param response
	 * @param replyPage
	 */
	private void setReplyPage(HttpServletRequest request, HttpServletResponse response, String replyPage) {
		logger.info("Reply page to " + replyPage);
		try {
			//Struts2.0-Struts2.1.2
			//RequestDispatcher rd = this.getServletContext().getRequestDispatcher(response.encodeURL(replyPage));
			
			javax.servlet.ServletContext sc = this.getSession(request).getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(response.encodeURL(replyPage));			
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �û���¼�ɹ����л�SessionFactory
	 * δ��¼Ĭ�Ϲ�����
	 * @param request
	 * @param response
	 */
	private void setSessionFactoryContext(HttpServletRequest request, HttpServletResponse response) {
		// ���ݵ��в�ѯ���п�
		HttpSession session = request.getSession(true);
		LoginMember member = (LoginMember) session.getAttribute(HttpDictionary.USER_NAME);
		if (member != null)
			SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
	}
}
