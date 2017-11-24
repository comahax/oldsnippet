package com.sunrise.boss.business.cms.reward.stdrewardcq.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StdrewardcqVO implements Serializable {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** nullable persistent field */
    private Short slv;

    /** nullable persistent field */
    private Double citystd;

    /** full constructor */
    public StdrewardcqVO(java.lang.String region, java.lang.Long rewardid, java.lang.Short slv, java.lang.Double citystd) {
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
        this.citystd = citystd;
    }

    /** default constructor */
    public StdrewardcqVO() {
    }

    /** minimal constructor */
    public StdrewardcqVO(java.lang.String region, java.lang.Long rewardid) {
        this.region = region;
        this.rewardid = rewardid;
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

    public java.lang.Double getCitystd() {
        return this.citystd;
    }

    public void setCitystd(java.lang.Double citystd) {
        this.citystd = citystd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardcqVO) ) return false;
        StdrewardcqVO castOther = (StdrewardcqVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .toHashCode();
    }

}
