/**
 * auto-generated code
 * Wed Jul 08 11:39:56 CST 2009
 */
package com.gmcc.pboss.web.channel.employee;

import com.gmcc.pboss.business.channel.employee.EmployeeVO;

/**
 * <p>Title: EmployeeForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeForm extends EmployeeVO {

	//	modify for ���������Ա����������ͱ༭���� ���ӹ���ģʽѡ���� 
	//  by zhangsiwei
	/**��Ӧ ��Ա����ģʽ��(ch_pw_empmodel) ��������ʶ EMPMODELID*/
	private Long empmodelid;
	/**��Ӧ ��Ա����ģʽ��(ch_pw_empmodel) ��ģʽ��ʶ(model)�ֶ�*/
	private String model;
	/**��Ӧ ��Ա����ģʽ��(ch_pw_empmodel) ��״̬(state)�ֶ�*/
	private Short modelState;
	/** ����ID������ */
	private String wayidAndName;
	
	public Long getEmpmodelid() {
		return empmodelid;
	}
	public void setEmpmodelid(Long empmodelid) {
		this.empmodelid = empmodelid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Short getModelState() {
		return modelState;
	}
	public void setModelState(Short modelState) {
		this.modelState = modelState;
	}
	public String getWayidAndName() {
		return wayidAndName;
	}
	public void setWayidAndName(String wayidAndName) {
		this.wayidAndName = wayidAndName;
	}
}
