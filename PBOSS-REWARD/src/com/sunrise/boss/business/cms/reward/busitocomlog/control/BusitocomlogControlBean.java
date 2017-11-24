/**
* auto-generated code
* Fri Aug 28 11:21:30 CST 2009
*/
package com.sunrise.boss.business.cms.reward.busitocomlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogVO;
import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogDAO;
import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogListVO;

/**
 * <p>Title: BusitocomlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busitocomlog/control/BusitocomlogControlBean"
 name="BusitocomlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BusitocomlogControlBean extends AbstractControlBean
    implements BusitocomlogControl {

    public BusitocomlogVO doCreate(BusitocomlogVO vo, User user)
        throws Exception {
        try{
			BusitocomlogDAO dao = (BusitocomlogDAO) DAOFactory.build(BusitocomlogDAO.class, user);
            // TODO  set the pk */
            return (BusitocomlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BusitocomlogVO vo, User user)
        throws Exception {
        try{
			BusitocomlogDAO dao = (BusitocomlogDAO) DAOFactory.build(BusitocomlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BusitocomlogVO doUpdate(BusitocomlogVO vo, User user)
        throws Exception {
        try{
			BusitocomlogDAO dao = (BusitocomlogDAO) DAOFactory.build(BusitocomlogDAO.class, user);
            return (BusitocomlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BusitocomlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BusitocomlogDAO dao = (BusitocomlogDAO) DAOFactory.build(BusitocomlogDAO.class, user);
        return (BusitocomlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BusitocomlogListVO params, User user)
        throws Exception {
			BusitocomlogDAO dao = (BusitocomlogDAO) DAOFactory.build(BusitocomlogDAO.class, user);
        return dao.query(params);
    }
}
