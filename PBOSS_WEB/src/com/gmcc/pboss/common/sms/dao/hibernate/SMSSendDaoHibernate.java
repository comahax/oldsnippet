package com.gmcc.pboss.common.sms.dao.hibernate;

import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.sms.dao.SMSSendDao;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-2
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class SMSSendDaoHibernate extends BaseDaoHibernate implements SMSSendDao {

	public SMSSendDaoHibernate() {
		super(ChSmsWaitreq.class);
	}

}
