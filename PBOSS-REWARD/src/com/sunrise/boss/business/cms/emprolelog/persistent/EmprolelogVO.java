package com.sunrise.boss.business.cms.emprolelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EmprolelogVO implements Serializable {

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
    private String employeeid;

    /** nullable persistent field */
    private String ekey;

    /** nullable persistent field */
    private String evalue;

    /** full constructor */
    public EmprolelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String employeeid, java.lang.String ekey, java.lang.String evalue) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.employeeid = employeeid;
        this.ekey = ekey;
        this.evalue = evalue;
    }

    /** default constructor */
    public EmprolelogVO() {
    }

    /** minimal constructor */
    public EmprolelogVO(java.lang.Long logid) {
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

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getEkey() {
        return this.ekey;
    }

    public void setEkey(java.lang.String ekey) {
        this.ekey = ekey;
    }

    public java.lang.String getEvalue() {
        return this.evalue;
    }

    public void setEvalue(java.lang.String evalue) {
        this.evalue = evalue;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmprolelogVO) ) return false;
        EmprolelogVO castOther = (EmprolelogVO) other;
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
