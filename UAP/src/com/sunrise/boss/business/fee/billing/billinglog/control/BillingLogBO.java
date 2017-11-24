/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billinglog.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDAO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDBParam;

import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author Hanny Yeung,mys
 * @version 1.0
 */

public class BillingLogBO extends AbstractControlBean implements
		BillingLog {

	public BillingLogVO doCreate(BillingLogVO vo, User user) throws Exception {
		try {
			BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
					BillingLogDAO.class, user.getCityid());
			return (BillingLogVO) dao.create(vo);
		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BillingLogVO vo, User user) throws Exception {
		try {
			BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
					BillingLogDAO.class, user.getCityid());
			dao.remove(vo);
		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BillingLogVO doUpdate(BillingLogVO vo, User user) throws Exception {
		try {
			BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
					BillingLogDAO.class, user.getCityid());
			return (BillingLogVO) dao.update(vo);
		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BillingLogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
				BillingLogDAO.class, user.getCityid());
		return (BillingLogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BillingLogDBParam params, User user)
			throws Exception {
		BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
				BillingLogDAO.class, user.getDbFlag());	
		
		return dao.query(params);
	}

}
