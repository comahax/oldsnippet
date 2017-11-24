package com.gmcc.pboss.biz.info.reward.payment.service.impl;

import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentManageDao;
import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentManagelogDao;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentManageService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentManageQueryParameter;
import com.gmcc.pboss.biz.info.reward.payment.support.processor.PaymentManageQueryParamProcessor;
import com.gmcc.pboss.biz.info.reward.service.RewardServiceRetCode;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

public class PaymentManageServiceImpl extends QueryBaseServiceImpl implements
		PaymentManageService {

	private PaymentManageDao paymentManageDao;

	private PaymentManagelogDao paymentManagelogDao;

	protected static final org.apache.commons.logging.Log logger = LogFactory
			.getLog(PaymentConfigServiceImpl.class);

	public PaymentManageDao getPaymentManageDao() {
		return paymentManageDao;
	}

	public void setPaymentManageDao(PaymentManageDao paymentManageDao) {
		this.paymentManageDao = paymentManageDao;
	}

	public PaymentManagelogDao getPaymentManagelogDao() {
		return paymentManagelogDao;
	}

	public void setPaymentManagelogDao(PaymentManagelogDao paymentManagelogDao) {
		this.paymentManagelogDao = paymentManagelogDao;
	}

	public PaymentManageServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARD_MANAGE;
		this.serviceName = "���һ�廯����";
		this.isNeedLogin = true;

		setProcessor(new PaymentManageQueryParamProcessor());
	}

	/**
	 * �л������п�
	 * 
	 * @param cityid
	 */
	private void changeSessionFactory(String cityid) {
		SessionFactoryContextHolder.setSessionFactoryContext(cityid);
		paymentManagelogDao.reloadSessionFactory();
	}

	public ServiceResult query(QueryParameter parameter) {

		return null;
	}

	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(RewardServiceRetCode.FAIL);
		result.setRetObject(null);

		// ����ҳ����Ϣ
		parameter.setAction(QueryAction.SECTION);

		if (parameter.getNo() < 1) {
			parameter.setNo(1);
		}
		parameter.setSize(20);

		// ���õ�ǰ�ĵ��п�
		String curCityid = ((PaymentManageQueryParameter) parameter)
				.getCityid();
		changeSessionFactory(curCityid);

		QueryParameterProcessor processor = new PaymentManageQueryParamProcessor();
		QueryResult rtn = paymentManageDao.getAllSQL(processor, parameter);

		// ����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setRetObject(null);
		result.setSuccess(true);
		result.setRetCode(RewardServiceRetCode.SUCCESS);
		result.setRetResult(rtn);

		return result;
	}

}
