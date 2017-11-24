/**
* auto-generated code
* Tue May 17 15:57:34 CST 2011
*/
package com.sunrise.boss.business.cms.reward.salecredit.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditVO;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditDAO;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditListVO;

/**
 * <p>Title: SalecreditControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/salecredit/control/SalecreditControlBean"
 name="SalecreditControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class SalecreditControlBean extends AbstractControlBean
    implements SalecreditControl {

    public SalecreditVO doCreate(SalecreditVO vo, User user)
        throws Exception {
        try{
			SalecreditDAO dao = (SalecreditDAO) DAOFactory.build(SalecreditDAO.class, user);
            // TODO  set the pk */
            return (SalecreditVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(SalecreditVO vo, User user)
        throws Exception {
        try{
			SalecreditDAO dao = (SalecreditDAO) DAOFactory.build(SalecreditDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalecreditVO doUpdate(SalecreditVO vo, User user)
        throws Exception {
        try{
			SalecreditDAO dao = (SalecreditDAO) DAOFactory.build(SalecreditDAO.class, user);
            return (SalecreditVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalecreditVO doFindByPk(Serializable pk, User user)
        throws Exception {
			SalecreditDAO dao = (SalecreditDAO) DAOFactory.build(SalecreditDAO.class, user);
        return (SalecreditVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(SalecreditListVO params, User user)
        throws Exception {
			SalecreditDAO dao = (SalecreditDAO) DAOFactory.build(SalecreditDAO.class, user);
        return dao.query(params);
    }
}
