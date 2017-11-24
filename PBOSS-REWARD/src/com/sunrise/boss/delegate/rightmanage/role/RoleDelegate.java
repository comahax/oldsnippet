/**
* auto-generated code
* Sat Oct 21 10:39:48 CST 2006
*/
package com.sunrise.boss.delegate.rightmanage.role;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleListVO;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleVO;
import com.sunrise.boss.business.rightmanage.role.control.RoleControlBean;
import com.sunrise.boss.business.rightmanage.role.control.RoleControl;

import java.io.Serializable;

/**
 * <p>Title: RoleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RoleDelegate {

    private static RoleControl control;

    public RoleDelegate() throws Exception {
        control = (RoleControl) ControlFactory.build(RoleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RoleVO doCreate(RoleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RoleVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public RoleVO doUpdate(RoleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RoleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RoleVO) control.doFindByPk(pk, user);
    }
    
    public DataPackage doQuery(RoleListVO params, User user) throws Exception{
    	return control.doQuery(params, user);
    }
    
}
