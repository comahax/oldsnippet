package com.gmcc.pboss.biz.info.salesRpt.dao.hibernate;

import com.gmcc.pboss.biz.info.salesRpt.dao.OrderProceDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sales.FxRuOrderproce;

public class OrderProceDaoHibernate extends BaseDaoHibernate implements OrderProceDao {

	public OrderProceDaoHibernate() {
		//设置订单流程主表
		super(FxRuOrderproce.class);
	}

	public FxRuOrderproce getByFlowidInstate(Long flowid, String instate) {
		// TODO Auto-generated method stub
		String [] propertyNames = {"flowid","instate"};
		Object [] values = {flowid,instate};
		Object rtnObj = this.getOne(propertyNames, values);
		return (FxRuOrderproce) rtnObj;
	}
}

