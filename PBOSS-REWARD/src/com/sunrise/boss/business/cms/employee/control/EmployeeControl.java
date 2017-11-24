/**
 * auto-generated code Sun Aug 27 13:31:54 CST 2006
 */
package com.sunrise.boss.business.cms.employee.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: EmployeeControl
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
 * @author yjr
 * @version 1.0
 */
public interface EmployeeControl extends AbstractControl {
	public EmployeeVO doCreate(EmployeeVO vo, User user) throws Exception;

	public void doRemove(EmployeeVO vo, User user) throws Exception;

	public EmployeeVO doUpdate(EmployeeVO vo, User user) throws Exception;

	public EmployeeVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(EmployeeListVO params, User user)
			throws Exception;

	public EmployeeVO doFindByOprcode(String oprcode, User user)
			throws Exception;

	public DataPackage getByPostinfo(Long postid, User user) throws Exception;

	public DataPackage doSocietyEmployeeQuery(EmployeeListVO params, User user)
			throws Exception;

	public DataPackage doServerhallEmployeeQuery(EmployeeListVO params,
			User user) throws Exception;

	public DataPackage doDitchmgrEmployeeQuery(EmployeeListVO params, User user)
			throws Exception;

	// 社会渠道人员信息查询
	public DataPackage getSelectEmployee(List groupoprList,
			EmployeeListVO params, User user) throws Exception;

	// 社会渠道人员信息批量导入
	public EmployeeVO doSocietyBatchCreate(EmployeeVO vo, User user)
			throws Exception;

	// 移动渠道人员信息修改，检查渠道是否是当前渠道的下属渠道
	public EmployeeVO doDitchupdate(EmployeeVO vo, User user) throws Exception;

	// 增加移动渠道人员信息，检查渠道是否是当前渠道的下属渠道
	public EmployeeVO doDitchcreate(EmployeeVO vo, User user) throws Exception;

	// 移动渠道人员信息批量导入
	public EmployeeVO doDitchBatchCreate(EmployeeVO vo, User user)
			throws Exception;

	/*
	 * 得到当前渠道的上级实体渠道
	 */
	public DataPackage doUpperwayid(String basewayid, String wayid, User user)
			throws Exception;

	/*
	 * 生成人员编号
	 */
	public String getEmployeeid(User user) throws Exception;

	/*
	 * 新增社会渠道人员
	 */
	public EmployeeVO doSocietycreate(EmployeeVO vo, User user)
			throws Exception;

	public EmployeeVO doUpdate2(EmployeeVO vo, User user) throws Exception;

	public boolean jdugeIsNet(String wayid, User user) throws Exception;

	public DataPackage doWayproemployeeQuery(EmployeeListVO listvo, User user) throws Exception;
	
	//判断是否需要二次确认
	public boolean doMessage(EmployeeVO empVO,User user,String operate) throws Exception ;
	//判断是否需要二次确认
	public boolean doMessage(User user) throws Exception ;
	//
	public EmpconfirmVO doConfirm(EmployeeVO empVO,User user,String operate) throws Exception;
	
	public EmployeeVO doUpdateWaypro(EmployeeVO empVO, User user) throws Exception;

	public EmployeeVO doCreateWaypro(EmployeeVO empVO, User user) throws Exception;
	
	public DataPackage mobileEmployeeQuery(EmployeeListVO params,User user)	throws Exception;
	
	public boolean mobileEmployeeQuery(String officetel,User user) throws Exception;
}
