package com.gmcc.pboss.biz.info.node.dao.hibernate;

import com.gmcc.pboss.biz.info.node.dao.WayDao;
import com.gmcc.pboss.biz.info.node.model.Way;
//import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class WayDaoHibernate extends BaseHqlQueryDao implements WayDao {  //extends BaseDaoHibernate

	public WayDaoHibernate(){
		super(Way.class);
	}
	
	public Way getByWayid(String wayid) {
		// TODO Auto-generated method stub
		String[] propertyNames = {"wayid"};
		Object[] obj = {wayid};
		return (Way)getOne(propertyNames,obj);
	}

}
