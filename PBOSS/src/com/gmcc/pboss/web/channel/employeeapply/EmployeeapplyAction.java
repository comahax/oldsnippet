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
	private String formType;//��������ĸ�ҳ����� ���Ӵ����������ʱ��ADVINFO�� ����ͨ����رմ���
	private Long rvcobjid;//���ն�����ʶ

	public EmployeeapplyAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new EmployeeapplyForm());
		this.setParam(new EmployeeapplyWebParam());

		// ָ��VO��
		setClsVO(EmployeeapplyVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "applyno" };
		this.setClsControl(Employeeapply.class);
		this.setClsQueryParam(EmployeeapplyDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * ��дdoEdit����������SEQIDȡ��CH_PW_AUDITWORK���е�ֵ
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
		//�����������= EMPLOYEE_UPDATE_AUDIT:��Ա�޸Ļ���EMPLOYEE_REMOVE_AUDIT:��Ա�˳����ȶ�ȡ��Ա��ر���Ϣ�������༭ҳ����ʾ
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
		
		if(!StringUtils.isEmpty(frm.getEmployeeid())) { // ֻ�е�ĳ���������Ա(ch_pw_employee)�Ѿ�����ʱ
			// ����ģʽ ����Begin
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
			// ����ģʽ ����End
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
	 * ��дdoList������
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
	 * ���Ǳ��淽��
	 */
	public String doSave() throws Exception {
		EmployeeapplyVO employeeapplyVO = new EmployeeapplyVO();
		EmployeeapplyForm frm = (EmployeeapplyForm) getForm();
		BeanUtils.copyProperties(employeeapplyVO, frm);
		String returnMsg="";
		if (WEB_CMD_NEW.equals(CMD)) {
			// ��Ա���������ṩ����
		} else {
			try {
				CMD = WEB_CMD_SAVE;
				
				Employeeapply employeeapply = (Employeeapply) BOFactory.build(
						EmployeeapplyBO.class, getDBAccessUser());
				if (SAVETYPE_SAVE.equals(saveType)) {
					employeeapplyVO = employeeapply.doSave(employeeapplyVO);
					returnMsg="����ɹ�";
				} else if (SAVETYPE_CANCEL.equals(saveType)) {
					if("ADVINFO".equals(this.formType)){//�Ӵ������������
						employeeapplyVO = employeeapply.doCancel(employeeapplyVO,true,rvcobjid);
					}else{
						employeeapplyVO = employeeapply.doCancel(employeeapplyVO,false,null);
					}				
					returnMsg="���������˻�";
				} else if (SAVETYPE_PASS.equals(saveType)) {
					if("ADVINFO".equals(this.formType)){//�Ӵ������������
						employeeapplyVO = employeeapply.doPass(employeeapplyVO,true,rvcobjid);
					}else{
						employeeapplyVO = employeeapply.doPass(employeeapplyVO,false,null);
					}
					returnMsg="��������ͨ��";
				}
				BeanUtils.copyProperties(frm, employeeapplyVO);
				if(!StringUtils.isEmpty(frm.getEmployeeid())) { // ֻ�е�ĳ���������Ա(ch_pw_employee)�Ѿ�����ʱ
					// ����ģʽ ����Begin
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
					if(empmodelid != null && modelState != null && modelState == 0) { // ��Ա����ģʽ��¼������״̬Ϊ0����
						if(agentmodeArr != null && agentmodeArr.length > 0) {
							// �����ѡȫԱ����ģʽ����ʲô������Ҫ��
						}else{
							// ���δ��ѡȫԱ����ģʽ
							DataPackage dp = modelBO.doQuery(modelParam);
							List<EmpmodelVO> list = dp.getDatas();
							if(list.size() > 0) {
								//����д��ڼ�¼������¼�¼�е�״̬�ֶε���1���˳�����
								modelVO = list.get(0);
								modelVO.setState(Short.parseShort("1"));
								modelVO = modelBO.doUpdate(modelVO);
							}
						}
					} else if(empmodelid != null && modelState != null && modelState == 1){ // ��Ա����ģʽ��¼������״̬Ϊ1�˳�
						if(agentmodeArr != null && agentmodeArr.length > 0) {
							// �����ѡȫԱ����ģʽ
							DataPackage dp = modelBO.doQuery(modelParam);
							List<EmpmodelVO> list = dp.getDatas();
							if(list.size() > 0) {
								//����д��ڼ�¼������¼�¼�е�״̬�ֶε���0����������
								modelVO = list.get(0);
								modelVO.setState(Short.parseShort("0"));
								modelVO = modelBO.doUpdate(modelVO);
							}
						}
					}else if((empmodelid != null && modelState == null) 
							|| empmodelid == null){ // ��Ա����ģʽ��¼������״̬Ϊ�� ���� ��Ա����ģʽ��¼������
						// ��������¼����Ա����ģʽ��
						modelVO = new EmpmodelVO();
						modelVO.setEmployeeid(employeeapplyVO.getEmployeeid());
						modelVO.setModel("3"); //����ģʽ����3��ȫԱ����ģʽ��
						if(agentmodeArr != null && agentmodeArr.length > 0) {
							//����й�ѡȫԱ����ģʽ��,״̬Ϊ0������
							modelVO.setState(Short.parseShort("0"));
						}else{
							//���δ��ѡȫԱ����ģʽ��,״̬Ϊ1�˳���
							modelVO.setState(Short.parseShort("1"));
						}
						modelVO = modelBO.doCreateNoSeq(modelVO);
					}
					if(modelVO != null) {
						frm.setModelState(modelVO.getState());
						frm.setModel(modelVO.getModel());
					}
					// ����ģʽ ����End
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