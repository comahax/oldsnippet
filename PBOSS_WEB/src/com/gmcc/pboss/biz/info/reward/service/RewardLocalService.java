package com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryParameter;

public interface RewardLocalService extends BaseService {
	/**
	 * Ã÷Ï¸²éÑ¯
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult queryDtl(LoginMember member, QueryParameter parameter);

}
