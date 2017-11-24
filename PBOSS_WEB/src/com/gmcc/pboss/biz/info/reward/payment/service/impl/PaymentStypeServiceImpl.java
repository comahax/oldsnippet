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
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public PaymentStypeServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARD_CONFIG;
		this.serviceName = "���һ�廯����";
		this.isNeedLogin = true;

		setProcessor(new PaymentStypeQueryParamProcessor());
	}
}
