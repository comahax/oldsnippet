/**
* auto-generated code
* Fri Oct 15 15:45:05 CST 2010
*/
package com.sunrise.boss.business.cms.reward.disintegrallog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogVO;
import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogDAO;
import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogListVO;

/**
 * <p>Title: DisintegrallogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/disintegrallog/control/DisintegrallogControlBean"
 name="DisintegrallogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class DisintegrallogControlBean extends AbstractControlBean
    implements DisintegrallogControl {

    public DisintegrallogVO doCreate(DisintegrallogVO vo, User user)
        throws Exception {
        try{
			DisintegrallogDAO dao = (DisintegrallogDAO) DAOFactory.build(DisintegrallogDAO.class, user);
            // TODO  set the pk */
            return (DisintegrallogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(DisintegrallogVO vo, User user)
        throws Exception {
        try{
			DisintegrallogDAO dao = (DisintegrallogDAO) DAOFactory.build(DisintegrallogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DisintegrallogVO doUpdate(DisintegrallogVO vo, User user)
        throws Exception {
        try{
			DisintegrallogDAO dao = (DisintegrallogDAO) DAOFactory.build(DisintegrallogDAO.class, user);
            return (DisintegrallogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DisintegrallogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			DisintegrallogDAO dao = (DisintegrallogDAO) DAOFactory.build(DisintegrallogDAO.class, user);
        return (DisintegrallogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(DisintegrallogListVO params, User user)
        throws Exception {
			DisintegrallogDAO dao = (DisintegrallogDAO) DAOFactory.build(DisintegrallogDAO.class, user);
        return dao.query(params);
    }
}
