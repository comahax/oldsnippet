package com.sunrise.boss.business.cms.reward.rewardrulequery.persistent;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjVO;

public class RewardrulequeryVO implements java.io.Serializable{
	private Long rewardid;
	private String rewardname;
	private Long rewardtype;
	private String region;
	private String opnid;
	private Long intvmonth;
	private Long acctype;
	private Double rewardstd;
	private Date startdate;
	private Date stopdate;
	public Long getAcctype() {
		return acctype;
	}
	public void setAcctype(Long acctype) {
		this.acctype = acctype;
	}
	public Long getIntvmonth() {
		return intvmonth;
	}
	public void setIntvmonth(Long intvmonth) {
		this.intvmonth = intvmonth;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Long getRewardid() {
		return rewardid;
	}
	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}
	public String getRewardname() {
		return rewardname;
	}
	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}
	public Double getRewardstd() {
		return rewardstd;
	}
	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}
	public Long getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(Long rewardtype) {
		this.rewardtype = rewardtype;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getStopdate() {
		return stopdate;
	}
	public void setStopdate(Date stopdate) {
		this.stopdate = stopdate;
	}
	public String toString() {
		return new ToStringBuilder(this).append("region", getRegion()).append(
				"rewardid", getRewardid()).toString();
	}
	public boolean equals(Object other) {
		if (!(other instanceof StdrewardbjVO))
			return false;
		StdrewardbjVO castOther = (StdrewardbjVO) other;
		return new EqualsBuilder().append(this.getRegion(),
				castOther.getRegion()).append(this.getRewardid(),
				castOther.getRewardid()).isEquals();
	}
	
	public RewardrulequeryVO() {
	}
	
	public RewardrulequeryVO(java.lang.String region, java.lang.Long rewardid,
			java.lang.String opnid) {
		this.region = region;
		this.rewardid = rewardid;
		this.opnid = opnid;
	}
	/** full constructor */
	public RewardrulequeryVO(java.lang.String region, java.lang.Long rewardid,
			java.lang.String opnid, java.lang.Long acctype,
			java.lang.Double rewardstd, java.lang.Long intvmonth,
			java.util.Date startdate,java.util.Date stopdate
			) {
		this.region = region;
		this.rewardid = rewardid;
		this.opnid = opnid;
		this.acctype = acctype;
		this.rewardstd = rewardstd;
		this.intvmonth = intvmonth;
		this.startdate=startdate;
		this.stopdate=stopdate;
	}
	public int hashCode() {
		return new HashCodeBuilder().append(getRegion()).append(getRewardid())
				.toHashCode();
	}
}
