/**
* auto-generated code
* Wed Nov 25 11:14:06 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogVO;
import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogDAO;
import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogListVO;

/**
 * <p>Title: ExmnitemlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnitemlog/control/ExmnitemlogControlBean"
 name="ExmnitemlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnitemlogControlBean extends AbstractControlBean
    implements ExmnitemlogControl {

    public ExmnitemlogVO doCreate(ExmnitemlogVO vo, User user)
        throws Exception {
        try{
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
            // TODO  set the pk */
            return (ExmnitemlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnitemlogVO vo, User user)
        throws Exception {
        try{
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemlogVO doUpdate(ExmnitemlogVO vo, User user)
        throws Exception {
        try{
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
            return (ExmnitemlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
        return (ExmnitemlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemlogListVO params, User user)
        throws Exception {
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
        return dao.query(params);
    }
}
