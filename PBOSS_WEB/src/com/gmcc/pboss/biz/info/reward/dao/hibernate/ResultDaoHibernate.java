package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import com.gmcc.pboss.biz.info.reward.dao.ResultDao;
import com.gmcc.pboss.biz.info.reward.model.Result;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class ResultDaoHibernate extends BaseDaoHibernate implements ResultDao {

	public ResultDaoHibernate() {
		super(Result.class);
	}

}
