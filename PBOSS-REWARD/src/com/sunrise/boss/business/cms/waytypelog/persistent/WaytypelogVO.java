package com.sunrise.boss.business.cms.waytypelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaytypelogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String waytypecode;

    /** nullable persistent field */
    private String waytypename;

    /** nullable persistent field */
    private String uppercode;

    /** nullable persistent field */
    private String desp;

    /** full constructor */
    public WaytypelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String waytypecode, java.lang.String waytypename, java.lang.String uppercode, java.lang.String desp) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.waytypecode = waytypecode;
        this.waytypename = waytypename;
        this.uppercode = uppercode;
        this.desp = desp;
    }

    /** default constructor */
    public WaytypelogVO() {
    }

    /** minimal constructor */
    public WaytypelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
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

    public java.lang.String getWaytypecode() {
        return this.waytypecode;
    }

    public void setWaytypecode(java.lang.String waytypecode) {
        this.waytypecode = waytypecode;
    }

    public java.lang.String getWaytypename() {
        return this.waytypename;
    }

    public void setWaytypename(java.lang.String waytypename) {
        this.waytypename = waytypename;
    }

    public java.lang.String getUppercode() {
        return this.uppercode;
    }

    public void setUppercode(java.lang.String uppercode) {
        this.uppercode = uppercode;
    }

    public java.lang.String getDesp() {
        return this.desp;
    }

    public void setDesp(java.lang.String desp) {
        this.desp = desp;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaytypelogVO) ) return false;
        WaytypelogVO castOther = (WaytypelogVO) other;
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
