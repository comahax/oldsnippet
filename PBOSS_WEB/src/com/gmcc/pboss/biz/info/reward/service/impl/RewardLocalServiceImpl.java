package com.gmcc.pboss.biz.info.reward.service.impl;


import java.util.List;

import com.gmcc.pboss.biz.info.reward.dao.RewardLocalDTLDao;
import com.gmcc.pboss.biz.info.reward.dao.RewardLocalDao;
import com.gmcc.pboss.biz.info.reward.dao.RewardLocalTTLDao;
import com.gmcc.pboss.biz.info.reward.service.RewardLocalService;
import com.gmcc.pboss.biz.info.reward.service.RewardServiceRetCode;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.processor.RewardLocalDtlProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocal;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocalvalue;

public class RewardLocalServiceImpl extends BaseServiceImpl implements RewardLocalService {
	//�����DAO
	private RewardLocalTTLDao rewardLocalTTLDao;
	//ֵ��DAO
	private RewardLocalDTLDao rewardLocalDTLDao;
	/**
	 * ���� ����
	 */
	public RewardLocalServiceImpl() {
		this.serviceCode = ServiceCode.REWARD_LOCAL;
		this.serviceName = "���س���ѯ";
		this.isNeedLogin = true;
	}
	

	public ServiceResult query(LoginMember member, QueryParameter parameter) {

		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//����������ΪRPWDLocalRPT�����س����ϸ��ʱ��ת�����س����ϸ��ѯ�߼�
		if (ConstantsType.RPWDLocalRPT.equals(param.getRewardtype()))
			return queryDtl(member,parameter);
		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(RewardServiceRetCode.FAIL);
		result.setRetObject(null);

		RewardLocalDao localDao = (RewardLocalDao) this.getDao();
		//��ѯ�����
		List<ChPwRewardlocaltitle> ttlList = rewardLocalTTLDao.getLocalTitle(parameter);
		if (ttlList.size()==0){
			result.setRetCode(RewardServiceRetCode.DATA_ERROR);
			return result;
		}
		Object[] rtn=new Object[2];
		if (ConstantsType.RRWDSumRPT.equals(param.getRewardtype())){
			//�������·ݡ��������ͺ��û�����ȡ����
			ChPwRewardlocal rewardlocalObj = localDao.getRewardlocalByUser(member, parameter);
			if (rewardlocalObj == null){
				result.setRetCode(RewardServiceRetCode.USER_EMPTY);
				return result;
			}
			List<ChPwRewardlocalvalue> valuesList = localDao.getRewardlocalValuesById(rewardlocalObj.getRewardid());
			//��װ�����������
			for (ChPwRewardlocalvalue valueObj:valuesList){
				rewardlocalObj.getDatas().put(valueObj.getId().getSeq().toString(), valueObj);
			}
			rtn[0]=rewardlocalObj;
			rtn[1]=ttlList;
		}else{
		
			List<ChPwRewardlocal> rewardlocalObjList = localDao.getRewardlocalListByUser(member, parameter);
			if (rewardlocalObjList == null || rewardlocalObjList.size()==0){
				result.setRetCode(RewardServiceRetCode.USER_EMPTY);
				return result;
			}
			
			//��ȡֵ
			for(ChPwRewardlocal rewardlocalObj:rewardlocalObjList){
				List<ChPwRewardlocalvalue> valuesList = localDao.getRewardlocalValuesById(rewardlocalObj.getRewardid());
				rewardlocalObj.setValuesList(valuesList);
			}
			
			
			//���ض���[0]�������[1]�����List
			rtn[0]=rewardlocalObjList;
			rtn[1]=ttlList;
		}
		result.setSuccess(true);
		result.setRetCode(RewardServiceRetCode.SUCCESS);
		result.setRetObject(rtn);
		
		return result;
	}

	/**
	 * ��ϸ��ѯ
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult queryDtl(LoginMember member, QueryParameter parameter) {

		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(RewardServiceRetCode.FAIL);
		result.setRetObject(null);
		
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//����ҳ����Ϣ
		parameter.setAction(QueryAction.SECTION);
		
		if(param.getNo() <1) param.setNo(1);
		param.setWayid(member.getWayid());
//		param.setSize(3);
		
		QueryResult rtn = rewardLocalDTLDao.getAll(new RewardLocalDtlProcessor(), param);

		result.setSuccess(true);
		result.setRetCode(RewardServiceRetCode.SUCCESS);
		result.setRetResult(rtn);
		return result;
	}
	/**
	 * @return the rewardLocalTTLDao
	 */
	public RewardLocalTTLDao getRewardLocalTTLDao() {
		return rewardLocalTTLDao;
	}


	/**
	 * @param rewardLocalTTLDao the rewardLocalTTLDao to set
	 */
	public void setRewardLocalTTLDao(RewardLocalTTLDao rewardLocalTTLDao) {
		this.rewardLocalTTLDao = rewardLocalTTLDao;
	}


	/**
	 * @return the rewardLocalDTLDao
	 */
	public RewardLocalDTLDao getRewardLocalDTLDao() {
		return rewardLocalDTLDao;
	}


	/**
	 * @param rewardLocalDTLDao the rewardLocalDTLDao to set
	 */
	public void setRewardLocalDTLDao(RewardLocalDTLDao rewardLocalDTLDao) {
		this.rewardLocalDTLDao = rewardLocalDTLDao;
	}
}
