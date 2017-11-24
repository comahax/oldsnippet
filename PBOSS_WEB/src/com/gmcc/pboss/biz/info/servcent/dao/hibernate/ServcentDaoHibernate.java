package com.gmcc.pboss.biz.info.servcent.dao.hibernate;

import com.gmcc.pboss.biz.info.servcent.dao.ServcentDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.servcent.Servcent;

public class ServcentDaoHibernate extends BaseHqlQueryDao implements ServcentDao {

	public ServcentDaoHibernate() {
		//…Ë÷√÷˜±Ì
		super(Servcent.class);
	}
}
