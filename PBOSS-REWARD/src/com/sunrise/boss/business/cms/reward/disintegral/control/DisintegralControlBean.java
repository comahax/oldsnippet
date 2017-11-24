/**
* auto-generated code
* Fri Oct 15 15:43:07 CST 2010
*/
package com.sunrise.boss.business.cms.reward.disintegral.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralVO;
import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralDAO;
import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralListVO;

/**
 * <p>Title: DisintegralControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/disintegral/control/DisintegralControlBean"
 name="DisintegralControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class DisintegralControlBean extends AbstractControlBean
    implements DisintegralControl {

    public DisintegralVO doCreate(DisintegralVO vo, User user)
        throws Exception {
        try{
			DisintegralDAO dao = (DisintegralDAO) DAOFactory.build(DisintegralDAO.class, user);
            // TODO  set the pk */
            return (DisintegralVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(DisintegralVO vo, User user)
        throws Exception {
        try{
			DisintegralDAO dao = (DisintegralDAO) DAOFactory.build(DisintegralDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DisintegralVO doUpdate(DisintegralVO vo, User user)
        throws Exception {
        try{
			DisintegralDAO dao = (DisintegralDAO) DAOFactory.build(DisintegralDAO.class, user);
            return (DisintegralVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DisintegralVO doFindByPk(Serializable pk, User user)
        throws Exception {
			DisintegralDAO dao = (DisintegralDAO) DAOFactory.build(DisintegralDAO.class, user);
        return (DisintegralVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(DisintegralListVO params, User user)
        throws Exception {
			DisintegralDAO dao = (DisintegralDAO) DAOFactory.build(DisintegralDAO.class, user);
        return dao.query(params);
    }
}
