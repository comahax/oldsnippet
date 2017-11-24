package com.gmcc.pboss.biz.info.reward.payment.service.impl;

import com.gmcc.pboss.biz.info.reward.payment.dao.other.PaymentPayeeDao;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentPayeeService;
import com.gmcc.pboss.biz.info.reward.payment.support.processor.PaymentPayeeQueryParamProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class PaymentPayeeServiceImpl extends QueryBaseServiceImpl implements
		PaymentPayeeService {
	private PaymentPayeeDao paymentPayeeDao;

	public PaymentPayeeDao getPaymentPayeeDao() {
		return paymentPayeeDao;
	}

	public void setPaymentPayeeDao(PaymentPayeeDao paymentPayeeDao) {
		this.paymentPayeeDao = paymentPayeeDao;
	}

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public PaymentPayeeServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARD_CONFIG;
		this.serviceName = "酬金一体化配置";
		this.isNeedLogin = true;

		setProcessor(new PaymentPayeeQueryParamProcessor());
	}
}
