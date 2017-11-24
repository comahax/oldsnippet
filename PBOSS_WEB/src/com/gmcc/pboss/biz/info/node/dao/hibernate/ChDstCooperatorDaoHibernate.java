package com.gmcc.pboss.biz.info.node.dao.hibernate;

import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;
import com.gmcc.pboss.biz.info.node.dao.ChDstCooperatorDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class ChDstCooperatorDaoHibernate extends BaseDaoHibernate implements
		ChDstCooperatorDao {
	public ChDstCooperatorDaoHibernate(){
		super(ChDstCooperator.class);
	}
	
	public ChDstCooperator getByWayid(String wayid){
		String[] propertyNames = {"cooperauid"};
		Object[] obj = {wayid};
		return (ChDstCooperator)getOne(propertyNames,obj);
	}
}
