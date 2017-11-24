package com.gmcc.pboss.biz.info.examine.service.impl;

import com.gmcc.pboss.biz.info.examine.service.ChPwExmnRsltService;
import com.gmcc.pboss.biz.info.examine.support.ChPwExmnRsltQueryParameterProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class ChPwExmnRsltServiceImpl extends QueryBaseServiceImpl implements ChPwExmnRsltService {

	public ChPwExmnRsltServiceImpl() {
		serviceName = "¿¼ºË±¨±í";
		serviceCode = ServiceCode.EXAMINE;
		isNeedLogin = true;

		setProcessor(new ChPwExmnRsltQueryParameterProcessor());
	}

}
