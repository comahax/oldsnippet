package com.gmcc.pboss.common.businesslog.dao.hibernate;

import com.gmcc.pboss.common.bean.AutoLogBean;
import com.gmcc.pboss.common.businesslog.dao.AutoLogDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class AutoLogDaoHibernate extends BaseDaoHibernate implements AutoLogDao {

	public AutoLogDaoHibernate() {
		super(AutoLogBean.class);
		// TODO Auto-generated constructor stub
	}
	
	public void setLogClass(Class persistentClass){
		this.setPersistentClass(persistentClass);
	}
}
