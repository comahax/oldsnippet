/**
* auto-generated code
* Tue Aug 21 10:43:23 CST 2012
*/
package com.sunrise.boss.delegate.cms.kdkhzl.chpwregisterbroad;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadListVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.control.ChPwRegisterbroadControlBean;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.control.ChPwRegisterbroadControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwRegisterbroadDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwRegisterbroadDelegate {

    private static ChPwRegisterbroadControl control;

    public ChPwRegisterbroadDelegate() throws Exception {
        control = (ChPwRegisterbroadControl) ControlFactory.build(ChPwRegisterbroadControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwRegisterbroadVO doCreate(ChPwRegisterbroadVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwRegisterbroadVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwRegisterbroadVO doUpdate(ChPwRegisterbroadVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwRegisterbroadVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwRegisterbroadVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwRegisterbroadListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
