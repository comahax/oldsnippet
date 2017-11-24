package com.sunrise.boss.business.cms.netsyn.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NetsynVO implements Serializable {

	private Long itemid;

	private String mobile;

	private Short opract;
	
	private String oprcode;

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
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

	public Short getOpract() {
		return opract;
	}

	public void setOpract(Short opract) {
		this.opract = opract;
	}

	/** full constructor */
	public NetsynVO() {
	}

	public String toString() {
		return new ToStringBuilder(this).toString();
	}

}
