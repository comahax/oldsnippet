package com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.dao.hibernate;

import com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.dao.UnvrcfaildayDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.reward.unvrcfailday.ChBbcUnvrcfailday;

public class UnvrcfaildayDaoHibernate extends BaseHqlQueryDao implements
		UnvrcfaildayDao {
	public UnvrcfaildayDaoHibernate(){
		super(ChBbcUnvrcfailday.class);
	}

}
