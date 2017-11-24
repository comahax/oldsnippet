package com.sunrise.boss.business.cms.wayhznx.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayhznxVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short years;

    /** nullable persistent field */
    private java.util.Date yearstime;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private java.util.Date cleartime;

    /** nullable persistent field */
    private java.util.Date laststarttime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public WayhznxVO(java.lang.String wayid, java.lang.Short years, java.util.Date yearstime, java.lang.String calcmonth, java.util.Date cleartime, java.util.Date laststarttime, java.lang.String oprcode, java.util.Date oprtime, java.lang.String remark) {
        this.wayid = wayid;
        this.years = years;
        this.yearstime = yearstime;
        this.calcmonth = calcmonth;
        this.cleartime = cleartime;
        this.laststarttime = laststarttime;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.remark = remark;
    }

    /** default constructor */
    public WayhznxVO() {
    }

    /** minimal constructor */
    public WayhznxVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getYears() {
        return this.years;
    }

    public void setYears(java.lang.Short years) {
        this.years = years;
    }

    public java.util.Date getYearstime() {
        return this.yearstime;
    }

    public void setYearstime(java.util.Date yearstime) {
        this.yearstime = yearstime;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.util.Date getCleartime() {
        return this.cleartime;
    }

    public void setCleartime(java.util.Date cleartime) {
        this.cleartime = cleartime;
    }

    public java.util.Date getLaststarttime() {
        return this.laststarttime;
    }

    public void setLaststarttime(java.util.Date laststarttime) {
        this.laststarttime = laststarttime;
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

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayhznxVO) ) return false;
        WayhznxVO castOther = (WayhznxVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

}
