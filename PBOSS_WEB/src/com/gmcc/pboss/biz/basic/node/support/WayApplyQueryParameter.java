package com.gmcc.pboss.biz.basic.node.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class WayApplyQueryParameter extends QueryParameter {

	/* ���������� */
	private String principal;// ����
	private String principaltel;// �ƶ��绰
	private String principalphone;// �̶��绰
	private String principalemail;// ����

	/* ����������� */
	private String wayname;// ��������
	private String buzarea;// �������
	private String address;// �����ַ
	private String cityid;// ������
	private Byte formtype;// ҵ̬����

	/* ���������� */
	private String bankname;// ��������
	private String acctno;// �����ʺ�
	private String acctfid;// ���������֤

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
