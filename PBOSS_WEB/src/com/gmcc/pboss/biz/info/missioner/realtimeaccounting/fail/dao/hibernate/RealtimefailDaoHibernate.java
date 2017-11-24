package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.dao.hibernate;

import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.dao.RealtimefailDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.reward.chbbcrealtimefail.Chbbcrealtimefail;

public class RealtimefailDaoHibernate extends BaseHqlQueryDao implements
		RealtimefailDao {
	public RealtimefailDaoHibernate(){
		super(Chbbcrealtimefail.class);
	}

}
