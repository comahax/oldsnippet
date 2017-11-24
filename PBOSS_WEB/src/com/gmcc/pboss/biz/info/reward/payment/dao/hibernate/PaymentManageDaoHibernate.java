package com.gmcc.pboss.biz.info.reward.payment.dao.hibernate;

import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentManageDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwPayment;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class PaymentManageDaoHibernate extends BaseHqlQueryDao implements
		PaymentManageDao {
	public PaymentManageDaoHibernate() {
		super(ChCwPayment.class);
	}
}
