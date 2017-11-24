/**
 * auto-generated code
 * Wed Oct 07 16:55:22 CST 2009
 */
package com.gmcc.pboss.control.channel.employeelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeelog.EmployeelogDBParam;
import com.gmcc.pboss.business.channel.employeelog.EmployeelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Employeelog
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author wefrogll
 * @version 1.0
 */
public interface Employeelog extends AbstractControl {
	public EmployeelogVO doCreate(EmployeelogVO vo) throws Exception;

	public void doRemoveByVO(EmployeelogVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public EmployeelogVO doUpdate(EmployeelogVO vo) throws Exception;

	public EmployeelogVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(EmployeelogDBParam params) throws Exception;

	public DataPackage doDitchmgrEmployeeLogQuery(EmployeelogDBParam params)
			throws Exception;

}
