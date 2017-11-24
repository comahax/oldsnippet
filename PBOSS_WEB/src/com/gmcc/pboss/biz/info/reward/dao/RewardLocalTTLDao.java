package com.gmcc.pboss.biz.info.reward.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;

public interface RewardLocalTTLDao extends BaseDao {

	/**
	 * �������·ݺͱ������ͷ��ر�������
	 * @param RewardQueryParameter month �����·�  rewardtype ��������
	 * @return
	 */
	public List<ChPwRewardlocaltitle> getLocalTitle(QueryParameter parameter);
}
