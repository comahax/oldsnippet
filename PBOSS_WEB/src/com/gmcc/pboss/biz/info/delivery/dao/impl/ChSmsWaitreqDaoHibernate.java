package com.gmcc.pboss.biz.info.delivery.dao.impl;

import com.gmcc.pboss.biz.info.delivery.dao.ChSmsWaitreqDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;

public class ChSmsWaitreqDaoHibernate extends BaseDaoHibernate implements ChSmsWaitreqDao {

	public ChSmsWaitreqDaoHibernate() {
		super(ChSmsWaitreq.class);
	}
}

