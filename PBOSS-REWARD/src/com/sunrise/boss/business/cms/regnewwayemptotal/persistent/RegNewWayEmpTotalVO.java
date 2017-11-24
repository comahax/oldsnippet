package com.sunrise.boss.business.cms.regnewwayemptotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RegNewWayEmpTotalVO implements Serializable {

    /** identifier field */
    private String countyid;

    /** identifier field */
    private Short starlevel;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Long amt;

    /** nullable persistent field */
    private String waymagcode;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Short brand;

    /** full constructor */
    public RegNewWayEmpTotalVO(java.lang.String countyid, java.lang.Short starlevel, java.lang.String wayid, java.lang.String wayname, java.lang.Long amt, java.lang.String waymagcode, java.lang.String svccode, java.util.Date oprtime, java.lang.Short brand) {
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.wayid = wayid;
        this.wayname = wayname;
        this.amt = amt;
        this.waymagcode = waymagcode;
        this.svccode = svccode;
        this.oprtime = oprtime;
        this.brand = brand;
    }

    /** default constructor */
    public RegNewWayEmpTotalVO() {
    }

    /** minimal constructor */
    public RegNewWayEmpTotalVO(java.lang.String countyid, java.lang.Short starlevel, java.lang.String wayid) {
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.wayid = wayid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Long getAmt() {
        return this.amt;
    }

    public void setAmt(java.lang.Long amt) {
        this.amt = amt;
    }

    public java.lang.String getWaymagcode() {
        return this.waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Short getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Short brand) {
        this.brand = brand;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("countyid", getCountyid())
            .append("starlevel", getStarlevel())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RegNewWayEmpTotalVO) ) return false;
        RegNewWayEmpTotalVO castOther = (RegNewWayEmpTotalVO) other;
        return new EqualsBuilder()
            .append(this.getCountyid(), castOther.getCountyid())
            .append(this.getStarlevel(), castOther.getStarlevel())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCountyid())
            .append(getStarlevel())
            .append(getWayid())
            .toHashCode();
    }

}
