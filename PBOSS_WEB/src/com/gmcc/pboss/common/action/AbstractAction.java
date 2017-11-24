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

	/** 首页 */
	public static final String INDEX = "/";
	/** 首页 Action*/
	public static final String INDEXACTION = "/index.do";
	/** 配送商 页面 */
	public static final String DELIVERY_PAGE = "/delivery/query.do";
	/** 经理人员 页面*/
	public static final String MANAGER_PAGE = "/managerView/nodeList.do";
	
	/** 省公司管理员登录*/
	public static final String GD_MANAGER_PAGE = "/gdView/nodeGdList.do";
	/** 市公司管理员页面*/
	public static final String CITY_MANAGER_PAGE = "/cityView/nodeCityList.do";
	
	/**推广专员 页面*/
	public static final String MISSIONER_PAGE = "/missioner/recommendSuccess.do";
	
	/** 登录页面 */
	public static final String LOGIN = "/tologin.do";
	/** 消息页面 */
	public static final String MESSAGE = "/message.jsp";
	
	public static final char[] KEYWORD_ENTER = { 13, 10 }; // 换行
	public static final String FIELD_SEPARATOR_REGEX = "|"; // "|"

	/** 提示信息 */
	private String message;

	private String title;
	private Long id;
	private Integer pageNo;
	private Integer pageSize;
	/**
	 * 翻页查询标识
	 */
	private Integer pageQuery;
	private Condition cond;
	private int ajaxPost;

	protected static final Log logger = LogFactory.getLog(AbstractAction.class);

	/**
	 * 返回结果
	 */
	private QueryResult result;

	/**
	 * 必须要子类重写,用于回调 QueryParameter 子类
	 */
	public abstract QueryParameter getParameter();

	/**
	 * 添加Cookie
	 */
	public void addCookie(Cookie cookie) {
		getResponse().addCookie(cookie);
	}

	/**
	 * 获取Cookie数组
	 * 
	 * @return
	 */
	public Cookie[] getCookies() {
		return getRequest().getCookies();
	}

	/**
	 * 默认List方法
	 * 
	 * @return
	 */
	public String doList() {
		return execute();
	}

	/**
	 * 默认Edit方法
	 * 
	 * @return
	 */
	public String doEdit() {
		return execute();
	}

	/**
	 * 默认Remove方法
	 * 
	 * @return
	 */
	public String doRemove() {
		return execute();
	}

	/**
	 * 默认Load方法
	 * 
	 * @return
	 */
	public String doLoad() {
		return execute();
	}

	/**
	 * 将某个对象以name保存在session中
	 * 
	 * @param name
	 * @param obj
	 */
	public void setSessionAttribute(String name, Object obj) {
		getSession().setAttribute(name, obj);
	}

	/**
	 * 从Session中取出以name命名的对象
	 * 
	 * @param name
	 * @return
	 */
	public Object getSessionAttribute(String name) {
		return getSession().getAttribute(name);
	}

	/**
	 * 从Session中删除以name命名的对象
	 * 
	 * @param name
	 */
	public void removeSessionAttribute(String name) {
		getSession().removeAttribute(name);
	}

	/**
	 * 将某个对象以name保存在request中
	 * 
	 * @param name
	 * @param obj
	 */
	public void setRequestAttribute(String name, Object obj) {
		this.getRequest().setAttribute(name, obj);
	}

	/**
	 * 从Request中取出以name命名的对象
	 * 
	 * @param name
	 * @return
	 */
	public Object getRequestAttribute(String name) {
		return getRequest().getAttribute(name);
	}

	/**
	 * 从Request中删除以name命名的对象
	 * 
	 * @param name
	 */
	public void removeRequestAttribute(String name) {
		getRequest().removeAttribute(name);
	}

	/**
	 * 提取当然路径的方法
	 * 
	 * @return
	 */
	public String getLocation() {
		// 替换网站路径
		String ctx = this.getRequest().getContextPath();
		// String rtn = (String)PageLoction.PAGELOCTION.get(getTitle());
		String rtn = ConfigUtil.getPageLocation(getTitle());
		rtn = rtn.replaceAll("\\$\\{ctx\\}", ctx);

		return rtn;
	}

	/**
	 * 提取页面配置信息
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
	 * 返回页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}

	public List getsetCols() {
		// 由子类实现
		return null;
	}

	/**
	 * 直接输出.
	 * 
	 * @param text
	 * @param contentType
	 *            内容的类型.html,text,xml的值见后，json为"text/x-json;charset=GBK"
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
	 * 直接输出纯字符串.
	 */
	protected void renderText(String text) {
		render(text, "text/plain;charset=" + HttpDictionary.ENCODE);
	}

	/**
	 * 直接输出纯HTML.
	 */
	protected void renderHtml(String text) {
		render(text, "text/html;charset=" + HttpDictionary.ENCODE);
	}

	/**
	 * 直接输出纯XML.
	 */
	protected void renderXML(String text) {
		render(text, "text/xml;charset=" + HttpDictionary.ENCODE);
	}

	/**
	 * 判断是否登录
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
	 * 验证图形校验码
	 * 
	 * @param inputCode
	 *            用户输入值
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
	 * 验证随机短信校验码
	 * 
	 * @param inputCode
	 *            用户输入值
	 * @return
	 */
	public ServiceResult validateSMSRndCode(String inputCode) {
		int retCode = ServiceRetCode.FAIL_ICODE;
		boolean isSuccess = false;

		// //<TEMP>暂时默认为123456<TEMP>
		if (inputCode.equals("123456")) {
			isSuccess = true;
			retCode = ServiceRetCode.SUCCESS;
		} else {
			Object obj = getSessionAttribute(HttpDictionary.SMS_CODE_NAME);
			if (!CommonUtil.isEmptyOrNull(inputCode) && obj != null) {
				logger.info("ValidateSMSRndCode InputCode[" + inputCode + "]");

				SMSRndCode smsRndCode = (SMSRndCode) obj;
				List codeList = smsRndCode.getCodeList();
				// <TEMP>暂时默认为123456<TEMP>
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
	 * 创建ServiceResult对象
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
	 * 报出异常信息
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
	 * 写Page JSON对象
	 * 
	 * @param list
	 *            要写的对象
	 */
	/*
	 * 暂时不用 public void writeJSONData(QueryResult result) { try { //
	 * Assert.notEmpty(args); List dataList = result.getData(); Page page =
	 * result.getPage(); JSONObject jsonObject = new JSONObject(); //总记录数
	 * jsonObject.put("totalRecords", Integer.valueOf(page.getRows()) ); //总页数
	 * jsonObject.put("totalPage", Integer.valueOf(page.getNumbers()) ); //当前页
	 * jsonObject.put("current", Integer.valueOf(page.getCurrent()) ); //页内数据
	 * jsonObject.put("data", JSONArray.fromObject(dataList));
	 * renderHtml(jsonObject.toString()); } catch (Exception e) {
	 * writeJSONError(e.getMessage()); } }
	 */
	/**
	 * 写JSON对象
	 * 
	 * @param list
	 *            要写的对象
	 */
	/*
	 * 暂时不用 public void writeJSONData(List list) { try { //
	 * Assert.notEmpty(args); // List dataList = new java.util.ArrayList();
	 * JSONObject jsonObject = new JSONObject(); jsonObject.put("totalRecords",
	 * new Long(list.size())); jsonObject.put("data",
	 * JSONArray.fromObject(list)); renderHtml(jsonObject.toString()); } catch
	 * (Exception e) { writeJSONError(e.getMessage()); } }
	 */

	/**
	 * 写JSON对象 - 对象为ServiceResult
	 * 
	 * @param serviceResult
	 */
	public void writeJSONServiceData(ServiceResult serviceResult) {
		try {
			JSONObject jsonObject = new JSONObject();
			// 是否成功
			jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult
					.isSuccess()));
			// 返回码
			jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult
					.getRetCode()));
			// 描述信息
			jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());
			// 返回对象
			if (serviceResult.getRetObject() != null)
				jsonObject.put(JSONKey.OBJECT, serviceResult.getRetObject());
			// jsonObject.put("data", JSONObject.toBean());
			renderHtml(jsonObject.toString());
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}

	/**
	 * 写JSON对象 - 对象为ServiceResult 把List中所有的内容写到JSON中,对List不做封装
	 * 
	 * @param serviceResult
	 */
	public void writeJSONServiceList(ServiceResult serviceResult) {
		try {
			JSONObject jsonObject = new JSONObject();
			// 是否成功
			jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult
					.isSuccess()));
			// 返回码
			jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult
					.getRetCode()));
			// 描述信息
			jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());
			// 返回对象
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
	 * 写JSON对象，业务出错
	 * 
	 * @param serviceResult
	 * @return
	 */
	public JSONObject writeJSONServiceError(ServiceResult serviceResult) {

		JSONObject jsonObject = new JSONObject();
		// 是否成功
		jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult
				.isSuccess()));
		// 返回码
		jsonObject.put(JSONKey.RET_CODE,
				new Integer(serviceResult.getRetCode()));
		// 描述信息
		jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());
		return jsonObject;
	}

	/**
	 * 
	 * 写JSON列表对象 - 对象为ServiceResult
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
	 * 写JSON列表对象 - 对象为ServiceResult
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
				// 业务成功
				List list = pageRslt.getData();
				List dataList = new ArrayList();
				// 转换页内数据
				parseData(list, dataList, resultFields);

				Page page = pageRslt.getPage();
				// 是否成功
				jsonObject.put(JSONKey.IS_SUCCESS, Boolean
						.valueOf(serviceResult.isSuccess()));
				// 返回码
				jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult
						.getRetCode()));
				// 描述信息
				jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());

				// //总记录数
				// jsonObject.put(JSONKey.TOTALRECORDS,
				// Integer.valueOf(page.getRows()));
				// //总页数
				// jsonObject.put(JSONKey.TOTALPAGE,
				// Integer.valueOf(page.getNumbers()));
				// //当前页
				// jsonObject.put(JSONKey.CURRENTPAGE,
				// Integer.valueOf(page.getCurrent()));
				// //页内记录数
				// jsonObject.put(JSONKey.PAGESIZE,
				// Integer.valueOf(page.getSize()));
				// 回写翻页用类
				jsonObject.put(JSONKey.PAGE, page);

				// 页内数据
				jsonObject.put(JSONKey.DATAS, JSONArray.fromObject(dataList));
			} else {
				// 业务出错显示出错信息
				jsonObject = this.writeJSONServiceError(serviceResult);
			}
			renderHtml(jsonObject.toString());
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}

	/**
	 * 处理查询结果
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
				ColumnSet dtlSet = (ColumnSet) args.get(i);// 取ColumnSet对象
				if (dtlSet.isNonData())
					continue;
				// 类型转换
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
				dataMap.put(tdKey, fixValueForJSON(value));// 使用表格KEY进行数据保存
			}
			dataList.add(dataMap);
		}
	}


	/**
	 * 修正对象值(限用于writeJSON)
	 * 
	 * @param value
	 *            对象值
	 * @return 修正后的值
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
	 * 获取response的便利方法
	 * 
	 * @return 当前response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 获取request的便利方法
	 * 
	 * @return 当前request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 获取session的便利方法
	 * 
	 * @return 当前session
	 */
	protected HttpSession getSession() {
		HttpServletRequest req = this.getRequest();
		return req.getSession();
	}

	/**
	 * 获取LoginMember的便利方法
	 * 
	 * @return 当前member
	 */
	protected LoginMember getMember() {
		Object obj = getSession().getAttribute(HttpDictionary.USER_NAME);
		LoginMember member = (obj != null) ? (LoginMember) obj : null;
		// @@ 不应该把翻译写在取数的位置，应该写在赋值的位置
		// 渠道星级翻译
		// if(member!=null && member.getChannel()!=null)
		// member.getChannel().setStrStarLevel(Constant.getConstantName(ConstantsType.STARLEVEL,
		// member.getChannel().getStarlevel().toString()));
		return member;
	}

	/**
	 * 给页面使用
	 * 
	 * @return
	 */
	public LoginMember getLogMember() {
		Object obj = getSession().getAttribute(HttpDictionary.USER_NAME);
		LoginMember member = (obj != null) ? (LoginMember) obj : null;
		return member;
	}

	/**
	 * 获取servletContext的便利方法
	 * 
	 * @return 当前ServletContext
	 */
	protected ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	/**
	 * 获取 ActionMapping
	 */
	protected ActionMapping getActionMapping() {
		return ServletActionContext.getActionMapping();
	}

	/**
	 * 统一返回值
	 */
	public String execute() {
		return SUCCESS;
	}

	/* Getter/Setter 方法 */

	/**
	 * 设置结果
	 * 
	 * @param result
	 */
	public void setResult(QueryResult result) {
		this.result = result;
	}

	/**
	 * 返回结果
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
	 * 页码
	 * 
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * 页码
	 * 
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 页内大小
	 * 
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 页内大小
	 * 
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 翻页标识
	 * 
	 * @return the pageQuery
	 */
	public Integer getPageQuery() {
		return pageQuery;
	}

	/**
	 * 翻页标识
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
	 * 提取Service出错信息
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
	 * 根据子类重写的方法导出excel
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
			
			//标题与数据之间
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
			
			//表头
			for (int i = 0; i < colSize; i++) {
				sheet.setColumnView(i, list.get(i).getColWidth());
				Label l = new Label(i, rowIndex, list.get(i).getName());
				sheet.addCell(l);
			}
			rowIndex++;
			//数据
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
			//数据后
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
	 * 根据子类重写的方法导出txt
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
			
			//表头
			for (int i = 0; i < colSize; i++) {
				buff.append(list.get(i).getName()).append(FIELD_SEPARATOR_REGEX);
			}
			buff.append(KEYWORD_ENTER);
			//数据
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
	//修改该方法，不做编码转换 （这里认为str为gbk编码的字符串）
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
	 * 子类重写返回导出的excel的文件名和标题
	 * @return
	 */
	protected String getExcelTitle(){
		return null;
	}
	/**
	 * 返回导出excel的列的信息
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		return null;
	}
}
