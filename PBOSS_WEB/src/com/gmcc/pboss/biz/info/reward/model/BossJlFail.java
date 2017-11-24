package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.biz.info.reward.support.DefaultSetFailModelSetParameter;
import com.gmcc.pboss.biz.info.reward.support.FailModelSetParameter;

/**
 * ChAdtBossjlfail entity. @author MyEclipse Persistence Tools
 */

public class BossJlFail extends DefaultSetFailModelSetParameter implements FailModelSetParameter, java.io.Serializable {

	// Fields

	private Long seq;
	private Long srcseq;
	private String ruleid;
	private String ruleitemid;
	private String opnid;
	private String calcopnid;
	private String wayid;
	private Date oprtime;
	private String oprcode;
	private String mobile;
	private Double busivalue;
	private Double wrapfee;
	private Short noncyc;
	private Short rewardtype;
	private String calcmonth;
	private String datasource;
	private Byte calcflag;
	private String calcremark;
	private Date createtime;
	private Date wadttime;
	private Date updatetime;
	private Byte adtflag;
	private String adtcode;
	private String adtremark;
	private Long oid;

	// Constructors

	/** default constructor */
	public BossJlFail() {
	}

	/** minimal constructor */
	public BossJlFail(Long seq) {
		this.seq = seq;
	}

	/** full constructor */
	public BossJlFail(Long seq, Long srcseq, String ruleid, String ruleitemid, String opnid, String calcopnid, String wayid, Date oprtime, String oprcode,
			String mobile, Double busivalue, Double wrapfee, Short noncyc, Short rewardtype, String calcmonth, String datasource, Byte calcflag,
			String calcremark, Date createtime, Date wadttime, Date updatetime, Byte adtflag, String adtcode, String adtremark, Long oid) {
		this.seq = seq;
		this.srcseq = srcseq;
		this.ruleid = ruleid;
		this.ruleitemid = ruleitemid;
		this.opnid = opnid;
		this.calcopnid = calcopnid;
		this.wayid = wayid;
		this.oprtime = oprtime;
		this.oprcode = oprcode;
		this.mobile = mobile;
		this.busivalue = busivalue;
		this.wrapfee = wrapfee;
		this.noncyc = noncyc;
		this.rewardtype = rewardtype;
		this.calcmonth = calcmonth;
		this.datasource = datasource;
		this.calcflag = calcflag;
		this.calcremark = calcremark;
		this.createtime = createtime;
		this.wadttime = wadttime;
		this.updatetime = updatetime;
		this.adtflag = adtflag;
		this.adtcode = adtcode;
		this.adtremark = adtremark;
		this.oid = oid;
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

	public String getRuleitemid() {
		return this.ruleitemid;
	}

	public void setRuleitemid(String ruleitemid) {
		this.ruleitemid = ruleitemid;
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

	public Double getWrapfee() {
		return this.wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}

	public Short getNoncyc() {
		return this.noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
	}

	public Short getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getCalcmonth() {
		return this.calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
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

	public Date getWadttime() {
		return this.wadttime;
	}

	public void setWadttime(Date wadttime) {
		this.wadttime = wadttime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
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

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this) + "\n";
	}

}