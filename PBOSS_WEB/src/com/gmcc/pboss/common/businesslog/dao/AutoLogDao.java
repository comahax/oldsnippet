package com.gmcc.pboss.common.businesslog.dao;

import com.gmcc.pboss.common.dao.BaseDao;

public interface AutoLogDao extends BaseDao {
	
	/**
	 * ����ע���Log��
	 * @param persistentClass
	 */
	public void setLogClass(Class persistentClass);
}
