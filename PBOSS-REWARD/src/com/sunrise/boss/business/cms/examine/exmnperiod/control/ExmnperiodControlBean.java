/**
* auto-generated code
* Tue Nov 24 10:54:37 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnperiod.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodDAO;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodListVO;

/**
 * <p>Title: ExmnperiodControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnperiod/control/ExmnperiodControlBean"
 name="ExmnperiodControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnperiodControlBean extends AbstractControlBean
    implements ExmnperiodControl {

    public ExmnperiodVO doCreate(ExmnperiodVO vo, User user)
        throws Exception {
        try{
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
            // TODO  set the pk */
            return (ExmnperiodVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnperiodVO vo, User user)
        throws Exception {
        try{
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnperiodVO doUpdate(ExmnperiodVO vo, User user)
        throws Exception {
        try{
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
            return (ExmnperiodVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnperiodVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
        return (ExmnperiodVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnperiodListVO params, User user)
        throws Exception {
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
        return dao.query(params);
    }
    public boolean doCheckBeingPeriod(ExmnperiodVO vo, User user)
    throws Exception{
    	ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
        return dao.doCheckBeingPeriod(vo, user);
    }
}
