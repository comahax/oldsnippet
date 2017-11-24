package com.sunrise.boss.business.cms.bbc.registersucc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RegistersuccVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String calcopnid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Long busivalue;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Short ossrc;

    /** full constructor */
    public RegistersuccVO(java.lang.String ruleid, java.lang.String opnid, java.lang.String calcopnid, java.lang.String calcmonth, java.lang.String wayid, java.util.Date oprtime, java.lang.String officetel, java.lang.String mobile, java.lang.Long busivalue, java.lang.Short rewardtype, java.lang.Short ossrc) {
        this.ruleid = ruleid;
        this.opnid = opnid;
        this.calcopnid = calcopnid;
        this.calcmonth = calcmonth;
        this.wayid = wayid;
        this.oprtime = oprtime;
        this.officetel = officetel;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.rewardtype = rewardtype;
        this.ossrc = ossrc;
    }

    /** default constructor */
    public RegistersuccVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getCalcopnid() {
        return this.calcopnid;
    }

    public void setCalcopnid(java.lang.String calcopnid) {
        this.calcopnid = calcopnid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Long getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Long busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Short getOssrc() {
        return this.ossrc;
    }

    public void setOssrc(java.lang.Short ossrc) {
        this.ossrc = ossrc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RegistersuccVO) ) return false;
        RegistersuccVO castOther = (RegistersuccVO) other;
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
