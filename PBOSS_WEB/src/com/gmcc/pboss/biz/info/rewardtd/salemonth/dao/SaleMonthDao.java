package com.gmcc.pboss.biz.info.rewardtd.salemonth.dao;

import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonthQueryParameter;
import com.gmcc.pboss.common.dao.BaseDao;

public interface SaleMonthDao extends BaseDao {
	public String getMaxcount(SaleMonthQueryParameter parameter); 
}
