/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billinglog.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDAO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogListVO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author Hanny Yeung,mys
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/billing/billinglog/control/BillingLogControlBean"
*    name="BillingLogControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class BillingLogControlBean extends AbstractControlBean implements
		BillingLogControl {

	public BillingLogVO doCreate(BillingLogVO vo, User user) throws Exception {
		try {
			BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
					BillingLogDAO.class, user.getCityid());
			return (BillingLogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BillingLogVO vo, User user) throws Exception {
		try {
			BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
					BillingLogDAO.class, user.getCityid());
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BillingLogVO doUpdate(BillingLogVO vo, User user) throws Exception {
		try {
			BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
					BillingLogDAO.class, user.getCityid());
			return (BillingLogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BillingLogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
				BillingLogDAO.class, user.getCityid());
		return (BillingLogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BillingLogListVO params, User user)
			throws Exception {
		BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(
				BillingLogDAO.class, user.getCityid());
		return dao.query(params);
	}

}
