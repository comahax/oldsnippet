package com.sunrise.boss.business.fee.print.billebox.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BillEboxVO implements Serializable {

    /** identifier field */
    private Long billitemid;

    /** identifier field */
    private Long eboxunitid;

    /** nullable persistent field */
    private Short eboxunittype;

    /** full constructor */
    public BillEboxVO(java.lang.Long billitemid, java.lang.Long eboxunitid, java.lang.Short eboxunittype) {
        this.billitemid = billitemid;
        this.eboxunitid = eboxunitid;
        this.eboxunittype = eboxunittype;
    }

    /** default constructor */
    public BillEboxVO() {
    }

    /** minimal constructor */
    public BillEboxVO(java.lang.Long billitemid, java.lang.Long eboxunitid) {
        this.billitemid = billitemid;
        this.eboxunitid = eboxunitid;
    }

    public java.lang.Long getBillitemid() {
        return this.billitemid;
    }

    public void setBillitemid(java.lang.Long billitemid) {
        this.billitemid = billitemid;
    }

    public java.lang.Long getEboxunitid() {
        return this.eboxunitid;
    }

    public void setEboxunitid(java.lang.Long eboxunitid) {
        this.eboxunitid = eboxunitid;
    }

    public java.lang.Short getEboxunittype() {
        return this.eboxunittype;
    }

    public void setEboxunittype(java.lang.Short eboxunittype) {
        this.eboxunittype = eboxunittype;
    }

    public String toString() {
    	StringBuffer buf = new StringBuffer();
 		buf.append(this.getBillitemid().toString()).append("~").append(this.getEboxunitid().toString()).append("~")
 			.append(this.getEboxunittype().toString()).append("~");
 		return buf.toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BillEboxVO) ) return false;
        BillEboxVO castOther = (BillEboxVO) other;
        return new EqualsBuilder()
            .append(this.getBillitemid(), castOther.getBillitemid())
            .append(this.getEboxunitid(), castOther.getEboxunitid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillitemid())
            .append(getEboxunitid())
            .toHashCode();
    }

}
