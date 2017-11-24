package com.gmcc.pboss.manager.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class ManagerMemberQueryParameter extends QueryParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -218337722891634498L;
	
	//经理人员登录后，LoginMember中的employeeid
	private String managerid;
	public void setManagerid(String id){
		this.managerid = id;
	}
	public String getManagerid(){
		return this.managerid;
	}
	
	//根据公务机号码，过滤店员列表
	private String officetel;
	public void setOfficetel(String tel){
		this.officetel = tel;
	}
	public String getOfficetel(){
		return this.officetel;
	}
	
	//根据id,查询单个店员
	private String employeeid;
	public void setEmployeeid(String id){
		this.employeeid = id;
	}
	public String getEmployeeid(){
		return this.employeeid;
	}
}
