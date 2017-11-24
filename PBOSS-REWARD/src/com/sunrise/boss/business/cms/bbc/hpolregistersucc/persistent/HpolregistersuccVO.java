package com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class HpolregistersuccVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private Integer subnumber;

    /** full constructor */
    public HpolregistersuccVO(java.lang.String wayid, java.lang.String wayname, java.lang.Short starlevel, java.lang.String officetel, java.util.Date oprtime, java.lang.String mobile, java.util.Date startdate, java.lang.Integer subnumber) {
        this.wayid = wayid;
        this.wayname = wayname;
        this.starlevel = starlevel;
        this.officetel = officetel;
        this.oprtime = oprtime;
        this.mobile = mobile;
        this.startdate = startdate;
        this.subnumber = subnumber;
    }

    /** default constructor */
    public HpolregistersuccVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
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

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.lang.Integer getSubnumber() {
        return this.subnumber;
    }

    public void setSubnumber(java.lang.Integer subnumber) {
        this.subnumber = subnumber;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof HpolregistersuccVO) ) return false;
        HpolregistersuccVO castOther = (HpolregistersuccVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
