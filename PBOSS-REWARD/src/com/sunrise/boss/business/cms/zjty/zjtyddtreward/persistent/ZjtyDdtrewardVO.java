package com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyDdtrewardVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Short ddttype;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String rewardmont;

    /** nullable persistent field */
    private Double amount;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public ZjtyDdtrewardVO(java.lang.Long seqid, java.lang.Short ddttype, java.lang.String wayid, java.lang.String rewardmont, java.lang.Double amount, java.lang.String remark) {
        this.seqid = seqid;
        this.ddttype = ddttype;
        this.wayid = wayid;
        this.rewardmont = rewardmont;
        this.amount = amount;
        this.remark = remark;
    }

    /** default constructor */
    public ZjtyDdtrewardVO() {
    }

    /** minimal constructor */
    public ZjtyDdtrewardVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Short getDdttype() {
        return this.ddttype;
    }

    public void setDdttype(java.lang.Short ddttype) {
        this.ddttype = ddttype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getRewardmont() {
        return this.rewardmont;
    }

    public void setRewardmont(java.lang.String rewardmont) {
        this.rewardmont = rewardmont;
    }

    public java.lang.Double getAmount() {
        return this.amount;
    }

    public void setAmount(java.lang.Double amount) {
        this.amount = amount;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyDdtrewardVO) ) return false;
        ZjtyDdtrewardVO castOther = (ZjtyDdtrewardVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
