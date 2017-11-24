/**
* auto-generated code
* Fri Feb 01 18:20:26 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpoolrlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogVO;
import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogDAO;
import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogListVO;

/**
 * <p>Title: RewardpoolrlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardpoolrlog/control/RewardpoolrlogControlBean"
 name="RewardpoolrlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardpoolrlogControlBean extends AbstractControlBean
    implements RewardpoolrlogControl {

    public RewardpoolrlogVO doCreate(RewardpoolrlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RewardpoolrlogDAO dao = (RewardpoolrlogDAO) DAOFactory.build(RewardpoolrlogDAO.class, user);
            return (RewardpoolrlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardpoolrlogVO vo, User user)
        throws Exception {
        try{
         RewardpoolrlogDAO dao = (RewardpoolrlogDAO) DAOFactory.build(RewardpoolrlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpoolrlogVO doUpdate(RewardpoolrlogVO vo, User user)
        throws Exception {
        try{
         RewardpoolrlogDAO dao = (RewardpoolrlogDAO) DAOFactory.build(RewardpoolrlogDAO.class, user);
            return (RewardpoolrlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardpoolrlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RewardpoolrlogDAO dao = (RewardpoolrlogDAO) DAOFactory.build(RewardpoolrlogDAO.class, user);
        return (RewardpoolrlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardpoolrlogListVO params, User user)
        throws Exception {
         RewardpoolrlogDAO dao = (RewardpoolrlogDAO) DAOFactory.build(RewardpoolrlogDAO.class, user);
        return dao.query(params);
    }
}
