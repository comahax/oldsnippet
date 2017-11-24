package com.gmcc.pboss.business.sales.disoverdetail;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisoverdetailVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Long statseqid;

    /** nullable persistent field */
    private String overtype;

    /** nullable persistent field */
    private Long overhour;

    /** nullable persistent field */
    private String orderid;

    /** full constructor */
    public DisoverdetailVO(java.lang.Long seqid, java.lang.Long statseqid, java.lang.String overtype, java.lang.Long overhour, java.lang.String orderid) {
        this.seqid = seqid;
        this.statseqid = statseqid;
        this.overtype = overtype;
        this.overhour = overhour;
        this.orderid = orderid;
    }

    /** default constructor */
    public DisoverdetailVO() {
    }

    /** minimal constructor */
    public DisoverdetailVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getStatseqid() {
        return this.statseqid;
    }

    public void setStatseqid(java.lang.Long statseqid) {
        this.statseqid = statseqid;
    }

    public java.lang.String getOvertype() {
        return this.overtype;
    }

    public void setOvertype(java.lang.String overtype) {
        this.overtype = overtype;
    }

    public java.lang.Long getOverhour() {
        return this.overhour;
    }

    public void setOverhour(java.lang.Long overhour) {
        this.overhour = overhour;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisoverdetailVO) ) return false;
        DisoverdetailVO castOther = (DisoverdetailVO) other;
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
