package com.gmcc.pboss.biz.info.reward.payment.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryParameter;

public interface PaymentManageService extends BaseService {
	public ServiceResult query(QueryParameter parameter);
}
