/**
* auto-generated code
* Mon Feb 21 11:05:09 CST 2011
*/
package com.sunrise.boss.delegate.cms.employeelogquery;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryVO;
import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryListVO;
import com.sunrise.boss.business.cms.employeelogquery.control.EmployeelogQueryControlBean;
import com.sunrise.boss.business.cms.employeelogquery.control.EmployeelogQueryControl;

import java.io.Serializable;

/**
 * <p>Title: EmployeelogQueryDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class EmployeelogQueryDelegate {

    private static EmployeelogQueryControl control;

    public EmployeelogQueryDelegate() throws Exception {
        control = (EmployeelogQueryControl) ControlFactory.build(EmployeelogQueryControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public EmployeelogQueryVO doCreate(EmployeelogQueryVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(EmployeelogQueryVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public EmployeelogQueryVO doUpdate(EmployeelogQueryVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public EmployeelogQueryVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (EmployeelogQueryVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(EmployeelogQueryListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
