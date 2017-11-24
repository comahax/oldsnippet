package com.sunrise.boss.business.cms.opntree.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OpnTreeVO implements Serializable {

    /** identifier field */
    private String opnid;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String parentid;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private Byte isbusi;

    /** nullable persistent field */
    private Short opnlevel;

    /** full constructor */
    public OpnTreeVO(java.lang.String opnid, java.lang.String name, java.lang.String parentid, java.lang.Short state, java.util.Date startdate, java.util.Date enddate, java.lang.Byte isbusi, java.lang.Short opnlevel) {
        this.opnid = opnid;
        this.name = name;
        this.parentid = parentid;
        this.state = state;
        this.startdate = startdate;
        this.enddate = enddate;
        this.isbusi = isbusi;
        this.opnlevel = opnlevel;
    }

    /** default constructor */
    public OpnTreeVO() {
    }

    /** minimal constructor */
    public OpnTreeVO(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getParentid() {
        return this.parentid;
    }

    public void setParentid(java.lang.String parentid) {
        this.parentid = parentid;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.Byte getIsbusi() {
        return this.isbusi;
    }

    public void setIsbusi(java.lang.Byte isbusi) {
        this.isbusi = isbusi;
    }

    public java.lang.Short getOpnlevel() {
        return this.opnlevel;
    }

    public void setOpnlevel(java.lang.Short opnlevel) {
        this.opnlevel = opnlevel;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OpnTreeVO) ) return false;
        OpnTreeVO castOther = (OpnTreeVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .toHashCode();
    }

}
