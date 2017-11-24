package com.sunrise.boss.business.cms.stdrewardhz.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardhzVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** identifier field */
    private Short slv;

    /** identifier field */
    private Short years;

    /** nullable persistent field */
    private Double lmtstd;

    /** nullable persistent field */
    private Double citystd;
    
    private String state;
    
    private String relateitem;

	/** full constructor */
    public StdrewardhzVO(java.lang.String region, java.lang.Long rewardid, java.lang.Short slv, java.lang.Short years, java.lang.Double lmtstd, java.lang.Double citystd, java.lang.String relateitem) {
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
        this.years = years;
        this.lmtstd = lmtstd;
        this.citystd = citystd;
        this.relateitem = relateitem;
    }

    /** default constructor */
    public StdrewardhzVO() {
    }

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/** minimal constructor */
    public StdrewardhzVO(java.lang.String region, java.lang.Long rewardid, java.lang.Short slv, java.lang.Short years) {
        this.region = region;
        this.rewardid = rewardid;
        this.slv = slv;
        this.years = years;
    }

    public String getRelateitem() {
		return relateitem;
	}

	public void setRelateitem(String relateitem) {
		this.relateitem = relateitem;
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

    public java.lang.Short getYears() {
        return this.years;
    }

    public void setYears(java.lang.Short years) {
        this.years = years;
    }

    public java.lang.Double getLmtstd() {
        return this.lmtstd;
    }

    public void setLmtstd(java.lang.Double lmtstd) {
        this.lmtstd = lmtstd;
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
            .append("slv", getSlv())
            .append("years", getYears())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardhzVO) ) return false;
        StdrewardhzVO castOther = (StdrewardhzVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .append(this.getSlv(), castOther.getSlv())
            .append(this.getYears(), castOther.getYears())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .append(getSlv())
            .append(getYears())
            .toHashCode();
    }

	public Class logVOClass() {
		return StdrewardhzlogVO.class;
	}

}
