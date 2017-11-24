package com.gmcc.pboss.biz.info.node.dao.hibernate;

import com.gmcc.pboss.biz.info.node.dao.DbBankDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.wayapply.SaDbBank;

public class DbBankDaoHibernate extends BaseDaoHibernate implements DbBankDao {
	public DbBankDaoHibernate() {
		super(SaDbBank.class);
		// TODO Auto-generated constructor stub
	}
	
}
