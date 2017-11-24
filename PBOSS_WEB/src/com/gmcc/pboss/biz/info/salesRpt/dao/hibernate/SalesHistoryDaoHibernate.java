package com.gmcc.pboss.biz.info.salesRpt.dao.hibernate;

import com.gmcc.pboss.biz.info.salesRpt.dao.SalesDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sales.FxSwPartnerres;

public class SalesHistoryDaoHibernate extends BaseDaoHibernate implements SalesDao {

	public SalesHistoryDaoHibernate() {
		//…Ë÷√÷˜±Ì
		super(FxSwPartnerres.class);
	}
}

