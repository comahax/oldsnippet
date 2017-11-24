/**
 * auto-generated code Sun Aug 27 13:31:54 CST 2006
 */
package com.sunrise.boss.ui.cms.employee;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelVO;
import com.sunrise.boss.business.cms.way.persistent.AGWayVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleListVO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.empmodel.EmpmodelDelegate;
import com.sunrise.boss.delegate.cms.way.AGWayDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: EmployeeAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */
public class EmployeeAction extends BaseDelegateAction {
	public EmployeeAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(EmployeeVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "employeeid";
	}

	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"��ͬ��ŵ���ԱID�Ѿ����ڻ��ID�ѱ���ʷ��Առ��!");

	}

	/**
	 * ����
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		EmployeeForm form = (EmployeeForm) actionForm;
		EmployeeVO contentVO = new EmployeeVO();
		setSaveVO(contentVO, form);

		EmployeeDelegate delegate = new EmployeeDelegate();
		EmployeeVO existObj = delegate.doFindByPk(contentVO.getEmployeeid(),
				user);
		if (existObj != null) {
			org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
					contentVO);
			contentVO = existObj;
		}

		try {
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				contentVO = delegate.doUpdate(contentVO, user);
			} else {
				if (existObj != null) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"�����ظ�");
					onDuplicatePk(actionMapping, actionForm, request, response,
							user);
					return (actionMapping.findForward("content"));
				} else {
					contentVO = delegate.doCreate(contentVO, user);
				}
			}
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (BusinessException e) {
			request.setAttribute("REEDIT", "TRUE");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return (actionMapping.findForward("content"));
	}

	/**
	 * ֻ���Բ鿴���ṩ��Ⱥ����Ϣ����������
	 */
	public ActionForward doOnlyview(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		return (actionMapping.findForward("view"));
	}

	/**
	 * ���������û����б�,�ṩ����Ҫѡ���û���ģ��ʹ��
	 */
	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeForm form = (EmployeeForm) actionForm;
		Page.setPageSize(request, form);

		EmployeeListVO listVO = new EmployeeListVO();
		setListVO(listVO, actionForm);

		EmployeeDelegate delegate = new EmployeeDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("select"));
	}
	
	/**
	 * �ṩ����Ҫѡ���û���ģ��ʹ��
	 */
	public ActionForward doShowemp(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeForm form = (EmployeeForm) actionForm;
		Page.setPageSize(request, form);

		EmployeeListVO listVO = new EmployeeListVO();
		setListVO(listVO, form);
		String isnet = request.getParameter("isnet");
		String empstatus = request.getParameter("empstatus");
		String wayid = request.getParameter("wayid");
		if (!"".equals(isnet) && isnet != null) {
			listVO.set_ne_isnet(isnet);
			form.set_ne_isnet(isnet);
		}
		if (!"".equals(empstatus) && empstatus != null) {
			listVO.set_ne_empstatus(empstatus);
			form.set_ne_empstatus(empstatus);
		}
		if (!"".equals(wayid) && wayid != null) {
			listVO.set_se_wayid(wayid);
			form.set_se_wayid(wayid);
		}

		EmployeeDelegate delegate = new EmployeeDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("showemp"));
	}
	
	/**
	 * ���������û����б�,�ṩ����Ҫѡ���û���ģ��ʹ��
	 */
	public ActionForward doSelecttel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeForm form = (EmployeeForm) actionForm;
		Page.setPageSize(request, form);

		EmployeeListVO listVO = new EmployeeListVO();
		setListVO(listVO, actionForm);

		EmployeeDelegate delegate = new EmployeeDelegate();
		listVO.set_snn_telephone("T");
		listVO.set_ne_isnet("2");
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("selectTel"));
	}

	/**
	 * ���������Ա������ʾ
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietyshow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return this.doSocietylist(actionMapping, actionForm, request, response,
				user);
	}

	/**
	 * ���������Ա�����ѯ
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietylist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		EmployeeListVO listVO = new EmployeeListVO();
		setListVO(listVO, actionForm);
		listVO.set_se_waytype("AG");// ��ͨ��������,���������
		// listVO.set_nne_empstatus("-1");// ��״̬��Ϊ -1����ɾ����
		String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
				+ user.getWayid()
				+ "' connect by prior   wayid   = upperwayid) and (empstatus is null or empstatus <> -1) "; // ����Ȩ������

		listVO.set_sql_waycondition(sql);
		EmployeeDelegate delegate = new EmployeeDelegate();
		// actionform.set_pagesize("20");
		// if(actionform.get_pageno()==null ||
		// "".equals(actionform.get_pageno())){
		// actionform.set_pageno("1");
		// }else {
		// actionform.set_pageno(actionform.get_pageno());
		// }
		DataPackage pack = delegate.doSocietyEmployeeQuery(listVO, user);
		// pack.setPageSize(20);
		// ���
		Iterator it = pack.getDatas().iterator();
		while (it.hasNext()) {
			EmployeeVO empVO = (EmployeeVO) (it.next());
			short isnet = empVO.getIsnet() == null ? 0 : empVO.getIsnet()
					.shortValue();
			short isopen = empVO.getIsopen() == null ? 0 : empVO.getIsopen()
					.shortValue();
			short empstatus = empVO.getEmpstatus() == null ? 0 : empVO
					.getEmpstatus().shortValue();
			if ((isnet == 1 || isnet==0 )&& isopen == 1 && empstatus == 1) {
				if (new AGWayDelegate().doHasRecords(empVO.getOfficetel()
						.trim(), user)) {
					empVO.setCancelFlag("1");
				}
			}
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		if ("G".equals(((EmployeeForm) actionForm).getKIND())) {
			return (actionMapping.findForward("societylist_g"));
		} else {
			return (actionMapping.findForward("societylist_g"));
		}
	}

	/**
	 * ���������Ա��������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doAdd(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		EmployeeForm form = new EmployeeForm();
		form = (EmployeeForm) actionForm;
		WayDelegate delegate = new WayDelegate();
		WayVO wayVO = delegate.doFindByPk(form.getWayid(), user);
		// ����Ĭ��ֵ
		form.setEmpstatus(new Short("0"));
		// �����Խ���Ӫ�����ж�
		if (wayVO != null 	&& ("AG".equals(wayVO.getWaytype()) ||
				("ET".equals(wayVO.getWaytype()) && wayVO.getRunmode()!=null &&  1 == wayVO.getRunmode().longValue())))
		{
			((EmployeeForm) actionForm).setCityid(wayVO.getCityid());
			((EmployeeForm) actionForm).setCountyid(wayVO.getCountyid());
			form.setZjty("");
			if ("SAGT".equals(wayVO.getWaysubtype())
					|| "PSAL".equals(wayVO.getWaysubtype())) {
				request.setAttribute("disFlag", "true");
				form.setZjty("false");
			} else if ("ET".equals(wayVO.getWaytype())
					&& 1 == wayVO.getRunmode().longValue()) {
				form.setZjty("true");
			}
		} else {
			if (!"".equals(form.getWayid())) {
				((EmployeeForm) actionForm).setWayid(null);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"��ѡ����������������Խ���Ӫ������������ѡ��");
			}
		}

		return (actionMapping.findForward("societycontent"));
	}

	/**
	 * �ƶ�������Ա��������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDitchadd(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		EmployeeForm form = new EmployeeForm();
		form = (EmployeeForm) actionForm;

		EmployeeDelegate delegate = new EmployeeDelegate();
		WayDelegate waydelegate = new WayDelegate();
		WayVO wayVO = waydelegate.doFindByPk(form.getWayid(), user);

		if (delegate.doUpperwayid(user.getWayid(), form.getWayid(), user)
				.getDatas().size() > 0) {
			((EmployeeForm) actionForm).setCityid(wayVO.getCityid());
			((EmployeeForm) actionForm).setCountyid(wayVO.getCountyid());

		} else {
			((EmployeeForm) actionForm).setWayid(null);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"��ѡ�����ǵ�ǰ����������ʵ��������������ѡ��");
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * ���������Ա����༭
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doServehalledit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeDelegate delegate = new EmployeeDelegate();
		EmployeeVO vo = delegate.doFindByPk(request.getParameter("PK"), user);
		if (delegate.doUpperwayid(user.getWayid(), vo.getWayid(), user)
				.getDatas().size() == 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"�������ǵ�ǰ����������ʵ������,���ܶ�������޸ģ�");
			return doServehalllist(actionMapping, actionForm, request,
					response, user);
		}
		((EmployeeForm) actionForm).setDitchFlag("ditchEdit");
		getContentVO(request, user, actionForm);
		return (actionMapping.findForward("content"));

	}

	/**
	 * ���������Ա����༭
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDitchmgredit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeDelegate delegate = new EmployeeDelegate();
		EmployeeVO vo = delegate.doFindByPk(request.getParameter("PK"), user);
		if (delegate.doUpperwayid(user.getWayid(), vo.getWayid(), user)
				.getDatas().size() == 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"�������ǵ�ǰ����������ʵ������,���ܶ�������޸ģ�");
			return doDitchmgrlist(actionMapping, actionForm, request, response,
					user);

		}
		((EmployeeForm) actionForm).setDitchFlag("ditchEdit");
		getContentVO(request, user, actionForm);
		return (actionMapping.findForward("content"));

	}

	/**
	 * ���������Ա����༭
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietyedit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		String wayid = ((EmployeeForm) actionForm).getWayid();

		getContentVO(request, user, actionForm);

		((EmployeeForm) actionForm).setSocietyFlag("societyEdit");

		WayDelegate delegate = new WayDelegate();

		if (!(wayid == null)) {
			WayVO wayVO = delegate.doFindByPk(wayid, user);

			if ("AG".equals(wayVO.getWaytype())) {
				((EmployeeForm) actionForm).setWayid(wayid);
				((EmployeeForm) actionForm).setCityid(wayVO.getCityid());
				((EmployeeForm) actionForm).setCountyid(wayVO.getCountyid());
				if ("DIS".equals(wayVO.getWaysubtype())
						|| "PSAL".equals(wayVO.getWaysubtype())) {
					// request.setAttribute("disFlag", "true");
				}
			} else {
				((EmployeeForm) actionForm).setWayid(null);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"��ѡ���������������������ѡ��");
			}
		} else {
			wayid = ((EmployeeForm) actionForm).getWayid();
			WayVO wayVO = delegate.doFindByPk(wayid, user);
			if ("DIS".equals(wayVO.getWaysubtype())
					|| "PSAL".equals(wayVO.getWaysubtype())) {
				request.setAttribute("disFlag", "true");
			}
		}
		
		EmpmodelDelegate empDelegate = new EmpmodelDelegate();
		EmpmodelListVO empListvo = new EmpmodelListVO();
		empListvo.set_se_employeeid(((EmployeeForm) actionForm).getEmployeeid());
		empListvo.set_se_model("3");
		empListvo.set_ne_state("0");
		DataPackage empDp = empDelegate.doQuery(empListvo, user);
		if(empDp.getDatas() != null && empDp.getDatas().size() != 0){
			((EmployeeForm) actionForm).setIsunpb(true);
		}else{
			((EmployeeForm) actionForm).setIsunpb(false);
		}
		return (actionMapping.findForward("societycontent"));
	}

	/**
	 * ���������Ա����ɾ��
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietydelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			EmployeeDelegate delegate = new EmployeeDelegate();

			for (int i = 0; i < selectArray.length; i++) {
				EmployeeVO vo = delegate.doFindByPk(selectArray[i], user);
				vo.setEmpstatus(new Short("1"));
				delegate.doUpdate(vo, user);
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return doSocietylist(actionMapping, actionForm, request, response, user);
	}

	/**
	 * ���������Ա������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietysave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeDelegate delegate = new EmployeeDelegate();
		EmployeeForm form = new EmployeeForm();
		form = (EmployeeForm) actionForm;
		if (form.getEmployeeid() == null || "".equals(form.getEmployeeid())) {// ����

			String employeeid = delegate.getEmployeeid(user);
			EmployeeVO oldVO = delegate.doFindByPk(employeeid, user);
			while (oldVO != null) {
				employeeid = delegate.getEmployeeid(user);
				oldVO = delegate.doFindByPk(employeeid, user);
			}
			form.setEmployeeid(employeeid);
		}

		if (((EmployeeForm) actionForm).getSocietyFlag().equals("societyEdit")) {
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
		}

		EmployeeVO contentVO = new EmployeeVO();
		setSaveVO(contentVO, form);

		EmployeeVO existObj = delegate.doFindByPk(contentVO.getEmployeeid(),
				user);
		if (existObj != null) {
			org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
					contentVO);
			contentVO = existObj;
		}

		try {
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				contentVO = delegate.doUpdate(contentVO, user);
			} else {
				if (existObj != null) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"�����ظ�");
					onDuplicatePk(actionMapping, actionForm, request, response,
							user);
					return (actionMapping.findForward("societycontent"));
				} else {
					contentVO = delegate.doSocietycreate(contentVO, user);
				}
			}
			
			EmpmodelDelegate empDelegate = new EmpmodelDelegate();
			EmpmodelListVO empListvo = new EmpmodelListVO();
			empListvo.set_se_employeeid(contentVO.getEmployeeid());
			empListvo.set_se_model("3");
			DataPackage empDp = empDelegate.doQuery(empListvo, user);
			
			if(form.isIsunpb()){
				if(empDp.getDatas() != null && empDp.getDatas().size() != 0){
					for(Iterator itt = empDp.getDatas().iterator(); itt.hasNext(); ){
						EmpmodelVO vo = (EmpmodelVO)itt.next();
						vo.setState(new Short("0"));
						empDelegate.doUpdate(vo, user);
					}
				}else{
					EmpmodelVO vo = new EmpmodelVO();
					vo.setEmployeeid(contentVO.getEmployeeid());
					vo.setModel("3");
					vo.setState(new Short("0"));
					empDelegate.doCreate(vo, user);
				}
			}else{
				if(empDp.getDatas() != null && empDp.getDatas().size() != 0){
					for(Iterator itt = empDp.getDatas().iterator(); itt.hasNext(); ){
						EmpmodelVO vo = (EmpmodelVO)itt.next();
						vo.setState(new Short("1"));
						empDelegate.doUpdate(vo, user);
					}
				}
			}
			
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (BusinessException e) {
			request.setAttribute("REEDIT", "TRUE");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("societycontent"));
		} catch (Exception e) {
			request.setAttribute("REEDIT", "TRUE");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("societycontent"));
		}

		WayDelegate waydelegate = new WayDelegate();
		WayVO wayVO = waydelegate.doFindByPk(form.getWayid(), user);

		if ("AG".equals(wayVO.getWaytype())) {
			if ("DIS".equals(wayVO.getWaysubtype())
					|| "PSAL".equals(wayVO.getWaysubtype())) {
				request.setAttribute("disFlag", "true");
			}
		}
		return (actionMapping.findForward("societycontent"));

	}

	/**
	 * ���������Ա������������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietybatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return (actionMapping.findForward("batch"));
	}

	/**
	 * �жϵ�ǰ�û�Ϊ���������Ƿ�������Ա
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietyselect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		OperroleListVO listVO = new OperroleListVO();
		listVO.set_se_operid(user.getOpercode());
		listVO.set_se_roleid("waymanager");

		CommonDelegate delegate = new CommonDelegate(OperroleVO.class);
		if (delegate.doQuery(listVO, user).getRowCount() > 0) {
			request.setAttribute("station", "M");
		} else
			request.setAttribute("station", "G");

		return (actionMapping.findForward("select"));
	}

	/**
	 * ��������Ա��ѯ�б�
	 */
	public ActionForward doServehalllist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeForm form = (EmployeeForm) actionForm;
		Page.setPageSize(request, form);
		EmployeeListVO listVO = new EmployeeListVO();
		if (((BaseActionForm) actionForm).get_pagesize() == null) {
			((BaseActionForm) actionForm).set_pagesize("15");
		}
		setListVO(listVO, actionForm);
		EmployeeDelegate delegate = new EmployeeDelegate();
		DataPackage pack = delegate.doServerhallEmployeeQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("list"));
	}

	/**
	 * ���������ѯ�б�
	 */
	public ActionForward doDitchmgrlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeeListVO listVO = new EmployeeListVO();
		EmployeeForm form = (EmployeeForm) actionForm;
		Page.setPageSize(request, form);
		if (((BaseActionForm) actionForm).get_pagesize() == null) {
			((BaseActionForm) actionForm).set_pagesize("15");
		}
		setListVO(listVO, actionForm);
		EmployeeDelegate delegate = new EmployeeDelegate();
		DataPackage pack = delegate.doDitchmgrEmployeeQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("list"));
	}

	/*
	 * ��ʾ
	 */

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return (actionMapping.findForward("list"));
	}

	/**
	 * ������Ա��Ϣ����
	 */

	public ActionForward doDitchsave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		EmployeeForm form = new EmployeeForm();
		form = (EmployeeForm) actionForm;
		EmployeeVO contentVO = new EmployeeVO();
		setSaveVO(contentVO, form);

		EmployeeDelegate delegate = new EmployeeDelegate();
		EmployeeVO existObj = delegate.doFindByPk(contentVO.getEmployeeid(),
				user);
		if (existObj != null) {
			org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
					contentVO);
			contentVO = existObj;
		}

		try {

			if (((EmployeeForm) actionForm).getDitchFlag().equals("ditchEdit")) {
				((BaseActionForm) actionForm)
						.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			}
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				contentVO = delegate.doDitchupdate(contentVO, user);
			} else {
				if (existObj != null) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"�����ظ�");
					onDuplicatePk(actionMapping, actionForm, request, response,
							user);
					return (actionMapping.findForward("content"));
				} else {
					contentVO = delegate.doDitchcreate(contentVO, user);
				}
			}
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,e.getMessage());
			request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
			return (actionMapping.findForward("content"));
		}

		return (actionMapping.findForward("content"));
	}

	/*
	 * ��Ͻ���㵼������
	 */
	public ActionForward doMgrwayexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean bean = new CommonExportBean(user);
		bean.setFileName("��Ͻ������Ϣ");
		bean.addOutputProperty("wayid", "��������");
		bean.addOutputProperty("wayname", "��������");
		bean.addOutputProperty("officetel", "�ɼ�ƽ̨�����ֻ���");
		bean.addOutputProperty("isopen", "��ͨ��־", CommonExportBean.CODE2NAME,
				"$CH_ISOPEN");
		bean.addOutputProperty("waysubtype", "�����������",
				CommonExportBean.CODE2NAME, "#WAYTYPE");
		bean.addOutputProperty("upperwayid", "�ϼ�����",
				CommonExportBean.CODE2NAME, "#WAY");
		bean.addOutputProperty("latitude", "γ��");
		bean.addOutputProperty("longtitude", "����");
		bean.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME,
				"$CH_STARLEVEL");
		bean.addOutputProperty("pt", "������", CommonExportBean.CODE2NAME,
				"$CH_PT");
		bean.addOutputProperty("isstraitprd", "�Ƿ�ֱ��",
				CommonExportBean.CODE2NAME, "$CH_STRAITPRD");
		bean.addOutputProperty("catetype", "��������", CommonExportBean.CODE2NAME,
				"$CH_CATETYPE");
		bean.addOutputProperty("cityid", "���й�˾", CommonExportBean.CODE2NAME,
				"#CITYCOMPANY");
		bean.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME,
				"#CNTYCOMPANY");
		bean.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME,
				"#CH_SERVCENT");
		bean.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME,
				"#CH_MICROAREA");
		bean.addOutputProperty("adtypecode", "��������",
				CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		bean.addOutputProperty("adacode", "��������", CommonExportBean.CODE2NAME,
				"#CH_ADIMAREA");
		bean.addOutputProperty("formtype", "ҵ̬����", CommonExportBean.CODE2NAME,
				"$CH_FORMTYPE");
		bean.addOutputProperty("starttime", "������ʼʱ��", CommonExportBean.DATE,
				"yyyy-MM-dd");
		bean.addOutputProperty("buzarea", "�ƶ�ר�����");
		bean.addOutputProperty("logiscode", "����������");
		bean.addOutputProperty("waymagcode", "������������");
		bean.addOutputProperty("bchlevel", "�ּ�", CommonExportBean.CODE2NAME,
				"$CH_BCHLEVEL");
		bean.addOutputProperty("waystate", "״̬", CommonExportBean.CODE2NAME,
				"$CH_VALIDFLAG");

		bean.appendEndLine(new String[] { "��������:", user.getOpercode() });
		bean.appendEndLine(new String[] { "��������:", user.getWayid() });
		String employyid = request.getParameter("employyid") == null ? ""
				: request.getParameter("employyid");
		((EmployeeForm) actionForm).setEmployeeid(employyid);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, bean);
		CommonExportBean commonExportBean = (CommonExportBean) request
				.getAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT);
		commonExportBean.voClassArray = new Class[] { AGWayVO.class };
		commonExportBean.queryMethodName = "doQuerywaybymgrid";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);
		return actionMapping.findForward(null);
	}

	/**
	 * ���������ѯ�б�
	 */
	public ActionForward doQuerywaybymgrid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			EmployeeForm theForm = (EmployeeForm) actionForm;
			WayListVO listVO = new WayListVO();
			listVO.set_se_waymagcode(theForm.getEmployeeid());
			BeanUtils.copyProperties(listVO, actionForm);
			Page.setPageSize(request, theForm);
			setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����
			WayDelegate delegate = new WayDelegate();
			DataPackage pack = delegate.queryEmployee(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("list"));
	}

	/*
	 * ����������Ϣ������
	 */
	public ActionForward doDitchmgrexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("����������Ϣ����");
		// commonExportBean.addOutputProperty(0,"business","Ӫҵ��",null,null);
		commonExportBean.addOutputProperty("employeeid", "��ԱID");
		commonExportBean.addOutputProperty("oprcode2", "����");
		commonExportBean.addOutputProperty("employeename", "����");
		commonExportBean.addOutputProperty("sex", "�Ա�",
				CommonExportBean.CODE2NAME, "$CH_SEX");
		commonExportBean.addOutputProperty("telephone", "��ϵ�绰");
		commonExportBean.addOutputProperty("cityid", "���й�˾",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "�ֹ�˾",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "������������",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("wayid", "������������������",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("station", "��λ",
				CommonExportBean.CODE2NAME, "#CH_POSTINFO");
		commonExportBean.addOutputProperty("intime", "��ְʱ��");
		commonExportBean.addOutputProperty("employtype", "�ù�����",
				CommonExportBean.CODE2NAME, "$CH_EMPLOYTYPE");

		commonExportBean.appendEndLine(new String[] { "��������:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "��������:", user.getWayid() });

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT,
				commonExportBean);
		commonExportBean.voClassArray = new Class[] { voClass };
		commonExportBean.queryMethodName = "doDitchmgrlist";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);
		return actionMapping.findForward(null);
	}

	/*
	 * ��������Ա��Ϣ������
	 */
	public ActionForward doServehallexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("��������Ա��Ϣ����");
		// commonExportBean.addOutputProperty(0,"business","Ӫҵ��",null,null);
		commonExportBean.addOutputProperty("employeeid", "��ԱID");
		commonExportBean.addOutputProperty("oprcode2", "����");
		commonExportBean.addOutputProperty("employeename", "����");
		commonExportBean.addOutputProperty("sex", "�Ա�",
				CommonExportBean.CODE2NAME, "$CH_SEX");
		commonExportBean.addOutputProperty("telephone", "��ϵ�绰");
		commonExportBean.addOutputProperty("cityid", "���й�˾",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "�ֹ�˾",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "������������",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("wayid", "������������������",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("station", "��λ",
				CommonExportBean.CODE2NAME, "#CH_POSTINFO");
		commonExportBean.addOutputProperty("intime", "��ְʱ��");
		commonExportBean.addOutputProperty("employtype", "�ù�����",
				CommonExportBean.CODE2NAME, "$CH_EMPLOYTYPE");

		commonExportBean.appendEndLine(new String[] { "��������:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "��������:", user.getWayid() });

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT,
				commonExportBean);
		commonExportBean.voClassArray = new Class[] { voClass };
		commonExportBean.queryMethodName = "doServehalllist";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);
		return actionMapping.findForward(null);
	}

	/**
	 * ��������Ա��Ϣɾ��.
	 */
	public ActionForward doServerhalldelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			EmployeeDelegate delegate = new EmployeeDelegate();

			for (int i = 0; i < selectArray.length; i++) {
				EmployeeVO vo = delegate.doFindByPk(selectArray[i], user);
				vo.setEmpstatus(new Short("1"));
				delegate.doUpdate(vo, user);
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return doServehalllist(actionMapping, actionForm, request, response,
				user);
	}

	/**
	 * ����������Ϣɾ��.
	 */
	public ActionForward doDitchmgrdelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			EmployeeDelegate delegate = new EmployeeDelegate();

			for (int i = 0; i < selectArray.length; i++) {
				EmployeeVO vo = delegate.doFindByPk(selectArray[i], user);
				vo.setEmpstatus(new Short("1"));
				delegate.doUpdate(vo, user);
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return doDitchmgrlist(actionMapping, actionForm, request, response,
				user);
	}

	/**
	 * ���������Ա�б���
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSocietyexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("���������Ա����");
		commonExportBean.queryMethodName = "doSocietylist";
		commonExportBean.addOutputProperty("employeeid", "��ԱID");
		commonExportBean.addOutputProperty("employeename", "����");
		commonExportBean.addOutputProperty("birthday", "��������");
		commonExportBean.addOutputProperty("sex", "�Ա�",
				CommonExportBean.CODE2NAME, "$CH_SEX");
		commonExportBean.addOutputProperty("empstatus", "�ù�״̬",
				CommonExportBean.CODE2NAME, "$CH_EMPSTATUS");
		commonExportBean.addOutputProperty("cardid", "���֤����");
		commonExportBean.addOutputProperty("telephone", "��ϵ�绰");
		commonExportBean.addOutputProperty("cityid", "���й�˾",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "�ֹ�˾",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "������������",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("wayid", "�������");
		commonExportBean.addOutputProperty("wayid", "��������",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("intime", "��ְʱ��");
		commonExportBean.addOutputProperty("employtype", "�ù�����",
				CommonExportBean.CODE2NAME, "$CH_EMPLOYTYPE");
		commonExportBean.addOutputProperty("bail", "��֤��(Ԫ)");
		commonExportBean.addOutputProperty("officetel", "�ɼ�ƽ̨�����ֻ���");
		commonExportBean.addOutputProperty("isnet", "�Ƿ�Ϊ����",
				CommonExportBean.CODE2NAME, "$CH_ISNET");
		commonExportBean.addOutputProperty("netpass", "����ȷ����");
		commonExportBean.addOutputProperty("isopen", "��ͨ�����־",
				CommonExportBean.CODE2NAME, "$CH_ISOPEN");
		commonExportBean.addOutputProperty("selectmobile", "����ѡ���ֻ���");
		commonExportBean.appendEndLine(new String[] { "��������:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "��������:", user.getWayid() });

		commonExportBean.voClassArray = new Class[] { voClass };
		((BaseActionForm)actionForm).set_orderby("employeeid");
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);

		return actionMapping.findForward(null);
	}

	/*
	 * ȡ���������
	 */
	public ActionForward doCancelservice(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			// String mobile = request.getParameter("mobile") == null ? ""
			// : request.getParameter("mobile");
			String employeeID = request.getParameter("employeeID") == null ? ""
					: request.getParameter("employeeID");
			if (!"".equals(employeeID)) {
				new AGWayDelegate().doCancelService(employeeID, user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"�˶�������Ҫ������ʱ�䣬���Ժ�鿴�Ƿ��˶��ɹ�");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
			throw e;
		}
		return this.doSocietylist(actionMapping, actionForm, request, response,
				user);

	}

}
