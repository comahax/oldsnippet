/**
* auto-generated code
* Wed Dec 24 11:06:41 CST 2008
*/
package com.sunrise.boss.business.cms.rewardadjust.control;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.jgroups.util.List;

import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustDAO;
import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustListVO;
import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: RewardadjustControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardadjust/control/RewardadjustControlBean"
 name="RewardadjustControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardadjustControlBean extends AbstractControlBean
    implements RewardadjustControl {
	
	

    public RewardadjustVO doCreate(RewardadjustVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RewardadjustDAO dao = (RewardadjustDAO) DAOFactory.build(RewardadjustDAO.class, user);
            return (RewardadjustVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardadjustVO vo, User user)
        throws Exception {
        try{
         RewardadjustDAO dao = (RewardadjustDAO) DAOFactory.build(RewardadjustDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardadjustVO doUpdate(RewardadjustVO vo, User user)
        throws Exception {
        try{
         RewardadjustDAO dao = (RewardadjustDAO) DAOFactory.build(RewardadjustDAO.class, user);
            return (RewardadjustVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardadjustVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RewardadjustDAO dao = (RewardadjustDAO) DAOFactory.build(RewardadjustDAO.class, user);
        return (RewardadjustVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardadjustListVO params, User user)
        throws Exception {
         RewardadjustDAO dao = (RewardadjustDAO) DAOFactory.build(RewardadjustDAO.class, user);

        return dao.query(params);
    }
}
