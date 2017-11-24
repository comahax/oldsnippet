/**
* auto-generated code
* Tue Dec 09 14:05:03 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpunishlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpunishlog.persistent.RewardpunishlogVO;
import com.sunrise.boss.business.cms.rewardpunishlog.persistent.RewardpunishlogDAO;
import com.sunrise.boss.business.cms.rewardpunishlog.persistent.RewardpunishlogListVO;

/**
 * <p>Title: RewardpunishlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/rewardpunishlog/control/RewardpunishlogControlBean"
*    name="RewardpunishlogControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RewardpunishlogControlBean extends AbstractControlBean
    implements RewardpunishlogControl {

    public RewardpunishlogVO doCreate(RewardpunishlogVO vo, User user)
        throws Exception {
        try{
			RewardpunishlogDAO dao = (RewardpunishlogDAO) DAOFactory.build(RewardpunishlogDAO.class, user);
            // TODO  set the pk */
            return (RewardpunishlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardpunishlogVO vo, User user)
        throws Exception {
        try{
			RewardpunishlogDAO dao = (RewardpunishlogDAO) DAOFactory.build(RewardpunishlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpunishlogVO doUpdate(RewardpunishlogVO vo, User user)
        throws Exception {
        try{
			RewardpunishlogDAO dao = (RewardpunishlogDAO) DAOFactory.build(RewardpunishlogDAO.class, user);
            return (RewardpunishlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpunishlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RewardpunishlogDAO dao = (RewardpunishlogDAO) DAOFactory.build(RewardpunishlogDAO.class, user);
        return (RewardpunishlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardpunishlogListVO params, User user)
        throws Exception {
			RewardpunishlogDAO dao = (RewardpunishlogDAO) DAOFactory.build(RewardpunishlogDAO.class, user);
        return dao.query(params);
    }
}
