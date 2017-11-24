/**
* auto-generated code
* Fri Jul 30 12:01:21 CST 2010
*/
package com.sunrise.boss.business.cms.reward.wayxplan.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanVO;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanDAO;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanListVO;

/**
 * <p>Title: WayxplanControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/wayxplan/control/WayxplanControlBean"
 name="WayxplanControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WayxplanControlBean extends AbstractControlBean
    implements WayxplanControl {

    public WayxplanVO doCreate(WayxplanVO vo, User user)
        throws Exception {
        try{
			WayxplanDAO dao = (WayxplanDAO) DAOFactory.build(WayxplanDAO.class, user);
            // TODO  set the pk */
            return (WayxplanVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(WayxplanVO vo, User user)
        throws Exception {
        try{
			WayxplanDAO dao = (WayxplanDAO) DAOFactory.build(WayxplanDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WayxplanVO doUpdate(WayxplanVO vo, User user)
        throws Exception {
        try{
			WayxplanDAO dao = (WayxplanDAO) DAOFactory.build(WayxplanDAO.class, user);
            return (WayxplanVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WayxplanVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WayxplanDAO dao = (WayxplanDAO) DAOFactory.build(WayxplanDAO.class, user);
        return (WayxplanVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(WayxplanListVO params, User user)
        throws Exception {
			WayxplanDAO dao = (WayxplanDAO) DAOFactory.build(WayxplanDAO.class, user);
        return dao.query(params);
    }
}
