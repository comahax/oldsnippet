/**
* auto-generated code
* Thu Jul 28 20:52:00 CST 2011
*/
package com.sunrise.boss.business.cms.rewardranlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogVO;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogDAO;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogListVO;

/**
 * <p>Title: RewardranlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardranlog/control/RewardranlogControlBean"
 name="RewardranlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardranlogControlBean extends AbstractControlBean
    implements RewardranlogControl {

    public RewardranlogVO doCreate(RewardranlogVO vo, User user)
        throws Exception {
        try{
			RewardranlogDAO dao = (RewardranlogDAO) DAOFactory.build(RewardranlogDAO.class, user);
            // TODO  set the pk */
            return (RewardranlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RewardranlogVO vo, User user)
        throws Exception {
        try{
			RewardranlogDAO dao = (RewardranlogDAO) DAOFactory.build(RewardranlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardranlogVO doUpdate(RewardranlogVO vo, User user)
        throws Exception {
        try{
			RewardranlogDAO dao = (RewardranlogDAO) DAOFactory.build(RewardranlogDAO.class, user);
            return (RewardranlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardranlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RewardranlogDAO dao = (RewardranlogDAO) DAOFactory.build(RewardranlogDAO.class, user);
        return (RewardranlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RewardranlogListVO params, User user)
        throws Exception {
			RewardranlogDAO dao = (RewardranlogDAO) DAOFactory.build(RewardranlogDAO.class, user);
        return dao.query(params);
    }
}
