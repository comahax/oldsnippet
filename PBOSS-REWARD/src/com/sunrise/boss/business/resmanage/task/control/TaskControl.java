package com.sunrise.boss.business.resmanage.task.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskListVO;

import java.io.Serializable;
import java.util.List;

public interface TaskControl extends AbstractControl {

	public TaskVO doCreate(TaskVO vo, User user) throws Exception;

	public void doRemove(TaskVO vo, User user) throws Exception;

	public TaskVO doUpdate(TaskVO vo, User user) throws Exception;

	public TaskVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(TaskListVO params, User user) throws Exception;

	public TaskVO doRecordTask(TaskVO task, List paramList, User user)
			throws Exception;
}
