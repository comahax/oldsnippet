package com.gmcc.pboss.biz.info.salesRpt.service;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;

public interface OrderTimesService extends BaseService {
	public int[] searchOrderCount(LoginMember member);
}
