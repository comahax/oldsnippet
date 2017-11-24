/**
* auto-generated code
* Tue May 01 15:19:39 CST 2007
*/
package com.sunrise.boss.business.cms.operationlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogVO;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogListVO;

import java.io.Serializable;

/**
 * <p>Title: OperationlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface OperationlogControl extends AbstractControl {
    public OperationlogVO doCreate(OperationlogVO vo, User user)
        throws Exception;

    public void doRemove(OperationlogVO vo, User user)
        throws Exception;

    public OperationlogVO doUpdate(OperationlogVO vo, User user)
        throws Exception;

    public OperationlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(OperationlogListVO params, User user)
        throws Exception;

}
