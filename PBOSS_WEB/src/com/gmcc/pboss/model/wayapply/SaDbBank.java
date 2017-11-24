package com.gmcc.pboss.model.wayapply;

import java.util.Date;

/**
 * SaDbBank entity. @author MyEclipse Persistence Tools
 */

public class SaDbBank extends com.gmcc.pboss.common.bean.CodeReverse implements
		java.io.Serializable {

	// Fields

	private String bankid;
	private String bankname;
	private String uniformcode;
	private String linkphone;
	private String addr;
	private Boolean container;
	private String exchangeno;
	private Short banklevel;
	private String parentid;
	private String orgid;
	private Date createdate;
	private Boolean status;
	private Date statusdate;

	// Constructors

	/** default constructor */
	public SaDbBank() {
	}

	/** minimal constructor */
	public SaDbBank(String bankid) {
		this.bankid = bankid;
	}

	/** full constructor */
	public SaDbBank(String bankid, String bankname, String uniformcode,
			String linkphone, String addr, Boolean container,
			String exchangeno, Short banklevel, String parentid, String orgid,
			Date createdate, Boolean status, Date statusdate) {
		this.bankid = bankid;
		this.bankname = bankname;
		this.uniformcode = uniformcode;
		this.linkphone = linkphone;
		this.addr = addr;
		this.container = container;
		this.exchangeno = exchangeno;
		this.banklevel = banklevel;
		this.parentid = parentid;
		this.orgid = orgid;
		this.createdate = createdate;
		this.status = status;
		this.statusdate = statusdate;
	}

	// Property accessors

	public String getBankid() {
		return this.bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getUniformcode() {
		return this.uniformcode;
	}

	public void setUniformcode(String uniformcode) {
		this.uniformcode = uniformcode;
	}

	public String getLinkphone() {
		return this.linkphone;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Boolean getContainer() {
		return this.container;
	}

	public void setContainer(Boolean container) {
		this.container = container;
	}

	public String getExchangeno() {
		return this.exchangeno;
	}

	public void setExchangeno(String exchangeno) {
		this.exchangeno = exchangeno;
	}

	public Short getBanklevel() {
		return this.banklevel;
	}

	public void setBanklevel(Short banklevel) {
		this.banklevel = banklevel;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

}