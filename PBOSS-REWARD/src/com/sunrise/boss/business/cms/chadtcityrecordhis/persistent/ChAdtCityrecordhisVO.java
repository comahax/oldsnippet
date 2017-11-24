package com.sunrise.boss.business.cms.chadtcityrecordhis.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtCityrecordhisVO implements Serializable {

    /** identifier field */
    private Long recordid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Short brand;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private Double paymoney;

    /** nullable persistent field */
    private String approveid;

    /** nullable persistent field */
    private Short isflag;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String accountoprcode;

    /** nullable persistent field */
    private java.util.Date accountoptime;

    /** nullable persistent field */
    private Short systemflag;

    /** nullable persistent field */
    private Long rewardlistid;

    /** nullable persistent field */
    private Long taskid;

    /** nullable persistent field */
    private String mbatchno;
    
    private String paymonth;

    /** full constructor */
    public ChAdtCityrecordhisVO(java.lang.String opnid, java.lang.String wayid, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.String mobile, java.lang.Short brand, java.util.Date oprtime, java.lang.Double busivalue, java.lang.Double paysum, java.lang.Double paymoney, java.lang.String approveid, java.lang.Short isflag, java.lang.String oprcode, java.util.Date optime, java.lang.String accountoprcode, java.util.Date accountoptime, java.lang.Short systemflag, java.lang.Long rewardlistid, java.lang.Long taskid, java.lang.String mbatchno) {
        this.opnid = opnid;
        this.wayid = wayid;
        this.rewardtype = rewardtype;
        this.rewardmonth = rewardmonth;
        this.mobile = mobile;
        this.brand = brand;
        this.oprtime = oprtime;
        this.busivalue = busivalue;
        this.paysum = paysum;
        this.paymoney = paymoney;
        this.approveid = approveid;
        this.isflag = isflag;
        this.oprcode = oprcode;
        this.optime = optime;
        this.accountoprcode = accountoprcode;
        this.accountoptime = accountoptime;
        this.systemflag = systemflag;
        this.rewardlistid = rewardlistid;
        this.taskid = taskid;
        this.mbatchno = mbatchno;
    }

    public ChAdtCityrecordhisVO(Long recordid, String opnid, String wayid,
			Short rewardtype, String rewardmonth, String mobile, Short brand,
			Date oprtime, Double busivalue, Double paysum, Double paymoney,
			String approveid, Short isflag, String oprcode, Date optime,
			String accountoprcode, Date accountoptime, Short systemflag,
			Long rewardlistid, Long taskid, String mbatchno, String paymonth) {
		super();
		this.recordid = recordid;
		this.opnid = opnid;
		this.wayid = wayid;
		this.rewardtype = rewardtype;
		this.rewardmonth = rewardmonth;
		this.mobile = mobile;
		this.brand = brand;
		this.oprtime = oprtime;
		this.busivalue = busivalue;
		this.paysum = paysum;
		this.paymoney = paymoney;
		this.approveid = approveid;
		this.isflag = isflag;
		this.oprcode = oprcode;
		this.optime = optime;
		this.accountoprcode = accountoprcode;
		this.accountoptime = accountoptime;
		this.systemflag = systemflag;
		this.rewardlistid = rewardlistid;
		this.taskid = taskid;
		this.mbatchno = mbatchno;
		this.paymonth = paymonth;
	}

	/** default constructor */
    public ChAdtCityrecordhisVO() {
    }

    public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public java.lang.Long getRecordid() {
        return this.recordid;
    }

    public void setRecordid(java.lang.Long recordid) {
        this.recordid = recordid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Short getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Short brand) {
        this.brand = brand;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public java.lang.Double getPaymoney() {
        return this.paymoney;
    }

    public void setPaymoney(java.lang.Double paymoney) {
        this.paymoney = paymoney;
    }

    public java.lang.String getApproveid() {
        return this.approveid;
    }

    public void setApproveid(java.lang.String approveid) {
        this.approveid = approveid;
    }

    public java.lang.Short getIsflag() {
        return this.isflag;
    }

    public void setIsflag(java.lang.Short isflag) {
        this.isflag = isflag;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getAccountoprcode() {
        return this.accountoprcode;
    }

    public void setAccountoprcode(java.lang.String accountoprcode) {
        this.accountoprcode = accountoprcode;
    }

    public java.util.Date getAccountoptime() {
        return this.accountoptime;
    }

    public void setAccountoptime(java.util.Date accountoptime) {
        this.accountoptime = accountoptime;
    }

    public java.lang.Short getSystemflag() {
        return this.systemflag;
    }

    public void setSystemflag(java.lang.Short systemflag) {
        this.systemflag = systemflag;
    }

    public java.lang.Long getRewardlistid() {
        return this.rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public java.lang.Long getTaskid() {
        return this.taskid;
    }

    public void setTaskid(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.String getMbatchno() {
        return this.mbatchno;
    }

    public void setMbatchno(java.lang.String mbatchno) {
        this.mbatchno = mbatchno;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recordid", getRecordid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtCityrecordhisVO) ) return false;
        ChAdtCityrecordhisVO castOther = (ChAdtCityrecordhisVO) other;
        return new EqualsBuilder()
            .append(this.getRecordid(), castOther.getRecordid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecordid())
            .toHashCode();
    }

}
