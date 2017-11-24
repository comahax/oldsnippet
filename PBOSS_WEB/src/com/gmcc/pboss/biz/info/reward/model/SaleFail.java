package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.biz.info.reward.support.DefaultSetFailModelSetParameter;
import com.gmcc.pboss.biz.info.reward.support.FailModelSetParameter;

/**
 * ChAdtSalefail entity. @author MyEclipse Persistence Tools
 */

public class SaleFail extends DefaultSetFailModelSetParameter implements FailModelSetParameter, java.io.Serializable {

	// Fields

	private Long seq;
	private Long srcseq;
	private String cityid;
	private String opnid;
	private String wayid;
	private String oprcode;
	private Date oprtime;
	private String mobile;
	private Boolean brand;
	private Date creattime;
	private String src;
	private String calcopnid;
	private String calcmonth;
	private String ruleid;
	private String ruleitemid;
	private Byte adtflag;
	private String adtcode;
	private String adtremark;

	// Constructors

	/** default constructor */
	public SaleFail() {
	}

	/** minimal constructor */
	public SaleFail(Long seq) {
		this.seq = seq;
	}

	/** full constructor */
	public SaleFail(Long seq, Long srcseq, String cityid, String opnid, String wayid, String oprcode, Date oprtime, String mobile, Boolean brand,
			Date creattime, String src, String calcopnid, String calcmonth, String ruleid, String ruleitemid, Byte adtflag, String adtcode, String adtremark) {
		this.seq = seq;
		this.srcseq = srcseq;
		this.cityid = cityid;
		this.opnid = opnid;
		this.wayid = wayid;
		this.oprcode = oprcode;
		this.oprtime = oprtime;
		this.mobile = mobile;
		this.brand = brand;
		this.creattime = creattime;
		this.src = src;
		this.calcopnid = calcopnid;
		this.calcmonth = calcmonth;
		this.ruleid = ruleid;
		this.ruleitemid = ruleitemid;
		this.adtflag = adtflag;
		this.adtcode = adtcode;
		this.adtremark = adtremark;
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

	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getBrand() {
		return this.brand;
	}

	public void setBrand(Boolean brand) {
		this.brand = brand;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
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

	public String getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getRuleitemid() {
		return this.ruleitemid;
	}

	public void setRuleitemid(String ruleitemid) {
		this.ruleitemid = ruleitemid;
	}

	public Byte getAdtflag() {
		return this.adtflag;
	}

	public void setAdtflag(Byte adtflag) {
		this.adtflag = adtflag;
	}

	public String getAdtcode() {
		return this.adtcode;
	}

	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}

	public String getAdtremark() {
		return this.adtremark;
	}

	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this) + "\n";
	}

}