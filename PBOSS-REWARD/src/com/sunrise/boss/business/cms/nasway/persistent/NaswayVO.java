package com.sunrise.boss.business.cms.nasway.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NaswayVO implements Serializable {

    /** identifier field */
    private Long itemid;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String agname;

    /** nullable persistent field */
    private Long officetel;

    /** nullable persistent field */
    private String actbank;

    /** nullable persistent field */
    private String actno;

    /** nullable persistent field */
    private Short agstate;

    /** nullable persistent field */
    private java.util.Date optime;

    /** full constructor */
    public NaswayVO(java.lang.Long itemid, java.lang.String wayid, java.lang.String wayname, java.lang.String agname, java.lang.Long officetel, java.lang.String actbank, java.lang.String actno, java.lang.Short agstate, java.util.Date optime) {
        this.itemid = itemid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.agname = agname;
        this.officetel = officetel;
        this.actbank = actbank;
        this.actno = actno;
        this.agstate = agstate;
        this.optime = optime;
    }

    /** default constructor */
    public NaswayVO() {
    }

    /** minimal constructor */
    public NaswayVO(java.lang.Long itemid, java.lang.String wayid) {
        this.itemid = itemid;
        this.wayid = wayid;
    }

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
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

    public java.lang.String getAgname() {
        return this.agname;
    }

    public void setAgname(java.lang.String agname) {
        this.agname = agname;
    }

    public java.lang.Long getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.Long officetel) {
        this.officetel = officetel;
    }

    public java.lang.String getActbank() {
        return this.actbank;
    }

    public void setActbank(java.lang.String actbank) {
        this.actbank = actbank;
    }

    public java.lang.String getActno() {
        return this.actno;
    }

    public void setActno(java.lang.String actno) {
        this.actno = actno;
    }

    public java.lang.Short getAgstate() {
        return this.agstate;
    }

    public void setAgstate(java.lang.Short agstate) {
        this.agstate = agstate;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NaswayVO) ) return false;
        NaswayVO castOther = (NaswayVO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .toHashCode();
    }

}
