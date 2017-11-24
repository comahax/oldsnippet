/**
* auto-generated code
* Tue Jul 14 16:42:23 CST 2009
*/
package com.sunrise.boss.business.cms.reward.waysnpt.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptVO;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptDAO;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptListVO;

/**
 * <p>Title: WaysnptControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/waysnpt/control/WaysnptControlBean"
 name="WaysnptControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WaysnptControlBean extends AbstractControlBean
    implements WaysnptControl {

    public WaysnptVO doCreate(WaysnptVO vo, User user)
        throws Exception {
        try{
			WaysnptDAO dao = (WaysnptDAO) DAOFactory.build(WaysnptDAO.class, user);
            // TODO  set the pk */
            return (WaysnptVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(WaysnptVO vo, User user)
        throws Exception {
        try{
			WaysnptDAO dao = (WaysnptDAO) DAOFactory.build(WaysnptDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaysnptVO doUpdate(WaysnptVO vo, User user)
        throws Exception {
        try{
			WaysnptDAO dao = (WaysnptDAO) DAOFactory.build(WaysnptDAO.class, user);
            return (WaysnptVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaysnptVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WaysnptDAO dao = (WaysnptDAO) DAOFactory.build(WaysnptDAO.class, user);
        return (WaysnptVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(WaysnptListVO params, User user)
        throws Exception {
			WaysnptDAO dao = (WaysnptDAO) DAOFactory.build(WaysnptDAO.class, user);
        return dao.query(params);
    }
}
