package com.gmcc.pboss.biz.communi.dao.hibernate;

import com.gmcc.pboss.biz.communi.dao.CommunicateInterlocutionDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;

public class CommunicateInterlocutionDaoHibernate extends BaseHqlQueryDao
		implements CommunicateInterlocutionDao {

	public CommunicateInterlocutionDaoHibernate() {
		super(ChPwAdvinfo.class);
	}
	
}
