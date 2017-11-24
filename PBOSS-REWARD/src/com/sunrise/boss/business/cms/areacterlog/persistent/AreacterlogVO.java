package com.sunrise.boss.business.cms.areacterlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AreacterlogVO implements Serializable {

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
    private String centerid;

    /** nullable persistent field */
    private String centername;

    /** nullable persistent field */
    private Short areatype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;

    /** full constructor */
    public AreacterlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String centerid, java.lang.String centername, java.lang.Short areatype, java.lang.String agent, java.lang.String billingcode) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.centerid = centerid;
        this.centername = centername;
        this.areatype = areatype;
        this.agent = agent;
        this.billingcode = billingcode;
    }

    /** default constructor */
    public AreacterlogVO() {
    }

    /** minimal constructor */
    public AreacterlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.lang.String getCenterid() {
        return this.centerid;
    }

    public void setCenterid(java.lang.String centerid) {
        this.centerid = centerid;
    }

    public java.lang.String getCentername() {
        return this.centername;
    }

    public void setCentername(java.lang.String centername) {
        this.centername = centername;
    }

    public java.lang.Short getAreatype() {
        return this.areatype;
    }

    public void setAreatype(java.lang.Short areatype) {
        this.areatype = areatype;
    }

    public java.lang.String getAgent() {
        return this.agent;
    }

    public void setAgent(java.lang.String agent) {
        this.agent = agent;
    }

    public java.lang.String getBillingcode() {
        return this.billingcode;
    }

    public void setBillingcode(java.lang.String billingcode) {
        this.billingcode = billingcode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AreacterlogVO) ) return false;
        AreacterlogVO castOther = (AreacterlogVO) other;
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
