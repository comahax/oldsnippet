/**
* auto-generated code
* Thu Dec 13 10:03:21 CST 2007
*/
package com.sunrise.boss.delegate.resmanage.taskparam;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamVO;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamListVO;
import com.sunrise.boss.business.resmanage.taskparam.control.TaskparamControlBean;
import com.sunrise.boss.business.resmanage.taskparam.control.TaskparamControl;

import java.io.Serializable;

/**
 * <p>Title: TaskparamDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class TaskparamDelegate {

    private static TaskparamControl control;

    public TaskparamDelegate() throws Exception {
        control = (TaskparamControl) ControlFactory.build(TaskparamControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public TaskparamVO doCreate(TaskparamVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(TaskparamVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public TaskparamVO doUpdate(TaskparamVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public TaskparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (TaskparamVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(TaskparamListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
