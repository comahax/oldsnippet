package com.gmcc.pboss.biz.info.regactInfo.model;

import java.util.Date;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * MhTkRegactinfo entity. @author MyEclipse Persistence Tools
 */

public class MhTkRegactinfo extends CodeReverse implements java.io.Serializable {

	// Fields

	private Long id;
	private Long fileseq;
	private String oprcode;
	private String wayid;
	private String opnid;
	private String mobile;
	private String posvalid;
	private Long posdiff;
	private Byte brand;
	private Date oprtime;
	private Date activedate;
	private String imei;
	private String imsi;

	// Constructors

	/** default constructor */
	public MhTkRegactinfo() {
	}

	/** minimal constructor */
	public MhTkRegactinfo(Long id, Long fileseq, String wayid, String opnid,
			String mobile, Byte brand, Date oprtime, Date activedate) {
		this.id = id;
		this.fileseq = fileseq;
		this.wayid = wayid;
		this.opnid = opnid;
		this.mobile = mobile;
		this.brand = brand;
		this.oprtime = oprtime;
		this.activedate = activedate;
	}

	/** full constructor */
	public MhTkRegactinfo(Long id, Long fileseq, String oprcode, String wayid,
			String opnid, String mobile, String posvalid, Long posdiff,
			Byte brand, Date oprtime, Date activedate, String imei, String imsi) {
		this.id = id;
		this.fileseq = fileseq;
		this.oprcode = oprcode;
		this.wayid = wayid;
		this.opnid = opnid;
		this.mobile = mobile;
		this.posvalid = posvalid;
		this.posdiff = posdiff;
		this.brand = brand;
		this.oprtime = oprtime;
		this.activedate = activedate;
		this.imei = imei;
		this.imsi = imsi;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFileseq() {
		return this.fileseq;
	}

	public void setFileseq(Long fileseq) {
		this.fileseq = fileseq;
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

	public Long getPosdiff() {
		return this.posdiff;
	}

	public void setPosdiff(Long posdiff) {
		this.posdiff = posdiff;
	}

	public Byte getBrand() {
		return this.brand;
	}

	public void setBrand(Byte brand) {
		this.brand = brand;
	}

	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public Date getActivedate() {
		return this.activedate;
	}

	public void setActivedate(Date activedate) {
		this.activedate = activedate;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return this.imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

}