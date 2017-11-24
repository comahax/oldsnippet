package com.gmcc.pboss.biz.info.missioner.recommend.success.dao.hibernate;

import com.gmcc.pboss.biz.info.missioner.recommend.success.dao.MissionerDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.reward.allsalesday.ChBbcAllsalesday;

public class MissionerDaoHibernate extends BaseHqlQueryDao implements MissionerDao {
	
	public MissionerDaoHibernate() {
		super(ChBbcAllsalesday.class);
	}

}
