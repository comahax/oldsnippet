/**
* auto-generated code
* Thu May 27 10:43:08 CST 2010
*/
package com.sunrise.boss.business.cms.emprole.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.employee.persistent.EmployeeDAO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleDAO;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleListVO;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: EmproleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/emprole/control/EmproleControlBean"
 name="EmproleControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class EmproleControlBean extends AbstractControlBean
    implements EmproleControl {

    public EmproleVO doCreate(EmproleVO vo, User user)
        throws Exception {
        try{
        	if(vo.getEmployeeid()!=null)
        	{
        	EmployeeDAO emp = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class, user);
        	EmployeeVO empVO=(EmployeeVO)emp.findByPk(vo.getEmployeeid());
        	if(empVO==null)
        	{
        		throw new Exception("[人员ID]在系统中不存在!");
        	}
        	}
			EmproleDAO dao = (EmproleDAO) DAOFactory.build(EmproleDAO.class, user);
            // TODO  set the pk */
            return (EmproleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(EmproleVO vo, User user)
        throws Exception {
        try{
			EmproleDAO dao = (EmproleDAO) DAOFactory.build(EmproleDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmproleVO doUpdate(EmproleVO vo, User user)
        throws Exception {
        try{
			EmproleDAO dao = (EmproleDAO) DAOFactory.build(EmproleDAO.class, user);
            return (EmproleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmproleVO doFindByPk(Serializable pk, User user)
        throws Exception {
			EmproleDAO dao = (EmproleDAO) DAOFactory.build(EmproleDAO.class, user);
        return (EmproleVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(EmproleListVO params, User user)
        throws Exception {
			EmproleDAO dao = (EmproleDAO) DAOFactory.build(EmproleDAO.class, user);
        return dao.query(params);
    }
}
