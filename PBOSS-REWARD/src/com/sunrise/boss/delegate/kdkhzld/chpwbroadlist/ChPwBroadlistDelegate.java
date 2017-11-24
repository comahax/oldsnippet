/**
* auto-generated code
* Tue Sep 18 14:59:25 CST 2012
*/
package com.sunrise.boss.delegate.kdkhzld.chpwbroadlist;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistListVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.control.ChPwBroadlistControlBean;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.control.ChPwBroadlistControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwBroadlistDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwBroadlistDelegate {

    private static ChPwBroadlistControl control;

    public ChPwBroadlistDelegate() throws Exception {
        control = (ChPwBroadlistControl) ControlFactory.build(ChPwBroadlistControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwBroadlistVO doCreate(ChPwBroadlistVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwBroadlistVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwBroadlistVO doUpdate(ChPwBroadlistVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwBroadlistVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwBroadlistVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwBroadlistListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
