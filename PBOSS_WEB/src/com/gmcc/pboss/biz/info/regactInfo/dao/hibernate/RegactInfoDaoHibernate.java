package com.gmcc.pboss.biz.info.regactInfo.dao.hibernate;


import com.gmcc.pboss.biz.info.regactInfo.dao.RegactInfoDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.sales.FxSwPartnerres;

public class RegactInfoDaoHibernate extends BaseHqlQueryDao implements RegactInfoDao {

	public RegactInfoDaoHibernate() {
		//…Ë÷√÷˜±Ì
		super(FxSwPartnerres.class);
	}
}

