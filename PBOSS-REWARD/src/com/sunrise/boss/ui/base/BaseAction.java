package com.sunrise.boss.ui.base;

import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * Action基类，实现一般的增删改查导出
 * 
 * @since 1.0
 * 
 * 
 */
public class BaseAction extends Action {

	// protected String command; //严重错误，多线程时会导致互相干扰

	protected Class voClass; // 必须在子类赋值，vo 类型

	protected String[] pkNameArray; // 主键的名字数组，如果只有查询导出不会用到，否则必须在子类赋值，

	static protected Class[] types = { ActionMapping.class, ActionForm.class, HttpServletRequest.class, HttpServletResponse.class, User.class };

	protected User getUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);

		return user;
	}

	protected String getCommandString(HttpServletRequest request) {
		String cmd = request.getParameter(WebConstant.PAGE_ATTRIBUTE_COMMAND);
		return (cmd == null) ? WebConstant.COMMAND_STRING_LIST : cmd;
	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = getUser(request);

		String command = getCommandString(request);
		try {
			if (command.equals(WebConstant.COMMAND_STRING_VIEW)) {
				return doView(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_LIST)) {
				return doList(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_LISTNOCOUNT)) {
				return doListNoCount(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_TOEXCEL)) {
				return doExcel(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_TOTXT)) {
				return doTxt(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_DELETE)) {
				return doDelete(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_NEW)) {
				return doNew(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_EDIT)) {
				return doEdit(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_SAVE)) {
				return doSave(actionMapping, actionForm, request, response, user);
			} else if (command.equals(WebConstant.COMMAND_STRING_EDITNEW)) {
				return doEditNew(actionMapping, actionForm, request, response, user);
			} else {
				// 调用方法名为 do???的方法 例如请求为select.do 则调用doSelect(actionMapping,
				// actionForm, request, response, user)
				// 注：URL调用的方法名称必须全为小写，实现的方法则需要首字母大写
				return doOther(command, actionMapping, actionForm, request, response, user);
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			ex.printStackTrace();
			return (actionMapping.findForward("list"));
		}
	}

	protected ActionForward doOther(String command, ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
		((BaseActionForm) actionForm).setCmdState(command);
		try {
			if (command != null && command.length() > 0) {
				String methodName = "do" + command.substring(0, 1).toUpperCase() + command.substring(1, command.length()).toLowerCase();
				Method method = this.getClass().getMethod(methodName, types);
				Object[] args = { actionMapping, actionForm, request, response, user };
				Object obj = method.invoke(this, args);
				return (ActionForward) obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "wrong path");
		return (actionMapping.findForward("error"));
	}

	/**
	 * 查看信息
	 */
	protected ActionForward doView(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		return (actionMapping.findForward("content"));
	}

	/**
	 * 查询
	 */
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();
		BaseActionForm baseForm = (BaseActionForm) actionForm;
		// BeanUtils.copyProperties(listVO, actionForm);

		setListVO(listVO, actionForm); // 设置好listVO，作Ordinary为查询条件

		CommonDelegate delegate = new CommonDelegate(voClass);
		boolean isDisplayCount = true;
		if (baseForm.get_displaycount() != null && (baseForm.get_displaycount().equalsIgnoreCase("no") || baseForm.get_displaycount().equalsIgnoreCase("false"))) {
			isDisplayCount = false;
		}
		DataPackage dp = delegate.doQuery(listVO, user, isDisplayCount);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	/**
	 * 查询不显示总页数
	 */
	protected ActionForward doListNoCount(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();

		setListVO(listVO, actionForm); // 设置好listVO，作Ordinary为查询条件

		CommonDelegate delegate = new CommonDelegate(voClass);

		DataPackage dp = delegate.doQuery(listVO, user, false);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	/**
	 * 查询生产库和历史库
	 */
	public ActionForward doListhis(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		boolean historyFlag = isQueryHistoryDB(user, request); // 是否查询历史库标识
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();
		setListVO(listVO, actionForm); // 设置好listVO，作为查询条件

		CommonDelegate delegate;
		DataPackage dp;
		if (historyFlag) {// 查询生产库和历史库数据
			BaseActionForm baseForm = (BaseActionForm) actionForm;
			int hispageno = Integer.valueOf(baseForm.get_hispageno()).intValue();
			if (hispageno > 0) {// 查历史库
				delegate = new CommonDelegate(getHistoryVoClass());
				((BaseListVO) listVO).set_pageno(baseForm.get_hispageno());
				dp = delegate.doQuery(listVO, user, false);
			} else {// 查生产库
				delegate = new CommonDelegate(voClass);
				dp = delegate.doQuery(listVO, user, false);
				int dataSize = Integer.valueOf(baseForm.get_pagesize()).intValue();
				if (dp.getDatas().size() == 0) {// 生产库没数据，查历史库
					delegate = new CommonDelegate(getHistoryVoClass());
					((BaseListVO) listVO).set_pageno("1");
					dp = delegate.doQuery(listVO, user, false);
					baseForm.set_hispageno("1");
					String pageNo = String.valueOf(Integer.valueOf(baseForm.get_pageno()).intValue() - 1); // 生产库当前页数减1
					baseForm.set_pageno(pageNo);
				} else if (dp.getDatas().size() < dataSize) {
					baseForm.set_hispageno("0");// 准备下一页查询开始查历史库
				}
			}
		} else {// 只查询生产库数据
			delegate = new CommonDelegate(voClass);
			dp = delegate.doQuery(listVO, user, false);
		}

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	/*
	 * 如果History VO不符合下面的规则，子类可以复写该方法
	 */
	public Class getHistoryVoClass() throws ClassNotFoundException {
		String voName = voClass.getName();
		String historyVoName = voName.substring(0, voName.length() - 2) + "hisVO";
		return Class.forName(historyVoName);
	}
	
	/*
	 * 判断是否查询历史库
	 */
	public boolean isQueryHistoryDB(User user) {
		return isQueryHistoryDB(user, null);
	}

	/*
	 * 判断是否查询历史库，当request参数不为null时，设置LVM接管标识
	 */
	public boolean isQueryHistoryDB(User user, HttpServletRequest request) {

		// 当否已实施数据迁移值设置为“0 否”时，只对生产库进行操作即可
		// 应用程序在判断发生LVM接管后，不再对历史库进行操作
		// 
		// 参数类型 参数标识 参数值说明
		// 是否已实施数据迁移 common 1 0 否；1 是 ；默认设置为“0 否”
		// 是否已发生LVM接管 common 2 0 否；1 是 ；默认设置为“0 否”

		boolean removeFlag = false; // 是否已实施数据迁移标识
		boolean lvmFlag = false; // 是否已发生LVM接管标识

		SysparamDelegate delegate;
		try {
			delegate = new SysparamDelegate();
			SysparamVO sysparavo = new SysparamVO();
			// 是否已实施数据迁移
			sysparavo.setParamtype("common");
			sysparavo.setSystemid(new Long(1));
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo, user);
			if (sysparavo != null && sysparavo.getParamvalue().equals("1")) {
				removeFlag = true;
			}
			// 是否已发生LVM接管
			sysparavo.setParamtype("common");
			sysparavo.setSystemid(new Long(2));
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo, user);
			if (sysparavo != null && sysparavo.getParamvalue().equals("1")) {
				lvmFlag = true;
				if(request!=null){
					//设置标志位，用于前台提示用户（注：LVM接管中，不查询历史数据）
					request.setAttribute("_isLVM", "TRUE"); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return removeFlag && (!lvmFlag);
	}

	private Object getListVO() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String voName = voClass.getName();
		String listVoName = voName.substring(0, voName.length() - 2) + "ListVO";
		return Class.forName(listVoName).newInstance();
	}

	/**
	 * 删除
	 */
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		CommonDelegate delegate = new CommonDelegate(voClass);
		for (int i = 0; i < selectArray.length; i++) {
			if (selectArray[0].indexOf('|') == -1) { // 单一主键
				delegate.doRemoveByPK(getDeletePK(selectArray[i]), user);
			} else { // 复合主键
				delegate.doRemoveByVO(getDeletePkVO(selectArray[i]), user);
			}
		}

		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 新建
	 */
	protected ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// 新建时设置form的默认值
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * 编辑
	 */
	protected ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * 准备编辑指定记录,如果记录不存在,则转为新增模式. 该方法只在特定需求时使用. <br>
	 * added by He Kun 2006-8-31
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doEditNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Object contentVO = getContentVO(request, user);
		if (contentVO == null) {
			((BaseActionForm) actionForm).setCmdState(WebConstant.COMMAND_STRING_NEW);
		} else {
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {

		Object contentVO = voClass.newInstance();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存

		CommonDelegate delegate = new CommonDelegate(voClass);
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} else {// 新增
			Object vo = null;
			if (pkNameArray.length == 1) { // 单一主键
				Object pk = PropertyUtils.getNestedProperty(contentVO, pkNameArray[0]);
				// Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
				// 这里返回的是String类型
				if (pk != null) {
					vo = delegate.doFindByPk((Serializable) pk, user);
				}
			} else {// 复合主建
				Object pkVO = voClass.newInstance();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = delegate.doFindByPk((Serializable) pkVO, user);
			}
			if (vo == null) {
				delegate.doCreate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "主键重复");
				onDuplicatePk(actionMapping, actionForm, request, response, user);
			}
		}
		return (actionMapping.findForward("content"));
	}

	protected void getContentVO(HttpServletRequest request, User user, ActionForm actionForm) throws Exception {

		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null)
			throw new NullPointerException("pk is required.");
		Object contentVO = getContentVO(request, user);
		if (contentVO == null)
			throw new NullPointerException("VO not found, pk " + pk + " of " + ClassUtils.getShortClassName(actionForm.getClass()));
		BeanUtils.copyProperties(actionForm, contentVO);

	}

	protected Object getContentVO(HttpServletRequest request, User user) throws Exception {
		String pk = "";
		String parameter = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		// list.jsp跳转过来的情况
		if (parameter != null)
			pk = parameter;
		CommonDelegate delegate = new CommonDelegate(voClass);
		Object contentVO;
		if (!pk.trim().equalsIgnoreCase("")) { // 由list.jsp 传过来
			if (pk.indexOf("|") == -1) { // 单一主键
				contentVO = delegate.doFindByPk(getDeletePK(pk), user);
			} else { // 复合主键
				contentVO = delegate.doFindByPk(getDeletePkVO(pk), user);
			}
			return contentVO;
		}
		return null;
	}

	/**
	 * 按单一主键删除时，返回主键 用于List.jsp按删除按钮时，从参数中取出删除数据的主键列
	 */
	protected Serializable getDeletePK(String pkValue) throws Exception {
		Method[] methodArray = voClass.getMethods();
		Class pkType = null;
		for (int i = 0; i < methodArray.length; i++) {
			if (methodArray[i].getName().equalsIgnoreCase("get" + pkNameArray[0])) {
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
			throw new Exception("错误的主键类型");
		}
	}

	/**
	 * 按复合主键删除时，返回主键VO 用于List.jsp按删除按钮时，从参数中取出删除数据的主键列
	 */
	protected Serializable getDeletePkVO(String pkValue) throws Exception {
		String[] pkValueArray = pkValue.split("\\|");
		Serializable vo = (Serializable) voClass.newInstance();
		for (int j = 0; j < pkValueArray.length; j++) {
			BeanUtils.setProperty(vo, pkNameArray[j], pkValueArray[j]);
		}
		return vo;
	}

	/**
	 * 取得客户端的locale
	 * 
	 * @param request
	 * @return
	 */
	public Locale getUserLocale(HttpServletRequest request) {
		Locale userLocale = null;
		HttpSession session = request.getSession(false);

		String locale = Globals.LOCALE_KEY; // 这个值是org.apache.struts.action.LOCALE
		if (session != null) {
			userLocale = (Locale) session.getAttribute(locale);
		}
		if (userLocale == null) {
			userLocale = request.getLocale();
		}
		return userLocale;
	}

	/**
	 * 输出Excel 需要继承并重写
	 */
	protected ActionForward doExcel(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		CommonExportBean commonExportBean = (CommonExportBean) request.getAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT);
		commonExportBean.voClassArray = new Class[] { voClass };
		commonExportBean.queryMethodName = "doList";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		return actionMapping.findForward(null);
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
	public void ExportQuery(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		// 查询数据输出,分页查询
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
		ArrayList list;
		OutputStream os = response.getOutputStream();
		for (int startindex = 1;; startindex++) {
			baseActionForm.set_pageno(String.valueOf(startindex));
			if ("doList".equals(commonExportBean.queryMethodName)) {
				doList(actionMapping, actionForm, request, response, user);
			} else {
				Method queryMethod = this.getClass().getMethod(commonExportBean.queryMethodName, types);
				queryMethod.invoke(this, new Object[] { actionMapping, actionForm, request, response, user });
			}
			DataPackage dp=(DataPackage) request.getAttribute(WebConstant.PAGE_ATTRIBUTE_LIST);
			list = (ArrayList) dp.getDatas();
			if (list != null && !list.isEmpty()) {
				commonExportBean.write(os, list.iterator(), commonExportBean.voClassArray);
				if (list.size() < CommonExportBean.EXCELOUT_PAGE_SIZE
						|| ((dp.getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// 代表最后一页
					break;
				}
			} else {// 该页没有数据
				break;
			}
			list.clear();
		}
	}
	public void ExportQueryNoseq(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		// 查询数据输出,分页查询
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
		ArrayList list;
		OutputStream os = response.getOutputStream();
		for (int startindex = 1;; startindex++) {
			baseActionForm.set_pageno(String.valueOf(startindex));
			if ("doList".equals(commonExportBean.queryMethodName)) {
				doList(actionMapping, actionForm, request, response, user);
			} else {
				Method queryMethod = this.getClass().getMethod(commonExportBean.queryMethodName, types);
				queryMethod.invoke(this, new Object[] { actionMapping, actionForm, request, response, user });
			}
			DataPackage dp=(DataPackage) request.getAttribute(WebConstant.PAGE_ATTRIBUTE_LIST);
			list = (ArrayList) dp.getDatas();
			if (list != null && !list.isEmpty()) {
				commonExportBean.writeNoseq(os, list.iterator(), commonExportBean.voClassArray);
				if (list.size() < CommonExportBean.EXCELOUT_PAGE_SIZE
						|| ((dp.getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// 代表最后一页
					break;
				}
			} else {// 该页没有数据
				break;
			}
			list.clear();
		}
	}

	/**
	 * 输出Txt 需要继承并重写
	 */
	protected ActionForward doTxt(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		return null;
	}

	// ------------以下方法可以由子类来覆盖----------------------------------------

	/**
	 * 格式化处理listVO的值，作为查询条件，listVO已初始为listForm的值
	 */
	protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 格式化处理 VO的值，以保存到数据库，VO 已初始为Form的值
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	protected void setSaveVO(Object vo, final ActionForm form) throws Exception {
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(vo, form);
	}

	/**
	 * 新建时,设置Form的默认值
	 */
	protected void setNewForm(ActionForm actionForm) {
	}

	public Class getVoClass() {
		return voClass;
	}

	public void setVoClass(Class voClass) {
		this.voClass = voClass;
	}

	/*
	 * 模板方法, 允许子类设置主键重复时的错误消息 @param actionMapping @param actionForm @param
	 * request @param response @param user
	 */
	protected void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {

	}
}
