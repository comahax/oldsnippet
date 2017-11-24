package com.sunrise.boss.business.cms.salereward.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SalerewardVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private Long slv;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private String opercode;

    /** nullable persistent field */
    private String opertype;

    /** nullable persistent field */
    private java.util.Date opertime;

    /** full constructor */
    public SalerewardVO(java.lang.Long slv, java.lang.Short cityid, java.lang.Double rewardstd, java.lang.String remark, java.lang.String opercode, java.lang.String opertype, java.util.Date opertime) {
        this.slv = slv;
        this.cityid = cityid;
        this.rewardstd = rewardstd;
        this.remark = remark;
        this.opercode = opercode;
        this.opertype = opertype;
        this.opertime = opertime;
    }

    /** default constructor */
    public SalerewardVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Long slv) {
        this.slv = slv;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
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
        if ( !(other instanceof SalerewardVO) ) return false;
        SalerewardVO castOther = (SalerewardVO) other;
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
