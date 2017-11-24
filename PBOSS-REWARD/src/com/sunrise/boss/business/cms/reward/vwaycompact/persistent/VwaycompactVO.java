package com.sunrise.boss.business.cms.reward.vwaycompact.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VwaycompactVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short calcumode;

    /** nullable persistent field */
    private String uniformtime;

    /** nullable persistent field */
    private String setflag;

    /** full constructor */
    public VwaycompactVO(java.lang.String cityid, java.lang.String wayid, java.lang.String wayname, java.lang.Short calcumode, java.lang.String uniformtime, java.lang.String setflag) {
        this.cityid = cityid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.calcumode = calcumode;
        this.uniformtime = uniformtime;
        this.setflag = setflag;
    }

    /** default constructor */
    public VwaycompactVO() {
    }

    /** minimal constructor */
    public VwaycompactVO(java.lang.String cityid, java.lang.String wayid) {
        this.cityid = cityid;
        this.wayid = wayid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
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

    public java.lang.Short getCalcumode() {
        return this.calcumode;
    }

    public void setCalcumode(java.lang.Short calcumode) {
        this.calcumode = calcumode;
    }

    public java.lang.String getUniformtime() {
        return this.uniformtime;
    }

    public void setUniformtime(java.lang.String uniformtime) {
        this.uniformtime = uniformtime;
    }

    public java.lang.String getSetflag() {
        return this.setflag;
    }

    public void setSetflag(java.lang.String setflag) {
        this.setflag = setflag;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VwaycompactVO) ) return false;
        VwaycompactVO castOther = (VwaycompactVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getWayid())
            .toHashCode();
    }

}
