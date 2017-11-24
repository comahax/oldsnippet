package com.gmcc.pboss.common.sms.dao.hibernate;

import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.sms.dao.SMSSendDao;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-2
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class SMSSendDaoHibernate extends BaseDaoHibernate implements SMSSendDao {

	public SMSSendDaoHibernate() {
		super(ChSmsWaitreq.class);
	}

}
