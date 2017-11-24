package com.gmcc.pboss.biz.info.salesRpt.service.impl;

import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.support.processor.OrderDtlQueryProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class OrderDtlServiceImpl extends QueryBaseServiceImpl implements SalesRptService {

	public OrderDtlServiceImpl() {
		serviceName = "∂©µ•–≈œ¢";
		serviceCode = ServiceCode.SALESORDER;
		isNeedLogin = true;

		setProcessor(new OrderDtlQueryProcessor());
	}
	
}
