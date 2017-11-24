package com.gmcc.pboss.member.service.impl;

//import org.apache.log4j.Logger;

import java.util.Date;

import com.gmcc.pboss.biz.basic.AuditWork.dao.AuditWorkDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwAdvinfoDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwFlownameDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.config.bean.PendingTaskConfigBean;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PendingTaskName;
import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.member.service.EmployeeApplyService;
import com.gmcc.pboss.member.service.MemberServiceRetCode;
import com.gmcc.pboss.member.support.EmployeeApplyParameter;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;
import com.gmcc.pboss.member.model.Employee;

public class EmployeeApplyServiceImpl extends BaseServiceImpl implements EmployeeApplyService {

//	private static Logger logger = Logger.getLogger(EmployeeApplyServiceImpl.class);

	private AuditWorkDao auditWorkDao;
	/**��˲��趨��DAO*/
	private ChPwFlownameDao chPwFlownameDao;
	/**������ϢDAO*/
	private ChPwAdvinfoDao chPwAdvinfoDao;
	/**���ܶ���DAO*/
	private ChPwRcvobjDao chPwRcvobjDao;
	/** �ֻ���������ز�ѯ Service*/
	private NosectService nosectService;
	
	public EmployeeApplyServiceImpl() {
		serviceName = "��Ա����";
		serviceCode = ServiceCode.MEMBER;
		isNeedLogin = true;
	}

	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		EmployeeApplyParameter eaParam = (EmployeeApplyParameter) parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);

		String stepid = null,workType = null;
		Byte state = ConstantsType.AUDITSTATUS_NO;

		//1�����������
		ChPwEmployeeapply object = eaParam.getApply();
		boolean isCheckModlie = true;//�Ƿ��ж��ֻ��Ƿ����
		if (ConstantsType.ACTION_ADD.equals(eaParam.getDoAction())){
			//��������
			stepid = ConstantsType.AUDITSTEPID_EMPLOYEEADD1;
			workType = ConstantsType.AUDITWORKTYPE_EMPLOYEEADD;
		}else {
			//�޸�����
			//@@ ��ֵ�ж�δ��
			stepid = ConstantsType.AUDITSTEPID_EMPLOYEEUPDATE1;
			workType = ConstantsType.AUDITWORKTYPE_EMPLOYEEUPDATE;	
			//��ѯԭ�����ֻ�����
			Employee memVO = (Employee)this.getMemberDao().get(object.getEmployeeid());
			if (memVO.getOfficetel().equals(object.getOfficetel())) {
				//û�иĹ����������ж�
				isCheckModlie = false;
			}
		}
		
		if (isCheckModlie){
			//�ж��ֻ��Ƿ��Ѿ�����

			//�ж��ֻ��������ڵ���
			//�л�������
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			MemberQueryParameter mparameter = new MemberQueryParameter();
			mparameter.setOfficeTel(object.getOfficetel());
			ServiceResult noSectrslt = nosectService.transact(null, mparameter, ServiceType.INITIATE);
			if(!noSectrslt.isSuccess()){
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.UNDEFAULT_BRANCH);
				return result;
			}
			String cityId = (String)noSectrslt.getRetObject();
			if (!cityId.equals(member.getCityid())){
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.MOBILENOCITYERROR);
				return result;
			}
			
			//�л������п�
			SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
			ServiceResult offTelResl = existsEmployee(object.getOfficetel());
			
			if (offTelResl.isSuccess()){
				//�ֻ������Ѿ�����
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.MOBLEEXIST);
				return result;
			}
		}//
		
		//��ѯĬ�ϴ�����
		String oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		
		if(!CommonUtil.isEmptyOrNull(oprcode)){
		
	//		EmployeeApplyDao eaDao = (EmployeeApplyDao) this.getDao();
			object.setAuditstatus(state);//���״��AUDITSTATUS��̬Ϊ0
			object.setCityid(member.getCityid());//����CITYID
			object.setOptime(new Date());
			this.save(object);
			
			//2�����봦������
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(workType);
			auditWork.setStepid(stepid);
			auditWork.setApplyno(object.getApplyno());
			auditWork.setCreatetime(object.getOptime());
			auditWork.setAuditstatus(ConstantsType.AUDITSTATUS_NO);
			auditWork.setOprcode(oprcode);//���ô�����
			auditWorkDao.save(auditWork);
			
			//3��¼�빫����Ϣ����������
			PendingTaskConfigBean bean =null;
			if (ConstantsType.ACTION_ADD.equals(eaParam.getDoAction())){
				//��������
				bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.EMPLOYEE_REGISTER);
			}else{
				//�޸�����
				//@@ ��ֵ�ж�δ��
				bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.EMPLOYEE_UPDATE);			
			}
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, object.getOptime(), auditWork, stepid,member.getEmployeeid());
			chPwAdvinfoDao.save(info);
			
			//4��¼����ܶ����
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(object.getOptime());
			chPwRcvobjDao.save(obj);
			
			//�������,���÷��ض���
			result.setSuccess(true);
			if (ConstantsType.ACTION_ADD.equals(eaParam.getDoAction())){
				//��������
				result.setRetCode(MemberServiceRetCode.EMPLOYEEAPPLY);
			}else{
				//�޸�����
				//@@ ��ֵ�ж�δ��
				result.setRetCode(MemberServiceRetCode.EMPLOYEEUPADEAPPLY);
				
			}
			result.setRetObject(object);
		}else{
			result.setRetCode(MemberServiceRetCode.OPRCODEISNULL);
			result.setRetObject(null);
		}//if
		
		return result;
	}//modify

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#cancel(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	public ServiceResult cancel(LoginMember member, QueryParameter parameter) {
		EmployeeApplyParameter eaParam = (EmployeeApplyParameter) parameter;
		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);

		String stepid = ConstantsType.AUDITSTEPID_EMPLOYEEREMOVE1,workType = ConstantsType.AUDITWORKTYPE_EMPLOYEEREMOVE;
		Byte state = ConstantsType.AUDITSTATUS_NO;

		//��ѯĬ�ϴ�����
		String oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		
		//�������ģʽ
		if(!CommonUtil.isEmptyOrNull(oprcode)){
			//1�����������
			ChPwEmployeeapply object = eaParam.getApply();
			object.setAuditstatus(ConstantsType.AUDITSTATUS_NO);//���״��AUDITSTATUS��̬Ϊ0
			object.setCityid(member.getCityid());//����CITYID
			object.setOptime(new Date());
			this.save(object);
			
			//2�����봦������
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(workType);
			auditWork.setApplyno(object.getApplyno());
			auditWork.setStepid(stepid);
			auditWork.setOprcode(oprcode);//�˳�������
			auditWork.setCreatetime(object.getOptime());
			auditWork.setAuditstatus(state);
			this.save(auditWork);
			
			//3��¼�빫����Ϣ����������
			PendingTaskConfigBean bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.EMPLOYEE_REMOVE);
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, object.getOptime(), auditWork, stepid,member.getEmployeeid());
			chPwAdvinfoDao.save(info);
			
			//4��¼����ܶ����
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(object.getOptime());
			chPwRcvobjDao.save(obj);
			//����ɹ�
			result.setSuccess(true);
			result.setRetCode(MemberServiceRetCode.EMPLOYEEQUIT);
			result.setRetObject(object);
		}else{
			result.setSuccess(false);
			result.setRetCode(MemberServiceRetCode.OPRCODEISNULL);
			result.setRetObject(null);
		}
		
