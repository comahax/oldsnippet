package com.gmcc.pboss.biz.info.reward.service.impl;

import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.member.service.MemberServiceRetCode;

public class RewardBalanceServiceImpl extends RewardRecordServiceImpl {

	public RewardBalanceServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDBALANC;
		this.serviceName = "�������ѯ";
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#other(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	/**
	 * �����������������ҵ��
	 */
	@Override
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		//����ҵ�񷵻�ֵ
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);
		result.setRetObject(member);
		
		//��ѯ2��
		RewardQueryParameter para = (RewardQueryParameter)parameter;
		para.setWayid(member.getWayid());
		//����ֵ
		Long rtnObj[] = new Long[2];		
		para.setTerm("2");
		rtnObj[0] = statRewardBalance(para);//���ڽ������ܶ�
		
		para.setTerm("3");
		rtnObj[1] = statRewardBalance(para);//���ڽ������ܶ�
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		result.setRetObject(rtnObj);
		
		return result;
	}
}
