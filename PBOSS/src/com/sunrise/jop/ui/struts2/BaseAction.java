package com.sunrise.jop.ui.struts2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.export.PageSetting;
import com.gmcc.pboss.common.jqTable.ColumnSet;
import com.gmcc.pboss.common.jqTable.JSONKey;
import com.gmcc.pboss.common.jqTable.Page;

import com.opensymphony.xwork2.ActionSupport;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.system.ActionException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public abstract class BaseAction extends ActionSupport {
	private static Log log = LogFactory.getLog(BaseAction.class);
	
	private static final long serialVersionUID = 1L;

	public static final int METHOD_TYPE_QUERY = 0;
	public static final int METHOD_TYPE_CREATE = 1;
	public static final int METHOD_TYPE_UPDATE = 2;
	public static final int METHOD_TYPE_REMOVEBYPK = 3;
	public static final int METHOD_TYPE_REMOVEBYVO = 4;
	public static final int METHOD_TYPE_FINDBYPK = 5;

	public static final String WEB_RESULT_LIST = "list";
	public static final String WEB_RESULT_CONTENT = "content";

	protected DBQueryParam param;
	private BaseVO form;

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	// ���ݲ������󣬱��븳ֵ
	private Class clsVO;
	private Class formClass; // hekun add. for doNew use.
	// �������������clsDelegate��ֵ����ôʹ�������clsDelegate�������󲢵��ã�����ʹ��CommonDelegate
	private Class clsControl;
	private Class clsQueryParam;
	private Class clsAction;
	protected String[] pkNameArray; // �������������飬���ֻ�в�ѯ���������õ���������������ำֵ��

	protected Class[] queryTypes = { null };
	protected Class[] crudTypes = { null };
	protected Class[] bypkTypes = { Serializable.class };

	private DataPackage dp;

	// private boolean isNew;
	// ȡ��isNewģʽ,��Ϊ����֮��Ҫ����ҳ��ȫdisabled���жϣ�isNewģʽ����CMDģʽ
	public String CMD;
	public static final String WEB_CMD_NEW = "NEW";
	public static final String WEB_CMD_EDIT = "EDIT";
	public static final String WEB_CMD_SAVE = "SAVE";

	private static UserProvider provider;

	static {
		try {
			provider = (UserProvider) InterfaceUtils.getInstance()
					.createObject(UserProvider.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JOPException("�޷���������� userProviderClass �ӿڵ�ʵ����ʵ��"
					+ e.getMessage());
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

		if (form != null) {
			formClass = form.getClass();
		} else {
			throw new IllegalArgumentException(
					"Form object can't be null when call setForm() ! ");
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

	// public String getResultmsg() {
	// if (resultmsg!=null){
	// return MessageFormat.format(tiptemplate, new Object[] {resultmsg});
	// }
	// return null;
	// }

	/**
	 * ����Strtus2 Action ���۶�Ӧ��������Ϣ�ķ���
	 */
	public void setActionMessage(String resultmsg) {
		List msgs = new ArrayList(0);
		msgs.add(resultmsg);

		setActionMessages(msgs);
	}

	/**
	 * ��ȡ��ǰ�Ự��Ӧ��User���� �������ʵ������������ṩ��������ݿ���ʲ���
	 */
	public DBAccessUser getDBAccessUser() {
		DBAccessUser user = null;

		user = provider.getUser();

		if (user == null)
			throw new RuntimeException("BaseAction �޷���ȡ��ǰ  User ");
		else
			return user;
	}

	public String doView() throws Exception {
		findVOFromDB();

		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_LIST;
	}

	public String doList() throws Exception {
		DataPackage dp = null;
		try {
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
		} catch (Exception e) {
			this.processException(e);
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	/**
	 * ����ҳ��ѯ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListExpress() throws Exception {
		getParam().setQueryAll(true);

		return doList();
	}

	/**
	 * ��BaseAction������̳к������ private Class clsDelegate; private Class
	 * clsQueryParam; ��ֵ����ô����������������������Ϊ������������Delegate�࣬�����ǵ���CommonDelegate��
	 * һ����˵������ҵ���Delegate��Ч�ʸ�Щ �쳣��Ӧ����������в�׽,��Ӧ������Ӧ���õķ���������в�׽,����Ӧ���׳��쳣����Ϣ���ˢ��
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	protected Object executeDlgMethod(int type, Object obj) throws Exception {
		if (queryTypes[0] == null) {
			queryTypes[0] = clsQueryParam;
		}
		if (crudTypes[0] == null) {
			crudTypes[0] = clsVO;
		}

		String methodName = null;
		Class[] methodType = null;
		switch (type) {
		case METHOD_TYPE_QUERY:
			methodName = "doQuery";
			methodType = queryTypes;
			break;
		case METHOD_TYPE_CREATE:
			methodName = "doCreate";
			methodType = crudTypes;
			break;
		case METHOD_TYPE_UPDATE:
			methodName = "doUpdate";
			methodType = crudTypes;
			break;
		case METHOD_TYPE_REMOVEBYPK:
			methodName = "doRemoveByPK";
			methodType = bypkTypes;
			break;
		case METHOD_TYPE_REMOVEBYVO:
			methodName = "doRemoveByVO";
			methodType = crudTypes;
			break;
		case METHOD_TYPE_FINDBYPK:
			methodName = "doFindByPk";
			methodType = bypkTypes;
			break;
		}

		Object rlt = null;

		Class beanClass = Class.forName(clsControl.getName() + "BO");

		Object control = BOFactory.build(beanClass, getDBAccessUser());
		Method method = null;

		method = control.getClass().getMethod(methodName, methodType);

		Object[] args = new Object[1];
		switch (type) {
		case METHOD_TYPE_QUERY:
			args[0] = obj;
			// args[1] = getDBAccessUser();
			break;
		case METHOD_TYPE_CREATE:
		case METHOD_TYPE_UPDATE:
		case METHOD_TYPE_REMOVEBYVO:
			args[0] = obj;
			// args[1] = getDBAccessUser();
			break;
		case METHOD_TYPE_REMOVEBYPK:
		case METHOD_TYPE_FINDBYPK:
			args[0] = obj;
			// args[1] = getDBAccessUser();
			break;
		}

		rlt = method.invoke(control, args);

		if (!"doQuery".equals(methodName) && !"doFindByPk".equals(methodName))
			setActionMessage("�����ɹ�!");

		return rlt;
	}

	public String doDelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();

		if (selectArray == null) {
			addActionError("�޷���ȡѡ����Ŀ��");
			return "list";
		}

		try {
			for (int i = 0; i < selectArray.length; i++) {
				if (selectArray[0].indexOf('|') == -1) { // ��һ����
					executeDlgMethod(METHOD_TYPE_REMOVEBYPK,
							getSelectedPK(selectArray[i]));
				} else { // ��������
					executeDlgMethod(METHOD_TYPE_REMOVEBYVO,
							getSelectedPkVO(selectArray[i]));
				}
			}
		} catch (Exception e) {
			this.processException(e);
		}
		return doList();
	}

	/**
	 * ����һ����ɾ��ʱ���������� ����List.jsp��ɾ����ťʱ���Ӳ�����ȡ��ɾ�����ݵ�������
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
			// throw new Exception("�������������");
		}
	}

	/**
	 * ����������ɾ��ʱ����������VO ����List.jsp��ɾ����ťʱ���Ӳ�����ȡ��ɾ�����ݵ�������
	 */
	protected Serializable getSelectedPkVO(String pkValue) throws Exception {
		String[] pkValueArray = pkValue.split("\\|");
		Serializable vo = (Serializable) clsVO.newInstance();
		for (int j = 0; j < pkValueArray.length; j++) {
			BeanUtils.setProperty(vo, pkNameArray[j], pkValueArray[j]);
		}
		return vo;
	}

	public String doNew() throws Exception {
		// �½�ʱ����form��Ĭ��ֵ
		// setForm((BaseVO) formClass.newInstance());

		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};

	public String doEdit() throws Exception {
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
		try {
			if (!pk.trim().equalsIgnoreCase("")) { // ��list.jsp ������
				if (pk.indexOf("|") == -1) { // ��һ����
					contentVO = (BaseVO) executeDlgMethod(METHOD_TYPE_FINDBYPK,
							getSelectedPK(pk));
				} else { // ��������
					contentVO = (BaseVO) executeDlgMethod(METHOD_TYPE_FINDBYPK,
							getSelectedPkVO(pk));
				}
			}
			if (contentVO == null) {
				String[] param = { pk,
						ClassUtils.getShortClassName(getForm().getClass()) };
				throw new ActionException("action.err.recordnotfound", param,
						null);
			}
		} catch (Exception e) {
			this.processException(e);
		}

		return contentVO;
	}

	public String doSave() throws Exception {
		Object obj = clsVO.newInstance();
		BeanUtils.copyProperties(obj, getForm());
		if (WEB_CMD_NEW.equals(CMD)) {
			try {
				CMD = WEB_CMD_SAVE;
				Object vo = null;
				if (pkNameArray.length == 1) { // ��һ����
					Object pk = PropertyUtils.getNestedProperty(obj,
							pkNameArray[0]);
					// ���ﷵ�ص���String����
					if (pk != null) {
						vo = executeDlgMethod(METHOD_TYPE_FINDBYPK,
								(Serializable) pk);
					}
				} else {// ��������
					vo = executeDlgMethod(METHOD_TYPE_FINDBYPK,
							(Serializable) obj);
				}
				if (vo == null) {
					vo = executeDlgMethod(METHOD_TYPE_CREATE, obj);
					BeanUtils.copyProperties(getForm(), vo);
				} else {
					onDuplicatePk();
					CMD = WEB_CMD_NEW;
				}

			} catch (Exception e) {
				CMD = WEB_CMD_NEW;
				this.processException(e);
			}
		} else {
			try {
				CMD = WEB_CMD_SAVE;
				Object vo = executeDlgMethod(METHOD_TYPE_UPDATE, obj);
				BeanUtils.copyProperties(getForm(), vo);
			} catch (Exception e) {
				CMD = WEB_CMD_EDIT;
				this.processException(e);
			}
		}
		return WEB_RESULT_CONTENT;
	}

	/**
	 * ����ѯ�����ݵ�������������commonExportBean�ص�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @param commonExportBean
	 * @throws Exception
	 */
	public void ExportQuery(BaseVO actionForm, HttpServletRequest request,
			HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		// ��ѯ�������,��ҳ��ѯ
		BaseVO baseActionForm = (BaseVO) actionForm;
		// baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
		ArrayList list;
		OutputStream os = response.getOutputStream();
		if ("0".equals(this.param.get_pagesize())) {// ��Ϊ�����������еĵ�������ΪЧ�ʣ����÷�ҳ�ķ�ʽ��������
			this.param.set_pagesize("" + CommonExportBean.EXCELOUT_PAGE_SIZE);// ����ÿ�����ļ�¼��
			this.param.setQueryAll(false);
		}
		/**
		 */
		long startindex = 1;
		long endindex = 0;
		if (param.getStartindex() != null && !"".equals(param.getStartindex())) {
			startindex = Long.parseLong((param.getStartindex()));
		}
		if (param.getEndindex() != null && !"".equals(param.getEndindex())) {
			endindex = Long.parseLong((param.getEndindex()));
		}
		if ((param.getStartindex() != null && !"".equals(param.getStartindex()))
				&& (param.getEndindex() != null && !"".equals(param
						.getEndindex()))) {
			PageSetting.checkPageIndex(startindex, endindex,
					Long.parseLong(param.get_pagesize()));
		}

		for (; ; startindex++) {

			// for (int startindex = 1;; startindex++) {
			// baseActionForm.set_pageno(String.valueOf(startindex));
			if (endindex != 0 && startindex > endindex) {
				break;
			}
			this.param.set_pageno("" + startindex);// ���õ�����ҳ��
			if ("doList".equals(commonExportBean.queryMethodName)) {
				doList();

			} else {
				Method method = this.getClass().getMethod(
						commonExportBean.queryMethodName, null);
				method.invoke(this, null);
			}
			list = (ArrayList) (getDp().getDatas());
			if (list != null && !list.isEmpty()) {
				// ��ʱ��������һ�У�Ϊ����
				// System.out.println("���ԣ����ڵ���������excel����ǰʱ�䣺"+new
				// Date().toLocaleString());
				commonExportBean.write(os, list.iterator(),
						commonExportBean.voClassArray);
				if ("10000".equals(this.param.get_pagesize())) {
					if (list.size() < Integer.parseInt(this.param
							.get_pagesize())
							|| ((this.getDp().getRowCount()
									+ CommonExportBean.EXCELOUT_PAGE_SIZE - 1) / CommonExportBean.EXCELOUT_PAGE_SIZE) <= startindex) {// �������һҳ
						break;
					}
				} else {
					if (list.size() < CommonExportBean.EXCELOUT_PAGE_SIZE
							|| ((this.getDp().getRowCount()
									+ CommonExportBean.EXCELOUT_PAGE_SIZE - 1) / CommonExportBean.EXCELOUT_PAGE_SIZE) <= startindex) {// �������һҳ
						break;
					}
				}
			} else {// ��ҳû������
				break;
			}
			list.clear();
		}
	}

	/*
	 * ģ�巽��, �����������������ظ�ʱ�Ĵ�����Ϣ @param actionMapping @param actionForm @param
	 */
	protected void onDuplicatePk() {
		setActionMessage(I18nMessage.getPublicString("msgDuplicatePk"));
	}

	public String doEditNew() throws Exception {
		Object contentVO = findVOFromDB();
		if (contentVO == null) {
			CMD = WEB_CMD_NEW;
		} else {
			CMD = WEB_CMD_EDIT;
		}
		BeanUtils.copyProperties(form, contentVO);
		return WEB_RESULT_CONTENT;
	}

	public String doExcel() throws Exception {
		CommonExportBean commonExportBean = (CommonExportBean) getRequest()
				.getAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT);
		if (commonExportBean.voClassArray == null)
			commonExportBean.voClassArray = new Class[] { clsVO };
		// commonExportBean.queryMethodName = "doList";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(form, getRequest(), getResponse(),
				(User) getDBAccessUser(), this);
		return null;
	}

	public String doTxt() throws Exception {
		return WEB_RESULT_LIST;
	}

	// ���txt��׼������
	public void prepareResponse(String fileName)
			throws UnsupportedEncodingException {
		getResponse().setCharacterEncoding("GBK");
		getResponse().setHeader("pragma", "no-cache");
		getResponse().setHeader("Cache-control", "public");
		getResponse().setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + fileName + ".txt";
		getResponse().setHeader("Content-Disposition",
				new String(fn.getBytes("GBK"), "ISO-8859-1"));
		getResponse().setContentType("text/plain;charset=gbk");
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

	public String getWEB_CMD_NEW() {
		return WEB_CMD_NEW;
	}

	public String getWEB_CMD_EDIT() {
		return WEB_CMD_EDIT;
	}

	public String getWEB_CMD_SAVE() {
		return WEB_CMD_SAVE;
	}

	private void processException(Throwable e) {
		log.error(e.getMessage());
		String msg = "";
		if (e instanceof InvocationTargetException) {
			InvocationTargetException ie = (InvocationTargetException) e;
			Throwable t = ie.getTargetException();
			if (null != t.getCause()) {
				if (null != t.getCause().getMessage())
					msg = t.getCause().getMessage();
			} else {
				msg = t.getMessage() != null ? t.getMessage() : t.toString();
			}
		} else if (e instanceof UndeclaredThrowableException) {
			UndeclaredThrowableException ue = (UndeclaredThrowableException) e;
			Throwable t = ue.getUndeclaredThrowable();
			if (null != t.getCause()) {
				if (null != t.getCause().getMessage())
					msg = t.getCause().getMessage();
			} else {
				msg = t.getMessage() != null ? t.getMessage() : t.toString();
			}
			msg = t.getMessage() != null ? t.getMessage() : t.toString();

		} else {

			if (null != e.getCause()) {
				if (null != e.getCause().getMessage())
					msg = e.getCause().getMessage();
			} else {
				msg = e.getMessage() != null ? e.getMessage() : e.toString();
			}
			msg = e.getMessage() != null ? e.getMessage() : e.toString();
		}
		if (log.isErrorEnabled())
			log.error("ִ��ʧ��,ԭ��" + msg);

		addActionError(msg); // Struts2 �ṩ
	}

	// Add by yu-wenjun

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
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * ֱ��������ַ���.
	 */
	protected void renderText(String text) {
		render(text, "text/plain;charset="
				+ getRequest().getCharacterEncoding());
	}

	/**
	 * ֱ�������HTML.
	 */
	protected void renderHtml(String text) {
		render(text, "text/html;charset=" + getRequest().getCharacterEncoding());
	}

	/**
	 * ֱ�������XML.
	 */
	protected void renderXML(String text) {
		render(text, "text/xml;charset=" + getRequest().getCharacterEncoding());
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
	 * 
	 * дJSON�б���� - ����ΪServiceResult
	 * 
	 * @param serviceResult
	 * @param resultFields
	 */
	public void writeJSONDataPackage(DataPackage serviceResult,
			String[] resultFields) {
		List<ColumnSet> set = new ArrayList<ColumnSet>();
		for (String dtl : resultFields) {
			ColumnSet dtlSet = new ColumnSet(dtl, "");
			set.add(dtlSet);
		}
		this.writeJSONDataPackage(serviceResult, set);
	}

	/**
	 * 
	 * дJSON�б���� - ����ΪDataPackage
	 * 
	 * @param dp
	 */
	public void writeJSONDataPackage(DataPackage dp, List resultFields) {
		try {
			// Assert.notEmpty(args);
			JSONObject jsonObject = new JSONObject();
			// ҵ��ɹ�
			List list = dp.getDatas();
			List dataList = new ArrayList();
			// ת��ҳ������
			parseData(list, dataList, resultFields);

			Page page = new Page(dp.getRowCount(), dp.getPageSize(),
					dp.getPageNo());
			// �Ƿ�ɹ�
			jsonObject.put(JSONKey.IS_SUCCESS, true);
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
						value = getProperty(value, arrArg[j]);
						if (value != null) {
							value = getProperty(value, arrArg[j + 1]);
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
	 * ��PropertyUtils.getProperty�Ĳ���,����ȡ��Map���Ӧkey��ֵ
	 * 
	 * @param value
	 * @param arg
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private Object getProperty(Object value, String key)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Object obj = null;
		if (value instanceof Map) {// �ж�value�Ƿ�Map��ʵ��,��ΪMap�Ѿ�Ŀ��ӿ�,����ҪisAssignableFrom���жϳ���
			// ���value��Map������,ֱ��ȡKEY
			Map m = (Map) value;
			obj = m.get(key);

		} else {
			obj = PropertyUtils.getProperty(value, key);
		}

		return obj;
	}

	/**
	 * ������������Ϣ
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}

	/**
	 * ����������ʵ��
	 * 
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		// ������ʵ��
		return null;
	}

	/**
	 * println ֧�ֶ������ͣ� write ֻ֧���ַ���
	 * 
	 * @param response
	 * @param obj
	 * @throws Exception
	 */
	public void ajaxUpdate(HttpServletResponse response, Object obj)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expires", "0");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.flush();
	}

	/**
	 * println ֧�ֶ������ͣ� write ֻ֧���ַ��� <br />
	 * �ʺ����XML ��ʽ
	 * 
	 * @param response
	 * @param obj
	 * @throws Exception
	 */
	public void ajaxXmlUpdate(HttpServletResponse response, Object obj)
			throws Exception {
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expires", "0");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.flush();
	}
}
