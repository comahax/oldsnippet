package com.gmcc.pboss.model.communi;

/**
 * ChPwAdvgroupobj entity. @author MyEclipse Persistence Tools
 */

public class ChPwAdvgroupobj implements java.io.Serializable {

	// Fields

	private Long groupoid;
	private Long groupid;
	private Long oid;

	/** default constructor */
	public ChPwAdvgroupobj() {
	}

	/** full constructor */
	public ChPwAdvgroupobj(Long groupid, Long oid) {
		this.groupid = groupid;
		this.oid = oid;
	}

	// Property accessors

	public Long getGroupoid() {
		return this.groupoid;
	}

	public void setGroupoid(Long groupoid) {
		this.groupoid = groupoid;
	}

	public Long getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

}