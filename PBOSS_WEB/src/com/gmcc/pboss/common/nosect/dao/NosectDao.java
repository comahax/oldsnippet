package com.gmcc.pboss.common.nosect.dao;

import com.gmcc.pboss.common.dao.BaseDao;

/**
 * 从兴公司营账研发部
 * @author yuwenjun
 * @date 2010-3-1
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：手机号码归属地查询
 */
public interface NosectDao extends BaseDao {
	/**
	 * 通过手机号码查询归属地
	 * @param mobileNo
	 */
	public String getCityByNo(String mobileNo);
}
