package com.gmcc.pboss.biz.basic.node.dao.hibernate;

import com.gmcc.pboss.biz.basic.node.dao.WayApplyDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

public class WayApplyDaoHibernate extends BaseDaoHibernate implements WayApplyDao {

	public WayApplyDaoHibernate() {
		super(ChPwWayapply.class);
	}
	
}
