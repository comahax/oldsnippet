/**
* auto-generated code
* Sat Nov 16 10:49:38 CST 2013
*/
package com.sunrise.boss.business.cms.reward.chadtwayspecialreward.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardVO;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardDAO;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardListVO;

/**
 * <p>Title: ChAdtWayspecialrewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/chadtwayspecialreward/control/ChAdtWayspecialrewardControlBean"
 name="ChAdtWayspecialrewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtWayspecialrewardControlBean extends AbstractControlBean
    implements ChAdtWayspecialrewardControl {

    public ChAdtWayspecialrewardVO doCreate(ChAdtWayspecialrewardVO vo, User user)
        throws Exception {
        try{
			ChAdtWayspecialrewardDAO dao = (ChAdtWayspecialrewardDAO) DAOFactory.build(ChAdtWayspecialrewardDAO.class, user);
            // TODO  set the pk */
            return (ChAdtWayspecialrewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtWayspecialrewardVO vo, User user)
        throws Exception {
        try{
			ChAdtWayspecialrewardDAO dao = (ChAdtWayspecialrewardDAO) DAOFactory.build(ChAdtWayspecialrewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtWayspecialrewardVO doUpdate(ChAdtWayspecialrewardVO vo, User user)
        throws Exception {
        try{
			ChAdtWayspecialrewardDAO dao = (ChAdtWayspecialrewardDAO) DAOFactory.build(ChAdtWayspecialrewardDAO.class, user);
            return (ChAdtWayspecialrewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtWayspecialrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtWayspecialrewardDAO dao = (ChAdtWayspecialrewardDAO) DAOFactory.build(ChAdtWayspecialrewardDAO.class, user);
        return (ChAdtWayspecialrewardVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtWayspecialrewardListVO params, User user)
        throws Exception {
			ChAdtWayspecialrewardDAO dao = (ChAdtWayspecialrewardDAO) DAOFactory.build(ChAdtWayspecialrewardDAO.class, user);
        return dao.query(params);
    }
}
