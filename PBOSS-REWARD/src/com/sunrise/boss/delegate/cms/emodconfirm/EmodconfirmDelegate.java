/**
* auto-generated code
* Thu Mar 03 20:02:58 CST 2011
*/
package com.sunrise.boss.delegate.cms.emodconfirm;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmVO;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmListVO;
import com.sunrise.boss.business.cms.emodconfirm.control.EmodconfirmControlBean;
import com.sunrise.boss.business.cms.emodconfirm.control.EmodconfirmControl;

import java.io.Serializable;

/**
 * <p>Title: EmodconfirmDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class EmodconfirmDelegate {

    private static EmodconfirmControl control;

    public EmodconfirmDelegate() throws Exception {
        control = (EmodconfirmControl) ControlFactory.build(EmodconfirmControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public EmodconfirmVO doCreate(EmodconfirmVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(EmodconfirmVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public EmodconfirmVO doUpdate(EmodconfirmVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public EmodconfirmVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (EmodconfirmVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(EmodconfirmListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
