/**
* auto-generated code
* Tue Apr 10 11:19:35 CST 2012
*/
package com.sunrise.boss.business.cms.reward.pwdictparam.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamVO;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamDAO;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamListVO;

/**
 * <p>Title: PwDictparamControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/pwdictparam/control/PwDictparamControlBean"
 name="PwDictparamControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class PwDictparamControlBean extends AbstractControlBean
    implements PwDictparamControl {

    public PwDictparamVO doCreate(PwDictparamVO vo, User user)
        throws Exception {
        try{
			PwDictparamDAO dao = (PwDictparamDAO) DAOFactory.build(PwDictparamDAO.class, user);
            // TODO  set the pk */
            return (PwDictparamVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(PwDictparamVO vo, User user)
        throws Exception {
        try{
			PwDictparamDAO dao = (PwDictparamDAO) DAOFactory.build(PwDictparamDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public PwDictparamVO doUpdate(PwDictparamVO vo, User user)
        throws Exception {
        try{
			PwDictparamDAO dao = (PwDictparamDAO) DAOFactory.build(PwDictparamDAO.class, user);
            return (PwDictparamVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public PwDictparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
			PwDictparamDAO dao = (PwDictparamDAO) DAOFactory.build(PwDictparamDAO.class, user);
        return (PwDictparamVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(PwDictparamListVO params, User user)
        throws Exception {
			PwDictparamDAO dao = (PwDictparamDAO) DAOFactory.build(PwDictparamDAO.class, user);
        return dao.query(params);
    }
}
