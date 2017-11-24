/**
* auto-generated code
* Fri May 16 09:53:52 CST 2008
*/
package com.sunrise.boss.business.cms.waysyn.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waysyn.persistent.WaysynVO;
import com.sunrise.boss.business.cms.waysyn.persistent.WaysynDAO;

/**
 * <p>Title: WaysynControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/waysyn/control/WaysynControlBean"
 name="WaysynControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WaysynControlBean extends AbstractControlBean
    implements WaysynControl {

    public WaysynVO doCreate(WaysynVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class, user);
            return (WaysynVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WaysynVO vo, User user)
        throws Exception {
        try{
         WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaysynVO doUpdate(WaysynVO vo, User user)
        throws Exception {
        try{
         WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class, user);
            return (WaysynVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaysynVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class, user);
        return (WaysynVO) dao.findByPk(pk);
    }
}
