package com.gmcc.pboss.biz.info.reward.payment.service;

import com.gmcc.pboss.common.service.BaseService;

public interface PaymentService extends BaseService {
	public boolean isSupportPaymonth();
	public boolean isSupportFee();
}
 