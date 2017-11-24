package com.gmcc.pboss.biz.info.reward.payment.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ChCwPayway {
	private Long seq;

	private String payee;

	private String wayid;

	private String cityid;

	/** full constructor */
	public ChCwPayway(Long seq, String payee, String wayid, String cityid) {
		this.seq = seq;
		this.payee = payee;
		this.wayid = wayid;
		this.cityid = cityid;
	}

	/** default constructor */
	public ChCwPayway() {
	}

	/** minimal constructor */
	public ChCwPayway(Long seq) {
		this.seq = seq;
	}

	public ChCwPayway(String payee, String wayid) {
		this.payee = payee;
		this.wayid = wayid;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public java.lang.String getWayid() {
		return this.wayid;
	}

	public void setWayid(java.lang.String wayid) {
		this.wayid = wayid;
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
