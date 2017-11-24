package com.gmcc.pboss.business.promotion.daemon;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DaemonVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Long processid;

    /** nullable persistent field */
    private java.util.Date startingdate;

    /** nullable persistent field */
    private String module;

    /** nullable persistent field */
    private String params;

    /** full constructor */
    public DaemonVO(java.lang.Long processid, java.util.Date startingdate, java.lang.String module, java.lang.String params) {
        this.processid = processid;
        this.startingdate = startingdate;
        this.module = module;
        this.params = params;
    }

    /** default constructor */
    public DaemonVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getProcessid() {
        return this.processid;
    }

    public void setProcessid(java.lang.Long processid) {
        this.processid = processid;
    }

    public java.util.Date getStartingdate() {
        return this.startingdate;
    }

    public void setStartingdate(java.util.Date startingdate) {
        this.startingdate = startingdate;
    }

    public java.lang.String getModule() {
        return this.module;
    }

    public void setModule(java.lang.String module) {
        this.module = module;
    }

    public java.lang.String getParams() {
        return this.params;
    }

    public void setParams(java.lang.String params) {
        this.params = params;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DaemonVO) ) return false;
        DaemonVO castOther = (DaemonVO) other;
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
