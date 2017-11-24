package com.gmcc.pboss.biz.info.node.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ChPwBchcontact entity. @author MyEclipse Persistence Tools
 */

public class Contact implements java.io.Serializable {

	// Fields

	private String wayid;
	private String principal;
	private String principaltel;
	private String principalemail;
	private String principalphone;
	private String linkman;
	private String linkmantel;
	private String linkmanemail;
	private String hotline;
	private String fax;
	private String address;
	private String zipcode;
	private Byte bailtype;
	private Short servbound;
	private Short coplevel;
	private String busnum;
	private Short certitype;
	private String certinum;
	private String regadress;
	private Long regcapital;
	private String company;
	private String provcode;

	// Constructors

	/** default constructor */
	public Contact() {
	}

	/** minimal constructor */
	public Contact(String wayid) {
		this.wayid = wayid;
	}

	/** full constructor */
	public Contact(String wayid, String principal, String principaltel, String principalemail, String principalphone, String linkman, String linkmantel,
			String linkmanemail, String hotline, String fax, String address, String zipcode, Byte bailtype, Short servbound, Short coplevel, String busnum,
			Short certitype, String certinum, String regadress, Long regcapital, String company, String provcode) {
		this.wayid = wayid;
		this.principal = principal;
		this.principaltel = principaltel;
		this.principalemail = principalemail;
		this.principalphone = principalphone;
		this.linkman = linkman;
		this.linkmantel = linkmantel;
		this.linkmanemail = linkmanemail;
		this.hotline = hotline;
		this.fax = fax;
		this.address = address;
		this.zipcode = zipcode;
		this.bailtype = bailtype;
		this.servbound = servbound;
		this.coplevel = coplevel;
		this.busnum = busnum;
		this.certitype = certitype;
		this.certinum = certinum;
		this.regadress = regadress;
		this.regcapital = regcapital;
		this.company = company;
		this.provcode = provcode;
	}

	// Property accessors

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipaltel() {
		return this.principaltel;
	}

	public void setPrincipaltel(String principaltel) {
		this.principaltel = principaltel;
	}

	public String getPrincipalemail() {
		return this.principalemail;
	}

	public void setPrincipalemail(String principalemail) {
		this.principalemail = principalemail;
	}

	public String getPrincipalphone() {
		return this.principalphone;
	}

	public void setPrincipalphone(String principalphone) {
		this.principalphone = principalphone;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmantel() {
		return this.linkmantel;
	}

	public void setLinkmantel(String linkmantel) {
		this.linkmantel = linkmantel;
	}

	public String getLinkmanemail() {
		return this.linkmanemail;
	}

	public void setLinkmanemail(String linkmanemail) {
		this.linkmanemail = linkmanemail;
	}

	public String getHotline() {
		return this.hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Byte getBailtype() {
		return this.bailtype;
	}

	public void setBailtype(Byte bailtype) {
		this.bailtype = bailtype;
	}

	public Short getServbound() {
		return this.servbound;
	}

	public void setServbound(Short servbound) {
		this.servbound = servbound;
	}

	public Short getCoplevel() {
		return this.coplevel;
	}

	public void setCoplevel(Short coplevel) {
		this.coplevel = coplevel;
	}

	public String getBusnum() {
		return this.busnum;
	}

	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}

	public Short getCertitype() {
		return this.certitype;
	}

	public void setCertitype(Short certitype) {
		this.certitype = certitype;
	}

	public String getCertinum() {
		return this.certinum;
	}

	public void setCertinum(String certinum) {
		this.certinum = certinum;
	}

	public String getRegadress() {
		return this.regadress;
	}

	public void setRegadress(String regadress) {
		this.regadress = regadress;
	}

	public Long getRegcapital() {
		return this.regcapital;
	}

	public void setRegcapital(Long regcapital) {
		this.regcapital = regcapital;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProvcode() {
		return this.provcode;
	}

	public void setProvcode(String provcode) {
		this.provcode = provcode;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}