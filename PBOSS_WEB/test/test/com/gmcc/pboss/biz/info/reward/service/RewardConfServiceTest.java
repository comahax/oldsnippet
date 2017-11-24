package test.com.gmcc.pboss.biz.info.reward.service;

import org.springframework.util.Assert;

import com.gmcc.pboss.biz.info.reward.service.RewardConfService;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class RewardConfServiceTest extends BaseTest {

	private RewardConfService rewardConfService;

	public RewardConfService getRewardConfService() {
		return rewardConfService;
	}

	public void setRewardConfService(RewardConfService rewardConfService) {
		this.rewardConfService = rewardConfService;
	}

	public void testIsStrikeBalance() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		boolean result = rewardConfService.isStrikeBalance("760", "B2M", "200903");
		Assert.isTrue(result);
		result = rewardConfService.isStrikeBalance("760", "B2M", "200902");
		Assert.isTrue(result);
		result = rewardConfService.isStrikeBalance("760", "B2M", "200901");
		Assert.isTrue(!result);
	}

}
