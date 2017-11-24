package com.sunrise.boss.business.cms.bbc.servicelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ServicelogVO implements Serializable {

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
    private String name;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private Float baserewardstd;

    /** nullable persistent field */
    private Float bonusrewardstd;

    /** full constructor */
    public ServicelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String name, java.lang.String opnid, java.lang.Float baserewardstd, java.lang.Float bonusrewardstd) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.name = name;
        this.opnid = opnid;
        this.baserewardstd = baserewardstd;
        this.bonusrewardstd = bonusrewardstd;
    }

    /** default constructor */
    public ServicelogVO() {
    }

    /** minimal constructor */
    public ServicelogVO(java.lang.Long logid) {
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

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Float getBaserewardstd() {
        return this.baserewardstd;
    }

    public void setBaserewardstd(java.lang.Float baserewardstd) {
        this.baserewardstd = baserewardstd;
    }

    public java.lang.Float getBonusrewardstd() {
        return this.bonusrewardstd;
    }

    public void setBonusrewardstd(java.lang.Float bonusrewardstd) {
        this.bonusrewardstd = bonusrewardstd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ServicelogVO) ) return false;
        ServicelogVO castOther = (ServicelogVO) other;
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
