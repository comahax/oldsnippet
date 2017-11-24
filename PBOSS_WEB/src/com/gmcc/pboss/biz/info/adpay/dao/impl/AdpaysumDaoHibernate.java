package com.gmcc.pboss.biz.info.adpay.dao.impl;

import com.gmcc.pboss.biz.info.adpay.dao.AdpaysumDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.adpay.FxSwAdpaysum;

public class AdpaysumDaoHibernate extends BaseDaoHibernate implements AdpaysumDao {

	public AdpaysumDaoHibernate() {
		super(FxSwAdpaysum.class);
	}
}

