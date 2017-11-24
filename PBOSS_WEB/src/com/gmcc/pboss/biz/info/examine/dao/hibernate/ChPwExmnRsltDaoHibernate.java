package com.gmcc.pboss.biz.info.examine.dao.hibernate;

import com.gmcc.pboss.biz.info.examine.dao.ChPwExmnRsltDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.examine.ChPwExmnRslt;

public class ChPwExmnRsltDaoHibernate extends BaseDaoHibernate implements ChPwExmnRsltDao {

	public ChPwExmnRsltDaoHibernate() {
		super(ChPwExmnRslt.class);
	}

}
