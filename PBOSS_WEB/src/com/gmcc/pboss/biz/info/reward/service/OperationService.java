package com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * 业务代码查询并支持缓存
 * 
 */
public interface OperationService extends BaseService, CacheService {

	/**
	 * 通过业务代码从缓存中取得业务名称返回
	 * 
	 * @param opnId 业务代码
	 * @return 业务名称
	 */
	public String getOperationName(String opnId);

}
