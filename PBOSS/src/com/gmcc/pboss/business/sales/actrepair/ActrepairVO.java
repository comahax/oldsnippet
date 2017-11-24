package com.gmcc.pboss.business.sales.actrepair;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ActrepairVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String mobileno;

    /** persistent field */
    private java.util.Date activedate;

    /** persistent field */
    private java.util.Date repairtime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String cause;

    /** full constructor */
    public ActrepairVO(java.lang.Long recid, java.lang.String mobileno, java.util.Date activedate, java.util.Date repairtime, java.lang.String oprcode, java.lang.String cause) {
        this.recid = recid;
        this.mobileno = mobileno;
        this.activedate = activedate;
        this.repairtime = repairtime;
        this.oprcode = oprcode;
        this.cause = cause;
    }

    /** default constructor */
    public ActrepairVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.util.Date getActivedate() {
        return this.activedate;
    }

    public void setActivedate(java.util.Date activedate) {
        this.activedate = activedate;
    }

    public java.util.Date getRepairtime() {
        return this.repairtime;
    }

    public void setRepairtime(java.util.Date repairtime) {
        this.repairtime = repairtime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getCause() {
        return this.cause;
    }

    public void setCause(java.lang.String cause) {
        this.cause = cause;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ActrepairVO) ) return false;
        ActrepairVO castOther = (ActrepairVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
