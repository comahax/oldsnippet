package com.sunrise.boss.business.cms.resalelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResalelogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private Long itemid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private Long brand;

    /** nullable persistent field */
    private java.util.Date daytime;

    /** full constructor */
    public ResalelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long itemid, java.lang.String wayid, java.lang.String mobile, java.lang.String countyid, java.lang.Long brand, java.util.Date daytime) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.itemid = itemid;
        this.wayid = wayid;
        this.mobile = mobile;
        this.countyid = countyid;
        this.brand = brand;
        this.daytime = daytime;
    }

    /** default constructor */
    public ResalelogVO() {
    }

    /** minimal constructor */
    public ResalelogVO(java.lang.Long logid) {
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

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.Long getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Long brand) {
        this.brand = brand;
    }

    public java.util.Date getDaytime() {
        return this.daytime;
    }

    public void setDaytime(java.util.Date daytime) {
        this.daytime = daytime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResalelogVO) ) return false;
        ResalelogVO castOther = (ResalelogVO) other;
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
