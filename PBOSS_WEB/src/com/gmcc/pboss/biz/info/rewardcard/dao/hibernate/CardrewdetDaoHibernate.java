package com.gmcc.pboss.biz.info.rewardcard.dao.hibernate;

import java.math.BigDecimal;

import org.hibernate.SQLQuery;

import com.gmcc.pboss.biz.info.rewardcard.dao.CardrewdetDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.model.reward.ChAdtCardrewdet;

public class CardrewdetDaoHibernate extends BaseHqlQueryDao implements
		CardrewdetDao {
	
	public CardrewdetDaoHibernate(){
		super(ChAdtCardrewdet.class);
	}
}
