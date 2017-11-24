package com.gmcc.pboss.biz.info.rewardtd.salemonth.service;

import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonthQueryParameter;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.ServiceResult;

public interface SaleMonthService  extends BaseService{
	public String getMaxcount(SaleMonthQueryParameter parameter);

}
