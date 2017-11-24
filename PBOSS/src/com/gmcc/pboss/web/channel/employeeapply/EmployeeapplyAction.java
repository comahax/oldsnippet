/**
 * auto-generated code
 * Tue Oct 20 15:53:37 CST 2009
 */
package com.gmcc.pboss.web.channel.employeeapply;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;

import com.gmcc.pboss.business.channel.auditwork.AuditworkVO;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyDBParam;
import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyVO;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelDBParam;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.auditwork.Auditwork;
import com.gmcc.pboss.control.channel.auditwork.AuditworkBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.employeeapply.Employeeapply;
import com.gmcc.pboss.control.channel.employeeapply.EmployeeapplyBO;
import com.gmcc.pboss.control.channel.empmodel.Empmodel;
import com.gmcc.pboss.control.channel.empmodel.EmpmodelBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: EmployeeapplyAction
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeapplyAction extends BaseAction {
	private static final String SAVETYPE_SAVE = "SAVE";
	private static final String SAVETYPE_CANCEL = "CANCEL";
	private static final String SAVETYPE_PASS = "PASS";
	private static final String EMPLOYEE_REMOVE="EMPLOYEE_REMOVE_AUDIT";
	private static final String EMPLOYEE_UPDATE="EMPLOYEE_UPDATE_AUDIT";
	private static final String EMPLOYEE_ADD="EMPLOYEE_ADD_AUDIT";
	private String saveType;
	private String formType;//表请求从哪个页面进来 当从待办任务过来时（ADVINFO） 审批通过后关闭待办
	private Long rvcobjid;//接收对象表标识

	public EmployeeapplyAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new EmployeeapplyForm());
		this.setParam(new EmployeeapplyWebParam());

		// 指定VO类
		setClsVO(EmployeeapplyVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "applyno" };
		this.setClsControl(Employeeapply.class);
		this.setClsQueryParam(EmployeeapplyDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 重写doEdit方法，根据SEQID取得CH_PW_AUDITWORK表中的值
	 */
	public String doEdit() throws Exception {
		try{
		EmployeeapplyVO employeeapplyVO = new EmployeeapplyVO();
		
		EmployeeapplyForm frm = (EmployeeapplyForm) getForm();
		EmployeeapplyVO vo = (EmployeeapplyVO) findVOFromDB();
		vo.setAuditstatus_work(vo.getAuditstatus());
		vo.setSeqid(frm.getSeqid());
		
		Auditwork auditwork = (Auditwork) BOFactory.build(
				AuditworkBO.class, super.getDBAccessUser());
		AuditworkVO auditworkVO = auditwork.doFindByPk(frm.getSeqid());
		
		String worktype = auditworkVO == null ? null : auditworkVO.getWorktype();
		//如果工单类型= EMPLOYEE_UPDATE_AUDIT:店员修改或者EMPLOYEE_REMOVE_AUDIT:店员退出；先读取店员相关表将信息拷贝到编辑页面显示
		if(EMPLOYEE_UPDATE.equals(worktype) || EMPLOYEE_REMOVE.equals(worktype)){
			Employee employeeBO = (EmployeeBO)BOFactory.build(EmployeeBO.class,super.getDBAccessUser());
			
			if(null != vo.getEmployeeid() && !"".equals(vo.getEmployeeid().trim())){
				EmployeeVO employeeVO = employeeBO.doFindByPk(vo.getEmployeeid());
				if( null != employeeVO ){
					BeanUtils.copyProperties(employeeapplyVO,employeeVO);
				}
				
//				Auditwork auditwork = (Auditwork)BOFactory.build(AuditworkBO.class,super.getDBAccessUser());
//				AuditworkVO auditworkVO = auditwork.doFindByPk(vo.getSeqid());
				if( null != auditworkVO){
					//BeanUtils.copyProperties(wayapplyVO, auditworkVO);
					employeeapplyVO.setContent(auditworkVO.getContent());
					employeeapplyVO.setAuditstatus(auditworkVO.getAuditstatus());
				}
			}
		}else if (EMPLOYEE_ADD.equals(worktype) && vo.getWayid()!=null)
		{
			Way way = (Way) BOFactory.build(WayBO.class, super.getDBAccessUser());
			WayVO wayVO=way.doFindByPk(vo.getWayid());
			if(wayVO!=null)
			{
				BeanUtils.copyProperties(employeeapplyVO, wayVO);
			}
		}
		BeanUtils.copyProperties(employeeapplyVO,vo);
		BeanUtils.copyProperties(frm, employeeapplyVO);
		
		if(!StringUtils.isEmpty(frm.getEmployeeid())) { // 只有当某社会渠道人员(ch_pw_employee)已经存在时
			// 工作模式 处理Begin
			Empmodel modelBO = (Empmodel)BOFactory.build(EmpmodelBO.class, super.getDBAccessUser());
			
			EmpmodelDBParam modelParam = new EmpmodelDBParam();
			modelParam.set_se_employeeid(frm.getEmployeeid());
			modelParam.set_se_model("3");
			modelParam.set_pagesize("0");
			modelParam.setDataOnly(true);
			DataPackage dp = modelBO.doQuery(modelParam);
			List<EmpmodelVO> list = dp.getDatas();
			if(list.size() > 0) {
				EmpmodelVO modelVO = list.get(0);
				frm.setEmpmodelid(modelVO.getEmpmodelid());
				frm.setModel(modelVO.getModel());
				frm.setModelState(modelVO.getState());
			}
			// 工作模式 处理End
		}
		setForm(frm);
		// Auditwork auditwork = (Auditwork) BOFactory.build(AuditworkBO.class,
		// getDBAccessUser());
		}catch (Exception e) {
			addActionError(e.getMessage());
			return WEB_RESULT_CONTENT;
		}
		this.CMD = WEB_CMD_EDIT;
		
		return WEB_RESULT_CONTENT;
	};

	/**
	 * 重写doList方法。
	 */
	public String doList() throws Exception {
		DataPackage dp = null;
		try {
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
		} catch (Exception e) {
			super.addActionError(e.getMessage());
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	/**
	 * 覆盖保存方法
	 */
	public String doSave() throws Exception {
		EmployeeapplyVO employeeapplyVO = new EmployeeapplyVO();
		EmployeeapplyForm frm = (EmployeeapplyForm) getForm();
		BeanUtils.copyProperties(employeeapplyVO, frm);
		String returnMsg="";
		if (WEB_CMD_NEW.equals(CMD)) {
			// 店员审批管理不提供新增
		} else {
			try {
				CMD = WEB_CMD_SAVE;
				
				Employeeapply employeeapply = (Employeeapply) BOFactory.build(
						EmployeeapplyBO.class, getDBAccessUser());
				if (SAVETYPE_SAVE.equals(saveType)) {
					employeeapplyVO = employeeapply.doSave(employeeapplyVO);
					returnMsg="保存成功";
				} else if (SAVETYPE_CANCEL.equals(saveType)) {
					if("ADVINFO".equals(this.formType)){//从待办任务过来的
						employeeapplyVO = employeeapply.doCancel(employeeapplyVO,true,rvcobjid);
					}else{
						employeeapplyVO = employeeapply.doCancel(employeeapplyVO,false,null);
					}				
					returnMsg="审批单已退回";
				} else if (SAVETYPE_PASS.equals(saveType)) {
					if("ADVINFO".equals(this.formType)){//从待办任务过来的
						employeeapplyVO = employeeapply.doPass(employeeapplyVO,true,rvcobjid);
					}else{
						employeeapplyVO = employeeapply.doPass(employeeapplyVO,false,null);
					}
					returnMsg="审批单已通过";
				}
				BeanUtils.copyProperties(frm, employeeapplyVO);
				if(!StringUtils.isEmpty(frm.getEmployeeid())) { // 只有当某社会渠道人员(ch_pw_employee)已经存在时
					// 工作模式 处理Begin
					String[] agentmodeArr = (String[])this.getRequest().getParameterValues("agentmode_checkbox");
					Empmodel modelBO = (Empmodel)BOFactory.build(EmpmodelBO.class, super.getDBAccessUser());
					EmpmodelVO modelVO = null;
					
					EmpmodelDBParam modelParam = new EmpmodelDBParam();
					modelParam.set_se_employeeid(employeeapplyVO.getEmployeeid());
					modelParam.set_se_model("3");
					modelParam.set_pagesize("0");
					modelParam.setDataOnly(true);
					
					Long empmodelid = frm.getEmpmodelid();
					Short modelState = frm.getModelState();
					if(empmodelid != null && modelState != null && modelState == 0) { // 人员工作模式记录存在且状态为0正常
						if(agentmodeArr != null && agentmodeArr.length > 0) {
							// 如果勾选全员代理模式，则什么都不需要做
						}else{
							// 如果未勾选全员代理模式
							DataPackage dp = modelBO.doQuery(modelParam);
							List<EmpmodelVO> list = dp.getDatas();
							if(list.size() > 0) {
								//如果有存在记录，则更新记录中的状态字段等于1（退出）。
								modelVO = list.get(0);
								modelVO.setState(Short.parseShort("1"));
								modelVO = modelBO.doUpdate(modelVO);
							}
						}
					} else if(empmodelid != null && modelState != null && modelState == 1){ // 人员工作模式记录存在且状态为1退出
						if(agentmodeArr != null && agentmodeArr.length > 0) {
							// 如果勾选全员代理模式
							DataPackage dp = modelBO.doQuery(modelParam);
							List<EmpmodelVO> list = dp.getDatas();
							if(list.size() > 0) {
								//如果有存在记录，则更新记录中的状态字段等于0（正常）。
								modelVO = list.get(0);
								modelVO.setState(Short.parseShort("0"));
								modelVO = modelBO.doUpdate(modelVO);
							}
						}
					}else if((empmodelid != null && modelState == null) 
							|| empmodelid == null){ // 人员工作模式记录存在且状态为空 或者 人员工作模式记录不存在
						// 则新增记录到人员工作模式表
						modelVO = new EmpmodelVO();
						modelVO.setEmployeeid(employeeapplyVO.getEmployeeid());
						modelVO.setModel("3"); //工作模式等于3（全员代理模式）
						if(agentmodeArr != null && agentmodeArr.length > 0) {
							//如果有勾选全员代理模式，,状态为0正常。
							modelVO.setState(Short.parseShort("0"));
						}else{
							//如果未勾选全员代理模式，,状态为1退出。
							modelVO.setState(Short.parseShort("1"));
						}
						modelVO = modelBO.doCreateNoSeq(modelVO);
					}
					if(modelVO != null) {
						frm.setModelState(modelVO.getState());
						frm.setModel(modelVO.getModel());
					}
					// 工作模式 处理End
				}
				setForm(frm);
				setActionMessage(returnMsg);
			} catch (Exception e) {
				CMD = WEB_CMD_EDIT;
				e.printStackTrace();
				super.addActionMessage(e.getMessage());
			}
		}
		return WEB_RESULT_CONTENT;
	}

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public Long getRvcobjid() {
		return rvcobjid;
	}

	public void setRvcobjid(Long rvcobjid) {
		this.rvcobjid = rvcobjid;
	}
	
}