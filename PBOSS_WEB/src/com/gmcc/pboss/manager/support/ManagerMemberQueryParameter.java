package com.gmcc.pboss.manager.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class ManagerMemberQueryParameter extends QueryParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -218337722891634498L;
	
	//������Ա��¼��LoginMember�е�employeeid
	private String managerid;
	public void setManagerid(String id){
		this.managerid = id;
	}
	public String getManagerid(){
		return this.managerid;
	}
	
	//���ݹ�������룬���˵�Ա�б�
	private String officetel;
	public void setOfficetel(String tel){
		this.officetel = tel;
	}
	public String getOfficetel(){
		return this.officetel;
	}
	
	//����id,��ѯ������Ա
	private String employeeid;
	public void setEmployeeid(String id){
		this.employeeid = id;
	}
	public String getEmployeeid(){
		return this.employeeid;
	}
}
