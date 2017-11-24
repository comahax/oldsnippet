package com.sunrise.boss.business.cms.emodconfirm.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EmodconfirmVO implements Serializable {

    /** identifier field */
    private Long confirmid;

    /** nullable persistent field */
    private Long empmodelid;

    /** nullable persistent field */
    private String employeeid;

    /** nullable persistent field */
    private String model;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private Short smsstatus;

    /** nullable persistent field */
    private java.util.Date smscreattime;

    /** nullable persistent field */
    private java.util.Date smsconfirmtime;

    /** full constructor */
    public EmodconfirmVO(java.lang.Long confirmid, java.lang.Long empmodelid, java.lang.String employeeid, java.lang.String model, java.lang.Short state, java.lang.Short smsstatus, java.util.Date smscreattime, java.util.Date smsconfirmtime) {
        this.confirmid = confirmid;
        this.empmodelid = empmodelid;
        this.employeeid = employeeid;
        this.model = model;
        this.state = state;
        this.smsstatus = smsstatus;
        this.smscreattime = smscreattime;
        this.smsconfirmtime = smsconfirmtime;
    }

    /** default constructor */
    public EmodconfirmVO() {
    }

    /** minimal constructor */
    public EmodconfirmVO(java.lang.Long confirmid) {
        this.confirmid = confirmid;
    }

    public java.lang.Long getConfirmid() {
        return this.confirmid;
    }

    public void setConfirmid(java.lang.Long confirmid) {
        this.confirmid = confirmid;
    }

    public java.lang.Long getEmpmodelid() {
        return this.empmodelid;
    }

    public void setEmpmodelid(java.lang.Long empmodelid) {
        this.empmodelid = empmodelid;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getModel() {
        return this.model;
    }

    public void setModel(java.lang.String model) {
        this.model = model;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.Short getSmsstatus() {
        return this.smsstatus;
    }

    public void setSmsstatus(java.lang.Short smsstatus) {
        this.smsstatus = smsstatus;
    }

    public java.util.Date getSmscreattime() {
        return this.smscreattime;
    }

    public void setSmscreattime(java.util.Date smscreattime) {
        this.smscreattime = smscreattime;
    }

    public java.util.Date getSmsconfirmtime() {
        return this.smsconfirmtime;
    }

    public void setSmsconfirmtime(java.util.Date smsconfirmtime) {
        this.smsconfirmtime = smsconfirmtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("confirmid", getConfirmid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmodconfirmVO) ) return false;
        EmodconfirmVO castOther = (EmodconfirmVO) other;
        return new EqualsBuilder()
            .append(this.getConfirmid(), castOther.getConfirmid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getConfirmid())
            .toHashCode();
    }

}
