package com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BBCstdrewardbjVO implements OperationLog {

	/** identifier field */
	private String region;

	/** identifier field */
	private Long rewardid;

	/** persistent field */
	private String opnid;

	/** nullable persistent field */
	private Short acctype;

	/** nullable persistent field */
	private Double rewardstd;

	/** nullable persistent field */
	private Integer intvmonth;

	/** nullable persistent field */
	private String ruleid;
	
	/** nullable persistent field */
	private Short ossrc;

	// extend fields
	private String rewardname; // 酬金名称

	private Short rewardtype; // 酬金类型

	private java.util.Date startdate; // 启用日期

	private java.util.Date stopdate; // 停用日期

	private Short rewardproj; // 酬金项目

	private boolean deleteflag; // 删除标识

	private Long temprewardid; // 临时酬金标识

	// 省公司上限
	private Double max_rewardstd;

	private Integer max_intvmonth;
	
	//市公司上限
	
	private Double max_city_rewardstd;
	
	private Integer max_city_intvmonth;

	public Integer getMax_city_intvmonth() {
		return max_city_intvmonth;
	}

	public void setMax_city_intvmonth(Integer max_city_intvmonth) {
		this.max_city_intvmonth = max_city_intvmonth;
	}

	/** full constructor */
	public BBCstdrewardbjVO(java.lang.String region, java.lang.Long rewardid,
			java.lang.String opnid, java.lang.Short acctype,
			java.lang.Double rewardstd, java.lang.Integer intvmonth,
			java.lang.String ruleid, java.lang.Short ossrc) {
		this.region = region;
		this.rewardid = rewardid;
		this.opnid = opnid;
		this.acctype = acctype;
		this.rewardstd = rewardstd;
		this.intvmonth = intvmonth;
		this.ruleid = ruleid;
		this.ossrc = ossrc;
	}

	/** default constructor */
	public BBCstdrewardbjVO() {
	}

	/** minimal constructor */
	public BBCstdrewardbjVO(java.lang.String region, java.lang.Long rewardid,
			java.lang.String opnid, java.lang.Short ossrc) {
		this.region = region;
		this.rewardid = rewardid;
		this.opnid = opnid;
		this.ossrc = ossrc;
	}

	public java.lang.String getRegion() {
		return this.region;
	}

	public void setRegion(java.lang.String region) {
		this.region = region;
	}

	public java.lang.Long getRewardid() {
		return this.rewardid;
	}

	public void setRewardid(java.lang.Long rewardid) {
		this.rewardid = rewardid;
	}

	public java.lang.String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(java.lang.String opnid) {
		this.opnid = opnid;
	}

	public java.lang.Short getAcctype() {
		return this.acctype;
	}

	public void setAcctype(java.lang.Short acctype) {
		this.acctype = acctype;
	}

	public java.lang.Double getRewardstd() {
		return this.rewardstd;
	}

	public void setRewardstd(java.lang.Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public java.lang.Integer getIntvmonth() {
		return this.intvmonth;
	}

	public void setIntvmonth(java.lang.Integer intvmonth) {
		this.intvmonth = intvmonth;
	}

	public java.lang.String getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.String ruleid) {
		this.ruleid = ruleid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("region", getRegion()).append(
				"rewardid", getRewardid()).append("ossrc",getOssrc()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof BBCstdrewardbjVO))
			return false;
		BBCstdrewardbjVO castOther = (BBCstdrewardbjVO) other;
		return new EqualsBuilder().append(this.getRegion(),
				castOther.getRegion()).append(this.getRewardid(),
				castOther.getRewardid()).append(this.getOssrc(),
				castOther.getOssrc()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRegion()).append(getRewardid())
				.toHashCode();
	}

	public Class logVOClass() {
		return BBCstdrewardbjlogVO.class;
	}

	public String getRewardname() {
		return rewardname;
	}

	public boolean isDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(boolean deleteflag) {
		this.deleteflag = deleteflag;
	}

	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}

	public Short getRewardproj() {
		return rewardproj;
	}

	public void setRewardproj(Short rewardproj) {
		this.rewardproj = rewardproj;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getStopdate() {
		return stopdate;
	}

	public void setStopdate(java.util.Date stopdate) {
		this.stopdate = stopdate;
	}

	public Long getTemprewardid() {
		return temprewardid;
	}

	public void setTemprewardid(Long temprewardid) {
		this.temprewardid = temprewardid;
	}

	public Integer getMax_intvmonth() {
		return max_intvmonth;
	}

	public void setMax_intvmonth(Integer max_intvmonth) {
		this.max_intvmonth = max_intvmonth;
	}

	public Double getMax_rewardstd() {
		return max_rewardstd;
	}

	public void setMax_rewardstd(Double max_rewardstd) {
		this.max_rewardstd = max_rewardstd;
	}

	public Double getMax_city_rewardstd() {
		return max_city_rewardstd;
	}

	public void setMax_city_rewardstd(Double max_city_rewardstd) {
		this.max_city_rewardstd = max_city_rewardstd;
	}

	public Short getOssrc() {
		return ossrc;
	}

	public void setOssrc(Short ossrc) {
		this.ossrc = ossrc;
	}

}
