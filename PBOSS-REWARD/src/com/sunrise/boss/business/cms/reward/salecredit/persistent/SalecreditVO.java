package com.sunrise.boss.business.cms.reward.salecredit.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SalecreditVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private Long busitype;

    /** nullable persistent field */
    private Double creditaccount;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Double creditstd;

    /** full constructor */
    public SalecreditVO(java.lang.Long seq, java.lang.String wayid, java.lang.String calcmonth, java.lang.Long busitype, java.lang.Double creditaccount, java.lang.Double busivalue, java.lang.Double creditstd) {
        this.seq = seq;
        this.wayid = wayid;
        this.calcmonth = calcmonth;
        this.busitype = busitype;
        this.creditaccount = creditaccount;
        this.busivalue = busivalue;
        this.creditstd = creditstd;
    }

    /** default constructor */
    public SalecreditVO() {
    }

    /** minimal constructor */
    public SalecreditVO(java.lang.Long seq) {
        this.seq = seq;
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

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.Long getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.Long busitype) {
        this.busitype = busitype;
    }

    public java.lang.Double getCreditaccount() {
        return this.creditaccount;
    }

    public void setCreditaccount(java.lang.Double creditaccount) {
        this.creditaccount = creditaccount;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SalecreditVO) ) return false;
        SalecreditVO castOther = (SalecreditVO) other;
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
