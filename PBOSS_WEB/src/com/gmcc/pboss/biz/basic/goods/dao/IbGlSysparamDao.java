package com.gmcc.pboss.biz.basic.goods.dao;

import com.gmcc.pboss.common.dao.BaseDao;

public interface IbGlSysparamDao extends BaseDao {
	/**
	 * ��ȡϵͳ����
	 * @param systemid   ϵͳ����id
	 * @param paramType  ϵͳ�������ͣ������ͬ��������
	 * @return   ϵͳ����ֵ���ظ�Action
	 */
	public String getSysValue(long systemid, String paramType);
}
