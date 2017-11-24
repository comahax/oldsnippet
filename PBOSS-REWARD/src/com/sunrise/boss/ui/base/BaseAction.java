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
 * Action���࣬ʵ��һ�����ɾ�Ĳ鵼��
 * 
 * @since 1.0
 * 
 * 
 */
public class BaseAction extends Action {

	// protected String command; //���ش��󣬶��߳�ʱ�ᵼ�»������

	protected Class voClass; // ���������ำֵ��vo ����

	protected String[] pkNameArray; // �������������飬���ֻ�в�ѯ���������õ���������������ำֵ��

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
				// ���÷�����Ϊ do???�ķ��� ��������Ϊselect.do �����doSelect(actionMapping,
				// actionForm, request, response, user)
				// ע��URL���õķ������Ʊ���ȫΪСд��ʵ�ֵķ�������Ҫ����ĸ��д
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
	 * �鿴��Ϣ
	 */
	protected ActionForward doView(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		return (actionMapping.findForward("content"));
	}

	/**
	 * ��ѯ
	 */
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();
		BaseActionForm baseForm = (BaseActionForm) actionForm;
		// BeanUtils.copyProperties(listVO, actionForm);

		setListVO(listVO, actionForm); // ���ú�listVO����OrdinaryΪ��ѯ����

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
	 * ��ѯ����ʾ��ҳ��
	 */
	protected ActionForward doListNoCount(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();

		setListVO(listVO, actionForm); // ���ú�listVO����OrdinaryΪ��ѯ����

		CommonDelegate delegate = new CommonDelegate(voClass);

		DataPackage dp = delegate.doQuery(listVO, user, false);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	/**
	 * ��ѯ���������ʷ��
	 */
	public ActionForward doListhis(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		boolean historyFlag = isQueryHistoryDB(user, request); // �Ƿ��ѯ��ʷ���ʶ
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();
		setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����

		CommonDelegate delegate;
		DataPackage dp;
		if (historyFlag) {// ��ѯ���������ʷ������
			BaseActionForm baseForm = (BaseActionForm) actionForm;
			int hispageno = Integer.valueOf(baseForm.get_hispageno()).intValue();
			if (hispageno > 0) {// ����ʷ��
				delegate = new CommonDelegate(getHistoryVoClass());
				((BaseListVO) listVO).set_pageno(baseForm.get_hispageno());
				dp = delegate.doQuery(listVO, user, false);
			} else {// ��������
				delegate = new CommonDelegate(voClass);
				dp = delegate.doQuery(listVO, user, false);
				int dataSize = Integer.valueOf(baseForm.get_pagesize()).intValue();
				if (dp.getDatas().size() == 0) {// ������û���ݣ�����ʷ��
					delegate = new CommonDelegate(getHistoryVoClass());
					((BaseListVO) listVO).set_pageno("1");
					dp = delegate.doQuery(listVO, user, false);
					baseForm.set_hispageno("1");
					String pageNo = String.valueOf(Integer.valueOf(baseForm.get_pageno()).intValue() - 1); // �����⵱ǰҳ����1
					baseForm.set_pageno(pageNo);
				} else if (dp.getDatas().size() < dataSize) {
					baseForm.set_hispageno("0");// ׼����һҳ��ѯ��ʼ����ʷ��
				}
			}
		} else {// ֻ��ѯ����������
			delegate = new CommonDelegate(voClass);
			dp = delegate.doQuery(listVO, user, false);
		}

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	/*
	 * ���History VO����������Ĺ���������Ը�д�÷���
	 */
	public Class getHistoryVoClass() throws ClassNotFoundException {
		String voName = voClass.getName();
		String historyVoName = voName.substring(0, voName.length() - 2) + "hisVO";
		return Class.forName(historyVoName);
	}
	
	/*
	 * �ж��Ƿ��ѯ��ʷ��
	 */
	public boolean isQueryHistoryDB(User user) {
		return isQueryHistoryDB(user, null);
	}

	/*
	 * �ж��Ƿ��ѯ��ʷ�⣬��request������Ϊnullʱ������LVM�ӹܱ�ʶ
	 */
	public boolean isQueryHistoryDB(User user, HttpServletRequest request) {

		// ������ʵʩ����Ǩ��ֵ����Ϊ��0 ��ʱ��ֻ����������в�������
		// Ӧ�ó������жϷ���LVM�ӹܺ󣬲��ٶ���ʷ����в���
		// 
		// �������� ������ʶ ����ֵ˵��
		// �Ƿ���ʵʩ����Ǩ�� common 1 0 ��1 �� ��Ĭ������Ϊ��0 ��
		// �Ƿ��ѷ���LVM�ӹ� common 2 0 ��1 �� ��Ĭ������Ϊ��0 ��

		boolean removeFlag = false; // �Ƿ���ʵʩ����Ǩ�Ʊ�ʶ
		boolean lvmFlag = false; // �Ƿ��ѷ���LVM�ӹܱ�ʶ

		SysparamDelegate delegate;
		try {
			delegate = new SysparamDelegate();
			SysparamVO sysparavo = new SysparamVO();
			// �Ƿ���ʵʩ����Ǩ��
			sysparavo.setParamtype("common");
			sysparavo.setSystemid(new Long(1));
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo, user);
			if (sysparavo != null && sysparavo.getParamvalue().equals("1")) {
				removeFlag = true;
			}
			// �Ƿ��ѷ���LVM�ӹ�
			sysparavo.setParamtype("common");
			sysparavo.setSystemid(new Long(2));
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo, user);
			if (sysparavo != null && sysparavo.getParamvalue().equals("1")) {
				lvmFlag = true;
				if(request!=null){
					//���ñ�־λ������ǰ̨��ʾ�û���ע��LVM�ӹ��У�����ѯ��ʷ���ݣ�
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
	 * ɾ��
	 */
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		CommonDelegate delegate = new CommonDelegate(voClass);
		for (int i = 0; i < selectArray.length; i++) {
			if (selectArray[0].indexOf('|') == -1) { // ��һ����
				delegate.doRemoveByPK(getDeletePK(selectArray[i]), user);
			} else { // ��������
				delegate.doRemoveByVO(getDeletePkVO(selectArray[i]), user);
			}
		}

		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * �½�
	 */
	protected ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// �½�ʱ����form��Ĭ��ֵ
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * �༭
	 */
	protected ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * ׼���༭ָ����¼,�����¼������,��תΪ����ģʽ. �÷���ֻ���ض�����ʱʹ��. <br>
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
	 * ����
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {

		Object contentVO = voClass.newInstance();
		setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���

		CommonDelegate delegate = new CommonDelegate(voClass);
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// ����
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} else {// ����
			Object vo = null;
			if (pkNameArray.length == 1) { // ��һ����
				Object pk = PropertyUtils.getNestedProperty(contentVO, pkNameArray[0]);
				// Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
				// ���ﷵ�ص���String����
				if (pk != null) {
					vo = delegate.doFindByPk((Serializable) pk, user);
				}
			} else {// ��������
				Object pkVO = voClass.newInstance();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = delegate.doFindByPk((Serializable) pkVO, user);
			}
			if (vo == null) {
				delegate.doCreate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����ظ�");
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
		// list.jsp��ת���������
		if (parameter != null)
			pk = parameter;
		CommonDelegate delegate = new CommonDelegate(voClass);
		Object contentVO;
		if (!pk.trim().equalsIgnoreCase("")) { // ��list.jsp ������
			if (pk.indexOf("|") == -1) { // ��һ����
				contentVO = delegate.doFindByPk(getDeletePK(pk), user);
			} else { // ��������
				contentVO = delegate.doFindByPk(getDeletePkVO(pk), user);
			}
			return contentVO;
		}
		return null;
	}

	/**
	 * ����һ����ɾ��ʱ���������� ����List.jsp��ɾ����ťʱ���Ӳ�����ȡ��ɾ�����ݵ�������
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
			throw new Exception("�������������");
		}
	}

	/**
	 * ����������ɾ��ʱ����������VO ����List.jsp��ɾ����ťʱ���Ӳ�����ȡ��ɾ�����ݵ�������
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
	 * ȡ�ÿͻ��˵�locale
	 * 
	 * @param request
	 * @return
	 */
	public Locale getUserLocale(HttpServletRequest request) {
		Locale userLocale = null;
		HttpSession session = request.getSession(false);

		String locale = Globals.LOCALE_KEY; // ���ֵ��org.apache.struts.action.LOCALE
		if (session != null) {
			userLocale = (Locale) session.getAttribute(locale);
		}
		if (userLocale == null) {
			userLocale = request.getLocale();
		}
		return userLocale;
	}

	/**
	 * ���Excel ��Ҫ�̳в���д
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
	public void ExportQuery(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		// ��ѯ�������,��ҳ��ѯ
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
						|| ((dp.getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// �������һҳ
					break;
				}
			} else {// ��ҳû������
				break;
			}
			list.clear();
		}
	}
	public void ExportQueryNoseq(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		// ��ѯ�������,��ҳ��ѯ
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
						|| ((dp.getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// �������һҳ
					break;
				}
			} else {// ��ҳû������
				break;
			}
			list.clear();
		}
	}

	/**
	 * ���Txt ��Ҫ�̳в���д
	 */
	protected ActionForward doTxt(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		return null;
	}

	// ------------���·�������������������----------------------------------------

	/**
	 * ��ʽ������listVO��ֵ����Ϊ��ѯ������listVO�ѳ�ʼΪlistForm��ֵ
	 */
	protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ʽ������ VO��ֵ���Ա��浽���ݿ⣬VO �ѳ�ʼΪForm��ֵ
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	protected void setSaveVO(Object vo, final ActionForm form) throws Exception {
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(vo, form);
	}

	/**
	 * �½�ʱ,����Form��Ĭ��ֵ
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
	 * ģ�巽��, �����������������ظ�ʱ�Ĵ�����Ϣ @param actionMapping @param actionForm @param
	 * request @param response @param user
	 */
	protected void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {

	}
}
