/**
* auto-generated code
* Fri Dec 09 10:19:02 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.registerfail;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailVO;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailListVO;
import com.sunrise.boss.business.cms.bbc.registerfail.control.RegisterfailControlBean;
import com.sunrise.boss.business.cms.bbc.registerfail.control.RegisterfailControl;

import java.io.Serializable;

/**
 * <p>Title: RegisterfailDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegisterfailDelegate {

    private static RegisterfailControl control;

    public RegisterfailDelegate() throws Exception {
        control = (RegisterfailControl) ControlFactory.build(RegisterfailControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RegisterfailVO doCreate(RegisterfailVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RegisterfailVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RegisterfailVO doUpdate(RegisterfailVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RegisterfailVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RegisterfailVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RegisterfailListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
