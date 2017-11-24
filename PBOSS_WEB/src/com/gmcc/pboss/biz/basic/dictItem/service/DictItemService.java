package com.gmcc.pboss.biz.basic.dictItem.service;

import java.util.Map;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * ҵ������ѯ��֧�ֻ���
 * 
 */
public interface DictItemService extends BaseService, CacheService {

	/**
	 * ͨ��ҵ�����ӻ�����ȡ��ҵ�����Ʒ���
	 * 
	 * @param opnId ҵ�����
	 * @return ҵ������
	 */
	public String getNameByCode(String opnId);

	/**
	 * ͨ��ҵ�����ӻ�����ȡ��ҵ�������
	 * 
	 * @param opnId ҵ�����
	 * @return ҵ������
	 */
	public String getTypeByCode(String opnId);

	/**
	 * ͨ��ҵ������ж��Ƿ��׿�
	 * 
	 * @param opnId ҵ�����
	 * @return ���׿�
	 */
	public boolean isComrescard(String opnId);
	
	//��ѯIM_PR_COMCATEGORYRELA����ȡ��Ʒ����-��Դ������
	//key-��Ʒ���࣬value-��Դ�б�
	public Map<String,String> getComcatoAndRestype();
}
