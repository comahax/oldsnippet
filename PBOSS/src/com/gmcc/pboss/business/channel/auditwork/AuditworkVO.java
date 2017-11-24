package com.gmcc.pboss.business.channel.auditwork;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AuditworkVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String worktype;

    /** nullable persistent field */
    private Long applyno;

    /** nullable persistent field */
    private String stepid;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private Short auditstatus;

    /** full constructor */
    public AuditworkVO(java.lang.Long seqid, java.lang.String worktype, java.lang.Long applyno, java.lang.String stepid, java.util.Date createtime, java.lang.String oprcode, java.util.Date optime, java.lang.String content, java.lang.Short auditstatus) {
        this.seqid = seqid;
        this.worktype = worktype;
        this.applyno = applyno;
        this.stepid = stepid;
        this.createtime = createtime;
        this.oprcode = oprcode;
        this.optime = optime;
        this.content = content;
        this.auditstatus = auditstatus;
    }

    /** default constructor */
    public AuditworkVO() {
    }

    /** minimal constructor */
    public AuditworkVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getWorktype() {
        return this.worktype;
    }

    public void setWorktype(java.lang.String worktype) {
        this.worktype = worktype;
    }

    public java.lang.Long getApplyno() {
        return this.applyno;
    }

    public void setApplyno(java.lang.Long applyno) {
        this.applyno = applyno;
    }

    public java.lang.String getStepid() {
        return this.stepid;
    }

    public void setStepid(java.lang.String stepid) {
        this.stepid = stepid;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.Short getAuditstatus() {
        return this.auditstatus;
    }

    public void setAuditstatus(java.lang.Short auditstatus) {
        this.auditstatus = auditstatus;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AuditworkVO) ) return false;
        AuditworkVO castOther = (AuditworkVO) other;
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
