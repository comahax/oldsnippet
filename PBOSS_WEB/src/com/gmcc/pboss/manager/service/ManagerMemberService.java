package com.gmcc.pboss.manager.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.bean.Channel;

public interface ManagerMemberService extends BaseService {
	//��Ա��ϸ��Ϣ��ѯʱ����ȡ��Ա����������Ϣ
	public Channel getEmployeeChannel(String emp_wayid,long emp_isnet);
}
