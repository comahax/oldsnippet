package com.gmcc.pboss.business.resource.resimport;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResimportVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String filename;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date overtime;

    /** nullable persistent field */
    private Long amount;

    /** nullable persistent field */
    private Long successamt;

    /** nullable persistent field */
    private Long failamt;

    /** full constructor */
    public ResimportVO(java.lang.String filename, java.util.Date begintime, java.util.Date overtime, java.lang.Long amount, java.lang.Long successamt, java.lang.Long failamt) {
        this.filename = filename;
        this.begintime = begintime;
        this.overtime = overtime;
        this.amount = amount;
        this.successamt = successamt;
        this.failamt = failamt;
    }

    /** default constructor */
    public ResimportVO() {
    }

    /** minimal constructor */
    public ResimportVO(java.lang.String filename) {
        this.filename = filename;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getOvertime() {
        return this.overtime;
    }

    public void setOvertime(java.util.Date overtime) {
        this.overtime = overtime;
    }

    public java.lang.Long getAmount() {
        return this.amount;
    }

    public void setAmount(java.lang.Long amount) {
        this.amount = amount;
    }

    public java.lang.Long getSuccessamt() {
        return this.successamt;
    }

    public void setSuccessamt(java.lang.Long successamt) {
        this.successamt = successamt;
    }

    public java.lang.Long getFailamt() {
        return this.failamt;
    }

    public void setFailamt(java.lang.Long failamt) {
        this.failamt = failamt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResimportVO) ) return false;
        ResimportVO castOther = (ResimportVO) other;
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
