package com.gmcc.pboss.biz.info.adpay.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sales.bankshop.FxCbBankshop;

public interface BankshopDao extends BaseDao {
	public FxCbBankshop getByCityCounty(String cityid, String countyid);
}
