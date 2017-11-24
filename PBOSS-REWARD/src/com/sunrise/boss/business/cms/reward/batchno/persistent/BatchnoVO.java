package com.sunrise.boss.business.cms.reward.batchno.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfVO;

/** @author Hibernate CodeGenerator */
public class BatchnoVO implements Serializable {

    /** persistent field */
    private String batchno;

    /** persistent field */
    private String batchtype;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public BatchnoVO(java.lang.String batchno, java.lang.String batchtype, java.lang.String name, java.lang.String remark) {
        this.batchno = batchno;
        this.batchtype = batchtype;
        this.name = name;
        this.remark = remark;
    }

    /** default constructor */
    public BatchnoVO() {
    }

    /** minimal constructor */
    public BatchnoVO(java.lang.String batchno, java.lang.String batchtype) {
        this.batchno = batchno;
        this.batchtype = batchtype;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBatchtype() {
        return this.batchtype;
    }

    public void setBatchtype(java.lang.String batchtype) {
        this.batchtype = batchtype;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("batchno", getBatchno())
            .append("batchtype", getBatchtype())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardconfVO) ) return false;
        RewardconfVO castOther = (RewardconfVO) other;
        return new EqualsBuilder()
            .append(this.getBatchno(), castOther.getBatchno())
            .append(this.getBatchtype(), castOther.getBatchno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBatchno())
            .append(getBatchtype())
            .toHashCode();
    }

}
