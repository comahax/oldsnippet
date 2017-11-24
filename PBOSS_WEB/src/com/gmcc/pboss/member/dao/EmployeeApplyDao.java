package com.gmcc.pboss.member.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;

/**
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2009-10-12
 * ������Ŀ��Pboss
 * ����ģ�飺��Ա����DAO
 * ������
 */
public interface EmployeeApplyDao extends BaseDao {
	
	/**
	 * �����������
	 * @param saveObj - Ҫ����Ķ���
	 * @return
	 */
	public boolean saveApply(ChPwEmployeeapply saveObj);//���������� ��������Ƶ�save��ͷ������
	/**
	 * �����˳�����
	 * @param saveObj - Ҫ����Ķ���
	 * @return
	 */
	public boolean saveQuit(ChPwEmployeeapply saveObj);//���������� ��������Ƶ�save��ͷ������
}
