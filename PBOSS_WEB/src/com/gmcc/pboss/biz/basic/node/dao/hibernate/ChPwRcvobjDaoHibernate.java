package com.gmcc.pboss.biz.basic.node.dao.hibernate;

import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.communi.ChPwRcvobj;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-28
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class ChPwRcvobjDaoHibernate extends BaseHqlQueryDao implements
		ChPwRcvobjDao {

	public ChPwRcvobjDaoHibernate() {
		super(ChPwRcvobj.class);
		// TODO Auto-generated constructor stub
	}

}
