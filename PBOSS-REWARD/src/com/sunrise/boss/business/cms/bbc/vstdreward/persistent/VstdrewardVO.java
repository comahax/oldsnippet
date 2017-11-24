package com.sunrise.boss.business.cms.bbc.vstdreward.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VstdrewardVO implements Serializable {

	/** identifier field */
	private Long rewardid;

	/** nullable persistent field */
	private String rewardname;

	/** nullable persistent field */
	private String opnid;

	/** nullable persistent field */
	private String region;

	/** nullable persistent field */
	private Short ossrc;

	/** nullable persistent field */
	private Short rewardtype;

	/** nullable persistent field */
	private Integer intvmonth;

	/** nullable persistent field */
	private Double rewardstd;

	/** nullable persistent field */
	private java.util.Date startdate;

	/** nullable persistent field */
	private java.util.Date stopdate;

	/** nullable persistent field */
	private Short acctype;

	/** nullable persistent field */
	private String ruleid;

	/** nullable persistent field */
	private String memo;

	private Short rewardproj;

	private Double max_pro_std;

	/** full constructor */
	public VstdrewardVO(java.lang.Long rewardid, java.lang.String rewardname,
			java.lang.String opnid, java.lang.String region, java.lang.Short ossrc,
			java.lang.Short rewardtype, java.lang.Integer intvmonth, java.lang.Double rewardstd,
			java.util.Date startdate, java.util.Date stopdate, java.lang.Short acctype,
			java.lang.String ruleid, java.lang.String memo) {
		this.rewardid = rewardid;
		this.rewardname = rewardname;
		this.opnid = opnid;
		this.region = region;
		this.ossrc = ossrc;
		this.rewardtype = rewardtype;
		this.intvmonth = intvmonth;
		this.rewardstd = rewardstd;
		this.startdate = startdate;
		this.stopdate = stopdate;
		this.acctype = acctype;
		this.ruleid = ruleid;
		this.memo = memo;
	}

	/** default constructor */
	public VstdrewardVO() {
	}

	/** minimal constructor */
	public VstdrewardVO(java.lang.Long rewardid) {
		this.rewardid = rewardid;
	}

	public java.lang.Long getRewardid() {
		return this.rewardid;
	}

	public void setRewardid(java.lang.Long rewardid) {
		this.rewardid = rewardid;
	}

	public java.lang.String getRewardname() {
		return this.rewardname;
	}

	public void setRewardname(java.lang.String rewardname) {
		this.rewardname = rewardname;
	}

	public java.lang.String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(java.lang.String opnid) {
		this.opnid = opnid;
	}

	public java.lang.String getRegion() {
		return this.region;
	}

	public void setRegion(java.lang.String region) {
		this.region = region;
	}

	public java.lang.Short getOssrc() {
		return this.ossrc;
	}

	public void setOssrc(java.lang.Short ossrc) {
		this.ossrc = ossrc;
	}

	public java.lang.Short getRewardtype() {
		return this.rewardtype;
	}

	public void setRewardtype(java.lang.Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public java.lang.Integer getIntvmonth() {
		return this.intvmonth;
	}

	public void setIntvmonth(java.lang.Integer intvmonth) {
		this.intvmonth = intvmonth;
	}

	public java.lang.Double getRewardstd() {
		return this.rewardstd;
	}

	public void setRewardstd(java.lang.Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public java.util.Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getStopdate() {
		return this.stopdate;
	}

	public void setStopdate(java.util.Date stopdate) {
		this.stopdate = stopdate;
	}

	public java.lang.Short getAcctype() {
		return this.acctype;
	}

	public void setAcctype(java.lang.Short acctype) {
		this.acctype = acctype;
	}

	public java.lang.String getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.String ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public String toString() {
		return new ToStringBuilder(this).append("rewardid", getRewardid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof VstdrewardVO))
			return false;
		VstdrewardVO castOther = (VstdrewardVO) other;
		return new EqualsBuilder().append(this.getRewardid(), castOther.getRewardid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRewardid()).toHashCode();
	}

	public Short getRewardproj() {
		return rewardproj;
	}

	public void setRewardproj(Short rewardproj) {
		this.rewardproj = rewardproj;
	}

	public Double getMax_pro_std() {
		return max_pro_std;
	}

	public void setMax_pro_std(Double max_pro_std) {
		this.max_pro_std = max_pro_std;
	}

}
