package com.gmcc.pboss.business.sales.actfilerec;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class ActfilerecVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String filename;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date overtime;

    /** nullable persistent field */
    private Long totalamt;

    /** nullable persistent field */
    private Long actualamt;

    /** nullable persistent field */
    private Long success;

    /** nullable persistent field */
    private Long fail;

    /** full constructor */
    public ActfilerecVO(java.lang.String filename, java.util.Date begintime, java.util.Date overtime, java.lang.Long totalamt, java.lang.Long actualamt, java.lang.Long success, java.lang.Long fail) {
        this.filename = filename;
        this.begintime = begintime;
        this.overtime = overtime;
        this.totalamt = totalamt;
        this.actualamt = actualamt;
        this.success = success;
        this.fail = fail;
    }

    /** default constructor */
    public ActfilerecVO() {
    }

    /** minimal constructor */
    public ActfilerecVO(java.lang.String filename) {
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

    public java.lang.Long getTotalamt() {
        return this.totalamt;
    }

    public void setTotalamt(java.lang.Long totalamt) {
        this.totalamt = totalamt;
    }

    public java.lang.Long getActualamt() {
        return this.actualamt;
    }

    public void setActualamt(java.lang.Long actualamt) {
        this.actualamt = actualamt;
    }

    public java.lang.Long getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.Long success) {
        this.success = success;
    }

    public java.lang.Long getFail() {
        return this.fail;
    }

    public void setFail(java.lang.Long fail) {
        this.fail = fail;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ActfilerecVO) ) return false;
        ActfilerecVO castOther = (ActfilerecVO) other;
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
