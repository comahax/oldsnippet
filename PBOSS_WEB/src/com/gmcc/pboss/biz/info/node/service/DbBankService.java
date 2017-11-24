package com.gmcc.pboss.biz.info.node.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * 卡类购销划扣银行标识查询并支持缓存
 * 
 */
public interface DbBankService extends BaseService, CacheService {

	/**
	 * 从缓存中取得业务名称返回
	 * 
	 * @param opnId 代码
	 * @return 名称
	 */
	public String getNameByCode(String opnId);

	/**
	 * 从缓存中取得业务的类型
	 * 
	 * @param opnId 代码
	 * @return 类型
	 */
	public String getTypeByCode(String opnId);

}
