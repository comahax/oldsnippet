/**
* auto-generated code
* Wed Dec 24 11:06:41 CST 2008
*/
package com.sunrise.boss.business.cms.rewardadjustlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.rewardadjustlog.persistent.RewardadjustlogDAO;
import com.sunrise.boss.business.cms.rewardadjustlog.persistent.RewardadjustlogListVO;
import com.sunrise.boss.business.cms.rewardadjustlog.persistent.RewardadjustlogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: RewardadjustlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardadjustlog/control/RewardadjustlogControlBean"
 name="RewardadjustlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardadjustlogControlBean extends AbstractControlBean
    implements RewardadjustlogControl {

    public RewardadjustlogVO doCreate(RewardadjustlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	RewardadjustlogDAO dao = (RewardadjustlogDAO) DAOFactory.build(RewardadjustlogDAO.class, user);
            return (RewardadjustlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardadjustlogVO vo, User user)
        throws Exception {
        try{
         RewardadjustlogDAO dao = (RewardadjustlogDAO) DAOFactory.build(RewardadjustlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardadjustlogVO doUpdate(RewardadjustlogVO vo, User user)
        throws Exception {
        try{
         RewardadjustlogDAO dao = (RewardadjustlogDAO) DAOFactory.build(RewardadjustlogDAO.class, user);
            return (RewardadjustlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardadjustlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RewardadjustlogDAO dao = (RewardadjustlogDAO) DAOFactory.build(RewardadjustlogDAO.class, user);
        return (RewardadjustlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardadjustlogListVO params, User user)
        throws Exception {
         RewardadjustlogDAO dao = (RewardadjustlogDAO) DAOFactory.build(RewardadjustlogDAO.class, user);
        return dao.query(params);
    }
}
