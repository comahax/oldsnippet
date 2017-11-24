/**
* auto-generated code
* Tue Sep 18 15:04:18 CST 2012
*/
package com.sunrise.boss.delegate.kdkhzld.chpwbroadlistlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogListVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.control.ChPwBroadlistlogControlBean;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.control.ChPwBroadlistlogControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwBroadlistlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwBroadlistlogDelegate {

    private static ChPwBroadlistlogControl control;

    public ChPwBroadlistlogDelegate() throws Exception {
        control = (ChPwBroadlistlogControl) ControlFactory.build(ChPwBroadlistlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwBroadlistlogVO doCreate(ChPwBroadlistlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwBroadlistlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwBroadlistlogVO doUpdate(ChPwBroadlistlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwBroadlistlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwBroadlistlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwBroadlistlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
