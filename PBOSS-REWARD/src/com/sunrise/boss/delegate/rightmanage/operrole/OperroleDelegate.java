/**
* auto-generated code
* Sat Oct 21 10:38:27 CST 2006
*/
package com.sunrise.boss.delegate.rightmanage.operrole;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;
import com.sunrise.boss.business.rightmanage.operrole.control.OperroleControlBean;
import com.sunrise.boss.business.rightmanage.operrole.control.OperroleControl;

import java.io.Serializable;

/**
 * <p>Title: OperroleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperroleDelegate {

    private static OperroleControl control;

    public OperroleDelegate() throws Exception {
        control = (OperroleControl) ControlFactory.build(OperroleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public OperroleVO doCreate(OperroleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(OperroleVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public OperroleVO doUpdate(OperroleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public OperroleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (OperroleVO) control.doFindByPk(pk, user);
    }
    public void doBatchin(OperroleVO vo,User user)throws Exception{
    	control.doBatchin(vo, user);
    }
}
