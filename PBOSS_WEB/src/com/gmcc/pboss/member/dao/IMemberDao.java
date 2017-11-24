package com.gmcc.pboss.member.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.member.model.Employee;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-7-29
 * ������Ŀ��
 * ����ģ�飺
 * ������
 */
public interface IMemberDao extends BaseDao{
	/**
	 * �����û������ѯ�û�
	 * @param officeTel ���������
	 * @return
	 */
	public Employee getUserByOfficTel(String officeTel);
	public List<Employee> getAllUserByOfficTel(String officeTel);
	public List<Employee> getAllUserByMobile(String mobile);
	
	public Employee getUserByOfftelIsnet(String officeTel,Long isnet);
	
	/**
	 * �����û�Id��ѯ�û�
	 * @param id ��ԱId
	 * @return
	 */
	public Employee getById(String id);
}
