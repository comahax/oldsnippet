/**
 * auto-generated code
 * Tue Sep 29 10:24:36 CST 2009
 */
package com.gmcc.pboss.web.common.multiselect;

import com.sunrise.jop.infrastructure.db.BaseVO;


/**
 * <p>Title: AdvapprovalForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MultiSelectForm extends BaseVO{
	//��ѯ������Ա�ֶ�
	private String employeeid;
	private String employeename;
	private String isnet;
	private String officetel;
	
	//��ѯ�����ֶ�
	private String wayid;
	private String wayname;
	
	//��ѯȺ���ֶ�
	private Long groupid;
	private String groupname;
	
	//������Ⱥ���ѯ��Ӧ��Ա�ֶ�
	private String wayidIn;
	private String groupidIn;
	
	//ѡ�������ֶ�
	private String paramType;
	
	//��������ѡ�ַ��������ŷָ�
	private String selectedStr;

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getIsnet() {
		return isnet;
	}

	public void setIsnet(String isnet) {
		this.isnet = isnet;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getWayidIn() {
		return wayidIn;
	}

	public void setWayidIn(String wayidIn) {
		this.wayidIn = wayidIn;
	}

	public String getGroupidIn() {
		return groupidIn;
	}

	public void setGroupidIn(String groupidIn) {
		this.groupidIn = groupidIn;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getSelectedStr() {
		return selectedStr;
	}

	public void setSelectedStr(String selectedStr) {
		this.selectedStr = selectedStr;
	}
	
}
