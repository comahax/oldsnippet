/**
* auto-generated code
* Tue Sep 03 21:23:23 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdsubscription.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionDAO;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionListVO;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionVO;

/**
 * <p>Title: ChPdSubscriptionControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/proagent/chpdsubscription/control/ChPdSubscriptionControlBean"
 name="ChPdSubscriptionControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdSubscriptionControlBean extends AbstractControlBean
    implements ChPdSubscriptionControl {

    public ChPdSubscriptionVO doCreate(ChPdSubscriptionVO vo, User user)
        throws Exception {
        try{
			ChPdSubscriptionDAO dao = (ChPdSubscriptionDAO) DAOFactory.build(ChPdSubscriptionDAO.class, user);
            // TODO  set the pk */
            return (ChPdSubscriptionVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdSubscriptionVO vo, User user)
        throws Exception {
        try{
			ChPdSubscriptionDAO dao = (ChPdSubscriptionDAO) DAOFactory.build(ChPdSubscriptionDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdSubscriptionVO doUpdate(ChPdSubscriptionVO vo, User user)
        throws Exception {
        try{
			ChPdSubscriptionDAO dao = (ChPdSubscriptionDAO) DAOFactory.build(ChPdSubscriptionDAO.class, user);
            return (ChPdSubscriptionVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdSubscriptionVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdSubscriptionDAO dao = (ChPdSubscriptionDAO) DAOFactory.build(ChPdSubscriptionDAO.class, user);
        return (ChPdSubscriptionVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdSubscriptionListVO params, User user)
        throws Exception {
			ChPdSubscriptionDAO dao = (ChPdSubscriptionDAO) DAOFactory.build(ChPdSubscriptionDAO.class, user);
        return dao.query(params);
    }
}
