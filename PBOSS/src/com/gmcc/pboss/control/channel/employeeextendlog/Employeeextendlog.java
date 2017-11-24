/**
 * auto-generated code
 * Thu Feb 17 11:55:20 CST 2011
 */
package com.gmcc.pboss.control.channel.employeeextendlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogDBParam;
import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Employeeextendlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Employeeextendlog extends AbstractControl {
    public EmployeeextendlogVO doCreate(EmployeeextendlogVO vo) throws Exception;

    public void doRemoveByVO(EmployeeextendlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmployeeextendlogVO doUpdate(EmployeeextendlogVO vo) throws Exception;

    public EmployeeextendlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmployeeextendlogDBParam params) throws Exception;

}
