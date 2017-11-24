package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.biz.info.reward.support.DefaultSetFailModelSetParameter;
import com.gmcc.pboss.biz.info.reward.support.FailModelSetParameter;

/**
 * ChBbcSelegfl entity. @author MyEclipse Persistence Tools
 */

public class BbcSeleGfl extends DefaultSetFailModelSetParameter implements FailModelSetParameter, java.io.Serializable {

	// Fields

	private Long seq;
	private String cityid;
	private String opnid;
	private String wayid;
	private String oprcode;
	private Date oprtime;
	private String mobile;
	private Double busivalue;
	private Date creattime;
	private Date adtttime;
	private String src;
	private String calcopnid;
	private String calcmonth;
	private String ruleid;
	private Byte adtflag;
	private String adtcode;
	private String adtremark;
	private String srcseq;
	private Short noncyc;

	// Constructors

	/** default constructor */
	public BbcSeleGfl() {
	}

	/** minimal constructor */
	public BbcSeleGfl(Long seq) {
		this.seq = seq;
	}

	/** full constructor */
	public BbcSeleGfl(Long seq, String cityid, String opnid, String wayid, String oprcode, Date oprtime, String mobile, Double busivalue, Date creattime,
			Date adtttime, String src, String calcopnid, String calcmonth, String ruleid, Byte adtflag, String adtcode, String adtremark, String srcseq,
			Short noncyc) {
		this.seq = seq;
		this.cityid = cityid;
		this.opnid = opnid;
		this.wayid = wayid;
		this.oprcode = oprcode;
		this.oprtime = oprtime;
		this.mobile = mobile;
		this.busivalue = busivalue;
		this.creattime = creattime;
		this.adtttime = adtttime;
		this.src = src;
		this.calcopnid = calcopnid;
		this.calcmonth = calcmonth;
		this.ruleid = ruleid;
		this.adtflag = adtflag;
		this.adtcode = adtcode;
		this.adtremark = adtremark;
		this.srcseq = srcseq;
		this.noncyc = noncyc;
	}

	// Property accessors

	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
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

	public Double getBusivalue() {
		return this.busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getAdtttime() {
		return this.adtttime;
	}

	public void setAdtttime(Date adtttime) {
		this.adtttime = adtttime;
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

	public String getSrcseq() {
		return this.srcseq;
	}

	public void setSrcseq(String srcseq) {
		this.srcseq = srcseq;
	}

	public Short getNoncyc() {
		return this.noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}