package com.gmcc.pboss.biz.info.reward.payment.service.impl;

import com.gmcc.pboss.biz.info.reward.payment.dao.other.PaymentStypeDao;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentStypeService;
import com.gmcc.pboss.biz.info.reward.payment.support.processor.PaymentStypeQueryParamProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class PaymentStypeServiceImpl extends QueryBaseServiceImpl implements
		PaymentStypeService {

	private PaymentStypeDao paymentStypeDao;

	public PaymentStypeDao getPaymentStypeDao() {
		return paymentStypeDao;
	}

	public void setPaymentStypeDao(PaymentStypeDao paymentStypeDao) {
		this.paymentStypeDao = paymentStypeDao;
	}

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public PaymentStypeServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARD_CONFIG;
		this.serviceName = "酬金一体化配置";
		this.isNeedLogin = true;

		setProcessor(new PaymentStypeQueryParamProcessor());
	}
}
