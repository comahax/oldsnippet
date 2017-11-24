package com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BbcReopnrangeVO implements Serializable {

    /** identifier field */
    private Long rangeid;

    /** nullable persistent field */
    private String opnbegin;

    /** nullable persistent field */
    private String opnend;

    /** nullable persistent field */
    private Short resertype;

    /** nullable persistent field */
    private String opnid;

    /** full constructor */
    public BbcReopnrangeVO(java.lang.String opnbegin, java.lang.String opnend, java.lang.Short resertype, java.lang.String opnid) {
        this.opnbegin = opnbegin;
        this.opnend = opnend;
        this.resertype = resertype;
        this.opnid = opnid;
    }

    /** default constructor */
    public BbcReopnrangeVO() {
    }

    public java.lang.Long getRangeid() {
        return this.rangeid;
    }

    public void setRangeid(java.lang.Long rangeid) {
        this.rangeid = rangeid;
    }

    public java.lang.String getOpnbegin() {
        return this.opnbegin;
    }

    public void setOpnbegin(java.lang.String opnbegin) {
        this.opnbegin = opnbegin;
    }

    public java.lang.String getOpnend() {
        return this.opnend;
    }

    public void setOpnend(java.lang.String opnend) {
        this.opnend = opnend;
    }

    public java.lang.Short getResertype() {
        return this.resertype;
    }

    public void setResertype(java.lang.Short resertype) {
        this.resertype = resertype;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rangeid", getRangeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BbcReopnrangeVO) ) return false;
        BbcReopnrangeVO castOther = (BbcReopnrangeVO) other;
        return new EqualsBuilder()
            .append(this.getRangeid(), castOther.getRangeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRangeid())
            .toHashCode();
    }

}
