/**
* auto-generated code
* Tue Aug 21 10:43:23 CST 2012
*/
package com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadDAO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadListVO;

/**
 * <p>Title: ChPwRegisterbroadControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/kdkhzl/chpwregisterbroad/control/ChPwRegisterbroadControlBean"
 name="ChPwRegisterbroadControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwRegisterbroadControlBean extends AbstractControlBean
    implements ChPwRegisterbroadControl {

    public ChPwRegisterbroadVO doCreate(ChPwRegisterbroadVO vo, User user)
        throws Exception {
        try{
			ChPwRegisterbroadDAO dao = (ChPwRegisterbroadDAO) DAOFactory.build(ChPwRegisterbroadDAO.class, user);
            // TODO  set the pk */
            return (ChPwRegisterbroadVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwRegisterbroadVO vo, User user)
        throws Exception {
        try{
			ChPwRegisterbroadDAO dao = (ChPwRegisterbroadDAO) DAOFactory.build(ChPwRegisterbroadDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwRegisterbroadVO doUpdate(ChPwRegisterbroadVO vo, User user)
        throws Exception {
        try{
			ChPwRegisterbroadDAO dao = (ChPwRegisterbroadDAO) DAOFactory.build(ChPwRegisterbroadDAO.class, user);
            return (ChPwRegisterbroadVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwRegisterbroadVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwRegisterbroadDAO dao = (ChPwRegisterbroadDAO) DAOFactory.build(ChPwRegisterbroadDAO.class, user);
        return (ChPwRegisterbroadVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwRegisterbroadListVO params, User user)
        throws Exception {
			ChPwRegisterbroadDAO dao = (ChPwRegisterbroadDAO) DAOFactory.build(ChPwRegisterbroadDAO.class, user);
        return dao.query(params);
    }
}
