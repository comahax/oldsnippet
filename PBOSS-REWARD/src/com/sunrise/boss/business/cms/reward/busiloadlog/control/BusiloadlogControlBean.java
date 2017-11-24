/**
* auto-generated code
* Fri Feb 15 15:25:15 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busiloadlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogVO;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogDAO;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogListVO;

/**
 * <p>Title: BusiloadlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busiloadlog/control/BusiloadlogControlBean"
 name="BusiloadlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BusiloadlogControlBean extends AbstractControlBean
    implements BusiloadlogControl {

    public BusiloadlogVO doCreate(BusiloadlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BusiloadlogDAO dao = (BusiloadlogDAO) DAOFactory.build(BusiloadlogDAO.class, user);
            return (BusiloadlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BusiloadlogVO vo, User user)
        throws Exception {
        try{
         BusiloadlogDAO dao = (BusiloadlogDAO) DAOFactory.build(BusiloadlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusiloadlogVO doUpdate(BusiloadlogVO vo, User user)
        throws Exception {
        try{
         BusiloadlogDAO dao = (BusiloadlogDAO) DAOFactory.build(BusiloadlogDAO.class, user);
            return (BusiloadlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusiloadlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BusiloadlogDAO dao = (BusiloadlogDAO) DAOFactory.build(BusiloadlogDAO.class, user);
        return (BusiloadlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BusiloadlogListVO params, User user)
        throws Exception {
         BusiloadlogDAO dao = (BusiloadlogDAO) DAOFactory.build(BusiloadlogDAO.class, user);
        return dao.query(params);
    }
}
