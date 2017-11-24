package com.gmcc.pboss.member.extend.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;

public interface EmployeeextendDao extends BaseDao {
	
	//¹Ì¶¨ÃÜÂëµÇÂ½
	public ChPwEmployeeextend find4Login(String id,String password);

}
