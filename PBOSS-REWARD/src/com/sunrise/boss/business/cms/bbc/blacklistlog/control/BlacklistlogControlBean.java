/**
* auto-generated code
* Wed Dec 07 09:31:25 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.blacklistlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogVO;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogDAO;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogListVO;

/**
 * <p>Title: BlacklistlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/blacklistlog/control/BlacklistlogControlBean"
 name="BlacklistlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BlacklistlogControlBean extends AbstractControlBean
    implements BlacklistlogControl {

    public BlacklistlogVO doCreate(BlacklistlogVO vo, User user)
        throws Exception {
        try{
			BlacklistlogDAO dao = (BlacklistlogDAO) DAOFactory.build(BlacklistlogDAO.class, user);
            // TODO  set the pk */
            return (BlacklistlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BlacklistlogVO vo, User user)
        throws Exception {
        try{
			BlacklistlogDAO dao = (BlacklistlogDAO) DAOFactory.build(BlacklistlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BlacklistlogVO doUpdate(BlacklistlogVO vo, User user)
        throws Exception {
        try{
			BlacklistlogDAO dao = (BlacklistlogDAO) DAOFactory.build(BlacklistlogDAO.class, user);
            return (BlacklistlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BlacklistlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BlacklistlogDAO dao = (BlacklistlogDAO) DAOFactory.build(BlacklistlogDAO.class, user);
        return (BlacklistlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BlacklistlogListVO params, User user)
        throws Exception {
			BlacklistlogDAO dao = (BlacklistlogDAO) DAOFactory.build(BlacklistlogDAO.class, user);
        return dao.query(params);
    }
}
