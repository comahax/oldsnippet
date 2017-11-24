/**
* auto-generated code
* Sat Nov 28 17:58:40 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnauditlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogDAO;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogListVO;

/**
 * <p>Title: ExmnauditlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnauditlog/control/ExmnauditlogControlBean"
 name="ExmnauditlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnauditlogControlBean extends AbstractControlBean
    implements ExmnauditlogControl {

    public ExmnauditlogVO doCreate(ExmnauditlogVO vo, User user)
        throws Exception {
        try{
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
            // TODO  set the pk */
            return (ExmnauditlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnauditlogVO vo, User user)
        throws Exception {
        try{
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnauditlogVO doUpdate(ExmnauditlogVO vo, User user)
        throws Exception {
        try{
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
            return (ExmnauditlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnauditlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
        return (ExmnauditlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnauditlogListVO params, User user)
        throws Exception {
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
        return dao.query(params);
    }
}
