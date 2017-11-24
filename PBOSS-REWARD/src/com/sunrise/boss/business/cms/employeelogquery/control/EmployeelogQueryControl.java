/**
* auto-generated code
* Mon Feb 21 11:05:09 CST 2011
*/
package com.sunrise.boss.business.cms.employeelogquery.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryVO;
import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryListVO;

import java.io.Serializable;

/**
 * <p>Title: EmployeelogQueryControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface EmployeelogQueryControl extends AbstractControl {
    public EmployeelogQueryVO doCreate(EmployeelogQueryVO vo, User user)
        throws Exception;

    public void doRemove(EmployeelogQueryVO vo, User user)
        throws Exception;

    public EmployeelogQueryVO doUpdate(EmployeelogQueryVO vo, User user)
        throws Exception;

    public EmployeelogQueryVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(EmployeelogQueryListVO params, User user)
        throws Exception;

}
