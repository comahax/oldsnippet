package com.gmcc.pboss.business.sales.auditdet;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AuditdetVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long auditseq;

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String orderid;

    /** full constructor */
    public AuditdetVO(java.lang.Long auditseq, java.lang.Long recid, java.lang.String orderid) {
        this.auditseq = auditseq;
        this.recid = recid;
        this.orderid = orderid;
    }

    /** default constructor */
    public AuditdetVO() {
    }

    /** minimal constructor */
    public AuditdetVO(java.lang.Long auditseq, java.lang.Long recid) {
        this.auditseq = auditseq;
        this.recid = recid;
    }

    public java.lang.Long getAuditseq() {
        return this.auditseq;
    }

    public void setAuditseq(java.lang.Long auditseq) {
        this.auditseq = auditseq;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("auditseq", getAuditseq())
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AuditdetVO) ) return false;
        AuditdetVO castOther = (AuditdetVO) other;
        return new EqualsBuilder()
            .append(this.getAuditseq(), castOther.getAuditseq())
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAuditseq())
            .append(getRecid())
            .toHashCode();
    }

}
