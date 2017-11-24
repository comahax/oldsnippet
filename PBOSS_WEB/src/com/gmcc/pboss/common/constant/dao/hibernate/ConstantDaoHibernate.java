package com.gmcc.pboss.common.constant.dao.hibernate;


import com.gmcc.pboss.common.constant.dao.ConstantDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.constant.SaDbDictitem;

public class ConstantDaoHibernate extends BaseDaoHibernate implements ConstantDao {
	public ConstantDaoHibernate() {
		super(SaDbDictitem.class);
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate#getAll()
	 */
}
