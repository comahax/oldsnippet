package com.sunrise.boss.business.cms.nasrwdtotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NasrwdtotalVO implements Serializable {

    /** identifier field */
    private Long totalid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Double paymoney;

    /** nullable persistent field */
    private Short ossrc;

    /** full constructor */
    public NasrwdtotalVO(java.lang.Long totalid, java.lang.String wayid, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.Double paymoney, java.lang.Short ossrc) {
        this.totalid = totalid;
        this.wayid = wayid;
        this.rewardtype = rewardtype;
        this.rewardmonth = rewardmonth;
        this.paymoney = paymoney;
        this.ossrc = ossrc;
    }

    /** default constructor */
    public NasrwdtotalVO() {
    }

    /** minimal constructor */
    public NasrwdtotalVO(java.lang.Long totalid) {
        this.totalid = totalid;
    }

    public java.lang.Long getTotalid() {
        return this.totalid;
    }

    public void setTotalid(java.lang.Long totalid) {
        this.totalid = totalid;
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

    public java.lang.Double getPaymoney() {
        return this.paymoney;
    }

    public void setPaymoney(java.lang.Double paymoney) {
        this.paymoney = paymoney;
    }

    public java.lang.Short getOssrc() {
        return this.ossrc;
    }

    public void setOssrc(java.lang.Short ossrc) {
        this.ossrc = ossrc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("totalid", getTotalid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NasrwdtotalVO) ) return false;
        NasrwdtotalVO castOther = (NasrwdtotalVO) other;
        return new EqualsBuilder()
            .append(this.getTotalid(), castOther.getTotalid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTotalid())
            .toHashCode();
    }

}
