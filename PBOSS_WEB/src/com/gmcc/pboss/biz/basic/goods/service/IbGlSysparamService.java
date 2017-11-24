package com.gmcc.pboss.biz.basic.goods.service;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * 业务代码查询并支持缓存
 * 
 */
public interface IbGlSysparamService extends BaseService {
	
	//提取是否提供资源明细查看 1-是，0-否
	public String getIsQuery(LoginMember member);
	
	/**
	 * 提取系统参数
	 * @param systemid   系统参数id
	 * @param paramType  系统参数类型，此两项共同构成主键
	 * @return   系统参数值返回给Action
	 */
	public String getSysValue(long systemid, String paramType);
	
}
