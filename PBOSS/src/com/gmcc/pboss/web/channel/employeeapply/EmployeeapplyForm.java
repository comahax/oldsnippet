/**
 * auto-generated code
 * Tue Oct 20 15:53:37 CST 2009
 */
package com.gmcc.pboss.web.channel.employeeapply;

import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyVO;

/**
 * <p>Title: EmployeeapplyForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeapplyForm extends EmployeeapplyVO {
	private String worktype;//������
	
	//	modify for ���������Ա����������ͱ༭���� ���ӹ���ģʽѡ���� 
	//  by zhangsiwei
	/**��Ӧ ��Ա����ģʽ��(ch_pw_empmodel) ��������ʶ EMPMODELID*/
	private Long empmodelid;
	/**��Ӧ ��Ա����ģʽ��(ch_pw_empmodel) ��ģʽ��ʶ(model)�ֶ�*/
	private String model;
	/**��Ӧ ��Ա����ģʽ��(ch_pw_empmodel) ��״̬(state)�ֶ�*/
	private Short modelState;

	public String getWorktype() {
		return worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

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
}
