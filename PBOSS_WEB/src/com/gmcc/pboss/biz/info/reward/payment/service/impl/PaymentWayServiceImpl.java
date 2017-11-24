package com.gmcc.pboss.biz.info.reward.payment.service.impl;

import com.gmcc.pboss.biz.info.reward.payment.dao.other.PaymentWayDao;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentWayService;
import com.gmcc.pboss.biz.info.reward.payment.support.processor.PaymentWayQueryParamProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class PaymentWayServiceImpl extends QueryBaseServiceImpl implements
		PaymentWayService {
	private PaymentWayDao paymentWayDao;

	public PaymentWayDao getPaymentWayDao() {
		return paymentWayDao;
	}

	public void setPaymentWayDao(PaymentWayDao paymentWayDao) {
		this.paymentWayDao = paymentWayDao;
	}

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public PaymentWayServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARD_CONFIG;
		this.serviceName = "酬金一体化配置";
		this.isNeedLogin = true;

		setProcessor(new PaymentWayQueryParamProcessor());
	}
}
