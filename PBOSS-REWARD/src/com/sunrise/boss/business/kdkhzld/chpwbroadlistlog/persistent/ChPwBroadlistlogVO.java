package com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwBroadlistlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String success;

    /** full constructor */
    public ChPwBroadlistlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprtype, java.lang.String mobile, java.lang.String oprcode, java.lang.String success) {
        this.logid = logid;
        this.optime = optime;
        this.oprtype = oprtype;
        this.mobile = mobile;
        this.oprcode = oprcode;
        this.success = success;
    }

    /** default constructor */
    public ChPwBroadlistlogVO() {
    }

    /** minimal constructor */
    public ChPwBroadlistlogVO(java.lang.Long logid) {
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

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwBroadlistlogVO) ) return false;
        ChPwBroadlistlogVO castOther = (ChPwBroadlistlogVO) other;
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
