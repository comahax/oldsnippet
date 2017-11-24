package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import com.gmcc.pboss.biz.info.reward.dao.RewardTotalDao;
import com.gmcc.pboss.biz.info.reward.model.RewardTotal;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class RewardTotalDaoHibernate extends BaseDaoHibernate implements RewardTotalDao {

	public RewardTotalDaoHibernate() {
		super(RewardTotal.class);
	}

}
