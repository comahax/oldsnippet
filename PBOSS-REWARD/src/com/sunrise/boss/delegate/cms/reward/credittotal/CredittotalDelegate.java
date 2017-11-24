/**
* auto-generated code
* Tue May 17 18:38:00 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.credittotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalVO;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalListVO;
import com.sunrise.boss.business.cms.reward.credittotal.control.CredittotalControlBean;
import com.sunrise.boss.business.cms.reward.credittotal.control.CredittotalControl;

import java.io.Serializable;

/**
 * <p>Title: CredittotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CredittotalDelegate {

    private static CredittotalControl control;

    public CredittotalDelegate() throws Exception {
        control = (CredittotalControl) ControlFactory.build(CredittotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public CredittotalVO doCreate(CredittotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(CredittotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public CredittotalVO doUpdate(CredittotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public CredittotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CredittotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(CredittotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
