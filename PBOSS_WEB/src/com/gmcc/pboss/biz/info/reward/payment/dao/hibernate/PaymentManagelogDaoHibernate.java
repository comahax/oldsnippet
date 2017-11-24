package com.gmcc.pboss.biz.info.reward.payment.dao.hibernate;

import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentManagelogDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwPaymentlog;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class PaymentManagelogDaoHibernate extends BaseDaoHibernate implements
		PaymentManagelogDao {
	public PaymentManagelogDaoHibernate() {
		// …Ë÷√÷˜±Ì
		super(ChCwPaymentlog.class);
	}
}
