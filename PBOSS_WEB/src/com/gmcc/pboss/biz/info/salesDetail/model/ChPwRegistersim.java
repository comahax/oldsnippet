package com.gmcc.pboss.biz.info.salesDetail.model;

import java.util.Date;

/**
 * ChPwRegistersim entity. @author MyEclipse Persistence Tools
 */
public class ChPwRegistersim implements	java.io.Serializable {

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
	private String imei;
	private String imsi;
	private Byte mendfalg;
	private Date mendtime;
	private Date addtime;
	private Integer comclassid;
	private Long comprice;
	private Long comid;
	private String comname;
	private Integer comtype;
	
	// Constructors

	/** default constructor */
	public ChPwRegistersim() {
	}

	/** minimal constructor */
	public ChPwRegistersim(Long seqid) {
		this.seqid = seqid;
	}

	/** full constructor */
	public ChPwRegistersim(Long seqid, String cityid, String oprcode,
			String wayid, String opnid, String mobile, String posvalid,
			Short posdiff, Short brand, Date oprtime, String imei, String imsi, Byte mendfalg,
			Date mendtime, Date addtime, Integer comclassid, Long comprice, 
			Long comid, String comname, Integer comtype) {
		this.cityid = cityid;
		this.oprcode = oprcode;
		this.wayid = wayid;
		this.opnid = opnid;
		this.mobile = mobile;
		this.posvalid = posvalid;
		this.posdiff = posdiff;
		this.brand = brand;
		this.oprtime = oprtime;
		this.imei = imei;
		this.imsi = imsi;
		this.mendfalg = mendfalg;
		this.mendtime = mendtime;
		this.addtime = addtime;
		this.comclassid = comclassid;
		this.comprice = comprice;
		this.comid = comid;
		this.comname = comname;
		this.comtype = comtype;
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
	
	public Byte getMendfalg() {
		return this.mendfalg;
	}

	public void setMendfalg(Byte mendfalg) {
		this.mendfalg = mendfalg;
	}

	public Date getMendtime() {
		return this.mendtime;
	}

	public void setMendtime(Date mendtime) {
		this.mendtime = mendtime;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getComclassid() {
		return this.comclassid;
	}

	public void setComclassid(Integer comclassid) {
		this.comclassid = comclassid;
	}

	public Long getComprice() {
		return this.comprice;
	}

	public void setComprice(Long comprice) {
		this.comprice = comprice;
	}
	
	public Long getComid() {
		return this.comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getComname() {
		return this.comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public Integer getComtype() {
		return this.comtype;
	}

	public void setComtype(Integer comtype) {
		this.comtype = comtype;
	}
}
