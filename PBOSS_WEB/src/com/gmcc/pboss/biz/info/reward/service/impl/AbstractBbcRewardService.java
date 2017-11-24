package com.gmcc.pboss.biz.info.reward.service.impl;

import com.gmcc.pboss.biz.info.reward.service.RewardConfService;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardKind;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.member.service.MemberServiceRetCode;

public abstract class AbstractBbcRewardService extends BaseServiceImpl implements RewardService {

	private RewardConfService rewardConfService;

	public AbstractBbcRewardService() {
		this.serviceCode = ServiceCode.REWARD_BBC;
		this.serviceName = "酬金明细查询_B2M";
		this.isNeedLogin = true;
	}

	public ServiceResult query(LoginMember member, QueryParameter parameter) {

		BbcRewardQueryParameter param = (BbcRewardQueryParameter) parameter;

		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);
		result.setRetObject(member);
		
		String rewardType=param.getRewardKind();
		if(rewardType.equals(RewardKind.UNPB)){
			this.serviceCode = ServiceCode.REWARD_UNPB;
			this.serviceName = "酬金明细查询_UNPB创新联盟";
		}
		
		if (rewardConfService.isStrikeBalance(member.getCityno(), param.getRewardKind(), param.getMonth())) {

			QueryResult queryResult = getAll(parameter);
			result.setRetResult(queryResult);
			result.setSuccess(true);
			result.setRetCode(MemberServiceRetCode.SUCCESS);

		} else {

			result.setRetCode(MemberServiceRetCode.REWARD_STRIKE_BALANCE);

		}
		return result;
	}

	public RewardConfService getRewardConfService() {
		return rewardConfService;
	}

	public void setRewardConfService(RewardConfService rewardConfService) {
		this.rewardConfService = rewardConfService;
	}

}
