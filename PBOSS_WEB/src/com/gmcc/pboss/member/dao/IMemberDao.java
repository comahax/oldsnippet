package com.gmcc.pboss.member.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.member.model.Employee;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-29
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public interface IMemberDao extends BaseDao{
	/**
	 * 根据用户号码查询用户
	 * @param officeTel 公务机号码
	 * @return
	 */
	public Employee getUserByOfficTel(String officeTel);
	public List<Employee> getAllUserByOfficTel(String officeTel);
	public List<Employee> getAllUserByMobile(String mobile);
	
	public Employee getUserByOfftelIsnet(String officeTel,Long isnet);
	
	/**
	 * 根据用户Id查询用户
	 * @param id 人员Id
	 * @return
	 */
	public Employee getById(String id);
}
