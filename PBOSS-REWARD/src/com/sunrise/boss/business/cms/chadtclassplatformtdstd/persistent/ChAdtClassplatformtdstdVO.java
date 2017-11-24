package com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtClassplatformtdstdVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** persistent field */
    private String comid;

    /** persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Long saleslower;

    /** nullable persistent field */
    private Long salesupper;

    /** nullable persistent field */
    private Double rewardstd;

    /** persistent field */
    private Short citycode;

    /** full constructor */
    public ChAdtClassplatformtdstdVO(java.lang.Long seq, java.lang.String comid, java.lang.Short rewardtype, java.lang.Short acctype, java.lang.Long saleslower, java.lang.Long salesupper, java.lang.Double rewardstd, java.lang.Short citycode) {
        this.seq = seq;
        this.comid = comid;
        this.rewardtype = rewardtype;
        this.acctype = acctype;
        this.saleslower = saleslower;
        this.salesupper = salesupper;
        this.rewardstd = rewardstd;
        this.citycode = citycode;
    }

    /** default constructor */
    public ChAdtClassplatformtdstdVO() {
    }

    /** minimal constructor */
    public ChAdtClassplatformtdstdVO(java.lang.Long seq, java.lang.String comid, java.lang.Short rewardtype, java.lang.Short citycode) {
        this.seq = seq;
        this.comid = comid;
        this.rewardtype = rewardtype;
        this.citycode = citycode;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getComid() {
        return this.comid;
    }

    public void setComid(java.lang.String comid) {
        this.comid = comid;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Long getSaleslower() {
        return this.saleslower;
    }

    public void setSaleslower(java.lang.Long saleslower) {
        this.saleslower = saleslower;
    }

    public java.lang.Long getSalesupper() {
        return this.salesupper;
    }

    public void setSalesupper(java.lang.Long salesupper) {
        this.salesupper = salesupper;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Short getCitycode() {
        return this.citycode;
    }

    public void setCitycode(java.lang.Short citycode) {
        this.citycode = citycode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtClassplatformtdstdVO) ) return false;
        ChAdtClassplatformtdstdVO castOther = (ChAdtClassplatformtdstdVO) other;
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
