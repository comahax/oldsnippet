package com.gmcc.pboss.model.sales;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * FxSwOrderresdet entity. @author MyEclipse Persistence Tools
 */

public class FxSwOrderresdet extends CodeReverse implements java.io.Serializable {

	// Fields

	private Long detid;
	private String orderid;
	private String ordercomtype;
	private String comcategory;
	private String restype;
	private Long comid;
	private String batchno;
	private String boxnum;
	private String comresid;
	private String brand;

	// Constructors

	/** default constructor */
	public FxSwOrderresdet() {
	}

	/** minimal constructor */
	public FxSwOrderresdet(String orderid) {
		this.orderid = orderid;
	}

	/** full constructor */
	public FxSwOrderresdet(String orderid, String ordercomtype,
			String comcategory, String restype, Long comid, String batchno,
			String boxnum, String comresid, String brand) {
		this.orderid = orderid;
		this.ordercomtype = ordercomtype;
		this.comcategory = comcategory;
		this.restype = restype;
		this.comid = comid;
		this.batchno = batchno;
		this.boxnum = boxnum;
		this.comresid = comresid;
		this.brand = brand;
	}

	// Property accessors

	public Long getDetid() {
		return this.detid;
	}

	public void setDetid(Long detid) {
		this.detid = detid;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrdercomtype() {
		return this.ordercomtype;
	}

	public void setOrdercomtype(String ordercomtype) {
		this.ordercomtype = ordercomtype;
	}

	public String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	public String getRestype() {
		return this.restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public Long getComid() {
		return this.comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getBatchno() {
		return this.batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getBoxnum() {
		return this.boxnum;
	}

	public void setBoxnum(String boxnum) {
		this.boxnum = boxnum;
	}

	public String getComresid() {
		return this.comresid;
	}

	public void setComresid(String comresid) {
		this.comresid = comresid;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}