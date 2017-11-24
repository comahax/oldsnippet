/**
* auto-generated code
* Mon Jan 07 11:02:50 CST 2008
*/
package com.sunrise.boss.business.resmanage.taskfile.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileVO;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileListVO;

import java.io.Serializable;

/**
 * <p>Title: TaskfileControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author David
 * @version 1.0
 */
public interface TaskfileControl extends AbstractControl {
    public TaskfileVO doCreate(TaskfileVO vo, User user)
        throws Exception;

    public void doRemove(TaskfileVO vo, User user)
        throws Exception;

    public TaskfileVO doUpdate(TaskfileVO vo, User user)
        throws Exception;

    public TaskfileVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(TaskfileListVO params, User user)
        throws Exception;

}
