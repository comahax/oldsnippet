package com.sunrise.boss.business.cms.reward.operationsms.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OperationsmsVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String smsno;

    /** nullable persistent field */
    private String opnname;

    /** nullable persistent field */
    private String opntype;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public OperationsmsVO(java.lang.String cityid, java.lang.String opnid, java.lang.String smsno, java.lang.String opnname, java.lang.String opntype, java.lang.String remark) {
        this.cityid = cityid;
        this.opnid = opnid;
        this.smsno = smsno;
        this.opnname = opnname;
        this.opntype = opntype;
        this.remark = remark;
    }

    /** default constructor */
    public OperationsmsVO() {
    }

    /** minimal constructor */
    public OperationsmsVO(java.lang.String cityid, java.lang.String opnid, java.lang.String smsno) {
        this.cityid = cityid;
        this.opnid = opnid;
        this.smsno = smsno;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getSmsno() {
        return this.smsno;
    }

    public void setSmsno(java.lang.String smsno) {
        this.smsno = smsno;
    }

    public java.lang.String getOpnname() {
        return this.opnname;
    }

    public void setOpnname(java.lang.String opnname) {
        this.opnname = opnname;
    }

    public java.lang.String getOpntype() {
        return this.opntype;
    }

    public void setOpntype(java.lang.String opntype) {
        this.opntype = opntype;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("opnid", getOpnid())
            .append("smsno", getSmsno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperationsmsVO) ) return false;
        OperationsmsVO castOther = (OperationsmsVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getSmsno(), castOther.getSmsno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getOpnid())
            .append(getSmsno())
            .toHashCode();
    }

}
