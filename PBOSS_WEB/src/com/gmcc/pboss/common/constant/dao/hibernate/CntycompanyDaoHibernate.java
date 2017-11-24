package com.gmcc.pboss.common.constant.dao.hibernate;


import com.gmcc.pboss.common.constant.dao.ConstantDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.constant.ChPwCntycompany;
import com.gmcc.pboss.model.constant.SaDbDictitem;

public class CntycompanyDaoHibernate extends BaseDaoHibernate implements ConstantDao {
	public CntycompanyDaoHibernate() {
		super(ChPwCntycompany.class);
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate#getAll()
	 */
}
