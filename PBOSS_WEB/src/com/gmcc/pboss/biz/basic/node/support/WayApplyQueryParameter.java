package com.gmcc.pboss.biz.basic.node.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class WayApplyQueryParameter extends QueryParameter {

	/* 申请人资料 */
	private String principal;// 姓名
	private String principaltel;// 移动电话
	private String principalphone;// 固定电话
	private String principalemail;// 邮箱

	/* 网点基本资料 */
	private String wayname;// 网点名称
	private String buzarea;// 网点面积
	private String address;// 网点地址
	private String cityid;// 归属地
	private Byte formtype;// 业态类型

	/* 网点酬金资料 */
	private String bankname;// 开户银行
	private String acctno;// 银行帐号
	private String acctfid;// 开户人身份证

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipaltel() {
		return principaltel;
	}

	public void setPrincipaltel(String principaltel) {
		this.principaltel = principaltel;
	}

	public String getPrincipalphone() {
		return principalphone;
	}

	public void setPrincipalphone(String principalphone) {
		this.principalphone = principalphone;
	}

	public String getPrincipalemail() {
		return principalemail;
	}

	public void setPrincipalemail(String principalemail) {
		this.principalemail = principalemail;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getBuzarea() {
		return buzarea;
	}

	public void setBuzarea(String buzarea) {
		this.buzarea = buzarea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Byte getFormtype() {
		return formtype;
	}

	public void setFormtype(Byte formtype) {
		this.formtype = formtype;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getAcctfid() {
		return acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
	}

}
