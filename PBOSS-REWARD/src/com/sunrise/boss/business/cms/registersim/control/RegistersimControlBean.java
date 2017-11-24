/**
* auto-generated code
* Tue Jun 21 10:33:15 GMT 2011
*/
package com.sunrise.boss.business.cms.registersim.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimVO;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimDAO;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimListVO;

/**
 * <p>Title: RegistersimControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/registersim/control/RegistersimControlBean"
 name="RegistersimControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RegistersimControlBean extends AbstractControlBean
    implements RegistersimControl {

    public RegistersimVO doCreate(RegistersimVO vo, User user)
        throws Exception {
        try{
			RegistersimDAO dao = (RegistersimDAO) DAOFactory.build(RegistersimDAO.class, user);
            // TODO  set the pk */
            return (RegistersimVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RegistersimVO vo, User user)
        throws Exception {
        try{
			RegistersimDAO dao = (RegistersimDAO) DAOFactory.build(RegistersimDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersimVO doUpdate(RegistersimVO vo, User user)
        throws Exception {
        try{
			RegistersimDAO dao = (RegistersimDAO) DAOFactory.build(RegistersimDAO.class, user);
            return (RegistersimVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersimVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RegistersimDAO dao = (RegistersimDAO) DAOFactory.build(RegistersimDAO.class, user);
        return (RegistersimVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RegistersimListVO params, User user)
        throws Exception {
			RegistersimDAO dao = (RegistersimDAO) DAOFactory.build(RegistersimDAO.class, user);
        return dao.query(params);
    }
}
