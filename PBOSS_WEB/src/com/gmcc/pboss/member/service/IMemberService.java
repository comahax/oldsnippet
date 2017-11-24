package com.gmcc.pboss.member.service;

import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.member.model.Employee;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-29
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public interface IMemberService extends BaseService {

	/**
	 * 根据用户Id查询用户
	 * @param id 人员Id
	 * @return
	 */
	public Employee getById(String id);
	/**
	 * 根据用户wayId查询用户的渠道信息
	 * @return
	 */
	public Channel getByWayId(String wayId);
}
