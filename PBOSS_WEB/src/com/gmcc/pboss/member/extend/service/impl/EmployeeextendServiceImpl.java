package com.gmcc.pboss.member.extend.service.impl;

import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;
import com.gmcc.pboss.member.extend.service.EmployeeextendService;
import com.gmcc.pboss.member.extend.dao.EmployeeextendDao;

public class EmployeeextendServiceImpl extends BaseServiceImpl implements
		EmployeeextendService {
	
	private EmployeeextendDao employeeextendDao;
	public void setEmployeeextendDao(EmployeeextendDao employeeextendDao){
		this.employeeextendDao = employeeextendDao;
	}

	public ChPwEmployeeextend find4Login(String id, String password) {
		// TODO Auto-generated method stub
		return this.employeeextendDao.find4Login(id, password);
	}

}
