package com.gmcc.pboss.biz.basic.node.dao;

import com.gmcc.pboss.common.dao.BaseDao;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-28
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������˲��趨��
 */
public interface ChPwFlownameDao extends BaseDao{
	/**
	 * ���ݲ���ID��ѯ����
	 * @param stepID ����ID
	 * @return
	 */
	public String getOprcodeByStepID(String stepID);
}
