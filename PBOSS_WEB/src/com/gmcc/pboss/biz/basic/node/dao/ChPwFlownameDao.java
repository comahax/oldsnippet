package com.gmcc.pboss.biz.basic.node.dao;

import com.gmcc.pboss.common.dao.BaseDao;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-28
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：审核步骤定义
 */
public interface ChPwFlownameDao extends BaseDao{
	/**
	 * 根据步骤ID查询工号
	 * @param stepID 步骤ID
	 * @return
	 */
	public String getOprcodeByStepID(String stepID);
}
