package com.gmcc.pboss.biz.info.node.service.impl;

import java.util.Date;
import java.util.List;

import com.gmcc.pboss.biz.basic.AuditWork.dao.AuditWorkDao;
import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwAdvinfoDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwFlownameDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.biz.info.node.dao.WayAccountDao;
import com.gmcc.pboss.biz.info.node.model.WayAccount;
import com.gmcc.pboss.biz.info.node.service.NodeInfoService;
import com.gmcc.pboss.biz.info.node.support.NodeInfoQueryParameter;
import com.gmcc.pboss.biz.info.node.support.NodeInfoQueryParameterProcessor;
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
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;
import com.gmcc.pboss.model.constant.IbGlSysparam;
import com.gmcc.pboss.model.constant.IbGlSysparamId;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

public class NodeInfoServiceImpl extends QueryBaseServiceImpl implements NodeInfoService {

	private AuditWorkDao auditWorkDao;
	
	/**��˲��趨��DAO*/
	private ChPwFlownameDao chPwFlownameDao;
	/**������ϢDAO*/
	private ChPwAdvinfoDao chPwAdvinfoDao;
	/**���ܶ���DAO*/
	private ChPwRcvobjDao chPwRcvobjDao;
	/**WayAccountDao DAO*/
	private WayAccountDao wayAccountDao;

	/** �ֻ���������ز�ѯ Service*/
	private NosectService nosectService;
	
	/**
	 * ϵͳ���� DAO
	 */
	private IbGlSysparamDao ibGlSysparamDao;
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

	public NodeInfoServiceImpl() {
		this.serviceCode = ServiceCode.NODE;
		this.serviceName = "��������";
		this.isNeedLogin = true;
		setProcessor(new NodeInfoQueryParameterProcessor());
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl#query(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	/**
	 * ���ظ��࣬�������ϲ�ѯ
	 */
	@Override
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		ServiceResult rtn = super.query(member, parameter);
		//������ѯWayAccount
		if (rtn.isSuccess()){
			//��ѯ�ɹ�����ȡ
			List rtnList = rtn.getRetResult().getData();
			if (rtnList.size()>0){
				com.gmcc.pboss.biz.info.node.model.Employee emp = (com.gmcc.pboss.biz.info.node.model.Employee)rtnList.get(0);
				//��ȡwayaccount
				WayAccount wayAcc = this.wayAccountDao.getWayAccountByWayidAccno(emp.getWayid());
				emp.setWayAccount(wayAcc);
				//���·�װ
				rtnList.clear();
				rtnList.add(emp);
				rtn.setRetResult(new QueryResult(null, rtnList));
//				System.out.println(emp.getWayid() +"");
			}
		}
		return rtn;
	}

