package com.gmcc.pboss.biz.info.reward.payment.dao.hibernate;

import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentConfiglogDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfiglog;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class PaymentConfiglogDaoHibernate extends BaseDaoHibernate implements
		PaymentConfiglogDao {
	public PaymentConfiglogDaoHibernate() {
		// …Ë÷√÷˜±Ì
		super(ChCwConfiglog.class);
	}

	public boolean saveConfiglog(ChCwConfiglog configlog) {
		boolean flag = false;

		try {
			super.save(configlog);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
