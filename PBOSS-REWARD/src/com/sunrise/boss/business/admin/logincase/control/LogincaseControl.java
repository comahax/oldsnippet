/**
* auto-generated code
* Mon Apr 30 16:49:59 CST 2007
*/
package com.sunrise.boss.business.admin.logincase.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseVO;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseListVO;

import java.io.Serializable;

/**
 * <p>Title: LogincaseControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface LogincaseControl extends AbstractControl {
    public LogincaseVO doCreate(LogincaseVO vo, User user)
        throws Exception;

    public void doRemove(LogincaseVO vo, User user)
        throws Exception;

    public LogincaseVO doUpdate(LogincaseVO vo, User user)
        throws Exception;

    public LogincaseVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(LogincaseListVO params, User user)
        throws Exception;

}
