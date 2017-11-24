package com.gmcc.pboss.business.channel.invoice;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class InvoiceVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private java.util.Date applytime;

    /** nullable persistent field */
    private Long momney;

    /** nullable persistent field */
    private String information;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** full constructor */
    public InvoiceVO(java.lang.String wayid, java.lang.String wayname, java.util.Date applytime, java.lang.Long momney, java.lang.String information, java.lang.String oprcode, java.lang.Short state, java.util.Date oprtime) {
        this.wayid = wayid;
        this.wayname = wayname;
        this.applytime = applytime;
        this.momney = momney;
        this.information = information;
        this.oprcode = oprcode;
        this.state = state;
        this.oprtime = oprtime;
    }

    /** default constructor */
    public InvoiceVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
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

    public java.util.Date getApplytime() {
        return this.applytime;
    }

    public void setApplytime(java.util.Date applytime) {
        this.applytime = applytime;
    }

    public java.lang.Long getMomney() {
        return this.momney;
    }

    public void setMomney(java.lang.Long momney) {
        this.momney = momney;
    }

    public java.lang.String getInformation() {
        return this.information;
    }

    public void setInformation(java.lang.String information) {
        this.information = information;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof InvoiceVO) ) return false;
        InvoiceVO castOther = (InvoiceVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
