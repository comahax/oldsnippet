/**
* auto-generated code
* Wed Nov 25 11:17:17 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemdtllog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogDAO;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogListVO;

/**
 * <p>Title: ExmnitemdtllogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnitemdtllog/control/ExmnitemdtllogControlBean"
 name="ExmnitemdtllogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnitemdtllogControlBean extends AbstractControlBean
    implements ExmnitemdtllogControl {

    public ExmnitemdtllogVO doCreate(ExmnitemdtllogVO vo, User user)
        throws Exception {
        try{
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
            // TODO  set the pk */
            return (ExmnitemdtllogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnitemdtllogVO vo, User user)
        throws Exception {
        try{
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemdtllogVO doUpdate(ExmnitemdtllogVO vo, User user)
        throws Exception {
        try{
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
            return (ExmnitemdtllogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemdtllogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
        return (ExmnitemdtllogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemdtllogListVO params, User user)
        throws Exception {
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
        return dao.query(params);
    }
}
