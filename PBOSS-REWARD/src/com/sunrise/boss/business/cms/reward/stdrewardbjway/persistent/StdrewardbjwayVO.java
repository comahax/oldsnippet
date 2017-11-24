package com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.stdrewardbjwaylog.persistent.StdrewardbjwaylogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardbjwayVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private String ruleid;

    private boolean updateFlag = false;
    private boolean deleteFlag = false;
    
    public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/** full constructor */
    public StdrewardbjwayVO(java.lang.String region, java.lang.Long rewardid, java.lang.String wayid, java.lang.String opnid, java.lang.Short acctype, java.lang.Double rewardstd, java.lang.String ruleid) {
        this.region = region;
        this.rewardid = rewardid;
        this.wayid = wayid;
        this.opnid = opnid;
        this.acctype = acctype;
        this.rewardstd = rewardstd;
        this.ruleid = ruleid;
    }

    /** default constructor */
    public StdrewardbjwayVO() {
    }

    /** minimal constructor */
    public StdrewardbjwayVO(java.lang.String region, java.lang.Long rewardid, java.lang.String wayid) {
        this.region = region;
        this.rewardid = rewardid;
        this.wayid = wayid;
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbjwayVO) ) return false;
        StdrewardbjwayVO castOther = (StdrewardbjwayVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getAcctype(), castOther.getAcctype())
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return StdrewardbjwaylogVO.class;
	}

	public boolean isUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

}
