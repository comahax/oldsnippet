package com.gmcc.pboss.biz.basic.node.dao.hibernate;

import com.gmcc.pboss.biz.basic.node.dao.ChPwAdvinfoDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-28
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class ChPwAdvinfoDaoHibernate extends BaseDaoHibernate implements
	ChPwAdvinfoDao {

	public ChPwAdvinfoDaoHibernate() {
		super(ChPwAdvinfo.class);
		// TODO Auto-generated constructor stub
	}
	
}
