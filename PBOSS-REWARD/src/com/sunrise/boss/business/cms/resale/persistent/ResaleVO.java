package com.sunrise.boss.business.cms.resale.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResaleVO {

	/** identifier field */
	private Long itemid;

	private String quantity;

	private String wayid;

	/** nullable persistent field */
	private String mobile;

	/** nullable persistent field */
	private String countyid;

	/** nullable persistent field */
	private Long brand;

	/** nullable persistent field */
	private java.util.Date daytime;

	private String opntype;

	private String calcmonth;

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getOpntype() {
		return opntype;
	}

	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}

	/** full constructor */
	public ResaleVO(java.lang.Long itemid, java.lang.String wayid,
			java.lang.String mobile, java.lang.String countyid,
			java.lang.Long brand, java.util.Date daytime) {
		this.itemid = itemid;
		this.wayid = wayid;
		this.mobile = mobile;
		this.countyid = countyid;
		this.brand = brand;
		this.daytime = daytime;
	}

	/** default constructor */
	public ResaleVO() {
	}

	/** minimal constructor */
	public ResaleVO(java.lang.Long itemid) {
		this.itemid = itemid;
	}

	public java.lang.Long getItemid() {
		return this.itemid;
	}

	public void setItemid(java.lang.Long itemid) {
		this.itemid = itemid;
	}

	public java.lang.String getWayid() {
		return this.wayid;
	}

	public void setWayid(java.lang.String wayid) {
		this.wayid = wayid;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public java.lang.String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(java.lang.String countyid) {
		this.countyid = countyid;
	}

	public java.lang.Long getBrand() {
		return this.brand;
	}

	public void setBrand(java.lang.Long brand) {
		this.brand = brand;
	}

	public java.util.Date getDaytime() {
		return this.daytime;
	}

	public void setDaytime(java.util.Date daytime) {
		this.daytime = daytime;
	}

	public String toString() {
		return new ToStringBuilder(this).append("itemid", getItemid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof ResaleVO))
			return false;
		ResaleVO castOther = (ResaleVO) other;
		return new EqualsBuilder().append(this.getItemid(),
				castOther.getItemid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getItemid()).toHashCode();
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
