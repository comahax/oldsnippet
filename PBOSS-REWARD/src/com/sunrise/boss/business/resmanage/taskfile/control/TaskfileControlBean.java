/**
* auto-generated code
* Mon Jan 07 11:02:50 CST 2008
*/
package com.sunrise.boss.business.resmanage.taskfile.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileVO;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileDAO;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileListVO;

/**
 * <p>Title: TaskfileControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author David
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/resmanage/taskfile/control/TaskfileControlBean"
 name="TaskfileControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class TaskfileControlBean extends AbstractControlBean
    implements TaskfileControl {

    public TaskfileVO doCreate(TaskfileVO vo, User user)
        throws Exception {
        try{
			TaskfileDAO dao = (TaskfileDAO) DAOFactory.build(TaskfileDAO.class, user.getCityid());
            // TODO  set the pk */
            return (TaskfileVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(TaskfileVO vo, User user)
        throws Exception {
        try{
			TaskfileDAO dao = (TaskfileDAO) DAOFactory.build(TaskfileDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public TaskfileVO doUpdate(TaskfileVO vo, User user)
        throws Exception {
        try{
			TaskfileDAO dao = (TaskfileDAO) DAOFactory.build(TaskfileDAO.class, user.getCityid());
            return (TaskfileVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public TaskfileVO doFindByPk(Serializable pk, User user)
        throws Exception {
			TaskfileDAO dao = (TaskfileDAO) DAOFactory.build(TaskfileDAO.class, user.getCityid());
        return (TaskfileVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(TaskfileListVO params, User user)
        throws Exception {
			TaskfileDAO dao = (TaskfileDAO) DAOFactory.build(TaskfileDAO.class, user.getCityid());
        return dao.query(params);
    }
}
