/**
* auto-generated code
* Fri Dec 09 10:02:24 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.registersucc.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccVO;
import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccDAO;
import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccListVO;

/**
 * <p>Title: RegistersuccControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/registersucc/control/RegistersuccControlBean"
 name="RegistersuccControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RegistersuccControlBean extends AbstractControlBean
    implements RegistersuccControl {

    public RegistersuccVO doCreate(RegistersuccVO vo, User user)
        throws Exception {
        try{
			RegistersuccDAO dao = (RegistersuccDAO) DAOFactory.build(RegistersuccDAO.class, user);
            // TODO  set the pk */
            return (RegistersuccVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RegistersuccVO vo, User user)
        throws Exception {
        try{
			RegistersuccDAO dao = (RegistersuccDAO) DAOFactory.build(RegistersuccDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersuccVO doUpdate(RegistersuccVO vo, User user)
        throws Exception {
        try{
			RegistersuccDAO dao = (RegistersuccDAO) DAOFactory.build(RegistersuccDAO.class, user);
            return (RegistersuccVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersuccVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RegistersuccDAO dao = (RegistersuccDAO) DAOFactory.build(RegistersuccDAO.class, user);
        return (RegistersuccVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RegistersuccListVO params, User user)
        throws Exception {
			RegistersuccDAO dao = (RegistersuccDAO) DAOFactory.build(RegistersuccDAO.class, user);
        return dao.query(params);
    }
}
