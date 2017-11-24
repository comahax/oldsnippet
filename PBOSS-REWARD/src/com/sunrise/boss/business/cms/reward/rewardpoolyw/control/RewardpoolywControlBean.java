/**
* auto-generated code
* Mon Sep 15 18:11:42 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rewardpoolyw.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywVO;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywDAO;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywListVO;

/**
 * <p>Title: RewardpoolywControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rewardpoolyw/control/RewardpoolywControlBean"
 name="RewardpoolywControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardpoolywControlBean extends AbstractControlBean
    implements RewardpoolywControl {

    public RewardpoolywVO doCreate(RewardpoolywVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RewardpoolywDAO dao = (RewardpoolywDAO) DAOFactory.build(RewardpoolywDAO.class, user);
            return (RewardpoolywVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardpoolywVO vo, User user)
        throws Exception {
        try{
         RewardpoolywDAO dao = (RewardpoolywDAO) DAOFactory.build(RewardpoolywDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpoolywVO doUpdate(RewardpoolywVO vo, User user)
        throws Exception {
        try{
         RewardpoolywDAO dao = (RewardpoolywDAO) DAOFactory.build(RewardpoolywDAO.class, user);
            return (RewardpoolywVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpoolywVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RewardpoolywDAO dao = (RewardpoolywDAO) DAOFactory.build(RewardpoolywDAO.class, user);
        return (RewardpoolywVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardpoolywListVO params, User user)
        throws Exception {
         RewardpoolywDAO dao = (RewardpoolywDAO) DAOFactory.build(RewardpoolywDAO.class, user);
        return dao.query(params);
    }
}
