package com.gmcc.pboss.biz.info.adpay.dao.impl;

import com.gmcc.pboss.biz.info.adpay.dao.BankshopDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sales.bankshop.FxCbBankshop;

public class BankshopDaoHibernate extends BaseDaoHibernate implements
		BankshopDao {
	public BankshopDaoHibernate(){
		super(FxCbBankshop.class);
	}

	public FxCbBankshop getByCityCounty(String cityid, String countyid) {
		// TODO Auto-generated method stub
		String[] propertiesName = {"cityid","countyid"};
		Object[] values = {cityid,countyid};				
		return (FxCbBankshop)this.getOne(propertiesName, values);
	}

}
