/**
* auto-generated code
* Mon Feb 21 10:37:21 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.registersimcnt;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntVO;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntListVO;
import com.sunrise.boss.business.cms.reward.registersimcnt.control.RegistersimcntControlBean;
import com.sunrise.boss.business.cms.reward.registersimcnt.control.RegistersimcntControl;

import java.io.Serializable;

/**
 * <p>Title: RegistersimcntDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RegistersimcntDelegate {

    private static RegistersimcntControl control;

    public RegistersimcntDelegate() throws Exception {
        control = (RegistersimcntControl) ControlFactory.build(RegistersimcntControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RegistersimcntVO doCreate(RegistersimcntVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RegistersimcntVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RegistersimcntVO doUpdate(RegistersimcntVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RegistersimcntVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RegistersimcntVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RegistersimcntListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
