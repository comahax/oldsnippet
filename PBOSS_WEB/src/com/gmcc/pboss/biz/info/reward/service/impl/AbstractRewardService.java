package com.gmcc.pboss.biz.info.reward.service.impl;

import com.gmcc.pboss.biz.info.reward.service.RewardConfService;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardKind;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.member.service.MemberServiceRetCode;

public abstract class AbstractRewardService extends BaseServiceImpl implements RewardService {

	private RewardConfService rewardConfService;

	public AbstractRewardService() {
		this.serviceCode = ServiceCode.REWARD_SOCIETY;
		this.serviceName = "酬金明细查询_社会渠道";
		this.isNeedLogin = true;
	}

	public ServiceResult query(LoginMember member, QueryParameter parameter) {

		RewardQueryParameter param = (RewardQueryParameter) parameter;

		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);
		result.setRetObject(member);

		if (rewardConfService.isStrikeBalance(member.getCityno(), RewardKind.AG, param.getMonth())) {

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
