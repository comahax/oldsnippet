package test.com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class BbcRewardTotalServiceTest extends BaseTest {

	private RewardService bbcRewardTotalService;

	public RewardService getBbcRewardTotalService() {
		return bbcRewardTotalService;
	}

	public void setBbcRewardTotalService(RewardService bbcRewardTotalService) {
		this.bbcRewardTotalService = bbcRewardTotalService;
	}

	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		BbcRewardQueryParameter parameter = new BbcRewardQueryParameter();
		LoginMember member = new LoginMember();
		member.setWayid("CH_2323");
		member.setCityno("ZS");
		
		//@@”√∑≠“≥≤È—Ø”–BUG
		parameter.setAction(QueryAction.ALL);
//		parameter.setSize(5);
//		parameter.setNo(2);
		parameter.setWayid("CH_2323");
		//parameter.setRewardtype("9");
		parameter.setMonth("200906");

		ServiceResult result = bbcRewardTotalService.query(member, parameter);
		System.out.println(result);
		System.out.println(result.getRetResult().getData().size());

	}
}
