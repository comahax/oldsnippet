/**
* auto-generated code
* Fri Aug 28 11:17:48 CST 2009
*/
package com.sunrise.boss.business.cms.reward.busitocom.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomDAO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomListVO;

/**
 * <p>Title: BusitocomControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busitocom/control/BusitocomControlBean"
 name="BusitocomControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BusitocomControlBean extends AbstractControlBean
    implements BusitocomControl {

    public BusitocomVO doCreate(BusitocomVO vo, User user)
        throws Exception {
        try{
			BusitocomDAO dao = (BusitocomDAO) DAOFactory.build(BusitocomDAO.class, user);
            // TODO  set the pk */
            return (BusitocomVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BusitocomVO vo, User user)
        throws Exception {
        try{
			BusitocomDAO dao = (BusitocomDAO) DAOFactory.build(BusitocomDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BusitocomVO doUpdate(BusitocomVO vo, User user)
        throws Exception {
        try{
			BusitocomDAO dao = (BusitocomDAO) DAOFactory.build(BusitocomDAO.class, user);
            return (BusitocomVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BusitocomVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BusitocomDAO dao = (BusitocomDAO) DAOFactory.build(BusitocomDAO.class, user);
        return (BusitocomVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BusitocomListVO params, User user)
        throws Exception {
			BusitocomDAO dao = (BusitocomDAO) DAOFactory.build(BusitocomDAO.class, user);
        return dao.query(params);
    }
}
