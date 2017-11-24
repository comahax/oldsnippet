/**
* auto-generated code
* Mon Feb 21 11:05:09 CST 2011
*/
package com.sunrise.boss.business.cms.employeelogquery.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryVO;
import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryDAO;
import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryListVO;

/**
 * <p>Title: EmployeelogQueryControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/employeelogquery/control/EmployeelogQueryControlBean"
 name="EmployeelogQueryControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class EmployeelogQueryControlBean extends AbstractControlBean
    implements EmployeelogQueryControl {

    public EmployeelogQueryVO doCreate(EmployeelogQueryVO vo, User user)
        throws Exception {
        try{
			EmployeelogQueryDAO dao = (EmployeelogQueryDAO) DAOFactory.build(EmployeelogQueryDAO.class, user);
            // TODO  set the pk */
            return (EmployeelogQueryVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(EmployeelogQueryVO vo, User user)
        throws Exception {
        try{
			EmployeelogQueryDAO dao = (EmployeelogQueryDAO) DAOFactory.build(EmployeelogQueryDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmployeelogQueryVO doUpdate(EmployeelogQueryVO vo, User user)
        throws Exception {
        try{
			EmployeelogQueryDAO dao = (EmployeelogQueryDAO) DAOFactory.build(EmployeelogQueryDAO.class, user);
            return (EmployeelogQueryVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmployeelogQueryVO doFindByPk(Serializable pk, User user)
        throws Exception {
			EmployeelogQueryDAO dao = (EmployeelogQueryDAO) DAOFactory.build(EmployeelogQueryDAO.class, user);
        return (EmployeelogQueryVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(EmployeelogQueryListVO params, User user)
        throws Exception {
			EmployeelogQueryDAO dao = (EmployeelogQueryDAO) DAOFactory.build(EmployeelogQueryDAO.class, user);
        return dao.query(params);
    }
}
