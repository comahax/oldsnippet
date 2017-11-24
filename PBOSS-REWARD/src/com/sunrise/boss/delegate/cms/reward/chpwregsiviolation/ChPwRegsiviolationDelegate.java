/**
* auto-generated code
* Fri Oct 18 14:59:15 CST 2013
*/
package com.sunrise.boss.delegate.cms.reward.chpwregsiviolation;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationVO;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationListVO;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.control.ChPwRegsiviolationControlBean;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.control.ChPwRegsiviolationControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwRegsiviolationDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwRegsiviolationDelegate {

    private static ChPwRegsiviolationControl control;

    public ChPwRegsiviolationDelegate() throws Exception {
        control = (ChPwRegsiviolationControl) ControlFactory.build(ChPwRegsiviolationControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwRegsiviolationVO doCreate(ChPwRegsiviolationVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwRegsiviolationVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwRegsiviolationVO doUpdate(ChPwRegsiviolationVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwRegsiviolationVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwRegsiviolationVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwRegsiviolationListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
