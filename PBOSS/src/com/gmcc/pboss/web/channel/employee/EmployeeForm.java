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

	//	modify for 社会渠道人员管理的新增和编辑界面 增加工作模式选择域 
	//  by zhangsiwei
	/**对应 人员工作模式表(ch_pw_empmodel) 的主键标识 EMPMODELID*/
	private Long empmodelid;
	/**对应 人员工作模式表(ch_pw_empmodel) 的模式标识(model)字段*/
	private String model;
	/**对应 人员工作模式表(ch_pw_empmodel) 的状态(state)字段*/
	private Short modelState;
	/** 渠道ID和名称 */
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
