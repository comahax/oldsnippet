package com.gmcc.pboss.biz.info.salesDetail.service;

import java.util.List;
import java.util.Map;
import com.gmcc.pboss.common.service.BaseService;

public interface OperationsmsService extends BaseService {
	/**
	 * ��ȡ����ҵ������б�
	 */
	public Map getOpnInfo(String cityid);
	
	/**
	 * ��ȡ����ҵ������б�
	 */
	public List getOperationsms(String cityid);
}
