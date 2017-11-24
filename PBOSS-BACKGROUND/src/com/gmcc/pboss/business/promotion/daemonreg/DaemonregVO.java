package com.gmcc.pboss.business.promotion.daemonreg;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class DaemonregVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long processid;

    /** nullable persistent field */
    private String processname;

    /** nullable persistent field */
    private String processor;

    /** full constructor */
    public DaemonregVO(java.lang.String processname, java.lang.String processor) {
        this.processname = processname;
        this.processor = processor;
    }

    /** default constructor */
    public DaemonregVO() {
    }

    public java.lang.Long getProcessid() {
        return this.processid;
    }

    public void setProcessid(java.lang.Long processid) {
        this.processid = processid;
    }

    public java.lang.String getProcessname() {
        return this.processname;
    }

    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }

    public java.lang.String getProcessor() {
        return this.processor;
    }

    public void setProcessor(java.lang.String processor) {
        this.processor = processor;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("processid", getProcessid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DaemonregVO) ) return false;
        DaemonregVO castOther = (DaemonregVO) other;
        return new EqualsBuilder()
            .append(this.getProcessid(), castOther.getProcessid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getProcessid())
            .toHashCode();
    }

}
