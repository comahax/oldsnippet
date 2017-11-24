/**
 * 
 */
package com.sunrise.boss.business.cms.audit.recfeeadjustrsn.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent.RecFeeAdjustRsnDAO;
import com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent.RecFeeAdjustRsnListVO;
import com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent.RecFeeAdjustRsnVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/audit/recfeeadjustrsn/control/RecFeeAdjustRsnControlBean"
*    name="RecFeeAdjustRsnControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RecFeeAdjustRsnControlBean extends AbstractControlBean implements
		RecFeeAdjustRsnControl {

	public RecFeeAdjustRsnVO doCreate(RecFeeAdjustRsnVO vo, User user)
			throws Exception {
		try {
			RecFeeAdjustRsnDAO dao = (RecFeeAdjustRsnDAO) DAOFactory.build(
					RecFeeAdjustRsnDAO.class, user );
			return (RecFeeAdjustRsnVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(RecFeeAdjustRsnVO vo, User user) throws Exception {
		try {
			RecFeeAdjustRsnDAO dao = (RecFeeAdjustRsnDAO) DAOFactory.build(
					RecFeeAdjustRsnDAO.class, user );
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RecFeeAdjustRsnVO doUpdate(RecFeeAdjustRsnVO vo, User user)
			throws Exception {
		try {
			RecFeeAdjustRsnDAO dao = (RecFeeAdjustRsnDAO) DAOFactory.build(
					RecFeeAdjustRsnDAO.class, user );
			return (RecFeeAdjustRsnVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RecFeeAdjustRsnVO doFindByPk(Serializable pk, User user)
			throws Exception {
		RecFeeAdjustRsnDAO dao = (RecFeeAdjustRsnDAO) DAOFactory.build(
				RecFeeAdjustRsnDAO.class, user );
		return (RecFeeAdjustRsnVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RecFeeAdjustRsnListVO params, User user)
			throws Exception {
		RecFeeAdjustRsnDAO dao = (RecFeeAdjustRsnDAO) DAOFactory.build(
				RecFeeAdjustRsnDAO.class, user );
		return dao.query(params);
	}

}
