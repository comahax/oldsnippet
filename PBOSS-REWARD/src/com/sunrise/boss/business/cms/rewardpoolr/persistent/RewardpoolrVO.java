package com.sunrise.boss.business.cms.rewardpoolr.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RewardpoolrVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Integer rewardtype;

    /** persistent field */
    private String slv;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date stopdate;

    /** nullable persistent field */
    private String memo;
    
    /** nullable persistent field */
    private String proportion;
    
    /** nullable persistent field */
    private String cycle;

    /** full constructor */
    public RewardpoolrVO(java.lang.String region, java.lang.Integer rewardtype, java.lang.String slv, java.util.Date startdate, java.util.Date stopdate, java.lang.String memo, java.lang.String proportion, java.lang.String cycle) {
        this.region = region;
        this.rewardtype = rewardtype;
        this.slv = slv;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.memo = memo;
        this.proportion = proportion;
        this.cycle = cycle;
    }

    /** default constructor */
    public RewardpoolrVO() {
    }

    /** minimal constructor */
    public RewardpoolrVO(java.lang.String region, java.lang.Integer rewardtype, java.lang.String slv) {
        this.region = region;
        this.rewardtype = rewardtype;
        this.slv = slv;
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

    public java.lang.String getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.String slv) {
        this.slv = slv;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getStopdate() {
        return this.stopdate;
    }

    public void setStopdate(java.util.Date stopdate) {
        this.stopdate = stopdate;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardtype", getRewardtype())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardpoolrVO) ) return false;
        RewardpoolrVO castOther = (RewardpoolrVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardtype(), castOther.getRewardtype())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardtype())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RewardpoolrlogVO.class;
	}

}
