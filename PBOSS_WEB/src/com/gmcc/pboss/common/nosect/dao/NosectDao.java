package com.gmcc.pboss.common.nosect.dao;

import com.gmcc.pboss.common.dao.BaseDao;

/**
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2010-3-1
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ֻ���������ز�ѯ
 */
public interface NosectDao extends BaseDao {
	/**
	 * ͨ���ֻ������ѯ������
	 * @param mobileNo
	 */
	public String getCityByNo(String mobileNo);
}
