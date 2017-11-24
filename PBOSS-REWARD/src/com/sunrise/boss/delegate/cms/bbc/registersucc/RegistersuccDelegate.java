/**
* auto-generated code
* Fri Dec 09 10:02:24 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.registersucc;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccVO;
import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccListVO;
import com.sunrise.boss.business.cms.bbc.registersucc.control.RegistersuccControlBean;
import com.sunrise.boss.business.cms.bbc.registersucc.control.RegistersuccControl;

import java.io.Serializable;

/**
 * <p>Title: RegistersuccDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegistersuccDelegate {

    private static RegistersuccControl control;

    public RegistersuccDelegate() throws Exception {
        control = (RegistersuccControl) ControlFactory.build(RegistersuccControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RegistersuccVO doCreate(RegistersuccVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RegistersuccVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RegistersuccVO doUpdate(RegistersuccVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RegistersuccVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RegistersuccVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RegistersuccListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
