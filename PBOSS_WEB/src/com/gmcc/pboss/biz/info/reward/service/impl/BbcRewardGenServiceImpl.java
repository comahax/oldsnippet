package com.gmcc.pboss.biz.info.reward.service.impl;

import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardKind;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryParameter;

public class BbcRewardGenServiceImpl extends BbcRewardRecordServiceImpl {
	public BbcRewardGenServiceImpl(){
		super();
		this.serviceCode=ServiceCode.REWARDTOTAL_BBC;
		this.serviceName="��Ӧ����𱨱�_B2M��վ";
	}
	
	public ServiceResult query(LoginMember member, QueryParameter parameter){
		ServiceResult result = super.query(member, parameter);
		BbcRewardQueryParameter param = (BbcRewardQueryParameter) parameter;
		if(param.getRewardKind().equals(RewardKind.UNPB)){
			this.serviceCode=ServiceCode.REWARDTOTAL_UNPB;
			this.serviceName="��Ӧ����𱨱�_UNPB��������";
		}
		return result;
	}
}
