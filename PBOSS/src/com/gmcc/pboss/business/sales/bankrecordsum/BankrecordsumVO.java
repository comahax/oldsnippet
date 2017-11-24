package com.gmcc.pboss.business.sales.bankrecordsum;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BankrecordsumVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Long successcount;

    /** nullable persistent field */
    private Long failurecount;

    /** nullable persistent field */
    private Long amterrcount;

    /** nullable persistent field */
    private Double localamt;

    /** nullable persistent field */
    private Double bankamt;

    /** nullable persistent field */
    private java.util.Date recordate;

    /** nullable persistent field */
    private java.util.Date creatdate;

    /** full constructor */
    public BankrecordsumVO(java.lang.Long seqid, java.lang.Long successcount, java.lang.Long failurecount, java.lang.Long amterrcount, java.lang.Double localamt, java.lang.Double bankamt, java.util.Date recordate, java.util.Date creatdate) {
        this.seqid = seqid;
        this.successcount = successcount;
        this.failurecount = failurecount;
        this.amterrcount = amterrcount;
        this.localamt = localamt;
        this.bankamt = bankamt;
        this.recordate = recordate;
        this.creatdate = creatdate;
    }

    /** default constructor */
    public BankrecordsumVO() {
    }

    /** minimal constructor */
    public BankrecordsumVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSuccesscount() {
        return this.successcount;
    }

    public void setSuccesscount(java.lang.Long successcount) {
        this.successcount = successcount;
    }

    public java.lang.Long getFailurecount() {
        return this.failurecount;
    }

    public void setFailurecount(java.lang.Long failurecount) {
        this.failurecount = failurecount;
    }

    public java.lang.Long getAmterrcount() {
        return this.amterrcount;
    }

    public void setAmterrcount(java.lang.Long amterrcount) {
        this.amterrcount = amterrcount;
    }

    public java.lang.Double getLocalamt() {
        return this.localamt;
    }

    public void setLocalamt(java.lang.Double localamt) {
        this.localamt = localamt;
    }

    public java.lang.Double getBankamt() {
        return this.bankamt;
    }

    public void setBankamt(java.lang.Double bankamt) {
        this.bankamt = bankamt;
    }

    public java.util.Date getRecordate() {
        return this.recordate;
    }

    public void setRecordate(java.util.Date recordate) {
        this.recordate = recordate;
    }

    public java.util.Date getCreatdate() {
        return this.creatdate;
    }

    public void setCreatdate(java.util.Date creatdate) {
        this.creatdate = creatdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BankrecordsumVO) ) return false;
        BankrecordsumVO castOther = (BankrecordsumVO) other;
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
