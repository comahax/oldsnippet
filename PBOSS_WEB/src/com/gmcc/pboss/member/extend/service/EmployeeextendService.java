package com.gmcc.pboss.member.extend.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;

public interface EmployeeextendService extends BaseService {

	//¹Ì¶¨ÃÜÂëµÇÂ¼
	public ChPwEmployeeextend find4Login(String id, String password);
}
