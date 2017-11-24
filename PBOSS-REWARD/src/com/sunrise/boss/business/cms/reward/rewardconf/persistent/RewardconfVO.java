package com.sunrise.boss.business.cms.reward.rewardconf.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardconfVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String rewardkind;

    /** identifier field */
    private String rewardmonth;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;
    
    private String batchno;

    /** full constructor */
    public RewardconfVO(java.lang.String cityid, java.lang.String rewardkind, java.lang.String rewardmonth, java.lang.Short state, java.lang.String oprcode, java.util.Date oprtime, java.lang.String batchno) {
        this.cityid = cityid;
        this.rewardkind = rewardkind;
        this.rewardmonth = rewardmonth;
        this.state = state;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.batchno = batchno;
    }

    /** default constructor */
    public RewardconfVO() {
    }

    /** minimal constructor */
    public RewardconfVO(java.lang.String cityid, java.lang.String rewardkind, java.lang.String rewardmonth, java.lang.String batchno) {
        this.cityid = cityid;
        this.rewardkind = rewardkind;
        this.rewardmonth = rewardmonth;
        this.batchno = batchno;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRewardkind() {
        return this.rewardkind;
    }

    public void setRewardkind(java.lang.String rewardkind) {
        this.rewardkind = rewardkind;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("rewardkind", getRewardkind())
            .append("rewardmonth", getRewardmonth())
            .append("batchno", getBatchno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardconfVO) ) return false;
        RewardconfVO castOther = (RewardconfVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getRewardkind(), castOther.getRewardkind())
            .append(this.getRewardmonth(), castOther.getRewardmonth())
            .append(this.getBatchno(), castOther.getBatchno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getRewardkind())
            .append(getRewardmonth())
            .append(getBatchno())
            .toHashCode();
    }

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

}
