package test.com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class BbcRewardRecordServiceTest extends BaseTest {

	private RewardService bbcRewardRecordService;

	public RewardService getBbcRewardRecordService() {
		return bbcRewardRecordService;
	}

	public void setBbcRewardRecordService(RewardService bbcRewardRecordService) {
		this.bbcRewardRecordService = bbcRewardRecordService;
	}

	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		BbcRewardQueryParameter parameter = new BbcRewardQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setRewardtype("9");
		parameter.setMonth("200906");
		parameter.setOpnid("010400033");

		ServiceResult result = bbcRewardRecordService.query(new LoginMember(), parameter);
		System.out.println(result);
		System.out.println(result.getRetResult().getData().size());
	}
}
