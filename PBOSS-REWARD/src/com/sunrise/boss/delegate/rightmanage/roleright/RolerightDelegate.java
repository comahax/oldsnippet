/**
* auto-generated code
* Sat Oct 21 10:41:08 CST 2006
*/
package com.sunrise.boss.delegate.rightmanage.roleright;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightVO;
import com.sunrise.boss.business.rightmanage.roleright.control.RolerightControlBean;
import com.sunrise.boss.business.rightmanage.roleright.control.RolerightControl;

import java.io.Serializable;

/**
 * <p>Title: RolerightDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RolerightDelegate {

    private static RolerightControl control;

    public RolerightDelegate() throws Exception {
        control = (RolerightControl) ControlFactory.build(RolerightControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RolerightVO doCreate(RolerightVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RolerightVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public RolerightVO doUpdate(RolerightVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RolerightVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RolerightVO) control.doFindByPk(pk, user);
    }
    public void doBatchin(RolerightVO vo,User user)throws Exception{
    		control.doBatchin(vo, user);
    }
}
