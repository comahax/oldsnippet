package com.sunrise.boss.business.cms.personalbusi.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PersonalbusiVO implements Serializable {

	/** full constructor */
	public PersonalbusiVO() {
	}

	private Long itemid;

	private java.util.Date opntime;

	private String mobile;

	private Long brand;

	private String opntype;

	private String wayid;

	private String oprtype;

	public String toString() {
		return new ToStringBuilder(this).toString();
	}

	public Long getBrand() {
		return brand;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public java.util.Date getOpntime() {
		return opntime;
	}

	public void setOpntime(java.util.Date opntime) {
		this.opntime = opntime;
	}

	public String getOpntype() {
		return opntype;
	}

	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

}
