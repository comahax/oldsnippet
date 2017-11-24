package com.gmcc.pboss.biz.info.node.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * ���๺���������б�ʶ��ѯ��֧�ֻ���
 * 
 */
public interface DbBankService extends BaseService, CacheService {

	/**
	 * �ӻ�����ȡ��ҵ�����Ʒ���
	 * 
	 * @param opnId ����
	 * @return ����
	 */
	public String getNameByCode(String opnId);

	/**
	 * �ӻ�����ȡ��ҵ�������
	 * 
	 * @param opnId ����
	 * @return ����
	 */
	public String getTypeByCode(String opnId);

}
