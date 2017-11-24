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
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(EmployeeVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "employeeid";
	}

	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"相同编号的人员ID已经存在或该ID已被历史人员占用!");

	}

	/**
	 * 保存
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
							"主键重复");
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
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
	 * 只可以查看，提供给群组信息，独立出来
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
	 * 给出所有用户的列表,提供给需要选择用户的模块使用
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
	 * 提供给需要选择用户的模块使用
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
	 * 给出所有用户的列表,提供给需要选择用户的模块使用
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
	 * 社会渠道人员管理显示
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
	 * 社会渠道人员管理查询
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
		listVO.set_se_waytype("AG");// 普通代理渠道,即社会渠道
		// listVO.set_nne_empstatus("-1");// 工状态不为 -1（已删除）
		String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
				+ user.getWayid()
				+ "' connect by prior   wayid   = upperwayid) and (empstatus is null or empstatus <> -1) "; // 数据权限限制

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
		// 解包
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
	 * 社会渠道人员管理新增
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
		// 设置默认值
		form.setEmpstatus(new Short("0"));
		// 增加自建他营渠道判断
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
						"所选渠道非社会渠道或自建他营渠道，请重新选择！");
			}
		}

		return (actionMapping.findForward("societycontent"));
	}

	/**
	 * 移动渠道人员管理新增
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
					"所选渠道非当前渠道的下属实体渠道，请重新选择！");
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * 社会渠道人员管理编辑
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
					"该渠道非当前渠道的下属实体渠道,不能对其进行修改！");
			return doServehalllist(actionMapping, actionForm, request,
					response, user);
		}
		((EmployeeForm) actionForm).setDitchFlag("ditchEdit");
		getContentVO(request, user, actionForm);
		return (actionMapping.findForward("content"));

	}

	/**
	 * 社会渠道人员管理编辑
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
					"该渠道非当前渠道的下属实体渠道,不能对其进行修改！");
			return doDitchmgrlist(actionMapping, actionForm, request, response,
					user);

		}
		((EmployeeForm) actionForm).setDitchFlag("ditchEdit");
		getContentVO(request, user, actionForm);
		return (actionMapping.findForward("content"));

	}

	/**
	 * 社会渠道人员管理编辑
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
						"所选渠道非社会渠道，请重新选择！");
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
	 * 社会渠道人员管理删除
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
	 * 社会渠道人员管理保存
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
		if (form.getEmployeeid() == null || "".equals(form.getEmployeeid())) {// 新增

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
							"主键重复");
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
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
	 * 社会渠道人员管理批量导入
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
	 * 判断当前用户为渠道经理还是服务厅人员
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
	 * 服务厅人员查询列表
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
	 * 渠道经理查询列表
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
	 * 显示
	 */

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return (actionMapping.findForward("list"));
	}

	/**
	 * 渠道人员信息保存
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
							"主键重复");
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,e.getMessage());
			request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
			return (actionMapping.findForward("content"));
		}

		return (actionMapping.findForward("content"));
	}

	/*
	 * 管辖网点导出导出
	 */
	public ActionForward doMgrwayexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean bean = new CommonExportBean(user);
		bean.setFileName("管辖网点信息");
		bean.addOutputProperty("wayid", "渠道编码");
		bean.addOutputProperty("wayname", "渠道名称");
		bean.addOutputProperty("officetel", "采集平台捆绑手机号");
		bean.addOutputProperty("isopen", "开通标志", CommonExportBean.CODE2NAME,
				"$CH_ISOPEN");
		bean.addOutputProperty("waysubtype", "零售渠道类别",
				CommonExportBean.CODE2NAME, "#WAYTYPE");
		bean.addOutputProperty("upperwayid", "上级渠道",
				CommonExportBean.CODE2NAME, "#WAY");
		bean.addOutputProperty("latitude", "纬度");
		bean.addOutputProperty("longtitude", "经度");
		bean.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME,
				"$CH_STARLEVEL");
		bean.addOutputProperty("pt", "排他性", CommonExportBean.CODE2NAME,
				"$CH_PT");
		bean.addOutputProperty("isstraitprd", "是否直供",
				CommonExportBean.CODE2NAME, "$CH_STRAITPRD");
		bean.addOutputProperty("catetype", "连锁性质", CommonExportBean.CODE2NAME,
				"$CH_CATETYPE");
		bean.addOutputProperty("cityid", "地市公司", CommonExportBean.CODE2NAME,
				"#CITYCOMPANY");
		bean.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME,
				"#CNTYCOMPANY");
		bean.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME,
				"#CH_SERVCENT");
		bean.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME,
				"#CH_MICROAREA");
		bean.addOutputProperty("adtypecode", "区域类型",
				CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		bean.addOutputProperty("adacode", "行政区划", CommonExportBean.CODE2NAME,
				"#CH_ADIMAREA");
		bean.addOutputProperty("formtype", "业态类型", CommonExportBean.CODE2NAME,
				"$CH_FORMTYPE");
		bean.addOutputProperty("starttime", "合作开始时间", CommonExportBean.DATE,
				"yyyy-MM-dd");
		bean.addOutputProperty("buzarea", "移动专区面积");
		bean.addOutputProperty("logiscode", "所属物流商");
		bean.addOutputProperty("waymagcode", "所属渠道经理");
		bean.addOutputProperty("bchlevel", "分级", CommonExportBean.CODE2NAME,
				"$CH_BCHLEVEL");
		bean.addOutputProperty("waystate", "状态", CommonExportBean.CODE2NAME,
				"$CH_VALIDFLAG");

		bean.appendEndLine(new String[] { "导出工号:", user.getOpercode() });
		bean.appendEndLine(new String[] { "导出渠道:", user.getWayid() });
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
	 * 渠道经理查询列表
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
			setListVO(listVO, actionForm); // 设置好listVO，作为查询条件
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
	 * 渠道经理信息管理导出
	 */
	public ActionForward doDitchmgrexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("渠道经理信息管理");
		// commonExportBean.addOutputProperty(0,"business","营业点",null,null);
		commonExportBean.addOutputProperty("employeeid", "人员ID");
		commonExportBean.addOutputProperty("oprcode2", "工号");
		commonExportBean.addOutputProperty("employeename", "姓名");
		commonExportBean.addOutputProperty("sex", "性别",
				CommonExportBean.CODE2NAME, "$CH_SEX");
		commonExportBean.addOutputProperty("telephone", "联系电话");
		commonExportBean.addOutputProperty("cityid", "地市公司",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "分公司",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "服务销售中心",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("wayid", "服务厅（所属渠道）",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("station", "岗位",
				CommonExportBean.CODE2NAME, "#CH_POSTINFO");
		commonExportBean.addOutputProperty("intime", "入职时间");
		commonExportBean.addOutputProperty("employtype", "用工性质",
				CommonExportBean.CODE2NAME, "$CH_EMPLOYTYPE");

		commonExportBean.appendEndLine(new String[] { "导出工号:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "导出渠道:", user.getWayid() });

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
	 * 服务厅人员信息管理导出
	 */
	public ActionForward doServehallexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("服务厅人员信息管理");
		// commonExportBean.addOutputProperty(0,"business","营业点",null,null);
		commonExportBean.addOutputProperty("employeeid", "人员ID");
		commonExportBean.addOutputProperty("oprcode2", "工号");
		commonExportBean.addOutputProperty("employeename", "姓名");
		commonExportBean.addOutputProperty("sex", "性别",
				CommonExportBean.CODE2NAME, "$CH_SEX");
		commonExportBean.addOutputProperty("telephone", "联系电话");
		commonExportBean.addOutputProperty("cityid", "地市公司",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "分公司",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "服务销售中心",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("wayid", "服务厅（所属渠道）",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("station", "岗位",
				CommonExportBean.CODE2NAME, "#CH_POSTINFO");
		commonExportBean.addOutputProperty("intime", "入职时间");
		commonExportBean.addOutputProperty("employtype", "用工性质",
				CommonExportBean.CODE2NAME, "$CH_EMPLOYTYPE");

		commonExportBean.appendEndLine(new String[] { "导出工号:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "导出渠道:", user.getWayid() });

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
	 * 服务厅人员信息删除.
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
	 * 渠道经理信息删除.
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
	 * 社会渠道人员列表导出
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
		commonExportBean.setFileName("社会渠道人员管理");
		commonExportBean.queryMethodName = "doSocietylist";
		commonExportBean.addOutputProperty("employeeid", "人员ID");
		commonExportBean.addOutputProperty("employeename", "姓名");
		commonExportBean.addOutputProperty("birthday", "出生日期");
		commonExportBean.addOutputProperty("sex", "性别",
				CommonExportBean.CODE2NAME, "$CH_SEX");
		commonExportBean.addOutputProperty("empstatus", "用工状态",
				CommonExportBean.CODE2NAME, "$CH_EMPSTATUS");
		commonExportBean.addOutputProperty("cardid", "身份证号码");
		commonExportBean.addOutputProperty("telephone", "联系电话");
		commonExportBean.addOutputProperty("cityid", "地市公司",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "分公司",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "服务销售中心",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("wayid", "网点编码");
		commonExportBean.addOutputProperty("wayid", "所属网点",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("intime", "入职时间");
		commonExportBean.addOutputProperty("employtype", "用工性质",
				CommonExportBean.CODE2NAME, "$CH_EMPLOYTYPE");
		commonExportBean.addOutputProperty("bail", "保证金(元)");
		commonExportBean.addOutputProperty("officetel", "采集平台捆绑手机号");
		commonExportBean.addOutputProperty("isnet", "是否为店主",
				CommonExportBean.CODE2NAME, "$CH_ISNET");
		commonExportBean.addOutputProperty("netpass", "网点确认码");
		commonExportBean.addOutputProperty("isopen", "开通服务标志",
				CommonExportBean.CODE2NAME, "$CH_ISOPEN");
		commonExportBean.addOutputProperty("selectmobile", "空中选号手机号");
		commonExportBean.appendEndLine(new String[] { "导出工号:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "导出渠道:", user.getWayid() });

		commonExportBean.voClassArray = new Class[] { voClass };
		((BaseActionForm)actionForm).set_orderby("employeeid");
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);

		return actionMapping.findForward(null);
	}

	/*
	 * 取消网点服务
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
					"退订服务需要几分钟时间，请稍后查看是否退订成功");
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
