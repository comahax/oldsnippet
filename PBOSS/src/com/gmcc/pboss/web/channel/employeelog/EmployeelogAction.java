/**
 * auto-generated code
 * Wed Oct 07 16:55:22 CST 2009
 */
package com.gmcc.pboss.web.channel.employeelog;

import com.gmcc.pboss.business.channel.employeelog.EmployeelogDBParam;
import com.gmcc.pboss.business.channel.employeelog.EmployeelogVO;
import com.gmcc.pboss.control.channel.employeelog.Employeelog;
import com.gmcc.pboss.control.channel.employeelog.EmployeelogBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: EmployeelogAction
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
public class EmployeelogAction extends BaseAction {
	private String employeeType;

	public EmployeelogAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new EmployeelogForm());
		this.setParam(new EmployeelogWebParam());

		// ָ��VO��
		setClsVO(EmployeelogVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "logid" };
		this.setClsControl(Employeelog.class);
		this.setClsQueryParam(EmployeelogDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	
	/*  
	 * ���������Ա�����ѯ
	 */
	public String doList() throws Exception{
		DataPackage dp = null;
		try{
			EmployeelogWebParam params = (EmployeelogWebParam) getParam();
			params.set_se_waytype("AG");
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
		}catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	/**
	 * ����������־��ѯ
	 * @return
	 * @throws Exception
	 */
	public String doListmg() throws Exception {
		DataPackage dp = null;
		try {
			EmployeelogWebParam params = (EmployeelogWebParam) getParam();
			Employeelog employeelog = (Employeelog) BOFactory.build(
					EmployeelogBO.class, getDBAccessUser());
//			params.set_se_posittype("1");
			params.set_se_waytype("ET");
			dp = employeelog.doQuery(params);
			setEmployeeType("MG");
		} catch (Exception e) {
			super.addActionError(e.getMessage());
		}
		setDp(dp);
		return "listmg";
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
}