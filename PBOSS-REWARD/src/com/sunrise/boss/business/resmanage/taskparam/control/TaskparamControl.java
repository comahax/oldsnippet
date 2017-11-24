/**
* auto-generated code
* Thu Dec 13 10:03:21 CST 2007
*/
package com.sunrise.boss.business.resmanage.taskparam.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamVO;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamListVO;

import java.io.Serializable;

/**
 * <p>Title: TaskparamControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface TaskparamControl extends AbstractControl {
    public TaskparamVO doCreate(TaskparamVO vo, User user)
        throws Exception;

    public void doRemove(TaskparamVO vo, User user)
        throws Exception;

    public TaskparamVO doUpdate(TaskparamVO vo, User user)
        throws Exception;

    public TaskparamVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(TaskparamListVO params, User user)
        throws Exception;

}