////		//���
//		EmployeeApplyDao eaDao = (EmployeeApplyDao) this.getDao();
//		result.setSuccess(eaDao.saveQuit((ChPwEmployeeapply)object));
		return result;
	}//cancel

	/**  GETTER & SETTER **/
	
	/**
	 * @return the chPwFlownameDao
	 */
	public ChPwFlownameDao getChPwFlownameDao() {
		return chPwFlownameDao;
	}

	/**
	 * @param chPwFlownameDao the chPwFlownameDao to set
	 */
	public void setChPwFlownameDao(ChPwFlownameDao chPwFlownameDao) {
		this.chPwFlownameDao = chPwFlownameDao;
	}

	/**
	 * @return the chPwAdvinfoDao
	 */
	public ChPwAdvinfoDao getChPwAdvinfoDao() {
		return chPwAdvinfoDao;
	}

	/**
	 * @param chPwAdvinfoDao the chPwAdvinfoDao to set
	 */
	public void setChPwAdvinfoDao(ChPwAdvinfoDao chPwAdvinfoDao) {
		this.chPwAdvinfoDao = chPwAdvinfoDao;
	}

	/**
	 * @return the chPwRcvobjDao
	 */
	public ChPwRcvobjDao getChPwRcvobjDao() {
		return chPwRcvobjDao;
	}

	/**
	 * @return the auditWorkDao
	 */
	public AuditWorkDao getAuditWorkDao() {
		return auditWorkDao;
	}

	/**
	 * @param auditWorkDao the auditWorkDao to set
	 */
	public void setAuditWorkDao(AuditWorkDao auditWorkDao) {
		this.auditWorkDao = auditWorkDao;
	}

	/**
	 * @param chPwRcvobjDao the chPwRcvobjDao to set
	 */
	public void setChPwRcvobjDao(ChPwRcvobjDao chPwRcvobjDao) {
		this.chPwRcvobjDao = chPwRcvobjDao;
	}

	/**
	 * @return the nosectService
	 */
	public NosectService getNosectService() {
		return nosectService;
	}

	/**
	 * @param nosectService the nosectService to set
	 */
	public void setNosectService(NosectService nosectService) {
		this.nosectService = nosectService;
	}

}
