package com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * ҵ������ѯ��֧�ֻ���
 * 
 */
public interface OperationService extends BaseService, CacheService {

	/**
	 * ͨ��ҵ�����ӻ�����ȡ��ҵ�����Ʒ���
	 * 
	 * @param opnId ҵ�����
	 * @return ҵ������
	 */
	public String getOperationName(String opnId);

}
