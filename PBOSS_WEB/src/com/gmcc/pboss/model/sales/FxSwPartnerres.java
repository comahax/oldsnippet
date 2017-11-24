package com.gmcc.pboss.model.sales;

import java.util.Date;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * FxSwPartnerres entity. @author MyEclipse Persistence Tools
 */

public class FxSwPartnerres extends CodeReverse implements java.io.Serializable {

	// Fields

	private Long recid;
	private String wayid;
	private String restype;
	private String comcategory;
	private String comresid;
	private Long comid;
	private String batchno;
	private Date createtime;
	private String brand;
	private Short isactive;
	private Date acttime;

	// Constructors

	/** default constructor */
	public FxSwPartnerres() {
	}

	/** minimal constructor */
	public FxSwPartnerres(String wayid, String restype) {
		this.wayid = wayid;
		this.restype = restype;
	}

	/** full constructor */
	public FxSwPartnerres(String wayid, String restype, String comcategory,
			String comresid, Long comid, String batchno, Date createtime,
			String brand, Short isactive, Date acttime) {
		this.wayid = wayid;
		this.restype = restype;
		this.comcategory = comcategory;
		this.comresid = comresid;
		this.comid = comid;
		this.batchno = batchno;
		this.createtime = createtime;
		this.brand = brand;
		this.isactive = isactive;
		this.acttime = acttime;
	}

	// Property accessors

	public Long getRecid() {
		return this.recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getRestype() {
		return this.restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	public String getComresid() {
		return this.comresid;
	}

	public void setComresid(String comresid) {
		this.comresid = comresid;
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

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Short getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Short isactive) {
		this.isactive = isactive;
	}

	public Date getActtime() {
		return this.acttime;
	}

	public void setActtime(Date acttime) {
		this.acttime = acttime;
	}

}