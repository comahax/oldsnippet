/**
* auto-generated code
* Mon Jun 29 11:25:27 CST 2009
*/
package com.sunrise.boss.delegate.cms.nasrwdtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalVO;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalListVO;
import com.sunrise.boss.business.cms.nasrwdtotal.control.NasrwdtotalControlBean;
import com.sunrise.boss.business.cms.nasrwdtotal.control.NasrwdtotalControl;

import java.io.Serializable;

/**
 * <p>Title: NasrwdtotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class NasrwdtotalDelegate {

    private static NasrwdtotalControl control;

    public NasrwdtotalDelegate() throws Exception {
        control = (NasrwdtotalControl) ControlFactory.build(NasrwdtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public NasrwdtotalVO doCreate(NasrwdtotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(NasrwdtotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public NasrwdtotalVO doUpdate(NasrwdtotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public NasrwdtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (NasrwdtotalVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(NasrwdtotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
