package com.gmcc.pboss.biz.info.reward.dao;

import com.gmcc.pboss.biz.info.reward.model.RewardConf;

public interface RewardConfDao {

	public RewardConf getRewardConf(String cityId, String rewardkind, String rewardmonth);

}
