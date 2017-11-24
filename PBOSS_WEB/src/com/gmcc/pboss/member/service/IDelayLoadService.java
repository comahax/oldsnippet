package com.gmcc.pboss.member.service;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.member.model.Employee;

public interface IDelayLoadService extends BaseService {
	/**
	 * 根据用户Id查询用户
	 * @param id 人员Id
	 * @return
	 */
	public Employee getById(String id);
	
	public LoginMember fillMember(LoginMember member);
}
