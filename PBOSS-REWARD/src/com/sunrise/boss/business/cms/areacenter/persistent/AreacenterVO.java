package com.sunrise.boss.business.cms.areacenter.persistent;

import java.io.*;
import org.apache.commons.lang.builder.*;

import com.sunrise.boss.business.cms.areacterlog.persistent.*;
import com.sunrise.boss.business.common.dblog.*;

/** @author Hibernate CodeGenerator */
public class AreacenterVO  implements OperationLog {

    /** identifier field */
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
    public AreacenterVO(java.lang.String centerid, java.lang.String centername, java.lang.Short areatype, java.lang.String agent, java.lang.String billingcode) {
        this.centerid = centerid;
        this.centername = centername;
        this.areatype = areatype;
        this.agent = agent;
        this.billingcode = billingcode;
    }

    /** default constructor */
    public AreacenterVO() {
    }

    /** minimal constructor */
    public AreacenterVO(java.lang.String centerid) {
        this.centerid = centerid;
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
            .append("centerid", getCenterid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AreacenterVO) ) return false;
        AreacenterVO castOther = (AreacenterVO) other;
        return new EqualsBuilder()
            .append(this.getCenterid(), castOther.getCenterid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCenterid())
            .toHashCode();
    }
    
    public Class logVOClass() {
    	return AreacterlogVO.class;
    }

}
