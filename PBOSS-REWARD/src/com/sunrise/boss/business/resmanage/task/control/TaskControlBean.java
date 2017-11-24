package com.sunrise.boss.business.resmanage.task.control;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskDAO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskListVO;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamDAO;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamVO;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/resmanage/task/control/TaskControlBean"
 *           name="TaskControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class TaskControlBean extends AbstractControlBean implements TaskControl {

	public TaskVO doCreate(TaskVO vo, User user) throws Exception {
		try {
			TaskDAO dao = (TaskDAO) DAOFactory.build(TaskDAO.class, user);
			return (TaskVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(TaskVO vo, User user) throws Exception {
		try {
			TaskDAO dao = (TaskDAO) DAOFactory.build(TaskDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TaskVO doUpdate(TaskVO vo, User user) throws Exception {
		try {
			TaskDAO dao = (TaskDAO) DAOFactory.build(TaskDAO.class, user);
			return (TaskVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TaskVO doFindByPk(Serializable pk, User user) throws Exception {
		TaskDAO dao = (TaskDAO) DAOFactory.build(TaskDAO.class, user);
		return (TaskVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TaskListVO params, User user) throws Exception {
		TaskDAO dao = (TaskDAO) DAOFactory.build(TaskDAO.class, user);
		return dao.query(params);
	}
	
	/**
	 * 登记批量处理任务及任务所需要的各参数，如无参数，则paramList置为null
	 * @param task
	 * @param paramList
	 * @param user
	 * @throws Exception
	 */
	public TaskVO doRecordTask(TaskVO task, List paramList, User user)throws Exception{
		try{
			TaskDAO taskDao = (TaskDAO) DAOFactory.build(TaskDAO.class, user);
			TaskVO taskVo = (TaskVO) taskDao.create(task);
			if( paramList != null ){
				TaskparamDAO paramDao = (TaskparamDAO)DAOFactory.build(TaskparamDAO.class, user);
				Iterator iter = paramList.iterator();
				while(iter.hasNext()){
					TaskparamVO param = (TaskparamVO) iter.next();
					param.setTaskid(taskVo.getTaskid());
					paramDao.create(param);
				}
			}
			return taskVo;
		}catch(Exception ex){
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
