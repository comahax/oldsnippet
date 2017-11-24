package com.gmcc.pboss.biz.info.salesDetail.service;

import java.util.List;
import java.util.Map;
import com.gmcc.pboss.common.service.BaseService;

public interface OperationsmsService extends BaseService {
	/**
	 * 获取短信业务编码列表
	 */
	public Map getOpnInfo(String cityid);
	
	/**
	 * 获取短信业务编码列表
	 */
	public List getOperationsms(String cityid);
}
