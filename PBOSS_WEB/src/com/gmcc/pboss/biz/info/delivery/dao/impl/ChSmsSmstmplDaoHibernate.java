package com.gmcc.pboss.biz.info.delivery.dao.impl;

import com.gmcc.pboss.biz.info.delivery.dao.ChSmsSmstmplDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sms.ChSmsSmstmpl;

public class ChSmsSmstmplDaoHibernate extends BaseDaoHibernate implements ChSmsSmstmplDao {

	public ChSmsSmstmplDaoHibernate() {
		super(ChSmsSmstmpl.class);
	}
}

