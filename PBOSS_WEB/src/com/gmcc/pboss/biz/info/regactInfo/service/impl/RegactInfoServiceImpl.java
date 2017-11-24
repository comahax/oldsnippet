package com.gmcc.pboss.biz.info.regactInfo.service.impl;

import com.gmcc.pboss.biz.info.regactInfo.service.RegactInfoService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactInfoQueryParameterProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class RegactInfoServiceImpl extends QueryBaseServiceImpl implements RegactInfoService {

	public RegactInfoServiceImpl() {
		//设置业务相关属性
		serviceName = "月度套卡激活登记明细查询";
		serviceCode = ServiceCode.REGACT_DETAILS;
		isNeedLogin = true;
		//设置参数处理器
		setProcessor(new RegactInfoQueryParameterProcessor());
	}

}
