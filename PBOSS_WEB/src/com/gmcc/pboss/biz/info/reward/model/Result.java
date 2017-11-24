package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

/**
 * ChAdtResult entity. @author MyEclipse Persistence Tools
 */

public class Result implements java.io.Serializable {

	// Fields

	private Long seq;
	private Long srcseq;
	private String ruleid;
	private String opnid;
	private String calcopnid;
	private String calcmonth;
	private String wayid;
	private Date oprtime;
	private String oprcode;
	private String mobile;
	private Double busivalue;
	private String datasource;
	private Byte calcflag;
	private String calcremark;
	private Date createtime;
	private Date updatetime;
	private String confirmadtflag;
	private Short rewardtype;

	// Constructors

	/** default constructor */
	public Result() {
	}

	/** full constructor */
	public Result(Long srcseq, String ruleid, String opnid, String calcopnid, String calcmonth, String wayid, Date oprtime, String oprcode, String mobile,
			Double busivalue, String datasource, Byte calcflag, String calcremark, Date createtime, Date updatetime, String confirmadtflag, Short rewardtype) {
		this.srcseq = srcseq;
		this.ruleid = ruleid;
		this.opnid = opnid;
		this.calcopnid = calcopnid;
		this.calcmonth = calcmonth;
		this.wayid = wayid;
		this.oprtime = oprtime;
		this.oprcode = oprcode;
		this.mobile = mobile;
		this.busivalue = busivalue;
		this.datasource = datasource;
		this.calcflag = calcflag;
		this.calcremark = calcremark;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.confirmadtflag = confirmadtflag;
		this.rewardtype = rewardtype;
	}

	// Property accessors

	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getSrcseq() {
		return this.srcseq;
	}

	public void setSrcseq(Long srcseq) {
		this.srcseq = srcseq;
	}

	public String getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getCalcopnid() {
		return this.calcopnid;
	}

	public void setCalcopnid(String calcopnid) {
		this.calcopnid = calcopnid;
	}

	public String getCalcmonth() {
		return this.calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Double getBusivalue() {
		return this.busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public String getDatasource() {
		return this.datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public Byte getCalcflag() {
		return this.calcflag;
	}

	public void setCalcflag(Byte calcflag) {
		this.calcflag = calcflag;
	}

	public String getCalcremark() {
		return this.calcremark;
	}

	public void setCalcremark(String calcremark) {
		this.calcremark = calcremark;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getConfirmadtflag() {
		return this.confirmadtflag;
	}

	public void setConfirmadtflag(String confirmadtflag) {
		this.confirmadtflag = confirmadtflag;
	}

	public Short getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

}