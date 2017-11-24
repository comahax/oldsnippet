/**
* auto-generated code
* Wed Nov 02 19:11:53 CST 2011
*/
package com.sunrise.boss.business.cms.reward.rewardslvlimit.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitVO;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitDAO;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitListVO;

/**
 * <p>Title: RewardslvlimitControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rewardslvlimit/control/RewardslvlimitControlBean"
 name="RewardslvlimitControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardslvlimitControlBean extends AbstractControlBean
    implements RewardslvlimitControl {

    public RewardslvlimitVO doCreate(RewardslvlimitVO vo, User user)
        throws Exception {
        try{
			RewardslvlimitDAO dao = (RewardslvlimitDAO) DAOFactory.build(RewardslvlimitDAO.class, user);
            // TODO  set the pk */
            return (RewardslvlimitVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RewardslvlimitVO vo, User user)
        throws Exception {
        try{
			RewardslvlimitDAO dao = (RewardslvlimitDAO) DAOFactory.build(RewardslvlimitDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardslvlimitVO doUpdate(RewardslvlimitVO vo, User user)
        throws Exception {
        try{
			RewardslvlimitDAO dao = (RewardslvlimitDAO) DAOFactory.build(RewardslvlimitDAO.class, user);
            return (RewardslvlimitVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardslvlimitVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RewardslvlimitDAO dao = (RewardslvlimitDAO) DAOFactory.build(RewardslvlimitDAO.class, user);
        return (RewardslvlimitVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RewardslvlimitListVO params, User user)
        throws Exception {
			RewardslvlimitDAO dao = (RewardslvlimitDAO) DAOFactory.build(RewardslvlimitDAO.class, user);
        return dao.query(params);
    }
}
