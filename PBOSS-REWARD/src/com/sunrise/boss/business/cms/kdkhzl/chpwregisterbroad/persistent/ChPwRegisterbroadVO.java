package com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwRegisterbroadVO implements Serializable {

    /** identifier field */
    private Long broadid;

    /** nullable persistent field */
    private String telephone;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Short broadnum;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date regdate;

    /** full constructor */
    public ChPwRegisterbroadVO(java.lang.Long broadid, java.lang.String telephone, java.lang.String mobile, java.lang.Short broadnum, java.lang.Short state, java.lang.String opnid, java.lang.String wayid, java.util.Date regdate) {
        this.broadid = broadid;
        this.telephone = telephone;
        this.mobile = mobile;
        this.broadnum = broadnum;
        this.state = state;
        this.opnid = opnid;
        this.wayid = wayid;
        this.regdate = regdate;
    }

    /** default constructor */
    public ChPwRegisterbroadVO() {
    }

    /** minimal constructor */
    public ChPwRegisterbroadVO(java.lang.Long broadid) {
        this.broadid = broadid;
    }

    public java.lang.Long getBroadid() {
        return this.broadid;
    }

    public void setBroadid(java.lang.Long broadid) {
        this.broadid = broadid;
    }

    public java.lang.String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(java.lang.String telephone) {
        this.telephone = telephone;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Short getBroadnum() {
        return this.broadnum;
    }

    public void setBroadnum(java.lang.Short broadnum) {
        this.broadnum = broadnum;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getRegdate() {
        return this.regdate;
    }

    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("broadid", getBroadid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwRegisterbroadVO) ) return false;
        ChPwRegisterbroadVO castOther = (ChPwRegisterbroadVO) other;
        return new EqualsBuilder()
            .append(this.getBroadid(), castOther.getBroadid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBroadid())
            .toHashCode();
    }

}
