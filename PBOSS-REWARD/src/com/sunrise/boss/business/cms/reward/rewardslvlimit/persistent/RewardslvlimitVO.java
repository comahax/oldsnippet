package com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardslvlimitVO implements Serializable {

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** identifier field */
    private Short slv;

    /** nullable persistent field */
    private Double rewardlimit;

    /** full constructor */
    public RewardslvlimitVO(java.lang.String opnid, java.lang.String region, java.lang.Long rewardid, java.lang.Short slv, java.lang.Double rewardlimit) {
        this.opnid = opnid;
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
        this.rewardlimit = rewardlimit;
    }

    /** default constructor */
    public RewardslvlimitVO() {
    }

    /** minimal constructor */
    public RewardslvlimitVO(java.lang.String opnid, java.lang.String region, java.lang.Long rewardid, java.lang.Short slv) {
        this.opnid = opnid;
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Short getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Short slv) {
        this.slv = slv;
    }

    public java.lang.Double getRewardlimit() {
        return this.rewardlimit;
    }

    public void setRewardlimit(java.lang.Double rewardlimit) {
        this.rewardlimit = rewardlimit;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .append("slv", getSlv())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardslvlimitVO) ) return false;
        RewardslvlimitVO castOther = (RewardslvlimitVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .append(this.getSlv(), castOther.getSlv())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getRegion())
            .append(getRewardid())
            .append(getSlv())
            .toHashCode();
    }

}
