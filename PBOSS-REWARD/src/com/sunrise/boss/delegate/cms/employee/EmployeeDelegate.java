/**
 * auto-generated code Sun Aug 27 13:31:54 CST 2006
 */
package com.sunrise.boss.delegate.cms.employee;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.employee.control.EmployeeControl;
import com.sunrise.boss.business.cms.employee.control.EmployeeControlBean;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: EmployeeDelegate
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
public class EmployeeDelegate {

	private static EmployeeControl control;

	public EmployeeDelegate() throws Exception {
		control = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public EmployeeVO doCreate(EmployeeVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(EmployeeVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public EmployeeVO doUpdate(EmployeeVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public EmployeeVO doFindByPk(Serializable pk, User user) throws Exception {
		return (EmployeeVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(EmployeeListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public EmployeeVO doFindByOprcode(String oprcode, User user)
			throws Exception {
		return control.doFindByOprcode(oprcode, user);
	}

	public DataPackage getSelectEmployee(List groupoprList,
			EmployeeListVO params, User user) throws Exception {
		return control.getSelectEmployee(groupoprList, params, user);
	}

	// 社会渠道人员信息查询
	public DataPackage doSocietyEmployeeQuery(EmployeeListVO params, User user)
			throws Exception {
		return control.doSocietyEmployeeQuery(params, user);
	}

	// 社会渠道人员信息批量导入
	public EmployeeVO doSocietyBatchCreate(EmployeeVO vo, User user)
			throws Exception {
		return control.doSocietyBatchCreate(vo, user);
	}

	// 移动渠道人员信息批量导入
	public EmployeeVO doDitchBatchCreate(EmployeeVO vo, User user)
			throws Exception {
		return control.doDitchBatchCreate(vo, user);
	}

	// 移动渠道人员信息修改，检查渠道是否是当前渠道的下属渠道
	public EmployeeVO doDitchupdate(EmployeeVO vo, User user) throws Exception {
		return control.doDitchupdate(vo, user);
	}

	// 增加移动渠道人员信息，检查渠道是否是当前渠道的下属渠道
	public EmployeeVO doDitchcreate(EmployeeVO vo, User user) throws Exception {
		return control.doDitchcreate(vo, user);
	}

	/*
	 * 得到当前渠道的上级实体渠道
	 */
	public DataPackage doUpperwayid(String basewayid, String wayid, User user)
			throws Exception {
		return control.doUpperwayid(basewayid, wayid, user);
	}

	// 移动渠道服务厅人员信息查询
	public DataPackage doServerhallEmployeeQuery(EmployeeListVO params,
			User user) throws Exception {
		return control.doServerhallEmployeeQuery(params, user);
	}

	// 移动渠道渠道经理信息查询
	public DataPackage doDitchmgrEmployeeQuery(EmployeeListVO params, User user)
			throws Exception {
		return control.doDitchmgrEmployeeQuery(params, user);
	}

	/*
	 * 生成人员编号
	 */

	public String getEmployeeid(User user) throws Exception {
		return control.getEmployeeid(user);
	}

	/*
	 * 新增社会渠道人员
	 */
	public EmployeeVO doSocietycreate(EmployeeVO vo, User user)
			throws Exception {
		return control.doSocietycreate(vo, user);
	}

	public EmployeeVO doUpdate2(EmployeeVO vo, User user) throws Exception {
		return control.doUpdate2(vo, user);
	}

	public boolean jdugeIsNet(String wayid, User user) throws Exception {
		return control.jdugeIsNet(wayid, user);
	}
	
	/**
	 * 查询省级人员信息
	 */
	public DataPackage doWayproemployeeQuery(EmployeeListVO listvo, User user) throws Exception {
		return control.doWayproemployeeQuery(listvo, user);
	}
	/**
	 * 判断是否需要二次确认
	 * @return
	 * @throws Exception
	 */
	public boolean  doMessage(EmployeeVO empVO,User user,String operate)  throws Exception{
		return control.doMessage(empVO, user, operate);
	}
	
	public boolean doMessage(User user) throws Exception {
		return control.doMessage(user);
	}
	/**
	 * 插二次确认表
	 */
	public EmpconfirmVO doConfirm(EmployeeVO empVO,User user,String operate) throws Exception{
		return control.doConfirm(empVO, user,operate);
	}
	
	/**
	 * 省级专员更新
	 */
	public EmployeeVO doUpdateWaypro(EmployeeVO empVO, User user)
	throws Exception {
		return control.doUpdateWaypro(empVO, user);
	}
	/**
	 * 省级专员新增
	 */
	public EmployeeVO doCreateWaypro(EmployeeVO empVO, User user)
	throws Exception {
		return control.doCreateWaypro(empVO, user);
	}
	
	// 根据公务机号码查询
	public DataPackage mobileEmployeeQuery(EmployeeListVO params,User user)	throws Exception{
		return control.mobileEmployeeQuery(params, user);
	}
	// 根据公务机号码查询
	public boolean mobileEmployeeQuery(String officetel,User user) throws Exception{
		return control.mobileEmployeeQuery(officetel, user);
	}
}
