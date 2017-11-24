package com.sunrise.boss.business.fee.hangbill.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.hangbill.control.UnwoffcustControl;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.hangbill.persistent.*;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/hangbill/control/UnwoffcustControlBean"
*    name="UnwoffcustControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class UnwoffcustControlBean extends AbstractControlBean implements UnwoffcustControl {
    public UnwoffcustVO doCreate(UnwoffcustVO vo, User user) throws Exception {
		try {
			UnwoffcustDAO dao = (UnwoffcustDAO) DAOFactory.build(UnwoffcustDAO.class,user.getCityid());
			// TODO set the pk */
			return (UnwoffcustVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

    public void doRemove(UnwoffcustVO vo, User user) throws Exception {
		try {
			UnwoffcustDAO dao = (UnwoffcustDAO) DAOFactory.build(UnwoffcustDAO.class,user.getCityid());
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
    
    
    public UnwoffcustVO doUpdate(UnwoffcustVO vo, User user) throws Exception {
		try {
			UnwoffcustDAO dao = (UnwoffcustDAO) DAOFactory.build(UnwoffcustDAO.class,user.getCityid());
			return (UnwoffcustVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
    
    public UnwoffcustVO doFindByPk(Serializable pk, User user) throws Exception {
    	UnwoffcustDAO dao = (UnwoffcustDAO) DAOFactory.build(UnwoffcustDAO.class,user.getCityid());
		return (UnwoffcustVO) dao.findByPk(pk);
	}
    
    public DataPackage doQuery(UnwoffcustListVO params, User user)
		throws Exception {
    	UnwoffcustDAO dao = (UnwoffcustDAO) DAOFactory.build(UnwoffcustDAO.class,user.getCityid());
    	return dao.getWoffCustByCallno(params);
    }
}
