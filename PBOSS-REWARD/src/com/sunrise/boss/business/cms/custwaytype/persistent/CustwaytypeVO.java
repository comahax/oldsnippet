package com.sunrise.boss.business.cms.custwaytype.persistent;

import org.apache.commons.lang.builder.*;

import com.sunrise.boss.business.cms.custwtypelog.persistent.*;
import com.sunrise.boss.business.common.dblog.*;

/** @author Hibernate CodeGenerator */
public class CustwaytypeVO implements OperationLog {

    /** identifier field */
    private String custwaytypecode;

    /** persistent field */
    private String citycompid;

    /** persistent field */
    private String custwaytypename;

    /** nullable persistent field */
    private Byte notusebysub;

    /** nullable persistent field */
    private String description;

    /** full constructor */
    public CustwaytypeVO(java.lang.String custwaytypecode, java.lang.String citycompid, java.lang.String custwaytypename, java.lang.Byte notusebysub, java.lang.String description) {
        this.custwaytypecode = custwaytypecode;
        this.citycompid = citycompid;
        this.custwaytypename = custwaytypename;
        this.notusebysub = notusebysub;
        this.description = description;
    }

    /** default constructor */
    public CustwaytypeVO() {
    }

    /** minimal constructor */
    public CustwaytypeVO(java.lang.String custwaytypecode, java.lang.String citycompid, java.lang.String custwaytypename) {
        this.custwaytypecode = custwaytypecode;
        this.citycompid = citycompid;
        this.custwaytypename = custwaytypename;
    }

    public java.lang.String getCustwaytypecode() {
        return this.custwaytypecode;
    }

    public void setCustwaytypecode(java.lang.String custwaytypecode) {
        this.custwaytypecode = custwaytypecode;
    }

    public java.lang.String getCitycompid() {
        return this.citycompid;
    }

    public void setCitycompid(java.lang.String citycompid) {
        this.citycompid = citycompid;
    }

    public java.lang.String getCustwaytypename() {
        return this.custwaytypename;
    }

    public void setCustwaytypename(java.lang.String custwaytypename) {
        this.custwaytypename = custwaytypename;
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
            .append("custwaytypecode", getCustwaytypecode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CustwaytypeVO) ) return false;
        CustwaytypeVO castOther = (CustwaytypeVO) other;
        return new EqualsBuilder()
            .append(this.getCustwaytypecode(), castOther.getCustwaytypecode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCustwaytypecode())
            .toHashCode();
    }
    
    public Class logVOClass() {    	
    	return CustwtypelogVO.class;
    }
}
