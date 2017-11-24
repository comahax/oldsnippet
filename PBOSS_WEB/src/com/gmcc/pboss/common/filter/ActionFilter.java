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
 * 从兴公司电子渠道业务部
 * 
 * @author tangzhu
 * @date 2009-8-4 所属项目： 所属模块： 
 * 描述：过滤器，按地市加载地市库，判断每个请求是否需要登录。
 */
public class ActionFilter extends BaseFilter {
	protected static final Log logger = LogFactory.getLog(ActionFilter.class);
	
	/**
	 * 初始化时开始加载配置文件。
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			FileConfigAdapter.init();
			//@@ yuwenjun 20100301不使用号码段文件
			//PNRGLoader.init(FileConfigAdapter.getCommonPath());
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Load Exception ");
		}
		super.init(filterConfig);
	}
	/**
	 * 设置默认编码
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
	 * 对所有jQuery的ajax请求进行转码UTF-8到GBK
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void encodeRequest(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException{
		//所有jQuery的ajax请求
        String requestedWith = req.getHeader("x-requested-with");   
//      String type = req.getContentType();   
        if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)   
        		//@@取消对ContentType的限制，针对所有XMLHttpRequest请求都转码为 UTF-8
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
	 * 根据uri返回未登录配置URL
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
	 * 过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
				throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//转码
		encodeRequest(req, resp);

		//过滤器，按地市加载地市库
		setSessionFactoryContext(req, resp);
		
		//请求uri
		String uri = req.getRequestURI();
		logger.info("In filter, request uri: " + uri);
		
		//访问登录JSP就直接访问action
		if(uri.equals(LOGIN_JSP)){
			this.redirectURL(LOGIN_DO, resp, req);
		}
		
		//读取配置信息
		URLAuthority urlAuthority = ConfigUtil.getURLAuthority();
		//不用登录的配置
		String path = getUnloginConfigPath(uri, urlAuthority);
		
		boolean isAjax = isAjaxRequest(req);
		boolean isOnline = isOnline(req);
		boolean isNeedLogin = !isEqualsConfig(uri, path, -1);
		
		//用户不在线
		if(!isOnline ){
			
			StringBuffer info = new StringBuffer();
			info.append("Not login or overtime this uri is need login ? ")
				.append(isNeedLogin);
			logger.info(info.toString());
			
			if(isNeedLogin){
				// 请求为AJAX JSON
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
		
		//用户在线，且该请求需要登录
		else if(isNeedLogin){
			LoginMember member = this.getMember(req);
			
			//得到该角色能使用的URL
			int role = member.getIsnet().intValue();
			String url = getURLAuthorityByRole(role, urlAuthority);
			
			//与当前URI比对
			boolean isRight = isEqualsConfig(uri, url, role);
			StringBuffer info = new StringBuffer();
			info.append("WayId[").append(member.getWayid()).append(']');
			info.append("OfficeTel[").append(member.getOfficetel()).append(']');
			info.append("Role[").append(member.getRoleName()).append(']')
				.append(" has right use this URL[").append(isRight).append(']');
			logger.info(info.toString());
			
			//没有权限
			if(!isRight){
				// 请求为AJAX JSON
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

		//注入 Request对象
		ContextUtil.getContext().setRequest(request);
		super.doFilter(request, response, chain);
	}
	/**
	 * 根据角色返回地址
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
	 * 等到角色编码
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
	 * 对一般请求重定向
	 * @param url
	 */
	private void redirectURL(String url, HttpServletResponse resp,HttpServletRequest req)throws IOException,ServletException{
		logger.info("Redirect for this response: " + url);
		resp.sendRedirect(url);
	}
	/**
	 * 对AJAX请求返回JSON对象
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
	 * 判断请求地址是否与配置的地址一致
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
		//判断店主条件，不能为配送商的主页
		if(role > 0 && role == Role.SHOP_MASTER ){
			//提取配送商的信息

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
	 * 写JSON对象，业务出错
	 * 
	 * @param serviceResult
	 * @return
	 */
	private void writeJSON(ServiceResult serviceResult, HttpServletResponse resp) {

		JSONObject jsonObject = new JSONObject();
		// 是否成功
		jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult.isSuccess()));
		// 返回码
		jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult.getRetCode()));
		// 描述信息
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
	 * 转发请求
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
	 * 用户登录成功后切换SessionFactory
	 * 未登录默认公共库
	 * @param request
	 * @param response
	 */
	private void setSessionFactoryContext(HttpServletRequest request, HttpServletResponse response) {
		// 根据地市查询地市库
		HttpSession session = request.getSession(true);
		LoginMember member = (LoginMember) session.getAttribute(HttpDictionary.USER_NAME);
		if (member != null)
			SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
	}
}
