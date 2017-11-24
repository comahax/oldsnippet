/**
* auto-generated code
* Thu Nov 19 11:08:41 CST 2009
*/
package com.sunrise.boss.delegate.cms.empmodel;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;
import com.sunrise.boss.business.cms.empmodel.control.EmpmodelControlBean;
import com.sunrise.boss.business.cms.empmodel.control.EmpmodelControl;

import java.io.Serializable;

/**
 * <p>Title: EmpmodelDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class EmpmodelDelegate {

    private static EmpmodelControl control;

    public EmpmodelDelegate() throws Exception {
        control = (EmpmodelControl) ControlFactory.build(EmpmodelControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public EmpmodelVO doCreate(EmpmodelVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(EmpmodelVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public EmpmodelVO doUpdate(EmpmodelVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public EmpmodelVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (EmpmodelVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(EmpmodelListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
