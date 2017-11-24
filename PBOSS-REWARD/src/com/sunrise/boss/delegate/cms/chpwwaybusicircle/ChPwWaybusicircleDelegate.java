/**
* auto-generated code
* Sat Jan 12 11:13:01 CST 2013
*/
package com.sunrise.boss.delegate.cms.chpwwaybusicircle;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleVO;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleListVO;
import com.sunrise.boss.business.cms.chpwwaybusicircle.control.ChPwWaybusicircleControlBean;
import com.sunrise.boss.business.cms.chpwwaybusicircle.control.ChPwWaybusicircleControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwWaybusicircleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwWaybusicircleDelegate {

    private static ChPwWaybusicircleControl control;

    public ChPwWaybusicircleDelegate() throws Exception {
        control = (ChPwWaybusicircleControl) ControlFactory.build(ChPwWaybusicircleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwWaybusicircleVO doCreate(ChPwWaybusicircleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwWaybusicircleVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwWaybusicircleVO doUpdate(ChPwWaybusicircleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwWaybusicircleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwWaybusicircleVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwWaybusicircleListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
