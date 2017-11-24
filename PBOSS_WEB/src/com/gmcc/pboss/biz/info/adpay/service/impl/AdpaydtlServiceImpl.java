package com.gmcc.pboss.biz.info.adpay.service.impl;

import com.gmcc.pboss.biz.info.adpay.service.AdpaydtlService;
import com.gmcc.pboss.biz.info.adpay.support.processor.AdpaydtlParameterProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class AdpaydtlServiceImpl extends QueryBaseServiceImpl implements AdpaydtlService{
	
	public AdpaydtlServiceImpl() {
		serviceName = "∂©µ•–≈œ¢";
		serviceCode = ServiceCode.SALESORDER;
		isNeedLogin = true;

		setProcessor(new AdpaydtlParameterProcessor());
	}
}
