/**
* auto-generated code
* Wed Dec 07 09:27:39 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.blacklist.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistVO;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistDAO;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistListVO;

/**
 * <p>Title: BlacklistControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/blacklist/control/BlacklistControlBean"
 name="BlacklistControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BlacklistControlBean extends AbstractControlBean
    implements BlacklistControl {

    public BlacklistVO doCreate(BlacklistVO vo, User user)
        throws Exception {
        try{
			BlacklistDAO dao = (BlacklistDAO) DAOFactory.build(BlacklistDAO.class, user);
            // TODO  set the pk */
            return (BlacklistVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BlacklistVO vo, User user)
        throws Exception {
        try{
			BlacklistDAO dao = (BlacklistDAO) DAOFactory.build(BlacklistDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BlacklistVO doUpdate(BlacklistVO vo, User user)
        throws Exception {
        try{
			BlacklistDAO dao = (BlacklistDAO) DAOFactory.build(BlacklistDAO.class, user);
            return (BlacklistVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BlacklistVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BlacklistDAO dao = (BlacklistDAO) DAOFactory.build(BlacklistDAO.class, user);
        return (BlacklistVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BlacklistListVO params, User user)
        throws Exception {
			BlacklistDAO dao = (BlacklistDAO) DAOFactory.build(BlacklistDAO.class, user);
        return dao.query(params);
    }
}
