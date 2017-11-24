package com.gmcc.pboss.biz.info.adpay.dao.impl;

import com.gmcc.pboss.biz.info.adpay.dao.BankdeductDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sales.bankdeduct.FxSwBankdeduct;

public class BankdeductDaoHibernate extends BaseDaoHibernate implements
		BankdeductDao {
	public BankdeductDaoHibernate(){
		super(FxSwBankdeduct.class);
	}

}
