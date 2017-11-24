package com.gmcc.pboss.business.channel.fdaudit;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FdauditVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recno;

    /** persistent field */
    private String tablename;

    /** persistent field */
    private String typename;

    /** persistent field */
    private String pkvalue;

    /** nullable persistent field */
    private String pkvalue2;

    /** persistent field */
    private String field;

    /** nullable persistent field */
    private String fieldvalue;

    /** persistent field */
    private String operid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private Short auditstatus;

    /** nullable persistent field */
    private String auditoperid;

    /** nullable persistent field */
    private java.util.Date audittime;

    /** full constructor */
    public FdauditVO(java.lang.String tablename, java.lang.String typename, java.lang.String pkvalue, java.lang.String pkvalue2, java.lang.String field, java.lang.String fieldvalue, java.lang.String operid, java.util.Date optime, java.lang.Short auditstatus, java.lang.String auditoperid, java.util.Date audittime) {
        this.tablename = tablename;
        this.typename = typename;
        this.pkvalue = pkvalue;
        this.pkvalue2 = pkvalue2;
        this.field = field;
        this.fieldvalue = fieldvalue;
        this.operid = operid;
        this.optime = optime;
        this.auditstatus = auditstatus;
        this.auditoperid = auditoperid;
        this.audittime = audittime;
    }

    /** default constructor */
    public FdauditVO() {
    }

    /** minimal constructor */
    public FdauditVO(java.lang.String tablename, java.lang.String typename, java.lang.String pkvalue, java.lang.String field, java.lang.String operid) {
        this.tablename = tablename;
        this.typename = typename;
        this.pkvalue = pkvalue;
        this.field = field;
        this.operid = operid;
    }

    public java.lang.Long getRecno() {
        return this.recno;
    }

    public void setRecno(java.lang.Long recno) {
        this.recno = recno;
    }

    public java.lang.String getTablename() {
        return this.tablename;
    }

    public void setTablename(java.lang.String tablename) {
        this.tablename = tablename;
    }

    public java.lang.String getTypename() {
        return this.typename;
    }

    public void setTypename(java.lang.String typename) {
        this.typename = typename;
    }

    public java.lang.String getPkvalue() {
        return this.pkvalue;
    }

    public void setPkvalue(java.lang.String pkvalue) {
        this.pkvalue = pkvalue;
    }

    public java.lang.String getPkvalue2() {
        return this.pkvalue2;
    }

    public void setPkvalue2(java.lang.String pkvalue2) {
        this.pkvalue2 = pkvalue2;
    }

    public java.lang.String getField() {
        return this.field;
    }

    public void setField(java.lang.String field) {
        this.field = field;
    }

    public java.lang.String getFieldvalue() {
        return this.fieldvalue;
    }

    public void setFieldvalue(java.lang.String fieldvalue) {
        this.fieldvalue = fieldvalue;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.Short getAuditstatus() {
        return this.auditstatus;
    }

    public void setAuditstatus(java.lang.Short auditstatus) {
        this.auditstatus = auditstatus;
    }

    public java.lang.String getAuditoperid() {
        return this.auditoperid;
    }

    public void setAuditoperid(java.lang.String auditoperid) {
        this.auditoperid = auditoperid;
    }

    public java.util.Date getAudittime() {
        return this.audittime;
    }

    public void setAudittime(java.util.Date audittime) {
        this.audittime = audittime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recno", getRecno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FdauditVO) ) return false;
        FdauditVO castOther = (FdauditVO) other;
        return new EqualsBuilder()
            .append(this.getRecno(), castOther.getRecno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecno())
            .toHashCode();
    }

}
