package com.sunrise.boss.business.cms.bchtypelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BchtypelogVO implements Serializable {

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
    private String bchtypecode;

    /** nullable persistent field */
    private String citycompid;

    /** nullable persistent field */
    private String bchtypename;

    /** nullable persistent field */
    private Byte notusebysub;

    /** nullable persistent field */
    private String description;

    /** full constructor */
    public BchtypelogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String bchtypecode, java.lang.String citycompid, java.lang.String bchtypename, java.lang.Byte notusebysub, java.lang.String description) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.bchtypecode = bchtypecode;
        this.citycompid = citycompid;
        this.bchtypename = bchtypename;
        this.notusebysub = notusebysub;
        this.description = description;
    }

    /** default constructor */
    public BchtypelogVO() {
    }

    /** minimal constructor */
    public BchtypelogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.lang.String getBchtypecode() {
        return this.bchtypecode;
    }

    public void setBchtypecode(java.lang.String bchtypecode) {
        this.bchtypecode = bchtypecode;
    }

    public java.lang.String getCitycompid() {
        return this.citycompid;
    }

    public void setCitycompid(java.lang.String citycompid) {
        this.citycompid = citycompid;
    }

    public java.lang.String getBchtypename() {
        return this.bchtypename;
    }

    public void setBchtypename(java.lang.String bchtypename) {
        this.bchtypename = bchtypename;
    }

    public java.lang.Byte getNotusebysub() {
        return this.notusebysub;
    }

    public void setNotusebysub(java.lang.Byte notusebysub) {
        this.notusebysub = notusebysub;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BchtypelogVO) ) return false;
        BchtypelogVO castOther = (BchtypelogVO) other;
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
