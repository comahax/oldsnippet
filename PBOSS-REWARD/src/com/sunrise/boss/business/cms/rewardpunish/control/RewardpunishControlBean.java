/**
* auto-generated code
* Sat Dec 06 16:11:20 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpunish.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpunish.persistent.RewardpunishVO;
import com.sunrise.boss.business.cms.rewardpunish.persistent.RewardpunishDAO;
import com.sunrise.boss.business.cms.rewardpunish.persistent.RewardpunishListVO;

/**
 * <p>Title: RewardpunishControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/rewardpunish/control/RewardpunishControlBean"
*    name="RewardpunishControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RewardpunishControlBean extends AbstractControlBean
    implements RewardpunishControl {

    public RewardpunishVO doCreate(RewardpunishVO vo, User user)
        throws Exception {
        try{
			RewardpunishDAO dao = (RewardpunishDAO) DAOFactory.build(RewardpunishDAO.class, user);
            // TODO  set the pk */
            return (RewardpunishVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardpunishVO vo, User user)
        throws Exception {
        try{
			RewardpunishDAO dao = (RewardpunishDAO) DAOFactory.build(RewardpunishDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpunishVO doUpdate(RewardpunishVO vo, User user)
        throws Exception {
        try{
			RewardpunishDAO dao = (RewardpunishDAO) DAOFactory.build(RewardpunishDAO.class, user);
            return (RewardpunishVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpunishVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RewardpunishDAO dao = (RewardpunishDAO) DAOFactory.build(RewardpunishDAO.class, user);
        return (RewardpunishVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardpunishListVO params, User user)
        throws Exception {
			RewardpunishDAO dao = (RewardpunishDAO) DAOFactory.build(RewardpunishDAO.class, user);
        return dao.query(params);
    }
}
