package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.dao.OperationDao;
import com.gmcc.pboss.biz.info.reward.model.BbcOperation;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class BbcOperationDaoHibernate extends BaseDaoHibernate implements OperationDao {

	public BbcOperationDaoHibernate() {
		super(BbcOperation.class);
	}

	public List getAll() {
		Criteria criteria = getSession().createCriteria(BbcOperation.class);
		criteria.add(Restrictions.eq("isbusi", Boolean.TRUE));
		return criteria.list();
	}

}
