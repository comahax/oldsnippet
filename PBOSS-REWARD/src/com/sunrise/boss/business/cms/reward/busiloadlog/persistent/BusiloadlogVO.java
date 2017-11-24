package com.sunrise.boss.business.cms.reward.busiloadlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BusiloadlogVO implements Serializable {

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

    /** persistent field */
    private String opnid;

    /** persistent field */
    private String loadinfo;

    /** persistent field */
    private String loadtype;

    /** full constructor */
    public BusiloadlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String opnid, java.lang.String loadinfo, java.lang.String loadtype) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.opnid = opnid;
        this.loadinfo = loadinfo;
        this.loadtype = loadtype;
    }

    /** default constructor */
    public BusiloadlogVO() {
    }

    /** minimal constructor */
    public BusiloadlogVO(java.lang.Long logid, java.lang.String opnid, java.lang.String loadinfo, java.lang.String loadtype) {
        this.logid = logid;
        this.opnid = opnid;
        this.loadinfo = loadinfo;
        this.loadtype = loadtype;
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

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getLoadinfo() {
        return this.loadinfo;
    }

    public void setLoadinfo(java.lang.String loadinfo) {
        this.loadinfo = loadinfo;
    }

    public java.lang.String getLoadtype() {
        return this.loadtype;
    }

    public void setLoadtype(java.lang.String loadtype) {
        this.loadtype = loadtype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusiloadlogVO) ) return false;
        BusiloadlogVO castOther = (BusiloadlogVO) other;
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
