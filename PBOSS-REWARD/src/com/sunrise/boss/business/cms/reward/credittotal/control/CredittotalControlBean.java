/**
* auto-generated code
* Tue May 17 18:38:00 CST 2011
*/
package com.sunrise.boss.business.cms.reward.credittotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalVO;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalDAO;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalListVO;

/**
 * <p>Title: CredittotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/credittotal/control/CredittotalControlBean"
 name="CredittotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CredittotalControlBean extends AbstractControlBean
    implements CredittotalControl {

    public CredittotalVO doCreate(CredittotalVO vo, User user)
        throws Exception {
        try{
			CredittotalDAO dao = (CredittotalDAO) DAOFactory.build(CredittotalDAO.class, user);
            // TODO  set the pk */
            return (CredittotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CredittotalVO vo, User user)
        throws Exception {
        try{
			CredittotalDAO dao = (CredittotalDAO) DAOFactory.build(CredittotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CredittotalVO doUpdate(CredittotalVO vo, User user)
        throws Exception {
        try{
			CredittotalDAO dao = (CredittotalDAO) DAOFactory.build(CredittotalDAO.class, user);
            return (CredittotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CredittotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CredittotalDAO dao = (CredittotalDAO) DAOFactory.build(CredittotalDAO.class, user);
        return (CredittotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CredittotalListVO params, User user)
        throws Exception {
			CredittotalDAO dao = (CredittotalDAO) DAOFactory.build(CredittotalDAO.class, user);
        return dao.query(params);
    }
}
