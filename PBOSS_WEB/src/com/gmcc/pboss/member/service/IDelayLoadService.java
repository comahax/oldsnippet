package com.gmcc.pboss.member.service;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.member.model.Employee;

public interface IDelayLoadService extends BaseService {
	/**
	 * �����û�Id��ѯ�û�
	 * @param id ��ԱId
	 * @return
	 */
	public Employee getById(String id);
	
	public LoginMember fillMember(LoginMember member);
}
