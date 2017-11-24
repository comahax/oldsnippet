package com.gmcc.pboss.member.extend.dao.hibernate;

import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.member.extend.dao.EmployeeextendDao;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;

public class EmployeeextendDaoHibernate extends BaseDaoHibernate implements
		EmployeeextendDao {
	
	public EmployeeextendDaoHibernate(){
		super(ChPwEmployeeextend.class);
	}

	public ChPwEmployeeextend find4Login(String id, String password) {
		// TODO Auto-generated method stub
		String[] propertyNames = {"employeeId","password"};
		Object[] obj = {id, password};
		return (ChPwEmployeeextend)this.getOne(propertyNames, obj);
	}

}
