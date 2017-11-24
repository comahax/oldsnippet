package com.gmcc.pboss.biz.info.reward.service.impl;

import com.gmcc.pboss.biz.info.reward.dao.RewardConfDao;
import com.gmcc.pboss.biz.info.reward.model.RewardConf;
import com.gmcc.pboss.biz.info.reward.service.RewardConfService;

public class RewardConfServiceImpl implements RewardConfService {

	private RewardConfDao rewardConfDao;

	public RewardConfDao getRewardConfDao() {
		return rewardConfDao;
	}

	public void setRewardConfDao(RewardConfDao rewardConfDao) {
		this.rewardConfDao = rewardConfDao;
	}

	public boolean isStrikeBalance(String cityId, String rewardkind, String rewardmonth) {
		RewardConf conf = rewardConfDao.getRewardConf(cityId, rewardkind, rewardmonth);
		return conf != null && conf.getState().shortValue() == 1 ? true : false;
	}

}
