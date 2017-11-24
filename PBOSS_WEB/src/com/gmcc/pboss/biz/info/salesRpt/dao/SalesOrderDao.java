package com.gmcc.pboss.biz.info.salesRpt.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sales.FxSwOrder;

public interface SalesOrderDao extends BaseDao {
	/**
	 * ��ȡ�����Ѿ��ύ���������������û�ȡ���Ķ���
	 * Ĭ��ʱ�������ǲ�ѯ�������£�ͨ����ȡϵͳʱ��ʵ��
	 * ��ͳ��CANCEL�Ķ���
	 * @param code  �����̱���
	 * @return ������Ч������Ŀ
	 */
	public int getNumbers(String code);
	
	/**
	 * ����ORDERID��ȡ����
	 * @param ����ID
	 * @return 
	 */
	public FxSwOrder getById(String orderid);
}
