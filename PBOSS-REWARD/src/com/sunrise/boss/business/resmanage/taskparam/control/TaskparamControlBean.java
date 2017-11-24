package com.sunrise.boss.business.resmanage.taskparam.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamVO;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamDAO;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamListVO;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/resmanage/taskparam/control/TaskparamControlBean"
*    name="TaskparamControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class TaskparamControlBean extends AbstractControlBean
    implements TaskparamControl {

    public TaskparamVO doCreate(TaskparamVO vo, User user)
        throws Exception {
        try{
			TaskparamDAO dao = (TaskparamDAO) DAOFactory.build(TaskparamDAO.class, user.getCityid());
            return (TaskparamVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(TaskparamVO vo, User user)
        throws Exception {
        try{
			TaskparamDAO dao = (TaskparamDAO) DAOFactory.build(TaskparamDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public TaskparamVO doUpdate(TaskparamVO vo, User user)
        throws Exception {
        try{
			TaskparamDAO dao = (TaskparamDAO) DAOFactory.build(TaskparamDAO.class, user.getCityid());
            return (TaskparamVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public TaskparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
			TaskparamDAO dao = (TaskparamDAO) DAOFactory.build(TaskparamDAO.class, user.getCityid());
        return (TaskparamVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(TaskparamListVO params, User user)
        throws Exception {
			TaskparamDAO dao = (TaskparamDAO) DAOFactory.build(TaskparamDAO.class, user.getCityid());
        return dao.query(params);
    }
}
