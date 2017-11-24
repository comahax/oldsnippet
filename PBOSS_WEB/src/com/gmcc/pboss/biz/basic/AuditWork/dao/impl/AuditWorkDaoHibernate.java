package com.gmcc.pboss.biz.basic.AuditWork.dao.impl;


import com.gmcc.pboss.biz.basic.AuditWork.dao.AuditWorkDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;

public class AuditWorkDaoHibernate extends BaseDaoHibernate implements AuditWorkDao {

	public AuditWorkDaoHibernate() {
		super(ChPwAuditwork.class);
	}
}
