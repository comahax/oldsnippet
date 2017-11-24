/**
* auto-generated code
* Tue Apr 10 11:19:35 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.pwdictparam;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamVO;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamListVO;
import com.sunrise.boss.business.cms.reward.pwdictparam.control.PwDictparamControlBean;
import com.sunrise.boss.business.cms.reward.pwdictparam.control.PwDictparamControl;

import java.io.Serializable;

/**
 * <p>Title: PwDictparamDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class PwDictparamDelegate {

    private static PwDictparamControl control;

    public PwDictparamDelegate() throws Exception {
        control = (PwDictparamControl) ControlFactory.build(PwDictparamControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public PwDictparamVO doCreate(PwDictparamVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(PwDictparamVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public PwDictparamVO doUpdate(PwDictparamVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public PwDictparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (PwDictparamVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(PwDictparamListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
