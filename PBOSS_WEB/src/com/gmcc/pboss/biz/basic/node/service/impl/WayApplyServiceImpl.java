package com.gmcc.pboss.biz.basic.node.service.impl;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.basic.AuditWork.dao.AuditWorkDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwAdvinfoDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwFlownameDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.biz.basic.node.service.WayApllyServiceRetCode;
import com.gmcc.pboss.biz.basic.node.service.WayApplyService;
import com.gmcc.pboss.biz.basic.node.support.WayApplyQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.config.bean.PendingTaskConfigBean;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PendingTaskName;
import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.member.service.MemberServiceRetCode;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

public class WayApplyServiceImpl extends BaseServiceImpl implements WayApplyService {
	
	private AuditWorkDao auditWorkDao;
	/**��˲��趨��DAO*/
	private ChPwFlownameDao chPwFlownameDao;
	/**������ϢDAO*/
	private ChPwAdvinfoDao chPwAdvinfoDao;
	/**���ܶ���DAO*/
	private ChPwRcvobjDao chPwRcvobjDao;

	/** �ֻ���������ز�ѯ Service*/
	private NosectService nosectService;

	private static Logger logger = Logger.getLogger(WayApplyServiceImpl.class);
	public WayApplyServiceImpl() {
		this.isNeedLogin = false;
		this.serviceCode = ServiceCode.WAYAPPLY;
		this.serviceName = "��������";
		setProcessor(new DefaultQueryParameterProcessor());
	}

	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		
		String stepid = ConstantsType.AUDITSTEPID_WAY_ADD1;
		Byte state = ConstantsType.AUDITSTATUS_NO;
		
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = WayApllyServiceRetCode.FAIL;
		ChPwWayapply apply = convertParameter(parameter);//��ȡ����

		//�ж��ֻ��������ڵ���
		//�л�������
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		MemberQueryParameter mparameter = new MemberQueryParameter();
		mparameter.setOfficeTel(apply.getPrincipaltel());
		ServiceResult noSectrslt = nosectService.transact(null, mparameter, ServiceType.INITIATE);
		if(!noSectrslt.isSuccess()){
			result.setSuccess(false);
			result.setRetCode(WayApllyServiceRetCode.UNDEFAULT_BRANCH);
			return result;
		}
		String cityId = (String)noSectrslt.getRetObject();
		if (!cityId.equals(apply.getCityid())){
			result.setSuccess(false);
			result.setRetCode(WayApllyServiceRetCode.MOBILENOCITYERROR);
			return result;
		}
		//�жϵ����Ƿ񿪷�
		String getConfig = Constant.getConstantName(ConstantsType.ISOPEN, cityId);
		if (!ConstantsType.ISOPEN_YES.equals(getConfig)){
			result.setSuccess(false);
			result.setRetCode(MemberServiceRetCode.INVALIDCITY);
			return result;
		}
		
		//�л����п�
		SessionFactoryContextHolder.setSessionFactoryContext(cityId);
		this.getDao().reloadSessionFactory();
		//�ж��ֻ��Ƿ��Ѿ�����
		ServiceResult offTelResl = existsEmployee(apply.getPrincipaltel());
		
		if (offTelResl.isSuccess()){
			//�ֻ������Ѿ�����
			result.setSuccess(isSuccess);
			result.setRetCode(WayApllyServiceRetCode.MOBLEEXIST);
			return result;
		}
		
		//�л����п�
		logger.info("�л����п⣺"+apply.getCityid());
		SessionFactoryContextHolder.setSessionFactoryContext(apply.getCityid());
		this.getDao().reloadSessionFactory();
		chPwFlownameDao.reloadSessionFactory();
		auditWorkDao.reloadSessionFactory();
		chPwAdvinfoDao.reloadSessionFactory();
		chPwRcvobjDao.reloadSessionFactory();
		
		//��ѯĬ�ϴ�����
		String oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		
		//�����˲�Ϊ��
		if(!CommonUtil.isEmptyOrNull(oprcode)){
			
			Date now = new Date();
			//��Principaltel���Ƶ�Officetel
			apply.setOfficetel(apply.getPrincipaltel());
			//1�����������
			apply.setAuditstatus(state);//���״��AUDITSTATUS��̬Ϊ0
			apply.setOptime(now);
			save(apply);
			
			//2�����봦������
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_WAYADD);
			auditWork.setApplyno(apply.getApplyno());
			auditWork.setStepid(stepid);
			auditWork.setCreatetime(apply.getOptime());
			auditWork.setAuditstatus(state);
			auditWork.setOprcode(oprcode);
			auditWorkDao.save(auditWork);
			
			//3��¼�빫����Ϣ����������
			PendingTaskConfigBean bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.WAY_REGISTER);
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, now, auditWork, stepid);
			chPwAdvinfoDao.save(info);
			
			//4��¼����ܶ����
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(now);
			chPwRcvobjDao.save(obj);
			//@@ ���Իع���
//			Assert.isTrue(false, -1, "�ֹ�����");
			isSuccess = true;
			retCode = WayApllyServiceRetCode.REGISTER_SUCCESS;
		}
		else{
			retCode = WayApllyServiceRetCode.NOTFOUND_OPRCODE;
		}
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}
	
	private ChPwWayapply convertParameter(QueryParameter parameter) {
		Assert.notNull(parameter, "parameter ����Ϊ��");

		if (!(WayApplyQueryParameter.class.isInstance(parameter))) {
			throw new IllegalArgumentException("�������Ͳ���");
		}

		ChPwWayapply apply = new ChPwWayapply();
		try {
			BeanUtils.copyProperties(apply, parameter);
		} catch (Exception e) {
			throw new IllegalStateException("��ֵ����");
		}
		return apply;
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
	
	
}
