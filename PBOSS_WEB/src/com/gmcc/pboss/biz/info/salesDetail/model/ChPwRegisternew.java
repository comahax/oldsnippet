package com.gmcc.pboss.biz.info.salesDetail.model;

import java.util.Date;

/**
 * ChPwRegisternew entity. @author MyEclipse Persistence Tools
 */
public class ChPwRegisternew implements	java.io.Serializable {

	// Fields

	private Long seqid;
	private String cityid;
	private String oprcode;
	private String wayid;
	private String opnid;
	private String mobile;
	private String posvalid;
	private Short posdiff;
	private Short brand;
	private Date oprtime;
	private String oprtype;

	// Constructors

	/** default constructor */
	public ChPwRegisternew() {
	}

	/** minimal constructor */
	public ChPwRegisternew(Long seqid) {
		this.seqid = seqid;
	}

	/** full constructor */
	public ChPwRegisternew(Long seqid, String cityid, String oprcode,
			String wayid, String opnid, String mobile, String posvalid,
			Short posdiff, Short brand, Date oprtime, String oprtype) {
		this.seqid = seqid;
		this.cityid = cityid;
		this.oprcode = oprcode;
		this.wayid = wayid;
		this.opnid = opnid;
		this.mobile = mobile;
		this.posvalid = posvalid;
		this.posdiff = posdiff;
		this.brand = brand;
		this.oprtime = oprtime;
		this.oprtype = oprtype;
	}
	
	// Property accessors

	public Long getSeqid() {
		return this.seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPosvalid() {
		return this.posvalid;
	}

	public void setPosvalid(String posvalid) {
		this.posvalid = posvalid;
	}

	public Short getPosdiff() {
		return this.posdiff;
	}

	public void setPosdiff(Short posdiff) {
		this.posdiff = posdiff;
	}

	public Short getBrand() {
		return this.brand;
	}

	public void setBrand(Short brand) {
		this.brand = brand;
	}

	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

}
