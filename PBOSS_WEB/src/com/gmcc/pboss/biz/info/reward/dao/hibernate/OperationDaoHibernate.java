package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.dao.OperationDao;
import com.gmcc.pboss.biz.info.reward.model.Operation;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class OperationDaoHibernate extends BaseDaoHibernate implements OperationDao {

	public OperationDaoHibernate() {
		super(Operation.class);
	}

	public List getAll() {
		Criteria criteria = getSession().createCriteria(Operation.class);
		criteria.add(Restrictions.eq("isbusi", Boolean.TRUE));
		return criteria.list();
	}

}
