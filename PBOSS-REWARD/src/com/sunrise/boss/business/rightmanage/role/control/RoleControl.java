/**
* auto-generated code
* Fri Oct 20 22:27:36 CST 2006
*/
package com.sunrise.boss.business.rightmanage.role.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleListVO;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleVO;

import java.io.Serializable;

/**
 * <p>Title: RoleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RoleControl extends AbstractControl {
    public RoleVO doCreate(RoleVO vo, User user)
        throws Exception;

    public void doRemove(RoleVO vo, User user)
        throws Exception;

    public RoleVO doUpdate(RoleVO vo, User user)
        throws Exception;

    public RoleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RoleListVO params, User user)
        throws Exception;

}
