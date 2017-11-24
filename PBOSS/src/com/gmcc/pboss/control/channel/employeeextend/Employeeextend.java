/**
 * auto-generated code
 * Thu Feb 17 11:53:25 CST 2011
 */
package com.gmcc.pboss.control.channel.employeeextend;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendDBParam;
import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Employeeextend </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Employeeextend extends AbstractControl {
    public EmployeeextendVO doCreate(EmployeeextendVO vo) throws Exception;

    public void doRemoveByVO(EmployeeextendVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmployeeextendVO doUpdate(EmployeeextendVO vo) throws Exception;

    public EmployeeextendVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmployeeextendDBParam params) throws Exception;

}
