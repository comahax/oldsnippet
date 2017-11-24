package com.sunrise.boss.business.cms.rewardasse.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RewardasseVO implements OperationLog {

    /** identifier field */
    private String assemonth;

    /** identifier field */
    private Integer rewardtype;

    /** identifier field */
    private String wayid;

    /** persistent field */
    private Float assegrade;

    /** nullable persistent field */
    private String memo;
    
    private String calcmonth;

    /** full constructor */
    public RewardasseVO(java.lang.String assemonth, java.lang.Integer rewardtype, java.lang.String wayid, java.lang.Float assegrade, java.lang.String memo) {
        this.assemonth = assemonth;
        this.rewardtype = rewardtype;
        this.wayid = wayid;
        this.assegrade = assegrade;
        this.memo = memo;
    }

    /** default constructor */
    public RewardasseVO() {
    }

    /** minimal constructor */
    public RewardasseVO(java.lang.String assemonth, java.lang.Integer rewardtype, java.lang.String wayid, java.lang.Float assegrade) {
        this.assemonth = assemonth;
        this.rewardtype = rewardtype;
        this.wayid = wayid;
        this.assegrade = assegrade;
    }

    public java.lang.String getAssemonth() {
        return this.assemonth;
    }

    public void setAssemonth(java.lang.String assemonth) {
        this.assemonth = assemonth;
    }

    public java.lang.Integer getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Integer rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Float getAssegrade() {
        return this.assegrade;
    }

    public void setAssegrade(java.lang.Float assegrade) {
        this.assegrade = assegrade;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("assemonth", getAssemonth())
            .append("rewardtype", getRewardtype())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardasseVO) ) return false;
        RewardasseVO castOther = (RewardasseVO) other;
        return new EqualsBuilder()
            .append(this.getAssemonth(), castOther.getAssemonth())
            .append(this.getRewardtype(), castOther.getRewardtype())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAssemonth())
            .append(getRewardtype())
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RewardasselogVO.class;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}
     
	
	
}
