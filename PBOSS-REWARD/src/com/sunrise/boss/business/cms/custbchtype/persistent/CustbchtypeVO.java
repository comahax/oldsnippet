package com.sunrise.boss.business.cms.custbchtype.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bchtypelog.persistent.*;
import com.sunrise.boss.business.common.dblog.*;

/** @author Hibernate CodeGenerator */
public class CustbchtypeVO implements OperationLog {

    /** identifier field */
    private String bchtypecode;

    /** persistent field */
    private String citycompid;

    /** persistent field */
    private String bchtypename;

    /** nullable persistent field */
    private Byte notusebysub;

    /** nullable persistent field */
    private String description;

    /** full constructor */
    public CustbchtypeVO(java.lang.String bchtypecode, java.lang.String citycompid, java.lang.String bchtypename, java.lang.Byte notusebysub, java.lang.String description) {
        this.bchtypecode = bchtypecode;
        this.citycompid = citycompid;
        this.bchtypename = bchtypename;
        this.notusebysub = notusebysub;
        this.description = description;
    }

    /** default constructor */
    public CustbchtypeVO() {
    }

    /** minimal constructor */
    public CustbchtypeVO(java.lang.String bchtypecode, java.lang.String citycompid, java.lang.String bchtypename) {
        this.bchtypecode = bchtypecode;
        this.citycompid = citycompid;
        this.bchtypename = bchtypename;
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
            .append("bchtypecode", getBchtypecode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CustbchtypeVO) ) return false;
        CustbchtypeVO castOther = (CustbchtypeVO) other;
        return new EqualsBuilder()
            .append(this.getBchtypecode(), castOther.getBchtypecode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBchtypecode())
            .toHashCode();
    }
    
    public Class logVOClass() {
    	return BchtypelogVO.class;
    }

}
