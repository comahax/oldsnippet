/**
* auto-generated code
* Sat Oct 21 10:43:42 CST 2006
*/
package com.sunrise.boss.delegate.rightmanage.operright;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightVO;
import com.sunrise.boss.business.rightmanage.operright.control.OperrightControlBean;
import com.sunrise.boss.business.rightmanage.operright.control.OperrightControl;

import java.io.Serializable;

/**
 * <p>Title: OperrightDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperrightDelegate {

    private static OperrightControl control;

    public OperrightDelegate() throws Exception {
        control = (OperrightControl) ControlFactory.build(OperrightControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public OperrightVO doCreate(OperrightVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(OperrightVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public OperrightVO doUpdate(OperrightVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public OperrightVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (OperrightVO) control.doFindByPk(pk, user);
    }
    public void doBatchin(OperrightVO vo,User user)throws Exception{
    	control.doBatchin(vo, user);
    }
}
