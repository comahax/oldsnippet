package com.gmcc.pboss.biz.basic.dictItem.model;

/**
 * ImPrComcategoryrela entity. @author MyEclipse Persistence Tools
 */

public class ImPrComcategoryrela extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Long relaid;
	private String comcategory;
	private Long comid;
	private String restype;
	private String brand;

	// Constructors

	/** default constructor */
	public ImPrComcategoryrela() {
	}

	/** minimal constructor */
	public ImPrComcategoryrela(Long relaid, String comcategory, Long comid,
			String restype) {
		this.relaid = relaid;
		this.comcategory = comcategory;
		this.comid = comid;
		this.restype = restype;
	}

	/** full constructor */
	public ImPrComcategoryrela(Long relaid, String comcategory, Long comid,
			String restype, String brand) {
		this.relaid = relaid;
		this.comcategory = comcategory;
		this.comid = comid;
		this.restype = restype;
		this.brand = brand;
	}

	// Property accessors

	public Long getRelaid() {
		return this.relaid;
	}

	public void setRelaid(Long relaid) {
		this.relaid = relaid;
	}

	public String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	public Long getComid() {
		return this.comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getRestype() {
		return this.restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}