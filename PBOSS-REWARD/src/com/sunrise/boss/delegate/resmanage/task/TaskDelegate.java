package com.sunrise.boss.delegate.resmanage.task;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskListVO;
import com.sunrise.boss.business.resmanage.task.control.TaskControlBean;
import com.sunrise.boss.business.resmanage.task.control.TaskControl;

import java.io.Serializable;
import java.util.List;

public class TaskDelegate {

	private static TaskControl control;

	public TaskDelegate() throws Exception {
		control = (TaskControl) ControlFactory.build(TaskControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public TaskVO doCreate(TaskVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(TaskVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public TaskVO doUpdate(TaskVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public TaskVO doFindByPk(Serializable pk, User user) throws Exception {
		return (TaskVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(TaskListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}

	public TaskVO doRecordTask(TaskVO task, List paramList, User user)
			throws Exception {
		return control.doRecordTask(task, paramList, user);
	}
}
