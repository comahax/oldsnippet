package com.sunrise.boss.business.cms.waystrarewardstd.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaystrarewardstdVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Long rewardtype;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private String opercode;

    /** nullable persistent field */
    private String opertype;

    /** nullable persistent field */
    private java.util.Date opertime;

    /** full constructor */
    public WaystrarewardstdVO(java.lang.String wayid, java.lang.Short cityid, java.lang.Double rewardstd, java.lang.Long rewardtype, java.lang.String remark, java.lang.String opercode, java.lang.String opertype, java.util.Date opertime) {
        this.wayid = wayid;
        this.cityid = cityid;
        this.rewardstd = rewardstd;
        this.rewardtype = rewardtype;
        this.remark = remark;
        this.opercode = opercode;
        this.opertype = opertype;
        this.opertime = opertime;
    }

    /** default constructor */
    public WaystrarewardstdVO() {
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

    public java.lang.Long getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Long rewardtype) {
        this.rewardtype = rewardtype;
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
        if ( !(other instanceof WaystrarewardstdVO) ) return false;
        WaystrarewardstdVO castOther = (WaystrarewardstdVO) other;
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
