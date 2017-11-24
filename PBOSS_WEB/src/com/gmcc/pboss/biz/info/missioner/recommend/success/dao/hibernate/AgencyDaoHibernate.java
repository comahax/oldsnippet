package com.gmcc.pboss.biz.info.missioner.recommend.success.dao.hibernate;

import com.gmcc.pboss.biz.info.missioner.recommend.success.dao.AgencyDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.reward.allsalesday.ChBbcAllsalesday;

public class AgencyDaoHibernate extends BaseHqlQueryDao implements AgencyDao {

	public AgencyDaoHibernate() {
		super(ChBbcAllsalesday.class);
	}

}
