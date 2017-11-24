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
	private String worktype;//单类型
	
	//	modify for 社会渠道人员管理的新增和编辑界面 增加工作模式选择域 
	//  by zhangsiwei
	/**对应 人员工作模式表(ch_pw_empmodel) 的主键标识 EMPMODELID*/
	private Long empmodelid;
	/**对应 人员工作模式表(ch_pw_empmodel) 的模式标识(model)字段*/
	private String model;
	/**对应 人员工作模式表(ch_pw_empmodel) 的状态(state)字段*/
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
