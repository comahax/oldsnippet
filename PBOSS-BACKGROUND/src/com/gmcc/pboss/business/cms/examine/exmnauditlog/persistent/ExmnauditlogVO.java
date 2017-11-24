package com.gmcc.pboss.business.cms.examine.exmnauditlog.persistent;


import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class ExmnauditlogVO  extends BaseVO implements Serializable {

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
    private java.util.Date submissiontime;

    /** nullable persistent field */
    private String auditor;

    /** nullable persistent field */
    private String auditopinion;

    /** nullable persistent field */
    private Long itemgradedid;

    /** nullable persistent field */
    private String state;

    /** full constructor */
    public ExmnauditlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.String presenter, java.util.Date submissiontime, java.lang.String auditor, java.lang.String auditopinion, java.lang.Long itemgradedid, java.lang.String state) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.presenter = presenter;
        this.submissiontime = submissiontime;
        this.auditor = auditor;
        this.auditopinion = auditopinion;
        this.itemgradedid = itemgradedid;
        this.state = state;
    }

    /** default constructor */
    public ExmnauditlogVO() {
    }

    /** minimal constructor */
    public ExmnauditlogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

 

    public java.util.Date getOptime() {
		return optime;
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

    public java.util.Date getSubmissiontime() {
        return this.submissiontime;
    }

    public void setSubmissiontime(java.util.Date submissiontime) {
        this.submissiontime = submissiontime;
    }

    public java.lang.String getAuditor() {
        return this.auditor;
    }

    public void setAuditor(java.lang.String auditor) {
        this.auditor = auditor;
    }

    public java.lang.String getAuditopinion() {
        return this.auditopinion;
    }

    public void setAuditopinion(java.lang.String auditopinion) {
        this.auditopinion = auditopinion;
    }

    public java.lang.Long getItemgradedid() {
        return this.itemgradedid;
    }

    public void setItemgradedid(java.lang.Long itemgradedid) {
        this.itemgradedid = itemgradedid;
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
        if ( !(other instanceof ExmnauditlogVO) ) return false;
        ExmnauditlogVO castOther = (ExmnauditlogVO) other;
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
