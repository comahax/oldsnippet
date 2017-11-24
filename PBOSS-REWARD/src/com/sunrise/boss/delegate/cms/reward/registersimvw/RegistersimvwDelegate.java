/**
* auto-generated code
* Mon Feb 21 10:20:06 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.registersimvw;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwListVO;
import com.sunrise.boss.business.cms.reward.registersimvw.control.RegistersimvwControlBean;
import com.sunrise.boss.business.cms.reward.registersimvw.control.RegistersimvwControl;

import java.io.Serializable;

/**
 * <p>Title: RegistersimvwDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RegistersimvwDelegate {

    private static RegistersimvwControl control;

    public RegistersimvwDelegate() throws Exception {
        control = (RegistersimvwControl) ControlFactory.build(RegistersimvwControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RegistersimvwVO doCreate(RegistersimvwVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RegistersimvwVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RegistersimvwVO doUpdate(RegistersimvwVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RegistersimvwVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RegistersimvwVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RegistersimvwListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
