package com.sunrise.boss.business.cms.reward.creditstd3g.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/** @author Hibernate CodeGenerator */
public class VCreditstd3gVO implements Serializable {

    public Double getRewardstdup() {
		return rewardstdup;
	}

	public void setRewardstdup(Double rewardstdup) {
		this.rewardstdup = rewardstdup;
	}

	/** identifier field */
    private Short cityid;

    /** identifier field */
    private String wayattr;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Double creditstd;

    /** nullable persistent field */
    private Double terminalstd;

    /** nullable persistent field */
    private Double zcterminalstd;

    /** nullable persistent field */
    private Short intvmonth;
    
    private Double rewardstdup;
    
	//专营奖励酬金标准
    private Double zyrewardstd;
    //积分奖励酬金标准（门店补贴下限）
    private Double jfrewardstd;
    //积分下限值
    private Double jfcreditstd;
    //全球通开户保底要求
    private Double gtnstd;

    /** full constructor */
    public VCreditstd3gVO(java.lang.Short cityid, java.lang.String wayattr, 
    		java.lang.Double rewardstd, java.lang.Double creditstd, java.lang.Double terminalstd,
    		java.lang.Double zcterminalstd, java.lang.Short intvmonth, Double rewardstdup) {
        this.cityid = cityid;
        this.wayattr = wayattr;
        this.rewardstd = rewardstd;
        this.creditstd = creditstd;
        this.terminalstd = terminalstd;
        this.zcterminalstd = zcterminalstd;
        this.intvmonth = intvmonth;
        this.rewardstdup = rewardstdup;
    }

    /** default constructor */
    public VCreditstd3gVO() {
    }

    /** minimal constructor */
    public VCreditstd3gVO(java.lang.Short cityid, java.lang.String wayattr) {
        this.cityid = cityid;
        this.wayattr = wayattr;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWayattr() {
        return this.wayattr;
    }

    public void setWayattr(java.lang.String wayattr) {
        this.wayattr = wayattr;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }

    public java.lang.Double getTerminalstd() {
        return this.terminalstd;
    }

    public void setTerminalstd(java.lang.Double terminalstd) {
        this.terminalstd = terminalstd;
    }

    public java.lang.Double getZcterminalstd() {
        return this.zcterminalstd;
    }

    public void setZcterminalstd(java.lang.Double zcterminalstd) {
        this.zcterminalstd = zcterminalstd;
    }

    public java.lang.Short getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Short intvmonth) {
        this.intvmonth = intvmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("wayattr", getWayattr())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Creditstd3gVO) ) return false;
        Creditstd3gVO castOther = (Creditstd3gVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getWayattr(), castOther.getWayattr())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getWayattr())
            .toHashCode();
    }

	public Double getZyrewardstd() {
		return zyrewardstd;
	}

	public void setZyrewardstd(Double zyrewardstd) {
		this.zyrewardstd = zyrewardstd;
	}

	public Double getJfrewardstd() {
		return jfrewardstd;
	}

	public void setJfrewardstd(Double jfrewardstd) {
		this.jfrewardstd = jfrewardstd;
	}

	public Double getJfcreditstd() {
		return jfcreditstd;
	}

	public void setJfcreditstd(Double jfcreditstd) {
		this.jfcreditstd = jfcreditstd;
	}

	public Double getGtnstd() {
		return gtnstd;
	}

	public void setGtnstd(Double gtnstd) {
		this.gtnstd = gtnstd;
	}
}
