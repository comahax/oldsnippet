/**
* auto-generated code
* Thu Jan 31 17:14:30 CST 2008
*/
package com.sunrise.boss.business.cms.rewardasselog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogVO;
import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogDAO;
import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogListVO;

/**
 * <p>Title: RewardasselogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardasselog/control/RewardasselogControlBean"
 name="RewardasselogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardasselogControlBean extends AbstractControlBean
    implements RewardasselogControl {

    public RewardasselogVO doCreate(RewardasselogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RewardasselogDAO dao = (RewardasselogDAO) DAOFactory.build(RewardasselogDAO.class, user);
            return (RewardasselogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RewardasselogVO vo, User user)
        throws Exception {
        try{
         RewardasselogDAO dao = (RewardasselogDAO) DAOFactory.build(RewardasselogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardasselogVO doUpdate(RewardasselogVO vo, User user)
        throws Exception {
        try{
         RewardasselogDAO dao = (RewardasselogDAO) DAOFactory.build(RewardasselogDAO.class, user);
            return (RewardasselogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RewardasselogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RewardasselogDAO dao = (RewardasselogDAO) DAOFactory.build(RewardasselogDAO.class, user);
        return (RewardasselogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RewardasselogListVO params, User user)
        throws Exception {
         RewardasselogDAO dao = (RewardasselogDAO) DAOFactory.build(RewardasselogDAO.class, user);
        return dao.query(params);
    }
}
