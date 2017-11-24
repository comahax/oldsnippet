/**
* auto-generated code
* Tue Jun 21 10:33:15 GMT 2011
*/
package com.sunrise.boss.delegate.cms.registersim;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimVO;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimListVO;
import com.sunrise.boss.business.cms.registersim.control.RegistersimControlBean;
import com.sunrise.boss.business.cms.registersim.control.RegistersimControl;

import java.io.Serializable;

/**
 * <p>Title: RegistersimDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class RegistersimDelegate {

    private static RegistersimControl control;

    public RegistersimDelegate() throws Exception {
        control = (RegistersimControl) ControlFactory.build(RegistersimControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RegistersimVO doCreate(RegistersimVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RegistersimVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RegistersimVO doUpdate(RegistersimVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RegistersimVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RegistersimVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RegistersimListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
