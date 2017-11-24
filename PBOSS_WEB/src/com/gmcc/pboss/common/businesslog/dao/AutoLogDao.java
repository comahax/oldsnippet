package com.gmcc.pboss.common.businesslog.dao;

import com.gmcc.pboss.common.dao.BaseDao;

public interface AutoLogDao extends BaseDao {
	
	/**
	 * 设置注入的Log类
	 * @param persistentClass
	 */
	public void setLogClass(Class persistentClass);
}
