/**
* auto-generated code
* Fri Oct 20 22:27:36 CST 2006
*/
package com.sunrise.boss.business.rightmanage.role.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleDAO;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleListVO;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleVO;

/**
 * <p>Title: RoleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/rightmanage/role/control/RoleControlBean"
 name="RoleControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RoleControlBean extends AbstractControlBean
    implements RoleControl {

    public RoleVO doCreate(RoleVO vo, User user)
        throws Exception {
        try{
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user.getCityid());
            // TODO  set the pk */
            return (RoleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RoleVO vo, User user)
        throws Exception {
        try{
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RoleVO doUpdate(RoleVO vo, User user)
        throws Exception {
        try{
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user.getCityid());
            return (RoleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RoleVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user.getCityid());
        return (RoleVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RoleListVO params, User user)
        throws Exception {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user.getCityid());
        return dao.query(params);
    }
}
