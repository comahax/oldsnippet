package com.sunrise.jop.ui.struts2;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.system.ActionException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

public abstract class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public static final int METHOD_TYPE_QUERY    = 0;
	public static final int METHOD_TYPE_CREATE   = 1;
	public static final int METHOD_TYPE_UPDATE   = 2;
	public static final int METHOD_TYPE_REMOVEBYPK   = 3;
	public static final int METHOD_TYPE_REMOVEBYVO   = 4;
	public static final int METHOD_TYPE_FINDBYPK = 5;
	
	public static final String WEB_RESULT_LIST = "list";
	public static final String WEB_RESULT_CONTENT = "content";
	
	protected DBQueryParam param;
	private BaseVO form; 
	

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	//数据操作对象，必须赋值
	private Class clsVO;
	private Class formClass; //hekun add. for doNew use.
	//如果子类给下面的clsDelegate赋值，那么使用下面的clsDelegate创建对象并调用，否则使用CommonDelegate
	private Class clsControl;
	private Class clsQueryParam;
	private Class clsAction;
	protected String[] pkNameArray; // 主键的名字数组，如果只有查询导出不会用到，否则必须在子类赋值，
	
	protected Class[] queryTypes = {null};
	protected Class[] crudTypes = {null};
	protected Class[] bypkTypes = {Serializable.class};
	
	private DataPackage dp;
	
	
	
	//private boolean isNew;
	//取消isNew模式,因为保存之后还要进行页面全disabled的判断，isNew模式改用CMD模式
	public String CMD;
	public static final String WEB_CMD_NEW = "NEW";
	public static final String WEB_CMD_EDIT = "EDIT";
	public static final String WEB_CMD_SAVE = "SAVE";
	
	//保存是否成功标识
	public String isSuccessful;
	public static final String WEB_SUCCESS_YES = "YES";
	public static final String WEB_SUCCESS_NO = "NO";
	
	
	private static UserProvider provider;
	
	private static Logger log = LoggerFactory.getLogger(BaseAction.class);
	
	static {
		try {		
			provider = (UserProvider)InterfaceUtils.getInstance().createObject(UserProvider.class);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException("无法创建或调用 userProviderClass 接口的实现类实例" + e.getMessage());
		}
	}

	public DataPackage getDp() {
		return dp;
	}

	public void setDp(DataPackage dp) {
		this.dp = dp;
	}

	public DBQueryParam getParam() {
		return param;
	}

	public void setParam(DBQueryParam param) {
		this.param = param;
	}

	public BaseVO getForm() {
		return form;
	}

	public void setForm(BaseVO form) {
		this.form = form;
		
		if(form!=null) {
			formClass = form.getClass();
		}else {
			throw new IllegalArgumentException("Form object can't be null when call setForm() ! ");
		}
	}

	public Class getClsQueryParam() {
		return clsQueryParam;
	}

	public void setClsQueryParam(Class clsQueryParam) {
		this.clsQueryParam = clsQueryParam;
	}

	public Class getClsVO() {
		return clsVO;
	}

	public void setClsVO(Class clsVO) {
		this.clsVO = clsVO;
	}

