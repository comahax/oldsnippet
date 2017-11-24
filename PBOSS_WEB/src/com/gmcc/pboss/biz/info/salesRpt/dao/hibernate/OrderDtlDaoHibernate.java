package com.gmcc.pboss.biz.info.salesRpt.dao.hibernate;

import com.gmcc.pboss.biz.info.salesRpt.dao.SalesDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.model.sales.FxSwPartnerres;

public class OrderDtlDaoHibernate extends BaseHqlQueryDao implements SalesDao {

	public OrderDtlDaoHibernate() {
		//…Ë÷√÷˜±Ì
		super(FxSwOrder.class);
	}
}

