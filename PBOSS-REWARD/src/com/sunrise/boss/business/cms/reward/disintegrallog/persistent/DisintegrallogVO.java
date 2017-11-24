package com.sunrise.boss.business.cms.reward.disintegrallog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisintegrallogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String region;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private Integer rewardtype;

    /** nullable persistent field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String calmonth;

    /** nullable persistent field */
    private Short integraltype;

    /** nullable persistent field */
    private Long integralnum;

    /** full constructor */
    public DisintegrallogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String region, java.lang.String opnid, java.lang.Integer rewardtype, java.lang.Long seq, java.lang.String wayid, java.lang.String calmonth, java.lang.Short integraltype, java.lang.Long integralnum) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.region = region;
        this.opnid = opnid;
        this.rewardtype = rewardtype;
        this.seq = seq;
        this.wayid = wayid;
        this.calmonth = calmonth;
        this.integraltype = integraltype;
        this.integralnum = integralnum;
    }

    /** default constructor */
    public DisintegrallogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Integer getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Integer rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCalmonth() {
        return this.calmonth;
    }

    public void setCalmonth(java.lang.String calmonth) {
        this.calmonth = calmonth;
    }

    public java.lang.Short getIntegraltype() {
        return this.integraltype;
    }

    public void setIntegraltype(java.lang.Short integraltype) {
        this.integraltype = integraltype;
    }

    public java.lang.Long getIntegralnum() {
        return this.integralnum;
    }

    public void setIntegralnum(java.lang.Long integralnum) {
        this.integralnum = integralnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisintegrallogVO) ) return false;
        DisintegrallogVO castOther = (DisintegrallogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
