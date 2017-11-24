/**
 * auto-generated code Wed Oct 18 16:14:47 CST 2006
 */
package com.sunrise.boss.business.cms.employeelog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogListVO;
import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: EmployeelogControl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
public interface EmployeelogControl extends AbstractControl {
	public EmployeelogVO doCreate(EmployeelogVO vo, User user) throws Exception;

	public void doRemove(EmployeelogVO vo, User user) throws Exception;

	public EmployeelogVO doUpdate(EmployeelogVO vo, User user) throws Exception;

	public EmployeelogVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(EmployeelogListVO params, User user)
			throws Exception;

	public DataPackage doSocietyEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception;

	public DataPackage doServerhallEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception;

	public DataPackage doDitchmgrEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception;

}
