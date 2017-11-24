package com.gmcc.pboss.biz.info.reward.model;

/**
 * ChAdtAdtcode entity. @author MyEclipse Persistence Tools
 */

public class AdtCode implements java.io.Serializable {

	// Fields

	private String adtcode;
	private String adtremark;
	private String adttype;
	private Integer adtprio;

	// Constructors

	/** default constructor */
	public AdtCode() {
	}

	/** minimal constructor */
	public AdtCode(String adtcode) {
		this.adtcode = adtcode;
	}

	/** full constructor */
	public AdtCode(String adtcode, String adtremark, String adttype, Integer adtprio) {
		this.adtcode = adtcode;
		this.adtremark = adtremark;
		this.adttype = adttype;
		this.adtprio = adtprio;
	}

	// Property accessors

	public String getAdtcode() {
		return this.adtcode;
	}

	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}

	public String getAdtremark() {
		return this.adtremark;
	}

	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}

	public String getAdttype() {
		return this.adttype;
	}

	public void setAdttype(String adttype) {
		this.adttype = adttype;
	}

	public Integer getAdtprio() {
		return this.adtprio;
	}

	public void setAdtprio(Integer adtprio) {
		this.adtprio = adtprio;
	}

}