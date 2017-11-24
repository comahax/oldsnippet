/**
* auto-generated code
* Mon Feb 21 10:37:21 CST 2011
*/
package com.sunrise.boss.business.cms.reward.registersimcnt.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntVO;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntDAO;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntListVO;

/**
 * <p>Title: RegistersimcntControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/registersimcnt/control/RegistersimcntControlBean"
 name="RegistersimcntControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RegistersimcntControlBean extends AbstractControlBean
    implements RegistersimcntControl {

    public RegistersimcntVO doCreate(RegistersimcntVO vo, User user)
        throws Exception {
        try{
			RegistersimcntDAO dao = (RegistersimcntDAO) DAOFactory.build(RegistersimcntDAO.class, user);
            // TODO  set the pk */
            return (RegistersimcntVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RegistersimcntVO vo, User user)
        throws Exception {
        try{
			RegistersimcntDAO dao = (RegistersimcntDAO) DAOFactory.build(RegistersimcntDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersimcntVO doUpdate(RegistersimcntVO vo, User user)
        throws Exception {
        try{
			RegistersimcntDAO dao = (RegistersimcntDAO) DAOFactory.build(RegistersimcntDAO.class, user);
            return (RegistersimcntVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegistersimcntVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RegistersimcntDAO dao = (RegistersimcntDAO) DAOFactory.build(RegistersimcntDAO.class, user);
        return (RegistersimcntVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RegistersimcntListVO params, User user)
        throws Exception {
			RegistersimcntDAO dao = (RegistersimcntDAO) DAOFactory.build(RegistersimcntDAO.class, user);
        return dao.doQuerycnt(params);
    }
}
