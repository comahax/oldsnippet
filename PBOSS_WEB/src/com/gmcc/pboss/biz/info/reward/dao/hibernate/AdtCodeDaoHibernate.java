package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import com.gmcc.pboss.biz.info.reward.dao.AdtCodeDao;
import com.gmcc.pboss.biz.info.reward.model.AdtCode;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class AdtCodeDaoHibernate extends BaseDaoHibernate implements AdtCodeDao {

	public AdtCodeDaoHibernate() {
		super(AdtCode.class);
	}

}
