/**
* auto-generated code
* Mon Jan 07 15:42:21 CST 2008
*/
package com.sunrise.boss.delegate.resmanage.taskfile;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileVO;
import com.sunrise.boss.business.resmanage.taskfile.control.TaskfileControlBean;
import com.sunrise.boss.business.resmanage.taskfile.control.TaskfileControl;

import java.io.Serializable;

/**
 * <p>Title: TaskfileDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author David
 * @version 1.0
 */
public class TaskfileDelegate {

    private static TaskfileControl control;

    public TaskfileDelegate() throws Exception {
        control = (TaskfileControl) ControlFactory.build(TaskfileControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public TaskfileVO doCreate(TaskfileVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(TaskfileVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public TaskfileVO doUpdate(TaskfileVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public TaskfileVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (TaskfileVO) control.doFindByPk(pk, user);
    }
}
