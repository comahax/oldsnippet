package com.gmcc.pboss.biz.info.reward.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;

public interface RewardLocalTTLDao extends BaseDao {

	/**
	 * 按结算月份和报表类型返回标题表对象
	 * @param RewardQueryParameter month 结算月份  rewardtype 报表类型
	 * @return
	 */
	public List<ChPwRewardlocaltitle> getLocalTitle(QueryParameter parameter);
}
