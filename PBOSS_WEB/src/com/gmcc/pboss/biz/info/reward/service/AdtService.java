package com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * 酬金校验失败查询信息的 失败原因 缓存
 * 
 */
public interface AdtService extends CacheService {

	public String getRemark(String code);

}
