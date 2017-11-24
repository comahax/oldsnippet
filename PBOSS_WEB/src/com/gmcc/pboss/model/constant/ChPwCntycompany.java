package com.gmcc.pboss.model.constant;

/**
 * ChPwCntycompany entity. @author MyEclipse Persistence Tools
 */

public class ChPwCntycompany extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private String countycompid;
	private String citycompid;
	private String countycompname;
	private Short countycomptype;
	private String agent;
	private String billingcode;
	private String adacode;
	private String longitude;
	private String latitude;

	// Constructors

	/** default constructor */
	public ChPwCntycompany() {
	}

	/** minimal constructor */
	public ChPwCntycompany(String countycompid) {
		this.countycompid = countycompid;
	}

	/** full constructor */
	public ChPwCntycompany(String countycompid, String citycompid,
			String countycompname, Short countycomptype, String agent,
			String billingcode, String adacode, String longitude,
			String latitude) {
		this.countycompid = countycompid;
		this.citycompid = citycompid;
		this.countycompname = countycompname;
		this.countycomptype = countycomptype;
		this.agent = agent;
		this.billingcode = billingcode;
		this.adacode = adacode;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	// Property accessors

	public String getCountycompid() {
		return this.countycompid;
	}

	public void setCountycompid(String countycompid) {
		this.countycompid = countycompid;
	}

	public String getCitycompid() {
		return this.citycompid;
	}

	public void setCitycompid(String citycompid) {
		this.citycompid = citycompid;
	}

	public String getCountycompname() {
		return this.countycompname;
	}

	public void setCountycompname(String countycompname) {
		this.countycompname = countycompname;
	}

	public Short getCountycomptype() {
		return this.countycomptype;
	}

	public void setCountycomptype(Short countycomptype) {
		this.countycomptype = countycomptype;
	}

	public String getAgent() {
		return this.agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getBillingcode() {
		return this.billingcode;
	}

	public void setBillingcode(String billingcode) {
		this.billingcode = billingcode;
	}

	public String getAdacode() {
		return this.adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}