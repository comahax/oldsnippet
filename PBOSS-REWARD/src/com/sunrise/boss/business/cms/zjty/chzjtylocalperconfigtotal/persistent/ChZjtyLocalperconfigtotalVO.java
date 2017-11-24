package com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyLocalperconfigtotalVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String companytype;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String zjtyname;

    /** nullable persistent field */
    private java.util.Date connecttime;

    /** nullable persistent field */
    private Long total;

    /** nullable persistent field */
    private String rewardreporttime;

    /** full constructor */
    public ChZjtyLocalperconfigtotalVO(java.lang.Long recid, java.lang.String wayname, java.lang.String companytype, java.lang.String cityid, java.lang.String zjtyname, java.util.Date connecttime, java.lang.Long total, java.lang.String rewardreporttime) {
        this.recid = recid;
        this.wayname = wayname;
        this.companytype = companytype;
        this.cityid = cityid;
        this.zjtyname = zjtyname;
        this.connecttime = connecttime;
        this.total = total;
        this.rewardreporttime = rewardreporttime;
    }

    /** default constructor */
    public ChZjtyLocalperconfigtotalVO() {
    }

    /** minimal constructor */
    public ChZjtyLocalperconfigtotalVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getCompanytype() {
        return this.companytype;
    }

    public void setCompanytype(java.lang.String companytype) {
        this.companytype = companytype;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getZjtyname() {
        return this.zjtyname;
    }

    public void setZjtyname(java.lang.String zjtyname) {
        this.zjtyname = zjtyname;
    }

    public java.util.Date getConnecttime() {
        return this.connecttime;
    }

    public void setConnecttime(java.util.Date connecttime) {
        this.connecttime = connecttime;
    }

    public java.lang.Long getTotal() {
        return this.total;
    }

    public void setTotal(java.lang.Long total) {
        this.total = total;
    }

    public java.lang.String getRewardreporttime() {
        return this.rewardreporttime;
    }

    public void setRewardreporttime(java.lang.String rewardreporttime) {
        this.rewardreporttime = rewardreporttime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyLocalperconfigtotalVO) ) return false;
        ChZjtyLocalperconfigtotalVO castOther = (ChZjtyLocalperconfigtotalVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
