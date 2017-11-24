/**
* auto-generated code
* Tue Aug 21 10:45:16 CST 2012
*/
package com.sunrise.boss.delegate.cms.kdkhzl.chpwbroadaccount;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountListVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.control.ChPwBroadaccountControlBean;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.control.ChPwBroadaccountControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwBroadaccountDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwBroadaccountDelegate {

    private static ChPwBroadaccountControl control;

    public ChPwBroadaccountDelegate() throws Exception {
        control = (ChPwBroadaccountControl) ControlFactory.build(ChPwBroadaccountControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwBroadaccountVO doCreate(ChPwBroadaccountVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwBroadaccountVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwBroadaccountVO doUpdate(ChPwBroadaccountVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwBroadaccountVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwBroadaccountVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwBroadaccountListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
