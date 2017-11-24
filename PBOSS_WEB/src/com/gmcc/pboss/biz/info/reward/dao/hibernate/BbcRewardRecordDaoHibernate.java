package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import com.gmcc.pboss.biz.info.reward.dao.RewardRecordDao;
import com.gmcc.pboss.biz.info.reward.model.BbcRewardRecord;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class BbcRewardRecordDaoHibernate extends BaseDaoHibernate implements RewardRecordDao {

	public BbcRewardRecordDaoHibernate() {
		super(BbcRewardRecord.class);
	}

	public Long statRewardBalance(RewardQueryParameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
