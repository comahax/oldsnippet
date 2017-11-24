package com.gmcc.pboss.business.sales.auditlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AuditlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
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
    private String state;

    /** full constructor */
    public AuditlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.String presenter, java.util.Date smsntime, java.lang.String auditor, java.util.Date audittime, java.lang.String opinion, java.lang.String state) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.presenter = presenter;
        this.smsntime = smsntime;
        this.auditor = auditor;
        this.audittime = audittime;
        this.opinion = opinion;
        this.state = state;
    }

    /** default constructor */
    public AuditlogVO() {
    }

    /** minimal constructor */
    public AuditlogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
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


    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AuditlogVO) ) return false;
        AuditlogVO castOther = (AuditlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
