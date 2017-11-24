/**
* auto-generated code
* Thu Mar 03 11:37:46 CST 2011
*/
package com.sunrise.boss.delegate.cms.empconfirm;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmListVO;
import com.sunrise.boss.business.cms.empconfirm.control.EmpconfirmControlBean;
import com.sunrise.boss.business.cms.empconfirm.control.EmpconfirmControl;

import java.io.Serializable;

/**
 * <p>Title: EmpconfirmDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class EmpconfirmDelegate {

    private static EmpconfirmControl control;

    public EmpconfirmDelegate() throws Exception {
        control = (EmpconfirmControl) ControlFactory.build(EmpconfirmControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public EmpconfirmVO doCreate(EmpconfirmVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(EmpconfirmVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public EmpconfirmVO doUpdate(EmpconfirmVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public EmpconfirmVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (EmpconfirmVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(EmpconfirmListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
