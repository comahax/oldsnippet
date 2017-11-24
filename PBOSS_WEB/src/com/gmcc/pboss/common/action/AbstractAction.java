package com.gmcc.pboss.common.action;

import java.io.OutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.gmcc.pboss.common.bean.BaseModel;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.bean.SMSRndCode;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.dictionary.JSONKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class AbstractAction extends ActionSupport implements
		Preparable {

	/** ��ҳ */
	public static final String INDEX = "/";
	/** ��ҳ Action*/
	public static final String INDEXACTION = "/index.do";
	/** ������ ҳ�� */
	public static final String DELIVERY_PAGE = "/delivery/query.do";
	/** ������Ա ҳ��*/
	public static final String MANAGER_PAGE = "/managerView/nodeList.do";
	
	/** ʡ��˾����Ա��¼*/
	public static final String GD_MANAGER_PAGE = "/gdView/nodeGdList.do";
	/** �й�˾����Աҳ��*/
	public static final String CITY_MANAGER_PAGE = "/cityView/nodeCityList.do";
	
	/**�ƹ�רԱ ҳ��*/
	public static final String MISSIONER_PAGE = "/missioner/recommendSuccess.do";
	
	/** ��¼ҳ�� */
	public static final String LOGIN = "/tologin.do";
	/** ��Ϣҳ�� */
	public static final String MESSAGE = "/message.jsp";
	
	public static final char[] KEYWORD_ENTER = { 13, 10 }; // ����
	public static final String FIELD_SEPARATOR_REGEX = "|"; // "|"

	/** ��ʾ��Ϣ */
	private String message;

	private String title;
	private Long id;
	private Integer pageNo;
	private Integer pageSize;
	/**
	 * ��ҳ��ѯ��ʶ
	 */
	private Integer pageQuery;
	private Condition cond;
	private int ajaxPost;

	protected static final Log logger = LogFactory.getLog(AbstractAction.class);

	/**
	 * ���ؽ��
	 */
	private QueryResult result;

	/**
	 * ����Ҫ������д,���ڻص� QueryParameter ����
	 */
	public abstract QueryParameter getParameter();

	/**
	 * ���Cookie
	 */
	public void addCookie(Cookie cookie) {
		getResponse().addCookie(cookie);
	}

	/**
	 * ��ȡCookie����
	 * 
	 * @return
	 */
	public Cookie[] getCookies() {
		return getRequest().getCookies();
	}

	/**
	 * Ĭ��List����
	 * 
	 * @return
	 */
	public String doList() {
		return execute();
	}

	/**
	 * Ĭ��Edit����
	 * 
	 * @return
	 */
	public String doEdit() {
		return execute();
	}

	/**
	 * Ĭ��Remove����
	 * 
	 * @return
	 */
	public String doRemove() {
		return execute();
	}

	/**
	 * Ĭ��Load����
	 * 
	 * @return
	 */
	public String doLoad() {
		return execute();
	}

	/**
	 * ��ĳ��������name������session��
	 * 
	 * @param name
	 * @param obj
	 */
	public void setSessionAttribute(String name, Object obj) {
		getSession().setAttribute(name, obj);
	}

	/**
	 * ��Session��ȡ����name�����Ķ���
	 * 
	 * @param name
	 * @return
	 */
	public Object getSessionAttribute(String name) {
		return getSession().getAttribute(name);
	}

	/**
	 * ��Session��ɾ����name�����Ķ���
	 * 
	 * @param name
	 */
	public void removeSessionAttribute(String name) {
		getSession().removeAttribute(name);
	}

	/**
	 * ��ĳ��������name������request��
	 * 
	 * @param name
	 * @param obj
	 */
	public void setRequestAttribute(String name, Object obj) {
		this.getRequest().setAttribute(name, obj);
	}

	/**
	 * ��Request��ȡ����name�����Ķ���
	 * 
	 * @param name
	 * @return
	 */
	public Object getRequestAttribute(String name) {
		return getRequest().getAttribute(name);
	}

	/**
	 * ��Request��ɾ����name�����Ķ���
	 * 
	 * @param name
	 */
	public void removeRequestAttribute(String name) {
		getRequest().removeAttribute(name);
	}

	/**
	 * ��ȡ��Ȼ·���ķ���
	 * 
	 * @return
	 */
	public String getLocation() {
		// �滻��վ·��
		String ctx = this.getRequest().getContextPath();
		// String rtn = (String)PageLoction.PAGELOCTION.get(getTitle());
		String rtn = ConfigUtil.getPageLocation(getTitle());
		rtn = rtn.replaceAll("\\$\\{ctx\\}", ctx);

		return rtn;
	}

	/**
	 * ��ȡҳ��������Ϣ
	 * 
	 * @return
	 */
	public PageInfo getPageInfo() {
		String title = getTitle();
		if (StringUtils.isNotEmpty(title)) {
			return (PageInfo) PageLoction.allPageInfo.get(title);
		}
		return new PageInfo("", "", "");
	}

	/**
	 * ����ҳ����ʾ��Ч��
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}

	public List getsetCols() {
		// ������ʵ��
		return null;
	}

	/**
	 * ֱ�����.
	 * 
	 * @param text
	 * @param contentType
	 *            ���ݵ�����.html,text,xml��ֵ����jsonΪ"text/x-json;charset=GBK"
	 */
	protected void render(String text, String contentType) {
		try {
			HttpServletResponse response = getResponse();
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * ֱ��������ַ���.
	 */
	protected void renderText(String text) {
		render(text, "text/plain;charset=" + HttpDictionary.ENCODE);
	}

	/**
	 * ֱ�������HTML.
	 */
	protected void renderHtml(String text) {
		render(text, "text/html;charset=" + HttpDictionary.ENCODE);
	}

	/**
	 * ֱ�������XML.
	 */
	protected void renderXML(String text) {
		render(text, "text/xml;charset=" + HttpDictionary.ENCODE);
	}

	/**
	 * �ж��Ƿ��¼
	 */
	public ServiceResult isLogin() {
		ServiceResult result = new ServiceResult();
		boolean isLogin = true;

		if (this.getMember() == null) {
			isLogin = false;
			result.setRetCode(ServiceRetCode.NOT_LOGIN);
			result.setMessage(ConfigUtil.getMessage(ServiceCode.COMMON,
					ServiceRetCode.NOT_LOGIN));
		}

		result.setSuccess(isLogin);
		return result;
	}

	/**
	 * ��֤ͼ��У����
	 * 
	 * @param inputCode
	 *            �û�����ֵ
	 * @return
	 */
	public ServiceResult validateImageCode(String inputCode) {
		ServiceResult result = new ServiceResult();
		int retCode = ServiceRetCode.FAIL_ICODE;
		boolean isSuccess = false;

		Object obj = getSessionAttribute(HttpDictionary.ICODE_NAME);
		if (!CommonUtil.isEmptyOrNull(inputCode) && obj != null) {
			logger.info("ValidateImageCode InputCode[" + inputCode
					+ "] SaveCode[" + obj + "]");
			if (inputCode.equalsIgnoreCase((String) obj)) {
				isSuccess = true;
				retCode = ServiceRetCode.SUCCESS;
			}
		}
		removeSessionAttribute(HttpDictionary.ICODE_NAME);
		result.setRetCode(retCode);
		result.setSuccess(isSuccess);
		result.setMessage(ConfigUtil.getMessage(ServiceCode.COMMON, retCode));
		return result;
	}

	/**
	 * ��֤�������У����
	 * 
	 * @param inputCode
	 *            �û�����ֵ
	 * @return
	 */
	public ServiceResult validateSMSRndCode(String inputCode) {
		int retCode = ServiceRetCode.FAIL_ICODE;
		boolean isSuccess = false;

		// //<TEMP>��ʱĬ��Ϊ123456<TEMP>
		if (inputCode.equals("123456")) {
			isSuccess = true;
			retCode = ServiceRetCode.SUCCESS;
		} else {
			Object obj = getSessionAttribute(HttpDictionary.SMS_CODE_NAME);
			if (!CommonUtil.isEmptyOrNull(inputCode) && obj != null) {
				logger.info("ValidateSMSRndCode InputCode[" + inputCode + "]");

				SMSRndCode smsRndCode = (SMSRndCode) obj;
				List codeList = smsRndCode.getCodeList();
				// <TEMP>��ʱĬ��Ϊ123456<TEMP>
				if (codeList.contains(inputCode)) {
					isSuccess = true;
					retCode = ServiceRetCode.SUCCESS;
				}
			}
		}
		removeSessionAttribute(HttpDictionary.SMS_CODE_NAME);
		return orgServiceResult(retCode, isSuccess);
	}

	/**
	 * ����ServiceResult����
	 * 
	 * @param retCode
	 * @param isSuccess
	 * @return
	 */
	public ServiceResult orgServiceResult(int retCode, boolean isSuccess) {
		ServiceResult result = new ServiceResult();
		result.setRetCode(retCode);
		result.setSuccess(isSuccess);
		result.setMessage(ConfigUtil.getMessage(ServiceCode.COMMON, retCode));

		return result;
	}

	/**
	 * �����쳣��Ϣ
	 * 
	 * @param msg
	 */
	public void writeJSONError(String msg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(false));
		jsonObject.put(JSONKey.MESSAGE, msg);
		renderHtml(jsonObject.toString());
	}

	/**
	 * дPage JSON����
	 * 
	 * @param list
	 *            Ҫд�Ķ���
	 */
	/*
	 * ��ʱ���� public void writeJSONData(QueryResult result) { try { //
	 * Assert.notEmpty(args); List dataList = result.getData(); Page page =
	 * result.getPage(); JSONObject jsonObject = new JSONObject(); //�ܼ�¼��
	 * jsonObject.put("totalRecords", Integer.valueOf(page.getRows()) ); //��ҳ��
	 * jsonObject.put("totalPage", Integer.valueOf(page.getNumbers()) ); //��ǰҳ
	 * jsonObject.put("current", Integer.valueOf(page.getCurrent()) ); //ҳ������
	 * jsonObject.put("data", JSONArray.fromObject(dataList));
	 * renderHtml(jsonObject.toString()); } catch (Exception e) {
	 * writeJSONError(e.getMessage()); } }
	 */
	/**
	 * дJSON����
	 * 
	 * @param list
	 *            Ҫд�Ķ���
	 */
	/*
	 * ��ʱ���� public void writeJSONData(List list) { try { //
	 * Assert.notEmpty(args); // List dataList = new java.util.ArrayList();
	 * JSONObject jsonObject = new JSONObject(); jsonObject.put("totalRecords",
	 * new Long(list.size())); jsonObject.put("data",
	 * JSONArray.fromObject(list)); renderHtml(jsonObject.toString()); } catch
	 * (Exception e) { writeJSONError(e.getMessage()); } }
	 */

	/**
	 * дJSON���� - ����ΪServiceResult
	 * 
	 * @param serviceResult
	 */
	public void writeJSONServiceData(ServiceResult serviceResult) {
		try {
			JSONObject jsonObject = new JSONObject();
			// �Ƿ�ɹ�
			jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult
					.isSuccess()));
			// ������
			jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult
					.getRetCode()));
			// ������Ϣ
			jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());
			// ���ض���
			if (serviceResult.getRetObject() != null)
				jsonObject.put(JSONKey.OBJECT, serviceResult.getRetObject());
			// jsonObject.put("data", JSONObject.toBean());
			renderHtml(jsonObject.toString());
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}

	/**
	 * дJSON���� - ����ΪServiceResult ��List�����е�����д��JSON��,��List������װ
	 * 
	 * @param serviceResult
	 */
	public void writeJSONServiceList(ServiceResult serviceResult) {
		try {
			JSONObject jsonObject = new JSONObject();
			// �Ƿ�ɹ�
			jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult
					.isSuccess()));
			// ������
			jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult
					.getRetCode()));
			// ������Ϣ
			jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());
			// ���ض���
			if (serviceResult.getRetObject() != null)
				jsonObject.put(JSONKey.OBJECT, serviceResult.getRetObject());
			List datas = serviceResult.getRetResult().getData();
			if (datas != null) {
				jsonObject.put(JSONKey.DATAS, JSONArray.fromObject(datas));
			}
			renderHtml(jsonObject.toString());
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}

	/**
	 * дJSON����ҵ�����
	 * 
	 * @param serviceResult
	 * @return
	 */
	public JSONObject writeJSONServiceError(ServiceResult serviceResult) {

		JSONObject jsonObject = new JSONObject();
		// �Ƿ�ɹ�
		jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult
				.isSuccess()));
		// ������
		jsonObject.put(JSONKey.RET_CODE,
				new Integer(serviceResult.getRetCode()));
		// ������Ϣ
		jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());
		return jsonObject;
	}

	/**
	 * 
	 * дJSON�б���� - ����ΪServiceResult
	 * 
	 * @param serviceResult
	 * @param resultFields
	 */
	public void writeJSONServicePage(ServiceResult serviceResult,
			String[] resultFields) {
		List<ColumnSet> set = new ArrayList<ColumnSet>();
		for (String dtl : resultFields) {
			ColumnSet dtlSet = new ColumnSet(dtl, "");
			set.add(dtlSet);
		}
		this.writeJSONServicePage(serviceResult, set);
	}

	/**
	 * 
	 * дJSON�б���� - ����ΪServiceResult
	 * 
	 * @param serviceResult
	 */
	public void writeJSONServicePage(ServiceResult serviceResult,
			List resultFields) {
		try {
			// Assert.notEmpty(args);
			QueryResult pageRslt = serviceResult.getRetResult();
			JSONObject jsonObject = new JSONObject();
			if (serviceResult.isSuccess()) {
				// ҵ��ɹ�
				List list = pageRslt.getData();
				List dataList = new ArrayList();
				// ת��ҳ������
				parseData(list, dataList, resultFields);

				Page page = pageRslt.getPage();
				// �Ƿ�ɹ�
				jsonObject.put(JSONKey.IS_SUCCESS, Boolean
						.valueOf(serviceResult.isSuccess()));
				// ������
				jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult
						.getRetCode()));
				// ������Ϣ
				jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());

				// //�ܼ�¼��
				// jsonObject.put(JSONKey.TOTALRECORDS,
				// Integer.valueOf(page.getRows()));
				// //��ҳ��
				// jsonObject.put(JSONKey.TOTALPAGE,
				// Integer.valueOf(page.getNumbers()));
				// //��ǰҳ
				// jsonObject.put(JSONKey.CURRENTPAGE,
				// Integer.valueOf(page.getCurrent()));
				// //ҳ�ڼ�¼��
				// jsonObject.put(JSONKey.PAGESIZE,
				// Integer.valueOf(page.getSize()));
				// ��д��ҳ����
				jsonObject.put(JSONKey.PAGE, page);

				// ҳ������
				jsonObject.put(JSONKey.DATAS, JSONArray.fromObject(dataList));
			} else {
				// ҵ�������ʾ������Ϣ
				jsonObject = this.writeJSONServiceError(serviceResult);
			}
			renderHtml(jsonObject.toString());
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}

	/**
	 * �����ѯ���
	 * 
	 * @param list
	 * @param dataList
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected void parseData(List list, List dataList, List args)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		int size = args.size();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = (Object) iter.next();
			Map dataMap = new HashMap(size);
			for (int i = 0; i < size; i++) {
				ColumnSet dtlSet = (ColumnSet) args.get(i);// ȡColumnSet����
				if (dtlSet.isNonData())
					continue;
				// ����ת��
				Object value = null;
				String dataKey = dtlSet.getDataKey();
				String tdKey = dtlSet.getKey();
				if (dataKey.indexOf('.') > -1) {
					String[] arrArg = StringUtils.split(dataKey, '.');
					value = element;
					for (int j = 0; j < arrArg.length - 1; j++) {
						value = CommonUtil.getProperty(value, arrArg[j]);
						if (value != null) {
							value = CommonUtil.getProperty(value, arrArg[j + 1]);
						} else {
							value = null;
							break;
						}
					}// end for
				} else {
					value = PropertyUtils.getProperty(element, dataKey);
				}// end if
				dataMap.put(tdKey, fixValueForJSON(value));// ʹ�ñ��KEY�������ݱ���
			}
			dataList.add(dataMap);
		}
	}


	/**
	 * ��������ֵ(������writeJSON)
	 * 
	 * @param value
	 *            ����ֵ
	 * @return �������ֵ
	 */
	private Object fixValueForJSON(Object value) {
		Object retObject = value;
		if (value instanceof java.util.Date) {
			// retObject = new java.sql.Timestamp(((java.util.Date) value)
			// .getTime());
			retObject = new String(value.toString());
		}
		return retObject;
	}

	/**
	 * ��ȡresponse�ı�������
	 * 
	 * @return ��ǰresponse
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * ��ȡrequest�ı�������
	 * 
	 * @return ��ǰrequest
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * ��ȡsession�ı�������
	 * 
	 * @return ��ǰsession
	 */
	protected HttpSession getSession() {
		HttpServletRequest req = this.getRequest();
		return req.getSession();
	}

	/**
	 * ��ȡLoginMember�ı�������
	 * 
	 * @return ��ǰmember
	 */
	protected LoginMember getMember() {
		Object obj = getSession().getAttribute(HttpDictionary.USER_NAME);
		LoginMember member = (obj != null) ? (LoginMember) obj : null;
		// @@ ��Ӧ�ðѷ���д��ȡ����λ�ã�Ӧ��д�ڸ�ֵ��λ��
		// �����Ǽ�����
		// if(member!=null && member.getChannel()!=null)
		// member.getChannel().setStrStarLevel(Constant.getConstantName(ConstantsType.STARLEVEL,
		// member.getChannel().getStarlevel().toString()));
		return member;
	}

	/**
	 * ��ҳ��ʹ��
	 * 
	 * @return
	 */
	public LoginMember getLogMember() {
		Object obj = getSession().getAttribute(HttpDictionary.USER_NAME);
		LoginMember member = (obj != null) ? (LoginMember) obj : null;
		return member;
	}

	/**
	 * ��ȡservletContext�ı�������
	 * 
	 * @return ��ǰServletContext
	 */
	protected ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	/**
	 * ��ȡ ActionMapping
	 */
	protected ActionMapping getActionMapping() {
		return ServletActionContext.getActionMapping();
	}

	/**
	 * ͳһ����ֵ
	 */
	public String execute() {
		return SUCCESS;
	}

	/* Getter/Setter ���� */

	/**
	 * ���ý��
	 * 
	 * @param result
	 */
	public void setResult(QueryResult result) {
		this.result = result;
	}

	/**
	 * ���ؽ��
	 * 
	 * @param result
	 */
	public QueryResult getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * ҳ��
	 * 
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * ҳ��
	 * 
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * ҳ�ڴ�С
	 * 
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * ҳ�ڴ�С
	 * 
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��ҳ��ʶ
	 * 
	 * @return the pageQuery
	 */
	public Integer getPageQuery() {
		return pageQuery;
	}

	/**
	 * ��ҳ��ʶ
	 * 
	 * @param pageQuery
	 *            the pageQuery to set
	 */
	public void setPageQuery(Integer pageQuery) {
		this.pageQuery = pageQuery;
	}

	/**
	 * @return the cond
	 */
	public Condition getCond() {
		return cond;
	}

	/**
	 * @param cond
	 *            the cond to set
	 */
	public void setCond(Condition cond) {
		this.cond = cond;
	}

	/**
	 * @return the ajaxPost
	 */
	public int getAjaxPost() {
		return ajaxPost;
	}

	/**
	 * @param ajaxPost
	 *            the ajaxPost to set
	 */
	public void setAjaxPost(int ajaxPost) {
		this.ajaxPost = ajaxPost;
	}
	
	public boolean getShowReward(){
		String value = Constant.getConstantName(ConstantsType.CAN_QUERY_REWARD, getMember().getCityid());
		return ConstantsType.CAN_QUERY_REWARD_YES.equals(value);
	}

	/**
	 * ��ȡService������Ϣ
	 * 
	 * @return
	 */
	protected ServiceResult getErrServiceResult(String serviceCode) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.EXCEPTION);
		result.setMessage(ConfigUtil.getMessage(serviceCode,
				ServiceRetCode.EXCEPTION));
		return result;
	}
	
	/**
	 * ����������д�ķ�������excel
	 * @param data
	 */
	protected void exportExcel(List data) {

		try {
			if(data==null || data.size()<1){
				return ;
			}
			List<ExcelColumn> list = getExcelColumn();

			getResponse().setCharacterEncoding("UTF-8");
			getResponse().setHeader("Content-Disposition","attachment; filename="+new String((getExcelTitle()+".xls").getBytes("GBK"),"ISO8859-1"));
			getResponse().setContentType("application/vnd.ms-excel");

			WritableWorkbook book = Workbook.createWorkbook(getResponse().getOutputStream());

			WritableSheet sheet = book.createSheet(getExcelTitle(), 0);
			int colSize = list.size();
			sheet.mergeCells(0, 0, colSize-1, 0);
			
			int rowIndex = 0;
			jxl.write.WritableFont wfc =new jxl.write.WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE);
            jxl.write.WritableCellFormat wcfFc =new jxl.write.WritableCellFormat(wfc);
            wcfFc.setAlignment(Alignment.CENTRE);
            
			Label label = new Label(0, 0, getExcelTitle(),wcfFc);
			sheet.addCell(label);
			
			rowIndex++;
			
			//����������֮��
			if(beforeWrite()!=null){
				String[][] before = beforeWrite();
				for(int i = 0;i<before.length;i++){
					for(int j = 0;j<before[i].length;j++){
						Label l = new Label(j, rowIndex, before[i][j]);
						sheet.addCell(l);
					}
					rowIndex++;
				}
			}
			
			//��ͷ
			for (int i = 0; i < colSize; i++) {
				sheet.setColumnView(i, list.get(i).getColWidth());
				Label l = new Label(i, rowIndex, list.get(i).getName());
				sheet.addCell(l);
			}
			rowIndex++;
			//����
			for (int j = 0; j < data.size(); j++) {
				for (int i = 0; i < colSize; i++) {
					Object o = data.get(j);
					String dataName = list.get(i).getDataKey();
					Object oo ;
					if(o instanceof BaseModel && dataName.indexOf(".")>-1){
						BaseModel baseModel = (BaseModel)o;
						oo = baseModel.getDatas().get(dataName.substring(dataName.indexOf(".")+1));
					}else{
						oo = PropertyUtils.getNestedProperty(o, dataName);	
					}
					if (oo != null) {
						if(oo instanceof Number){
							jxl.write.Number number = new jxl.write.Number(i,rowIndex, Double.valueOf(oo.toString()));
							sheet.addCell(number);
						}else if(oo instanceof Date){
							String dft = list.get(i).getDateFormat();
							jxl.write.DateTime datetime =null;
							if(dft!=null&&!"".equals(dft)){
								jxl.write.DateFormat df = new jxl.write.DateFormat(dft);
								jxl.write.WritableCellFormat wcfDF = new jxl.write.WritableCellFormat(df);
								datetime = new jxl.write.DateTime (i,rowIndex,(Date)oo,wcfDF);
							}else{
								datetime = new jxl.write.DateTime (i,rowIndex,(Date)oo);
							}
							sheet.addCell(datetime);
						}else {
							Label l = new Label(i, rowIndex, (String)oo);
							sheet.addCell(l);
						}
					}
				}
				rowIndex++;
			}
			//���ݺ�
			if(afterWrite()!=null){
				String[][] after = afterWrite();
				for(int i = 0;i<after.length;i++){
					for(int j = 0;j<after[i].length;j++){
						Label l = new Label(j, rowIndex, after[i][j]);
						sheet.addCell(l);
					}
					rowIndex++;
				}
			}
			book.write();
			book.close();
			getResponse().getOutputStream().flush();
			getResponse().getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����������д�ķ�������txt
	 * @param data
	 */
	protected void exportTxt(List data) {

		try {
			if(data==null || data.size()<1){
				return ;
			}
			List<ExcelColumn> list = getExcelColumn();

			getResponse().setCharacterEncoding("UTF-8");
			getResponse().setHeader("Content-Disposition","attachment; filename="+new String((getExcelTitle()+".txt").getBytes("GBK"),"ISO8859-1"));
			getResponse().setContentType("text/plain");

			OutputStream os = getResponse().getOutputStream();
			StringBuffer buff = new StringBuffer();
			int colSize = list.size();
			
			int rowIndex = 0;
			
			//��ͷ
			for (int i = 0; i < colSize; i++) {
				buff.append(list.get(i).getName()).append(FIELD_SEPARATOR_REGEX);
			}
			buff.append(KEYWORD_ENTER);
			//����
			for (int j = 0; j < data.size(); j++) {
				for (int i = 0; i < colSize; i++) {
					Object o = data.get(j);
					String dataName = list.get(i).getDataKey();
					Object oo ;
					if(o instanceof BaseModel && dataName.indexOf(".")>-1){
						BaseModel baseModel = (BaseModel)o;
						oo = baseModel.getDatas().get(dataName.substring(dataName.indexOf(".")+1));
					}else{
						oo = PropertyUtils.getNestedProperty(o, dataName);	
					}
					if (oo != null) {
						buff.append(oo);
					}
					buff.append(FIELD_SEPARATOR_REGEX);
				}
				buff.append(KEYWORD_ENTER);
			}
			
			os.write(cvtToGBK(buff.toString()));
            os.flush();
            os.close();           
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//�޸ĸ÷�������������ת�� ��������ΪstrΪgbk������ַ�����
    public byte[] cvtToGBK( String str ) {
    	if(str==null){
    		return "".getBytes();
    	}else{
    		return str.getBytes();
    	}
    }


	
	protected String[][] beforeWrite(){
		return null;
	}
	protected String[][] afterWrite(){
		return null;
	}
	/**
	 * ������д���ص�����excel���ļ����ͱ���
	 * @return
	 */
	protected String getExcelTitle(){
		return null;
	}
	/**
	 * ���ص���excel���е���Ϣ
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		return null;
	}
}
