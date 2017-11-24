/**
* auto-generated code
* Sat Jan 12 11:20:42 CST 2013
*/
package com.sunrise.boss.delegate.cms.chpwwaybusicirclelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogVO;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogListVO;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.control.ChPwWaybusicirclelogControlBean;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.control.ChPwWaybusicirclelogControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwWaybusicirclelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwWaybusicirclelogDelegate {

    private static ChPwWaybusicirclelogControl control;

    public ChPwWaybusicirclelogDelegate() throws Exception {
        control = (ChPwWaybusicirclelogControl) ControlFactory.build(ChPwWaybusicirclelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwWaybusicirclelogVO doCreate(ChPwWaybusicirclelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwWaybusicirclelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwWaybusicirclelogVO doUpdate(ChPwWaybusicirclelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwWaybusicirclelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwWaybusicirclelogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwWaybusicirclelogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
