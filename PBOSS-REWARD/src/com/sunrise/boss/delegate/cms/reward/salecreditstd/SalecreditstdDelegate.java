/**
* auto-generated code
* Wed May 18 10:32:19 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.salecreditstd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdVO;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdListVO;
import com.sunrise.boss.business.cms.reward.salecreditstd.control.SalecreditstdControlBean;
import com.sunrise.boss.business.cms.reward.salecreditstd.control.SalecreditstdControl;

import java.io.Serializable;

/**
 * <p>Title: SalecreditstdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditstdDelegate {

    private static SalecreditstdControl control;

    public SalecreditstdDelegate() throws Exception {
        control = (SalecreditstdControl) ControlFactory.build(SalecreditstdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public SalecreditstdVO doCreate(SalecreditstdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(SalecreditstdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public SalecreditstdVO doUpdate(SalecreditstdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public SalecreditstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (SalecreditstdVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(SalecreditstdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
