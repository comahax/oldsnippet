package com.gmcc.pboss.business.channel.bondaudit;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BondauditVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Long formid;

    /** nullable persistent field */
    private String bondtype;

    /** nullable persistent field */
    private String presenter;

    /** nullable persistent field */
    private java.util.Date smsntime;

    /** nullable persistent field */
    private String auditor;

    /** nullable persistent field */
    private java.util.Date audittime;

    /** nullable persistent field */
    private String opinion;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public BondauditVO(java.lang.Long seqid, java.lang.Long formid, java.lang.String bondtype, java.lang.String presenter, java.util.Date smsntime, java.lang.String auditor, java.util.Date audittime, java.lang.String opinion, java.lang.String state, java.lang.String memo) {
        this.seqid = seqid;
        this.formid = formid;
        this.bondtype = bondtype;
        this.presenter = presenter;
        this.smsntime = smsntime;
        this.auditor = auditor;
        this.audittime = audittime;
        this.opinion = opinion;
        this.state = state;
        this.memo = memo;
    }

    /** default constructor */
    public BondauditVO() {
    }

    /** minimal constructor */
    public BondauditVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getFormid() {
        return this.formid;
    }

    public void setFormid(java.lang.Long formid) {
        this.formid = formid;
    }

    public java.lang.String getBondtype() {
        return this.bondtype;
    }

    public void setBondtype(java.lang.String bondtype) {
        this.bondtype = bondtype;
    }

    public java.lang.String getPresenter() {
        return this.presenter;
    }

    public void setPresenter(java.lang.String presenter) {
        this.presenter = presenter;
    }

    public java.util.Date getSmsntime() {
        return this.smsntime;
    }

    public void setSmsntime(java.util.Date smsntime) {
        this.smsntime = smsntime;
    }

    public java.lang.String getAuditor() {
        return this.auditor;
    }

    public void setAuditor(java.lang.String auditor) {
        this.auditor = auditor;
    }

    public java.util.Date getAudittime() {
        return this.audittime;
    }

    public void setAudittime(java.util.Date audittime) {
        this.audittime = audittime;
    }

    public java.lang.String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(java.lang.String opinion) {
        this.opinion = opinion;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BondauditVO) ) return false;
        BondauditVO castOther = (BondauditVO) other;
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