	/**
	 * ���������޸�
	 * @@�޸�Ϊͬ������
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		NodeInfoQueryParameter saveParm = ( NodeInfoQueryParameter)parameter;
		
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = ServiceRetCode.FAIL;

		//����ֻ������Ƿ����
		Employee employee = (Employee)getMemberDao().get(saveParm.getEmployeeId());
		ChPwWayapply apply = (ChPwWayapply)saveParm.getSaveObj();
		if(!apply.getPrincipaltel().equals(employee.getOfficetel())){
			//�ж��ֻ��������ڵ���
			//�л�������
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			MemberQueryParameter mparameter = new MemberQueryParameter();
			mparameter.setOfficeTel(apply.getPrincipaltel());
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
			ServiceResult offTelResl = existsEmployee(apply.getPrincipaltel());
			if (offTelResl.isSuccess()){
				//�ֻ������Ѿ�����
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.MOBLEEXIST);
				return result;
			}
		}
		
		String stepid = ConstantsType.AUDITSTEPID_WAY_UPDATE1;
		Byte state = ConstantsType.AUDITSTATUS_NO;

		//�л������п�
		SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
		chPwFlownameDao.reloadSessionFactory();
		

		//��ȡϵͳ����������������ɫ���ƣ�1Ϊ���ã�0Ϊ������
		String paramChannal = ((IbGlSysparam) ibGlSysparamDao.get(new IbGlSysparamId((long)67,"channel"))).getParamvalue();
		String oprcode = null;
		boolean useWayMmg = false;
		if ("1".equals(paramChannal)){
			//��������
			useWayMmg = true;
			oprcode = member.getChannel().getWaymagcode();
		}else{	
			//������� ��ѯĬ�ϴ�����
			oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		}
		
		if(!CommonUtil.isEmptyOrNull(oprcode)){
			
			Date now = new Date();

			//��Principaltel���Ƶ�Officetel
			apply.setOfficetel(apply.getPrincipaltel());
			//1�����������
			apply = (ChPwWayapply)saveParm.getSaveObj();
			apply.setAuditstatus(state);//���״��AUDITSTATUS��̬Ϊ0
			apply.setOptime(now);
			this.save(apply);
			
			//2�����봦������
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_WAYUPDATE);
			auditWork.setApplyno(apply.getApplyno());
			auditWork.setStepid(stepid);
			auditWork.setCreatetime(apply.getOptime());
			auditWork.setAuditstatus(state);
			auditWork.setOprcode(oprcode);
			auditWorkDao.save(auditWork);
			
			//3��¼�빫����Ϣ����������
			PendingTaskConfigBean bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.WAY_UPDATE);

			//���÷�������
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, now, auditWork, stepid,member.getEmployeeid());
			chPwAdvinfoDao.save(info);
			
			//4��¼����ܶ����
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(now);
			chPwRcvobjDao.save(obj);
			
			isSuccess = true;
			retCode = ServiceRetCode.DEF_APPLY;
		}
		else{
			if (useWayMmg) 
				retCode = ServiceRetCode.EMPTY_WAYMMG;//��������û�ж���
			else
				retCode = ServiceRetCode.NOTFOUND_OPRCODE;//��һ��������û�ж���
		}
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}

	/**
	 * ���������˳�
	 * @@�޸�Ϊͬ������
	 */
	public ServiceResult cancel(LoginMember member, QueryParameter parameter) {
		NodeInfoQueryParameter saveParm = ( NodeInfoQueryParameter)parameter;
		
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = ServiceRetCode.FAIL;
		
		String stepid = ConstantsType.AUDITSTEPID_WAY_REMOVE1;
		Byte state = ConstantsType.AUDITSTATUS_NO;
		
		//��ȡϵͳ����������������ɫ���ƣ�1Ϊ���ã�0Ϊ������
		String paramChannal = ((IbGlSysparam) ibGlSysparamDao.get(new IbGlSysparamId((long)67,"channel"))).getParamvalue();
		String oprcode = null;
		boolean useWayMmg = false;
		if ("1".equals(paramChannal)){
			//��������
			useWayMmg = true;
			oprcode = member.getChannel().getWaymagcode();
		}else{	
			//������� ��ѯĬ�ϴ�����
			oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		}
		
		if(!CommonUtil.isEmptyOrNull(oprcode)){
			Date now = new Date();
			
			//1�����������
			ChPwWayapply apply = (ChPwWayapply)saveParm.getSaveObj();
			apply.setAuditstatus(state);//���״��AUDITSTATUS��̬Ϊ0
			apply.setOptime(now);
			this.save(apply);
			
			//2�����봦������
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_WAYREMOVE);
			auditWork.setApplyno(apply.getApplyno());
			auditWork.setStepid(stepid);
			auditWork.setCreatetime(apply.getOptime());
			auditWork.setAuditstatus(state);
			auditWork.setOprcode(oprcode);
			auditWorkDao.save(auditWork);
			
			//3��¼�빫����Ϣ����������
			PendingTaskConfigBean bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.WAY_REMOVE);
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, now, auditWork, stepid,member.getEmployeeid());
			chPwAdvinfoDao.save(info);
			
			//4��¼����ܶ����
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(now);
			chPwRcvobjDao.save(obj);
			
			isSuccess = true;
			retCode = ServiceRetCode.DEF_OUT;
		}
		else{
			if (useWayMmg) 
				retCode = ServiceRetCode.EMPTY_WAYMMG;//��������û�ж���
			else
				retCode = ServiceRetCode.NOTFOUND_OPRCODE;//��һ��������û�ж���
		}
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		
		return result;
	}

	public ChPwFlownameDao getChPwFlownameDao() {
		return chPwFlownameDao;
	}

	public void setChPwFlownameDao(ChPwFlownameDao chPwFlownameDao) {
		this.chPwFlownameDao = chPwFlownameDao;
	}

	public ChPwAdvinfoDao getChPwAdvinfoDao() {
		return chPwAdvinfoDao;
	}

	public void setChPwAdvinfoDao(ChPwAdvinfoDao chPwAdvinfoDao) {
		this.chPwAdvinfoDao = chPwAdvinfoDao;
	}

	public ChPwRcvobjDao getChPwRcvobjDao() {
		return chPwRcvobjDao;
	}

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

	/**
	 * @return the wayAccountDao
	 */
	public WayAccountDao getWayAccountDao() {
		return wayAccountDao;
	}

	/**
	 * @param wayAccountDao the wayAccountDao to set
	 */
	public void setWayAccountDao(WayAccountDao wayAccountDao) {
		this.wayAccountDao = wayAccountDao;
	}

	/**
	 * @return the ibGlSysparamDao
	 */
	public IbGlSysparamDao getIbGlSysparamDao() {
		return ibGlSysparamDao;
	}

	/**
	 * @param ibGlSysparamDao the ibGlSysparamDao to set
	 */
	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}
}
