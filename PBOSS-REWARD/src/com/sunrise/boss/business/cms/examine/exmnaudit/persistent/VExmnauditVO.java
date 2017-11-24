package com.sunrise.boss.business.cms.examine.exmnaudit.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class VExmnauditVO implements Serializable,OperationLog {

    /** identifier field */
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
    
    private String wayid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private Integer exmnstdid;

    /** nullable persistent field */
    private String exmnperiod;

    /** nullable persistent field */
    private Float penalmark;

    public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Integer getExmnid() {
		return exmnid;
	}

	public void setExmnid(Integer exmnid) {
		this.exmnid = exmnid;
	}

	public Integer getExmnstdid() {
		return exmnstdid;
	}

	public void setExmnstdid(Integer exmnstdid) {
		this.exmnstdid = exmnstdid;
	}

	public String getExmnperiod() {
		return exmnperiod;
	}

	public void setExmnperiod(String exmnperiod) {
		this.exmnperiod = exmnperiod;
	}

	public Float getPenalmark() {
		return penalmark;
	}

	public void setPenalmark(Float penalmark) {
		this.penalmark = penalmark;
	}

	/** full constructor */
    public VExmnauditVO(java.lang.Long seqid, java.lang.String presenter, java.util.Date submissiontime, java.lang.String auditor, java.lang.String auditopinion, java.lang.Long itemgradedid, java.lang.String state) {
        this.seqid = seqid;
        this.presenter = presenter;
        this.submissiontime = submissiontime;
        this.auditor = auditor;
        this.auditopinion = auditopinion;
        this.itemgradedid = itemgradedid;
        this.state = state;
    }

    /** default constructor */
    public VExmnauditVO() {
    }

    /** minimal constructor */
    public VExmnauditVO(java.lang.Long seqid) {
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
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VExmnauditVO) ) return false;
        VExmnauditVO castOther = (VExmnauditVO) other;
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
		return ExmnauditlogVO.class;
	}

}
