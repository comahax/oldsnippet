package com.gmcc.pboss.biz.info.reward.payment.dao.other.hibernate;

import com.gmcc.pboss.biz.info.reward.payment.dao.other.PaymentWayDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChPwWay;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class PaymentWayDaoHibernate extends BaseDaoHibernate implements
		PaymentWayDao {

	public PaymentWayDaoHibernate() {
		// …Ë÷√÷˜±Ì
		super(ChPwWay.class);
	}
}
