package com.sunrise.boss.business.cms.distribute.cpright.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.ManageLog;

/** @author Hibernate CodeGenerator */
public class CprightVO implements Serializable,ManageLog {

    /** identifier field */
    private String cooperauid;

    /** identifier field */
    private Short fxtype;

    /** persistent field */
    private Short returntype;

    /** persistent field */
    private Short paytype;

    /** persistent field */
    private String cooperalevel;

    /** persistent field */
    private String reswayid;

    /** persistent field */
    private String buswayid;

    /** full constructor */
    public CprightVO(java.lang.String cooperauid, java.lang.Short fxtype, java.lang.Short returntype, java.lang.Short paytype, java.lang.String cooperalevel, java.lang.String reswayid, java.lang.String buswayid) {
        this.cooperauid = cooperauid;
        this.fxtype = fxtype;
        this.returntype = returntype;
        this.paytype = paytype;
        this.cooperalevel = cooperalevel;
        this.reswayid = reswayid;
        this.buswayid = buswayid;
    }

    /** default constructor */
    public CprightVO() {
    }

    public java.lang.String getCooperauid() {
        return this.cooperauid;
    }

    public void setCooperauid(java.lang.String cooperauid) {
        this.cooperauid = cooperauid;
    }

    public java.lang.Short getFxtype() {
        return this.fxtype;
    }

    public void setFxtype(java.lang.Short fxtype) {
        this.fxtype = fxtype;
    }

    public java.lang.Short getReturntype() {
        return this.returntype;
    }

    public void setReturntype(java.lang.Short returntype) {
        this.returntype = returntype;
    }

    public java.lang.Short getPaytype() {
        return this.paytype;
    }

    public void setPaytype(java.lang.Short paytype) {
        this.paytype = paytype;
    }

    public java.lang.String getCooperalevel() {
        return this.cooperalevel;
    }

    public void setCooperalevel(java.lang.String cooperalevel) {
        this.cooperalevel = cooperalevel;
    }

    public java.lang.String getReswayid() {
        return this.reswayid;
    }

    public void setReswayid(java.lang.String reswayid) {
        this.reswayid = reswayid;
    }

    public java.lang.String getBuswayid() {
        return this.buswayid;
    }

    public void setBuswayid(java.lang.String buswayid) {
        this.buswayid = buswayid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cooperauid", getCooperauid())
            .append("fxtype", getFxtype())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CprightVO) ) return false;
        CprightVO castOther = (CprightVO) other;
        return new EqualsBuilder()
            .append(this.getCooperauid(), castOther.getCooperauid())
            .append(this.getFxtype(), castOther.getFxtype())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCooperauid())
            .append(getFxtype())
            .toHashCode();
    }

}
