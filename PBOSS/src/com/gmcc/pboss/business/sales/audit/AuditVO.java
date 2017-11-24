package com.gmcc.pboss.business.sales.audit;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.auditlog.AuditlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class AuditVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long seqid;

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
    private String memo;

    /** nullable persistent field */
    private String state;

    /** full constructor */
    public AuditVO(java.lang.Long seqid, java.lang.String presenter, java.util.Date smsntime, java.lang.String auditor, java.util.Date audittime, java.lang.String opinion, java.lang.String memo, java.lang.String state) {
        this.seqid = seqid;
        this.presenter = presenter;
        this.smsntime = smsntime;
        this.auditor = auditor;
        this.audittime = audittime;
        this.opinion = opinion;
        this.memo = memo;
        this.state = state;
    }

    /** default constructor */
    public AuditVO() {
    }

    /** minimal constructor */
    public AuditVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
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

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AuditVO) ) return false;
        AuditVO castOther = (AuditVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return AuditlogVO.class;
	}

}
