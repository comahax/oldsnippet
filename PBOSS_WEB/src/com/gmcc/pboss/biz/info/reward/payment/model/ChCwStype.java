package com.gmcc.pboss.biz.info.reward.payment.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ChCwStype {
	/** identifier field */
	private Long seq;

	/** nullable persistent field */
	private String stype;

	/** nullable persistent field */
	private String ltype;

	/** nullable persistent field */
	private String cityid;

	/** full constructor */
	public ChCwStype(Long seq, String stype, String ltype, String cityid) {
		this.seq = seq;
		this.stype = stype;
		this.ltype = ltype;
		this.cityid = cityid;
	}

	/** default constructor */
	public ChCwStype() {
	}

	/** minimal constructor */
	public ChCwStype(java.lang.Long seq) {
		this.seq = seq;
	}

	public java.lang.Long getSeq() {
		return this.seq;
	}

	public void setSeq(java.lang.Long seq) {
		this.seq = seq;
	}

	public java.lang.String getStype() {
		return this.stype;
	}

	public void setStype(java.lang.String stype) {
		this.stype = stype;
	}

	public java.lang.String getLtype() {
		return this.ltype;
	}

	public void setLtype(java.lang.String ltype) {
		this.ltype = ltype;
	}

	public java.lang.String getCityid() {
		return this.cityid;
	}

	public void setCityid(java.lang.String cityid) {
		this.cityid = cityid;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
