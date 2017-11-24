/**
 * auto-generated code Wed Oct 18 16:14:47 CST 2006
 */
package com.sunrise.boss.delegate.cms.employeelog;

import java.io.Serializable;

import com.sunrise.boss.business.cms.employeelog.control.EmployeelogControl;
import com.sunrise.boss.business.cms.employeelog.control.EmployeelogControlBean;
import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogListVO;
import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: EmployeelogDelegate
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
public class EmployeelogDelegate {

	private static EmployeelogControl control;

	public EmployeelogDelegate() throws Exception {
		control = (EmployeelogControl) ControlFactory
				.build(EmployeelogControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public EmployeelogVO doCreate(EmployeelogVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(EmployeelogVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public EmployeelogVO doUpdate(EmployeelogVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public EmployeelogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (EmployeelogVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(EmployeelogListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage doSocietyEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception {
		return control.doSocietyEmployeeLogQuery(params, user);
	}

	// 移动渠道服务厅人员日志查询
	public DataPackage doServerhallEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception {
		return control.doServerhallEmployeeLogQuery(params, user);
	}

	// 移动渠道渠道经理日志查询
	public DataPackage doDitchmgrEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception {
		return control.doDitchmgrEmployeeLogQuery(params, user);
	}
}
