package com.gmcc.pboss.biz.info.node.dao.hibernate;

import com.gmcc.pboss.biz.info.node.dao.WayAccountDao;
import com.gmcc.pboss.biz.info.node.model.WayAccount;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class WayAccountDaoHibernate extends BaseDaoHibernate implements WayAccountDao {

	public WayAccountDaoHibernate() {
		super(WayAccount.class);
	}

	public WayAccount getWayAccountByWayidAccno(String wayid) {
		// TODO Auto-generated method stub
		String[] propertyNames = {"wayid","accid"};
		Object[] obj = {wayid,new Integer(0)};
		return (WayAccount) getOne(propertyNames,obj);
	}

}
