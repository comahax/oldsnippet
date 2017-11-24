/**
* auto-generated code
* Fri Dec 09 10:19:02 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.registerfail.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailVO;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailDAO;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailListVO;

/**
 * <p>Title: RegisterfailControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/registerfail/control/RegisterfailControlBean"
 name="RegisterfailControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RegisterfailControlBean extends AbstractControlBean
    implements RegisterfailControl {

    public RegisterfailVO doCreate(RegisterfailVO vo, User user)
        throws Exception {
        try{
			RegisterfailDAO dao = (RegisterfailDAO) DAOFactory.build(RegisterfailDAO.class, user);
            // TODO  set the pk */
            return (RegisterfailVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RegisterfailVO vo, User user)
        throws Exception {
        try{
			RegisterfailDAO dao = (RegisterfailDAO) DAOFactory.build(RegisterfailDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegisterfailVO doUpdate(RegisterfailVO vo, User user)
        throws Exception {
        try{
			RegisterfailDAO dao = (RegisterfailDAO) DAOFactory.build(RegisterfailDAO.class, user);
            return (RegisterfailVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegisterfailVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RegisterfailDAO dao = (RegisterfailDAO) DAOFactory.build(RegisterfailDAO.class, user);
        return (RegisterfailVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RegisterfailListVO params, User user)
        throws Exception {
			RegisterfailDAO dao = (RegisterfailDAO) DAOFactory.build(RegisterfailDAO.class, user);
        return dao.query(params);
    }
}
