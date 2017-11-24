/**
* auto-generated code
* Mon Jan 14 14:13:06 CST 2013
*/
package com.sunrise.boss.business.cms.chadtsales.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesVO;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesDAO;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesListVO;

/**
 * <p>Title: ChAdtSalesControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtsales/control/ChAdtSalesControlBean"
 name="ChAdtSalesControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtSalesControlBean extends AbstractControlBean
    implements ChAdtSalesControl {

    public ChAdtSalesVO doCreate(ChAdtSalesVO vo, User user)
        throws Exception {
        try{
			ChAdtSalesDAO dao = (ChAdtSalesDAO) DAOFactory.build(ChAdtSalesDAO.class, user);
            // TODO  set the pk */
            return (ChAdtSalesVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtSalesVO vo, User user)
        throws Exception {
        try{
			ChAdtSalesDAO dao = (ChAdtSalesDAO) DAOFactory.build(ChAdtSalesDAO.class, user) ;
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtSalesVO doUpdate(ChAdtSalesVO vo, User user)
        throws Exception {
        try{
			ChAdtSalesDAO dao = (ChAdtSalesDAO) DAOFactory.build(ChAdtSalesDAO.class, user);
            return (ChAdtSalesVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtSalesVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtSalesDAO dao = (ChAdtSalesDAO) DAOFactory.build(ChAdtSalesDAO.class, user);
        return (ChAdtSalesVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtSalesListVO params, User user)
        throws Exception {
			ChAdtSalesDAO dao = (ChAdtSalesDAO) DAOFactory.build(ChAdtSalesDAO.class, user);
        return dao.query(params);
    }
}
