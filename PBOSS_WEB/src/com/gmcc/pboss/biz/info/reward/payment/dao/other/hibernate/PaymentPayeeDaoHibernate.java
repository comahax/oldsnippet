package com.gmcc.pboss.biz.info.reward.payment.dao.other.hibernate;

import com.gmcc.pboss.biz.info.reward.payment.dao.other.PaymentPayeeDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwPayway;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class PaymentPayeeDaoHibernate extends BaseDaoHibernate implements
		PaymentPayeeDao {

	public PaymentPayeeDaoHibernate() {
		// …Ë÷√÷˜±Ì
		super(ChCwPayway.class);
	}
}
