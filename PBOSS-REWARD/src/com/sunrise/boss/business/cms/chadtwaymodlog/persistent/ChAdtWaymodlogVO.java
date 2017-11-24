package com.sunrise.boss.business.cms.chadtwaymodlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtWaymodlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Float vi;

    /** nullable persistent field */
    private Float area;

    /** nullable persistent field */
    private Float doorhead;

    /** nullable persistent field */
    private Float backboard;

    /** nullable persistent field */
    private Float propaganda;

    /** full constructor */
    public ChAdtWaymodlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Short cityid, java.lang.String wayid, java.lang.Float vi, java.lang.Float area, java.lang.Float doorhead, java.lang.Float backboard, java.lang.Float propaganda) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.cityid = cityid;
        this.wayid = wayid;
        this.vi = vi;
        this.area = area;
        this.doorhead = doorhead;
        this.backboard = backboard;
        this.propaganda = propaganda;
    }

    /** default constructor */
    public ChAdtWaymodlogVO() {
    }

    /** minimal constructor */
    public ChAdtWaymodlogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Float getVi() {
        return this.vi;
    }

    public void setVi(java.lang.Float vi) {
        this.vi = vi;
    }

    public java.lang.Float getArea() {
        return this.area;
    }

    public void setArea(java.lang.Float area) {
        this.area = area;
    }

    public java.lang.Float getDoorhead() {
        return this.doorhead;
    }

    public void setDoorhead(java.lang.Float doorhead) {
        this.doorhead = doorhead;
    }

    public java.lang.Float getBackboard() {
        return this.backboard;
    }

    public void setBackboard(java.lang.Float backboard) {
        this.backboard = backboard;
    }

    public java.lang.Float getPropaganda() {
        return this.propaganda;
    }

    public void setPropaganda(java.lang.Float propaganda) {
        this.propaganda = propaganda;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtWaymodlogVO) ) return false;
        ChAdtWaymodlogVO castOther = (ChAdtWaymodlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
