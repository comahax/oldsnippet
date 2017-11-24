package com.sunrise.boss.business.fee.qsmanage.acctebox.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AcctEboxBakVO implements Serializable {

    /** identifier field */
    private Long acctid;

    /** identifier field */
    private Long eboxunitid;

    /** nullable persistent field */
    private Integer eboxunittype;

    /** full constructor */
    public AcctEboxBakVO(java.lang.Long acctid, java.lang.Long eboxunitid, java.lang.Integer eboxunittype) {
        this.acctid = acctid;
        this.eboxunitid = eboxunitid;
        this.eboxunittype = eboxunittype;
    }

    /** default constructor */
    public AcctEboxBakVO() {
    }

    /** minimal constructor */
    public AcctEboxBakVO(java.lang.Long acctid, java.lang.Long eboxunitid) {
        this.acctid = acctid;
        this.eboxunitid = eboxunitid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Long getEboxunitid() {
        return this.eboxunitid;
    }

    public void setEboxunitid(java.lang.Long eboxunitid) {
        this.eboxunitid = eboxunitid;
    }

    public java.lang.Integer getEboxunittype() {
        return this.eboxunittype;
    }

    public void setEboxunittype(java.lang.Integer eboxunittype) {
        this.eboxunittype = eboxunittype;
    }

    public String toString() {
   	 StringBuffer buf = new StringBuffer();
        buf.append(this.getAcctid().toString()).append("~").append(this.getEboxunitid().toString()).append("~").append(this.getEboxunittype().toString()).append("~");
        return buf.toString();
   }

    public boolean equals(Object other) {
        if ( !(other instanceof AcctEboxBakVO) ) return false;
        AcctEboxBakVO castOther = (AcctEboxBakVO) other;
        return new EqualsBuilder()
            .append(this.getAcctid(), castOther.getAcctid())
            .append(this.getEboxunitid(), castOther.getEboxunitid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctid())
            .append(getEboxunitid())
            .toHashCode();
    }

}
