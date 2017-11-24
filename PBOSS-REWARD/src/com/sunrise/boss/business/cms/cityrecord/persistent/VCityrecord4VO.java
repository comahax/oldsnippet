package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;

public class VCityrecord4VO implements Serializable {
	private Long seq;
	private String wayid;
	private String opnid;
	private Short rewardtype;
	private String mobile;
	private String rewardmonth;
	private Date oprtime;
	private Double busivalue;
	private Double paysum;		
	public VCityrecord4VO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VCityrecord4VO(Long seq) {
		super();
		// TODO Auto-generated constructor stub
		this.seq = seq;
	}
	public VCityrecord4VO(Long seq,String wayid, String opnid, Short rewardtype, String mobile,
			String rewardmonth, Date oprtime) {
		this.seq = seq;
		this.wayid = wayid;
		this.opnid = opnid;
		this.rewardtype = rewardtype;
		this.mobile = mobile;
		this.rewardmonth = rewardmonth;
		this.oprtime = oprtime;
	}
	public VCityrecord4VO(Long seq, String wayid, String opnid, Short rewardtype,
			String mobile, String rewardmonth, Date oprtime, Double busivalue,
			Double paysum) {
		super();
		this.seq = seq;
		this.wayid = wayid;
		this.opnid = opnid;
		this.rewardtype = rewardtype;
		this.mobile = mobile;
		this.rewardmonth = rewardmonth;
		this.oprtime = oprtime;
		this.busivalue = busivalue;
		this.paysum = paysum;
	}

	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public Short getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRewardmonth() {
		return rewardmonth;
	}
	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
	public Date getOprtime() {
		return oprtime;
	}
	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}
	public Double getBusivalue() {
		return busivalue;
	}
	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}
	public Double getPaysum() {
		return paysum;
	}
	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
        .append(this.getWayid())
        .append(this.getOpnid())
        .append(this.getRewardtype())
        .append(this.getMobile())
        .append(this.getRewardmonth()) 
        .append(this.getOprtime())
        .toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof VCityrecord4VO) ) return false;
		VCityrecord4VO castOther = (VCityrecord4VO) obj;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getRewardtype(), castOther.getRewardtype())
            .append(this.getMobile(), castOther.getMobile())
            .append(this.getRewardmonth(), castOther.getRewardmonth())
            .append(this.getOprtime(), castOther.getOprtime())
            .isEquals();		
	}
	public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", this.getWayid())
            .append("pnid", this.getOpnid())
            .append("rewardtype", this.getRewardtype())
            .append("mobile", this.getMobile())
            .append("rewardmonth", this.getRewardmonth())
            .append("oprtime", this.getOprtime())
            .toString();
    }
}
