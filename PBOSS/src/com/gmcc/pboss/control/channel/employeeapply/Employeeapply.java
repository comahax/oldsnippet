/**
 * auto-generated code
 * Tue Oct 20 15:53:36 CST 2009
 */
package com.gmcc.pboss.control.channel.employeeapply;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyDBParam;
import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Employeeapply
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
 * @author Jerimy
 * @version 1.0
 */
public interface Employeeapply extends AbstractControl {
	public EmployeeapplyVO doCreate(EmployeeapplyVO vo) throws Exception;

	public void doRemoveByVO(EmployeeapplyVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public EmployeeapplyVO doUpdate(EmployeeapplyVO vo) throws Exception;

	/**
	 * 店员审批管理之保存
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public EmployeeapplyVO doSave(EmployeeapplyVO vo) throws Exception;

	/**
	 * 店员审批管理之取消
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public EmployeeapplyVO doCancel(EmployeeapplyVO vo,boolean isTask,Long rvcobjid) throws Exception;

	/**
	 * 店员审批管理之通过
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public EmployeeapplyVO doPass(EmployeeapplyVO vo,boolean isTask,Long rvcobjid) throws Exception;

	public EmployeeapplyVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(EmployeeapplyDBParam params) throws Exception;

}
