package com.sunrise.boss.business.cms.nores.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NoresVO implements Serializable {

    /** identifier field */
    private String mobileno;

    /** persistent field */
    private Short notype;

    /** nullable persistent field */
    private String activeimsi;

    /** persistent field */
    private String prodid;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private java.util.Date stoptime;

    /** nullable persistent field */
    private Long selnofee;

    /** persistent field */
    private Short nostate;

    /** persistent field */
    private Integer nosectid;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private String oprcode;

    /** nullable persistent field */
    private Short mobiletype;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String noprompt;

    /** full constructor */
    public NoresVO(java.lang.String mobileno, java.lang.Short notype, java.lang.String activeimsi, java.lang.String prodid, java.util.Date starttime, java.util.Date stoptime, java.lang.Long selnofee, java.lang.Short nostate, java.lang.Integer nosectid, java.lang.String wayid, java.lang.String oprcode, java.lang.Short mobiletype, java.lang.String memo, java.lang.String noprompt) {
        this.mobileno = mobileno;
        this.notype = notype;
        this.activeimsi = activeimsi;
        this.prodid = prodid;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.selnofee = selnofee;
        this.nostate = nostate;
        this.nosectid = nosectid;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.mobiletype = mobiletype;
        this.memo = memo;
        this.noprompt = noprompt;
    }

    /** default constructor */
    public NoresVO() {
    }

    /** minimal constructor */
    public NoresVO(java.lang.String mobileno, java.lang.Short notype, java.lang.String prodid, java.lang.Short nostate, java.lang.Integer nosectid, java.lang.String wayid, java.lang.String oprcode) {
        this.mobileno = mobileno;
        this.notype = notype;
        this.prodid = prodid;
        this.nostate = nostate;
        this.nosectid = nosectid;
        this.wayid = wayid;
        this.oprcode = oprcode;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.lang.Short getNotype() {
        return this.notype;
    }

    public void setNotype(java.lang.Short notype) {
        this.notype = notype;
    }

    public java.lang.String getActiveimsi() {
        return this.activeimsi;
    }

    public void setActiveimsi(java.lang.String activeimsi) {
        this.activeimsi = activeimsi;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getStoptime() {
        return this.stoptime;
    }

    public void setStoptime(java.util.Date stoptime) {
        this.stoptime = stoptime;
    }

    public java.lang.Long getSelnofee() {
        return this.selnofee;
    }

    public void setSelnofee(java.lang.Long selnofee) {
        this.selnofee = selnofee;
    }

    public java.lang.Short getNostate() {
        return this.nostate;
    }

    public void setNostate(java.lang.Short nostate) {
        this.nostate = nostate;
    }

    public java.lang.Integer getNosectid() {
        return this.nosectid;
    }

    public void setNosectid(java.lang.Integer nosectid) {
        this.nosectid = nosectid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.Short getMobiletype() {
        return this.mobiletype;
    }

    public void setMobiletype(java.lang.Short mobiletype) {
        this.mobiletype = mobiletype;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getNoprompt() {
        return this.noprompt;
    }

    public void setNoprompt(java.lang.String noprompt) {
        this.noprompt = noprompt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mobileno", getMobileno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NoresVO) ) return false;
        NoresVO castOther = (NoresVO) other;
        return new EqualsBuilder()
            .append(this.getMobileno(), castOther.getMobileno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMobileno())
            .toHashCode();
    }

}
