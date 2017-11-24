package com.gmcc.pboss.biz.info.node.dao.hibernate;

import com.gmcc.pboss.biz.info.node.dao.NodeInfoDao;
import com.gmcc.pboss.biz.info.node.model.Employee;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class NodeInfoDaoHibernate extends BaseDaoHibernate implements NodeInfoDao {

	public NodeInfoDaoHibernate() {
		super(Employee.class);
	}

}
