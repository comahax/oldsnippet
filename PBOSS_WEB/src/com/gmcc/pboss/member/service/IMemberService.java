package com.gmcc.pboss.member.service;

import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.member.model.Employee;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-7-29
 * ������Ŀ��
 * ����ģ�飺
 * ������
 */
public interface IMemberService extends BaseService {

	/**
	 * �����û�Id��ѯ�û�
	 * @param id ��ԱId
	 * @return
	 */
	public Employee getById(String id);
	/**
	 * �����û�wayId��ѯ�û���������Ϣ
	 * @return
	 */
	public Channel getByWayId(String wayId);
}
