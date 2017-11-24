package com.sunrise.boss.business.cms.servcentlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ServcentlogVO implements Serializable {

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
    private String svccode;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svcname;

    /** nullable persistent field */
    private Short svctype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;

    /** nullable persistent field */
    private String adacode;

    /** nullable persistent field */
    private String longitude;

    /** nullable persistent field */
    private String latitude;

    /** full constructor */
    public ServcentlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String svccode, java.lang.String countyid, java.lang.String svcname, java.lang.Short svctype, java.lang.String agent, java.lang.String billingcode, java.lang.String adacode, java.lang.String longitude, java.lang.String latitude) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.svccode = svccode;
        this.countyid = countyid;
        this.svcname = svcname;
        this.svctype = svctype;
        this.agent = agent;
        this.billingcode = billingcode;
        this.adacode = adacode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /** default constructor */
    public ServcentlogVO() {
    }

    /** minimal constructor */
    public ServcentlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvcname() {
        return this.svcname;
    }

    public void setSvcname(java.lang.String svcname) {
        this.svcname = svcname;
    }

    public java.lang.Short getSvctype() {
        return this.svctype;
    }

    public void setSvctype(java.lang.Short svctype) {
        this.svctype = svctype;
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

    public java.lang.String getAdacode() {
        return this.adacode;
    }

    public void setAdacode(java.lang.String adacode) {
        this.adacode = adacode;
    }

    public java.lang.String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(java.lang.String longitude) {
        this.longitude = longitude;
    }

    public java.lang.String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(java.lang.String latitude) {
        this.latitude = latitude;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ServcentlogVO) ) return false;
        ServcentlogVO castOther = (ServcentlogVO) other;
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
