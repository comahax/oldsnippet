package com.sunrise.boss.business.cms.cityrewardad.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CityrewardadVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private String cityid;

    /** identifier field */
    private String paymonth;

    /** identifier field */
    private Short rewardtype;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Double amt;

    /** full constructor */
    public CityrewardadVO(java.lang.String cityid, java.lang.String paymonth, java.lang.Short rewardtype, java.lang.String wayid, java.lang.Double amt) {
        this.cityid = cityid;
        this.paymonth = paymonth;
        this.rewardtype = rewardtype;
        this.wayid = wayid;
        this.amt = amt;
    }

    /** default constructor */
    public CityrewardadVO() {
    }

    /** minimal constructor */
    public CityrewardadVO(java.lang.String cityid, java.lang.String paymonth, java.lang.Short rewardtype, java.lang.String wayid) {
        this.cityid = cityid;
        this.paymonth = paymonth;
        this.rewardtype = rewardtype;
        this.wayid = wayid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getPaymonth() {
        return this.paymonth;
    }

    public void setPaymonth(java.lang.String paymonth) {
        this.paymonth = paymonth;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getAmt() {
        return this.amt;
    }

    public void setAmt(java.lang.Double amt) {
        this.amt = amt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("paymonth", getPaymonth())
            .append("rewardtype", getRewardtype())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CityrewardadVO) ) return false;
        CityrewardadVO castOther = (CityrewardadVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getPaymonth(), castOther.getPaymonth())
            .append(this.getRewardtype(), castOther.getRewardtype())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getPaymonth())
            .append(getRewardtype())
            .append(getWayid())
            .toHashCode();
    }

}
