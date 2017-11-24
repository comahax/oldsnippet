/**
* auto-generated code
* Mon Sep 15 18:12:26 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rewardpoolywlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogVO;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogDAO;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogListVO;

/**
 * <p>Title: RewardpoolywlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rewardpoolywlog/control/RewardpoolywlogControlBean"
 name="RewardpoolywlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardpoolywlogControlBean extends AbstractControlBean
    implements RewardpoolywlogControl {

    public RewardpoolywlogVO doCreate(RewardpoolywlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RewardpoolywlogDAO dao = (RewardpoolywlogDAO) DAOFactory.build(RewardpoolywlogDAO.class, user);
            return (RewardpoolywlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardpoolywlogVO vo, User user)
        throws Exception {
        try{
         RewardpoolywlogDAO dao = (RewardpoolywlogDAO) DAOFactory.build(RewardpoolywlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpoolywlogVO doUpdate(RewardpoolywlogVO vo, User user)
        throws Exception {
        try{
         RewardpoolywlogDAO dao = (RewardpoolywlogDAO) DAOFactory.build(RewardpoolywlogDAO.class, user);
            return (RewardpoolywlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpoolywlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RewardpoolywlogDAO dao = (RewardpoolywlogDAO) DAOFactory.build(RewardpoolywlogDAO.class, user);
        return (RewardpoolywlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardpoolywlogListVO params, User user)
        throws Exception {
         RewardpoolywlogDAO dao = (RewardpoolywlogDAO) DAOFactory.build(RewardpoolywlogDAO.class, user);
        return dao.query(params);
    }
}
