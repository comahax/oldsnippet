package com.gmcc.pboss.biz.basic.dictItem.service;

import java.util.Map;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * 业务代码查询并支持缓存
 * 
 */
public interface DictItemService extends BaseService, CacheService {

	/**
	 * 通过业务代码从缓存中取得业务名称返回
	 * 
	 * @param opnId 业务代码
	 * @return 业务名称
	 */
	public String getNameByCode(String opnId);

	/**
	 * 通过业务代码从缓存中取得业务的类型
	 * 
	 * @param opnId 业务代码
	 * @return 业务类型
	 */
	public String getTypeByCode(String opnId);

	/**
	 * 通过业务代码判断是否套卡
	 * 
	 * @param opnId 业务代码
	 * @return 是套卡
	 */
	public boolean isComrescard(String opnId);
	
	//查询IM_PR_COMCATEGORYRELA表，获取商品种类-资源类别组合
	//key-商品种类，value-资源列别
	public Map<String,String> getComcatoAndRestype();
}
