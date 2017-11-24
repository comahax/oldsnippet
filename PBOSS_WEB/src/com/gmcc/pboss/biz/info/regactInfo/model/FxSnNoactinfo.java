package com.gmcc.pboss.biz.info.regactInfo.model;

import java.util.Date;

/**
 * FxSnNoactinfo entity. @author MyEclipse Persistence Tools
 */

public class FxSnNoactinfo implements java.io.Serializable {

	// Fields

	private Long recid;
	private String mobileno;
	private Date activedate;
	private Date creattime;
	private String memo;

	// Constructors

	/** default constructor */
	public FxSnNoactinfo() {
	}

	/** minimal constructor */
	public FxSnNoactinfo(Long recid, String mobileno, Date activedate) {
		this.recid = recid;
		this.mobileno = mobileno;
		this.activedate = activedate;
	}

	/** full constructor */
	public FxSnNoactinfo(Long recid, String mobileno, Date activedate,
			Date creattime, String memo) {
		this.recid = recid;
		this.mobileno = mobileno;
		this.activedate = activedate;
		this.creattime = creattime;
		this.memo = memo;
	}

	// Property accessors

	public Long getRecid() {
		return this.recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Date getActivedate() {
		return this.activedate;
	}

	public void setActivedate(Date activedate) {
		this.activedate = activedate;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}