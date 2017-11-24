package com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogVO;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RewardpoolywVO implements OperationLog {
	public Class logVOClass() {
		return RewardpoolywlogVO.class;
	}

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String region;

    /** identifier field */
    private Integer rewardtype;

    /** full constructor */
    public RewardpoolywVO(java.lang.String opnid, java.lang.String region, java.lang.Integer rewardtype) {
        this.opnid = opnid;
        this.region = region;
        this.rewardtype = rewardtype;
    }

    /** default constructor */
    public RewardpoolywVO() {
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

    public java.lang.Integer getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Integer rewardtype) {
        this.rewardtype = rewardtype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .append("region", getRegion())
            .append("rewardtype", getRewardtype())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardpoolywVO) ) return false;
        RewardpoolywVO castOther = (RewardpoolywVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardtype(), castOther.getRewardtype())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getRegion())
            .append(getRewardtype())
            .toHashCode();
    }

}
