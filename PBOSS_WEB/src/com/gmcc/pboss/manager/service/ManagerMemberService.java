package com.gmcc.pboss.manager.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.bean.Channel;

public interface ManagerMemberService extends BaseService {
	//店员详细信息查询时，获取店员所属渠道信息
	public Channel getEmployeeChannel(String emp_wayid,long emp_isnet);
}
