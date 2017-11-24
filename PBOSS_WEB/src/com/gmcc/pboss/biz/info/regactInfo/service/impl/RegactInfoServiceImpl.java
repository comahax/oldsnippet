package com.gmcc.pboss.biz.info.regactInfo.service.impl;

import com.gmcc.pboss.biz.info.regactInfo.service.RegactInfoService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactInfoQueryParameterProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class RegactInfoServiceImpl extends QueryBaseServiceImpl implements RegactInfoService {

	public RegactInfoServiceImpl() {
		//����ҵ���������
		serviceName = "�¶��׿�����Ǽ���ϸ��ѯ";
		serviceCode = ServiceCode.REGACT_DETAILS;
		isNeedLogin = true;
		//���ò���������
		setProcessor(new RegactInfoQueryParameterProcessor());
	}

}
