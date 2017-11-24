package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.biz.info.reward.support.DefaultSetFailModelSetParameter;
import com.gmcc.pboss.biz.info.reward.support.FailModelSetParameter;

/**
 * ChAdtJmjtfail entity. @author MyEclipse Persistence Tools
 */

public class JmjtFail extends DefaultSetFailModelSetParameter implements FailModelSetParameter, java.io.Serializable {

	// Fields

	private Long seq;
	private Long oldseq;
	private Long fileseq;
	private String cityid;
	private String opnid;
	private String wayid;
	private String oprcode;
	private Date oprtime;
	private String mobile;
	private Boolean brand;
	private String location;
	private String imei;
	private String imsi;
	private Date creattime;
	private String src;
	private String calcopnid;
	private String ruleid;
	private String ruleitemid;
	private Byte adtflag;
	private String adtcode;
	private String adtremark;
	private String calcmonth;

	// Constructors

	/** default constructor */
	public JmjtFail() {
	}

	/** minimal constructor */
	public JmjtFail(Long seq, Long oldseq) {
		this.seq = seq;
		this.oldseq = oldseq;
	}

	/** full constructor */
	public JmjtFail(Long seq, Long oldseq, Long fileseq, String cityid, String opnid, String wayid, String oprcode, Date oprtime, String mobile, Boolean brand,
			String location, String imei, String imsi, Date creattime, String src, String calcopnid, String ruleid, String ruleitemid, Byte adtflag,
			String adtcode, String adtremark, String calcmonth) {
		this.seq = seq;
		this.oldseq = oldseq;
		this.fileseq = fileseq;
		this.cityid = cityid;
		this.opnid = opnid;
		this.wayid = wayid;
		this.oprcode = oprcode;
		this.oprtime = oprtime;
		this.mobile = mobile;
		this.brand = brand;
		this.location = location;
		this.imei = imei;
		this.imsi = imsi;
		this.creattime = creattime;
		this.src = src;
		this.calcopnid = calcopnid;
		this.ruleid = ruleid;
		this.ruleitemid = ruleitemid;
		this.adtflag = adtflag;
		this.adtcode = adtcode;
		this.adtremark = adtremark;
		this.calcmonth = calcmonth;
	}

	// Property accessors

	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getOldseq() {
		return this.oldseq;
	}

	public void setOldseq(Long oldseq) {
		this.oldseq = oldseq;
	}

	public Long getFileseq() {
		return this.fileseq;
	}

	public void setFileseq(Long fileseq) {
		this.fileseq = fileseq;
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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getCalcmonth() {
		return this.calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}