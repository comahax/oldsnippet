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

	// ���������Ա��Ϣ��ѯ
	public DataPackage doSocietyEmployeeQuery(EmployeeListVO params, User user)
			throws Exception {
		return control.doSocietyEmployeeQuery(params, user);
	}

	// ���������Ա��Ϣ��������
	public EmployeeVO doSocietyBatchCreate(EmployeeVO vo, User user)
			throws Exception {
		return control.doSocietyBatchCreate(vo, user);
	}

	// �ƶ�������Ա��Ϣ��������
	public EmployeeVO doDitchBatchCreate(EmployeeVO vo, User user)
			throws Exception {
		return control.doDitchBatchCreate(vo, user);
	}

	// �ƶ�������Ա��Ϣ�޸ģ���������Ƿ��ǵ�ǰ��������������
	public EmployeeVO doDitchupdate(EmployeeVO vo, User user) throws Exception {
		return control.doDitchupdate(vo, user);
	}

	// �����ƶ�������Ա��Ϣ����������Ƿ��ǵ�ǰ��������������
	public EmployeeVO doDitchcreate(EmployeeVO vo, User user) throws Exception {
		return control.doDitchcreate(vo, user);
	}

	/*
	 * �õ���ǰ�������ϼ�ʵ������
	 */
	public DataPackage doUpperwayid(String basewayid, String wayid, User user)
			throws Exception {
		return control.doUpperwayid(basewayid, wayid, user);
	}

	// �ƶ�������������Ա��Ϣ��ѯ
	public DataPackage doServerhallEmployeeQuery(EmployeeListVO params,
			User user) throws Exception {
		return control.doServerhallEmployeeQuery(params, user);
	}

	// �ƶ���������������Ϣ��ѯ
	public DataPackage doDitchmgrEmployeeQuery(EmployeeListVO params, User user)
			throws Exception {
		return control.doDitchmgrEmployeeQuery(params, user);
	}

	/*
	 * ������Ա���
	 */

	public String getEmployeeid(User user) throws Exception {
		return control.getEmployeeid(user);
	}

	/*
	 * �������������Ա
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
	 * ��ѯʡ����Ա��Ϣ
	 */
	public DataPackage doWayproemployeeQuery(EmployeeListVO listvo, User user) throws Exception {
		return control.doWayproemployeeQuery(listvo, user);
	}
	/**
	 * �ж��Ƿ���Ҫ����ȷ��
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
	 * �����ȷ�ϱ�
	 */
	public EmpconfirmVO doConfirm(EmployeeVO empVO,User user,String operate) throws Exception{
		return control.doConfirm(empVO, user,operate);
	}
	
	/**
	 * ʡ��רԱ����
	 */
	public EmployeeVO doUpdateWaypro(EmployeeVO empVO, User user)
	throws Exception {
		return control.doUpdateWaypro(empVO, user);
	}
	/**
	 * ʡ��רԱ����
	 */
	public EmployeeVO doCreateWaypro(EmployeeVO empVO, User user)
	throws Exception {
		return control.doCreateWaypro(empVO, user);
	}
	
	// ���ݹ���������ѯ
	public DataPackage mobileEmployeeQuery(EmployeeListVO params,User user)	throws Exception{
		return control.mobileEmployeeQuery(params, user);
	}
	// ���ݹ���������ѯ
	public boolean mobileEmployeeQuery(String officetel,User user) throws Exception{
		return control.mobileEmployeeQuery(officetel, user);
	}
}
