/**
 * auto-generated code
 * Mon Nov 23 16:50:43 CST 2009
 */
package com.gmcc.pboss.control.channel.employeeapplylog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogDBParam;
import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Employeeapplylog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Employeeapplylog extends AbstractControl {
    public EmployeeapplylogVO doCreate(EmployeeapplylogVO vo) throws Exception;

    public void doRemoveByVO(EmployeeapplylogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmployeeapplylogVO doUpdate(EmployeeapplylogVO vo) throws Exception;

    public EmployeeapplylogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmployeeapplylogDBParam params) throws Exception;

}
