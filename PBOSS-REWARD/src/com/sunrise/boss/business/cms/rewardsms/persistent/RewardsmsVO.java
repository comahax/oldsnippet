package com.sunrise.boss.business.cms.rewardsms.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardsmsVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private java.util.Date sendtime;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String opercode;

    /** nullable persistent field */
    private String opertype;

    /** nullable persistent field */
    private java.util.Date opertime;

    /** full constructor */
    public RewardsmsVO(java.lang.Long seq, java.lang.String countyid, java.util.Date sendtime, java.lang.String calcmonth, java.lang.String opercode, java.lang.String opertype, java.util.Date opertime) {
        this.seq = seq;
        this.countyid = countyid;
        this.sendtime = sendtime;
        this.calcmonth = calcmonth;
        this.opercode = opercode;
        this.opertype = opertype;
        this.opertime = opertime;
    }

    /** default constructor */
    public RewardsmsVO() {
    }

    /** minimal constructor */
    public RewardsmsVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.util.Date getSendtime() {
        return this.sendtime;
    }

    public void setSendtime(java.util.Date sendtime) {
        this.sendtime = sendtime;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }

    public java.lang.String getOpertype() {
        return this.opertype;
    }

    public void setOpertype(java.lang.String opertype) {
        this.opertype = opertype;
    }

    public java.util.Date getOpertime() {
        return this.opertime;
    }

    public void setOpertime(java.util.Date opertime) {
        this.opertime = opertime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardsmsVO) ) return false;
        RewardsmsVO castOther = (RewardsmsVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