//	public String getResultmsg() {
//		if (resultmsg!=null){
//			 return MessageFormat.format(tiptemplate, new Object[] {resultmsg});
//		}
//		return null;
//	}
	
	/**
	 * 调用Strtus2 Action 积累对应的设置消息的方法
	 */
	public void setActionMessage(String resultmsg) {
		List msgs = new ArrayList(0);
		msgs.add(resultmsg);
		
		setActionMessages(msgs);
	}
	/**
	 * 设置用户访问的数据源
	 * by panmeifa 2013-10-25
	 */
	public void setDbFlag(String dbFlag) {
		if( !dbFlag.equals(DBConstant.DB_FLAG_GDIB) ) {
			dbFlag = CityMappingUtil.getCity(getDBAccessUser().getCityid()) + dbFlag;
		}
		getDBAccessUser().setDbFlag(dbFlag);
	}
	/**
	 * 获取当前会话对应的User对象
	 * 子类必须实现这个方法，提供具体的数据库访问参数
	 */
	public DBAccessUser getDBAccessUser() {		
		DBAccessUser user = null;
				
		user = provider.getUser();
			
		if(user == null)
			throw new RuntimeException("BaseAction 无法获取当前  User ");
		else
			return user;
		
	}
	
	public String doView() throws Exception{
		findVOFromDB();

		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_LIST;
	}
	
	public String doList() throws Exception{
		DataPackage dp = null;
		try{
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
		}catch (Exception e) {
			this.processException(e);
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}
	
	/**
	 * 部分页查询所有数据
	 * @return
	 * @throws Exception
	 */
	public String doListExpress() throws Exception{
		getParam().setQueryAll(true);
		
		return doList();
	}
	
	/**
	 * 当BaseAction的子类继承后，如果给
	 * 		private Class clsDelegate;
	 *		private Class clsQueryParam;
	 * 赋值，那么将会调用下面这个方法，改为调用子类具体的Delegate类，而不是调用CommonDelegate。
	 * 一般来说，调用业务的Delegate会效率高些
	 * 异常不应该在这里进行捕捉,而应该在相应调用的方法里面进行捕捉,否则本应该抛出异常的信息会给刷掉
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	protected Object executeDlgMethod(int type, Object obj) throws Exception {
		if (queryTypes[0] == null){
			queryTypes[0] = clsQueryParam;
		}
		if (crudTypes[0] == null){
			crudTypes[0] = clsVO;
		}
		
		String methodName = null;
		Class[] methodType = null;
		switch (type) {
		case METHOD_TYPE_QUERY    :
			methodName = "doQuery";
			methodType = queryTypes;
			break;
		case METHOD_TYPE_CREATE   :
			methodName = "doCreate";
			methodType = crudTypes;
			break;
		case METHOD_TYPE_UPDATE   :
			methodName = "doUpdate";
			methodType = crudTypes;
			break;
		case METHOD_TYPE_REMOVEBYPK   :
			methodName = "doRemoveByPK";
			methodType = bypkTypes;
			break;
		case METHOD_TYPE_REMOVEBYVO   :
			methodName = "doRemoveByVO";
			methodType = crudTypes;
			break;
		case METHOD_TYPE_FINDBYPK :
			methodName = "doFindByPk";
			methodType = bypkTypes;
			break;
		}
		
		Object rlt = null;
		
		Class beanClass = Class.forName(clsControl.getName() +"BO");
	
		Object control = BOFactory.build(beanClass, getDBAccessUser()) ;
		Method method = null;
	
		method = control.getClass().getMethod(methodName, methodType);
	
		Object[] args = new Object[1];
		switch (type) {
		case METHOD_TYPE_QUERY    :
			args[0] = obj;
			//args[1] = getDBAccessUser();
			break;
		case METHOD_TYPE_CREATE   :
		case METHOD_TYPE_UPDATE   :
		case METHOD_TYPE_REMOVEBYVO   :
			args[0] = obj;
			//args[1] = getDBAccessUser();
			break;
		case METHOD_TYPE_REMOVEBYPK   :
		case METHOD_TYPE_FINDBYPK :
			args[0] = obj;
			//args[1] = getDBAccessUser();
			break;
		}
		
		rlt = method.invoke(control, args);
		
		if(!"doQuery".equals(methodName) && !"doFindByPk".equals(methodName))
			setActionMessage("操作成功!");
		
		return rlt;
	}
	
	public String doDelete() throws Exception{
		isSuccessful = WEB_SUCCESS_YES;
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		
		if(selectArray == null) {
			addActionError("无法获取选中项目！");
			return "list";
		}
			
		try{
			for (int i = 0; i < selectArray.length; i++) {
				if (selectArray[0].indexOf('|') == -1) { // 单一主键
					executeDlgMethod(METHOD_TYPE_REMOVEBYPK, getSelectedPK(selectArray[i]));
				} else { // 复合主键
					executeDlgMethod(METHOD_TYPE_REMOVEBYVO, getSelectedPkVO(selectArray[i]));
				}
			}
		}catch (Exception e) {
			isSuccessful = WEB_SUCCESS_NO;
			this.processException(e);
		}
		return doList();
	}

	/**
	 * 按单一主键删除时，返回主键 用于List.jsp按删除按钮时，从参数中取出删除数据的主键列
	 */
	protected Serializable getSelectedPK(String pkValue) throws Exception {
		Method[] methodArray = clsVO.getMethods();
		Class pkType = null;
		for (int i = 0; i < methodArray.length; i++) {
			if (methodArray[i].getName().equalsIgnoreCase(
					"get" + pkNameArray[0])) {
				pkType = methodArray[i].getReturnType();
			}
		}
		if (Integer.class == pkType) {
			return new Integer(pkValue);
		} else if (Long.class == pkType) {
			return new Long(pkValue);
		} else if (String.class == pkType) {
			return pkValue;
		} else {
			throw new ActionException("action.err.wrongpk", pkValue, null);
//			throw new Exception("错误的主键类型");
		}
	}

	/**
	 * 按复合主键删除时，返回主键VO 用于List.jsp按删除按钮时，从参数中取出删除数据的主键列
	 */
	protected Serializable getSelectedPkVO(String pkValue) throws Exception {
		String[] pkValueArray = pkValue.split("\\|");
		Serializable vo = (Serializable) clsVO.newInstance();
		for (int j = 0; j < pkValueArray.length; j++) {
			BeanUtils.setProperty(vo, pkNameArray[j], pkValueArray[j]);
		}
		return vo;
	}

	public String doNew() throws Exception{
		// 新建时设置form的默认值
		//setForm((BaseVO) formClass.newInstance());

		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};	
	
	public String doEdit() throws Exception{
		BaseVO vo = findVOFromDB();
		BaseVO form = getForm(); 
		BeanUtils.copyProperties(form, vo);
		setForm(form);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	};
	
	protected BaseVO findVOFromDB() throws Exception {
		String pk = getParam().get_pk();
		if (pk == null)
			throw new ActionException("action.err.nullpk");
		
		BaseVO contentVO = null;
		try{
			if (!pk.trim().equalsIgnoreCase("")) { // 由list.jsp 传过来
				if (pk.indexOf("|") == -1) { // 单一主键
					contentVO = (BaseVO) executeDlgMethod(METHOD_TYPE_FINDBYPK, getSelectedPK(pk));
				} else { // 复合主键
					contentVO = (BaseVO) executeDlgMethod(METHOD_TYPE_FINDBYPK, getSelectedPkVO(pk));
				}
			}
			if (contentVO == null){
				String [] param = {pk, ClassUtils.getShortClassName(getForm().getClass())};
				throw new ActionException("action.err.recordnotfound", param, null);
			}
		}catch (Exception e) {
			this.processException(e);
		}
		
		return contentVO;
	}
	
	public String doSave() throws Exception{
		Object obj = clsVO.newInstance();
		BeanUtils.copyProperties(obj, getForm());		
		if (WEB_CMD_NEW.equals(CMD)) {
			try{
				CMD = WEB_CMD_SAVE;
				isSuccessful = WEB_SUCCESS_YES;
				Object vo = null;
				if (pkNameArray.length == 1) { // 单一主键
					Object pk = PropertyUtils.getNestedProperty(obj, pkNameArray[0]);
					// 这里返回的是String类型
					if (pk != null) {
						vo = executeDlgMethod(METHOD_TYPE_FINDBYPK, (Serializable) pk);
					}
				} else {// 复合主建
						vo = executeDlgMethod(METHOD_TYPE_FINDBYPK, (Serializable) obj);
				}
				if (vo == null) {
					vo = executeDlgMethod(METHOD_TYPE_CREATE, obj);
					BeanUtils.copyProperties(getForm(), vo);
				} else {
					onDuplicatePk();
					CMD = WEB_CMD_NEW;
					isSuccessful = WEB_SUCCESS_NO;
				}
				
			}catch (Exception e) {
				CMD = WEB_CMD_NEW;
				isSuccessful = WEB_SUCCESS_NO;
				this.processException(e);
			}
		} else {
			try{
				CMD = WEB_CMD_SAVE;
				isSuccessful = WEB_SUCCESS_YES;
				Object vo = executeDlgMethod(METHOD_TYPE_UPDATE, obj);
				BeanUtils.copyProperties(getForm(), vo);
			}catch (Exception e) {
				CMD = WEB_CMD_EDIT;
				isSuccessful = WEB_SUCCESS_NO;
				this.processException(e);
			}
		}		
		return WEB_RESULT_CONTENT;
	}
	/**
	 * 将查询的数据导出，供导出类commonExportBean回调
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @param commonExportBean
	 * @throws Exception
	 */
//	public void ExportQuery(BaseVO actionForm, HttpServletRequest request,
//			HttpServletResponse response, User user,
//			CommonExportBean commonExportBean) throws Exception {
//		// 查询数据输出,分页查询
//		BaseVO baseActionForm = (BaseVO) actionForm;
//		// baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
//		ArrayList list;
//		OutputStream os = response.getOutputStream();
//		if("0".equals(this.param.get_pagesize())){//因为导出都是所有的导出，但为效率，采用分页的方式导出数据
//			this.param.set_pagesize(""+CommonExportBean.EXCELOUT_PAGE_SIZE);//设置每面最多的记录数
//			this.param.setQueryAll(false);
//		}
//		for (int startindex = 1;; startindex++) {
//			// baseActionForm.set_pageno(String.valueOf(startindex));
//			this.param.set_pageno(""+startindex);//设置导出的页码
//			if ("doList".equals(commonExportBean.queryMethodName)) {
//				doList();
//				
//			} else {
//				Method method = this.getClass().getMethod(
//						commonExportBean.queryMethodName, null);
//				method.invoke(this, null);
//			}
//			list = (ArrayList) (getDp().getDatas());	
//			if (list != null && !list.isEmpty()) {
//				commonExportBean.write(os, list.iterator(),
//						commonExportBean.voClassArray);
//				if (list.size() < CommonExportBean.EXCELOUT_PAGE_SIZE 
//						|| ((this.getDp().getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// 代表最后一页
//					break;
//				}
//			} else {// 该页没有数据
//				break;
//			}
//			list.clear();
//		}
//	}
	/*
	 * 模板方法, 允许子类设置主键重复时的错误消息 @param actionMapping @param actionForm @param
	 */
	protected void onDuplicatePk() {
		setActionMessage(I18nMessage.getPublicString("msgDuplicatePk"));
	}

	public String doEditNew() throws Exception{
		Object contentVO = findVOFromDB();
		if(contentVO == null){
			CMD = WEB_CMD_NEW;
		}else{
			CMD = WEB_CMD_EDIT;
		}
		BeanUtils.copyProperties(form, contentVO);
		return WEB_RESULT_CONTENT;
	}
	
//	public String doExcel() throws Exception{
//		CommonExportBean commonExportBean = (CommonExportBean)getRequest()
//				.getAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT);
//		if(commonExportBean.voClassArray==null)
//			commonExportBean.voClassArray = new Class[] { clsVO };
//		// commonExportBean.queryMethodName = "doList";
//		if (commonExportBean.headtitle == null) {
//			commonExportBean.headtitle = commonExportBean.getFileName();
//		}
//		commonExportBean.buildExcelPage(form, getRequest(), getResponse(),
//				(User) getDBAccessUser(), this);
//		return null;
//	}
	
	public String doTxt() throws Exception{
		return WEB_RESULT_LIST;
	}

	//输出txt的准备工作
	public void prepareResponse(String fileName) throws UnsupportedEncodingException {
		getResponse().setCharacterEncoding("UTF-8");
		getResponse().setHeader("pragma", "no-cache");
		getResponse().setHeader("Cache-business", "public");
		getResponse().setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + fileName + ".txt";
		getResponse().setHeader("Content-Disposition", new String(fn.getBytes("UTF-8"), "ISO-8859-1"));
		getResponse().setContentType("text/plain;charset=utf-8");
	}
	
	public Class getClsControl() {
		return clsControl;
	}

	public void setClsControl(Class clsControl) {
		this.clsControl = clsControl;
	}

	public Class getFormClass() {
		return formClass;
	}

	public void setFormClass(Class formClass) {
		this.formClass = formClass;
	}

	public void setClsAction(Class clsAction) {
		this.clsAction = clsAction;
	}
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	public String getCMD() {
		return CMD;
	}

	public void setCMD(String CMD) {
		this.CMD = CMD;
	}

	public String getIsSuccessful() {
		return isSuccessful;
	}

	public void setIsSuccessful(String isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getWEB_CMD_NEW() {
		return WEB_CMD_NEW;
	}

	public String getWEB_CMD_EDIT() {
		return WEB_CMD_EDIT;
	}

	public String getWEB_CMD_SAVE() {
		return WEB_CMD_SAVE;
	}
	
	private void processException(Throwable e){
		e.printStackTrace();
		String msg = "";
		if(e instanceof InvocationTargetException) {
			InvocationTargetException ie = (InvocationTargetException) e;
			Throwable t = ie.getTargetException();
			if( null != t.getCause()){
				if(null != t.getCause().getMessage())
					msg = 	t.getCause().getMessage();
			}else{
				msg = t.getMessage()!=null ? t.getMessage() : t.toString();
			}
		}else if(e instanceof UndeclaredThrowableException) {
			UndeclaredThrowableException ue = (UndeclaredThrowableException)e;
			Throwable t = ue.getUndeclaredThrowable();
			if( null != t.getCause()){
				if(null != t.getCause().getMessage())
					msg = 	t.getCause().getMessage();
			}else{
				msg = t.getMessage()!=null ? t.getMessage() : t.toString();
			}
			msg = t.getMessage()!=null ? t.getMessage() : t.toString();
			
		}else {
			
			if( null != e.getCause()){
				if(null != e.getCause().getMessage())
					msg = 	e.getCause().getMessage();
			}else{
				msg = e.getMessage()!=null ? e.getMessage() : e.toString();
			}
			msg = e.getMessage()!=null ? e.getMessage() : e.toString();
		}
		if(log.isErrorEnabled())
			log.error("执行失败,原因：" + msg);

		addActionError(msg); //Struts2 提供
	}
	
	//Add by yu-wenjun

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
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	/**
	 * 直接输出纯字符串.
	 */
	protected void renderText(String text) {
		render(text, "text/plain;charset="+getRequest().getCharacterEncoding());
	}
	
	/**
	 * 直接输出纯HTML.
	 */
	protected void renderHtml(String text) {
		render(text, "text/html;charset="+getRequest().getCharacterEncoding());
	}

	/**
	 * 直接输出纯XML.
	 */
	protected void renderXML(String text) {
		render(text, "text/xml;charset="+getRequest().getCharacterEncoding());
	}

	/**
	 * 将查询的数据导出，供导出类commonExportBean回调
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @param commonExportBean
	 * @throws Exception
	 */
//	public void ExportQuery(BaseVO actionForm, HttpServletRequest request,
//			HttpServletResponse response, User user,
//			CommonExportBean commonExportBean) throws Exception {
//		// 查询数据输出,分页查询
//		BaseVO baseActionForm = (BaseVO) actionForm;
//		// baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
//		ArrayList list;
//		OutputStream os = response.getOutputStream();
//		if("0".equals(this.param.get_pagesize())){//因为导出都是所有的导出，但为效率，采用分页的方式导出数据
//			this.param.set_pagesize(""+CommonExportBean.EXCELOUT_PAGE_SIZE);//设置每面最多的记录数
//			this.param.setQueryAll(false);
//		}
//		for (int startindex = 1;; startindex++) {
//			// baseActionForm.set_pageno(String.valueOf(startindex));
//			this.param.set_pageno(""+startindex);//设置导出的页码
//			if ("doList".equals(commonExportBean.queryMethodName)) {
//				doList();
//				
//			} else {
//				Method method = this.getClass().getMethod(
//						commonExportBean.queryMethodName, null);
//				method.invoke(this, null);
//			}
//			list = (ArrayList) (getDp().getDatas());	
//			if (list != null && !list.isEmpty()) {
//				commonExportBean.write(os, list.iterator(),
//						commonExportBean.voClassArray);
//				if (list.size() < CommonExportBean.EXCELOUT_PAGE_SIZE 
//						|| ((this.getDp().getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// 代表最后一页
//					break;
//				}
//			} else {// 该页没有数据
//				break;
//			}
//			list.clear();
//		}
//	}
}
