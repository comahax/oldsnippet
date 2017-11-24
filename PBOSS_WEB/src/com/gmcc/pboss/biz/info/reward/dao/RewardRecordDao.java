package com.gmcc.pboss.biz.info.reward.dao;

import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.dao.BaseDao;

public interface RewardRecordDao extends BaseDao {
	/**
	 * ³ê½ðÓà¶î
	 * @param parameter
	 * @return
	 */
	public Long statRewardBalance(RewardQueryParameter parameter);
}
