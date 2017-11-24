package com.gmcc.pboss.biz.info.reward.payment.service.impl;

import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentConfigDao;
import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentConfiglogDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfiglog;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentConfigService;
import com.gmcc.pboss.biz.info.reward.payment.support.processor.PaymentConfigQueryParamProcessor;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

public class PaymentConfigServiceImpl extends QueryBaseServiceImpl implements
		PaymentConfigService {
	private PaymentConfigDao paymentConfigDao;

	private PaymentConfiglogDao paymentConfiglogDao;

	public PaymentConfigDao getPaymentConfigDao() {
		return paymentConfigDao;
	}

	public void setPaymentConfigDao(PaymentConfigDao paymentConfigDao) {
		this.paymentConfigDao = paymentConfigDao;
	}

	public PaymentConfiglogDao getPaymentConfiglogDao() {
		return paymentConfiglogDao;
	}

	public void setPaymentConfiglogDao(PaymentConfiglogDao paymentConfiglogDao) {
		this.paymentConfiglogDao = paymentConfiglogDao;
	}

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public PaymentConfigServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARD_CONFIG;
		this.serviceName = "酬金一体化配置";
		this.isNeedLogin = true;

		setProcessor(new PaymentConfigQueryParamProcessor());
	}

	public ChCwConfig getConfigByQuery(String key) {
		return paymentConfigDao.getConfigByQuery(key);
	}

	public ChCwConfig getConfigBySql(String key) {
		return paymentConfigDao.getConfigBySql(key);
	}

	public ChCwConfig getConfigByCriteria(String key) {
		return paymentConfigDao.getConfigByCriteria(key);
	}

	public boolean updateConfig(ChCwConfig config) {
		return paymentConfigDao.updateConfig(config);
	}
	
	public boolean saveConfiglog(ChCwConfiglog configlog) {
		return paymentConfiglogDao.saveConfiglog(configlog);
	}

}
