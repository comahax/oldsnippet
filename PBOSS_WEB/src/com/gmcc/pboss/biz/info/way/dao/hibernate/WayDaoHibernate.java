package com.gmcc.pboss.biz.info.way.dao.hibernate;

import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.way.dao.WayDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class WayDaoHibernate extends BaseHqlQueryDao implements WayDao {

	public WayDaoHibernate() {
		//…Ë÷√÷˜±Ì
		super(Way.class);
	}

}
