/**
 * 
 */
package com.sunrise.boss.business.fee.billing.validbillcyc.control;

import java.io.Serializable;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.OperAction;
import com.sunrise.boss.business.common.managelog.persistent.OperState;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDAO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycListVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
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
*    local-jndi-name="com/sunrise/boss/business/fee/billing/validbillcyc/control/ValidBillCycControlBean"
*    name="ValidBillCycControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ValidBillCycControlBean extends AbstractControlBean implements
		ValidBillCycControl {

	public ValidBillCycVO doCreate(ValidBillCycVO vo, User user)
			throws Exception {
		try {
			ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(ValidBillCycDAO.class, user.getCityid());
			
			ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid()); 			
			mdao.manageLog(user, vo.getClass().getName(), OperAction.INSERT, null,vo, OperState.SUCCESS);  
			
			return (ValidBillCycVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(ValidBillCycVO vo, User user) throws Exception {
		try {
			ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(ValidBillCycDAO.class, user.getCityid());
			
			ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid()); 			
			mdao.manageLog(user, vo.getClass().getName(), OperAction.DELETE, null,vo, OperState.SUCCESS);
			
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ValidBillCycVO doUpdate(ValidBillCycVO vo, User user)
			throws Exception {
		try {
			ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(ValidBillCycDAO.class, user.getCityid());
			
			ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid()); 			
			mdao.manageLog(user, vo.getClass().getName(), OperAction.UPDATE, null,vo, OperState.SUCCESS); 
			
			return (ValidBillCycVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ValidBillCycVO doFindByPk(Serializable pk, User user)
			throws Exception {
		ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(
				ValidBillCycDAO.class, user.getCityid());
		return (ValidBillCycVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ValidBillCycListVO params, User user)
			throws Exception {
		ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(
				ValidBillCycDAO.class, user.getCityid());
		return dao.query(params);
	}

}
