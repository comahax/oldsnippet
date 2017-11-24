package com.gmcc.pboss.biz.info.salesRpt.service.impl;

import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.support.processor.SalesHistoryParameterProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class SalesHistoryServiceImpl extends QueryBaseServiceImpl implements SalesRptService {

	public SalesHistoryServiceImpl() {
		serviceName = "商品订购历史";
		serviceCode = ServiceCode.SALESHISTORY;
		isNeedLogin = true;

		setProcessor(new SalesHistoryParameterProcessor());
	}

}
