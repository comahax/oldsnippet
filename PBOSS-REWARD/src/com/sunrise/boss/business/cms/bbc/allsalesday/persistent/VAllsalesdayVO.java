package com.sunrise.boss.business.cms.bbc.allsalesday.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VAllsalesdayVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String opnname;

    /** nullable persistent field */
    private String calcopnid;

    /** nullable persistent field */
    private String calopnname;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Short ossrc;

    /** nullable persistent field */
    private Short empattr2;

    /** nullable persistent field */
    private String srcseq;

    /** full constructor */
    public VAllsalesdayVO(java.lang.Long seq, java.lang.String ruleid, java.lang.String opnid, java.lang.String opnname, java.lang.String calcopnid, java.lang.String calopnname, java.lang.String calcmonth, java.lang.String wayid, java.lang.String wayname, java.util.Date oprtime, java.lang.String oprcode, java.lang.String mobile, java.lang.Double busivalue, java.lang.Short rewardtype, java.lang.Short ossrc, java.lang.Short empattr2, java.lang.String srcseq) {
        this.seq = seq;
        this.ruleid = ruleid;
        this.opnid = opnid;
        this.opnname = opnname;
        this.calcopnid = calcopnid;
        this.calopnname = calopnname;
        this.calcmonth = calcmonth;
        this.wayid = wayid;
        this.wayname = wayname;
        this.oprtime = oprtime;
        this.oprcode = oprcode;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.rewardtype = rewardtype;
        this.ossrc = ossrc;
        this.empattr2 = empattr2;
        this.srcseq = srcseq;
    }

    /** default constructor */
    public VAllsalesdayVO() {
    }

    /** minimal constructor */
    public VAllsalesdayVO(java.lang.Long seq) {
        this.seq = seq;
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

    public java.lang.String getOpnname() {
        return this.opnname;
    }

    public void setOpnname(java.lang.String opnname) {
        this.opnname = opnname;
    }

    public java.lang.String getCalcopnid() {
        return this.calcopnid;
    }

    public void setCalcopnid(java.lang.String calcopnid) {
        this.calcopnid = calcopnid;
    }

    public java.lang.String getCalopnname() {
        return this.calopnname;
    }

    public void setCalopnname(java.lang.String calopnname) {
        this.calopnname = calopnname;
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

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
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

    public java.lang.Short getEmpattr2() {
        return this.empattr2;
    }

    public void setEmpattr2(java.lang.Short empattr2) {
        this.empattr2 = empattr2;
    }

    public java.lang.String getSrcseq() {
        return this.srcseq;
    }

    public void setSrcseq(java.lang.String srcseq) {
        this.srcseq = srcseq;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VAllsalesdayVO) ) return false;
        VAllsalesdayVO castOther = (VAllsalesdayVO) other;
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
