package com.gmcc.pboss.biz.info.reward.payment.dao.other.hibernate;

import com.gmcc.pboss.biz.info.reward.payment.dao.other.PaymentStypeDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwStype;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class PaymentStypeDaoHibernate extends BaseDaoHibernate implements
		PaymentStypeDao {

	public PaymentStypeDaoHibernate() {
		super(ChCwStype.class);
	}
}
