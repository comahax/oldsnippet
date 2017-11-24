/**
* auto-generated code
* Sat Jan 12 11:13:01 CST 2013
*/
package com.sunrise.boss.business.cms.chpwwaybusicircle.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleVO;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleDAO;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleListVO;

/**
 * <p>Title: ChPwWaybusicircleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chpwwaybusicircle/control/ChPwWaybusicircleControlBean"
 name="ChPwWaybusicircleControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwWaybusicircleControlBean extends AbstractControlBean
    implements ChPwWaybusicircleControl {

    public ChPwWaybusicircleVO doCreate(ChPwWaybusicircleVO vo, User user)
        throws Exception {
        try{
			ChPwWaybusicircleDAO dao = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
            // TODO  set the pk */
            return (ChPwWaybusicircleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwWaybusicircleVO vo, User user)
        throws Exception {
        try{
			ChPwWaybusicircleDAO dao = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwWaybusicircleVO doUpdate(ChPwWaybusicircleVO vo, User user)
        throws Exception {
        try{
			ChPwWaybusicircleDAO dao = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
            return (ChPwWaybusicircleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwWaybusicircleVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwWaybusicircleDAO dao = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
        return (ChPwWaybusicircleVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwWaybusicircleListVO params, User user)
        throws Exception {
			ChPwWaybusicircleDAO dao = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
        return dao.query(params);
    }
}
