package com.gmcc.pboss.biz.basic.goods.dao;

import com.gmcc.pboss.common.dao.BaseDao;

public interface IbGlSysparamDao extends BaseDao {
	/**
	 * 提取系统参数
	 * @param systemid   系统参数id
	 * @param paramType  系统参数类型，此两项共同构成主键
	 * @return   系统参数值返回给Action
	 */
	public String getSysValue(long systemid, String paramType);
}
