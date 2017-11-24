package com.sunrise.boss.business.cms.mendregister.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MendregisterVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private java.util.Date selltime;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.lang.Short success;

    /** nullable persistent field */
    private String adtremark;

    /** full constructor */
    public MendregisterVO(java.lang.String mobile, java.lang.String officetel, java.util.Date selltime, java.util.Date optime, java.lang.String oprcode, java.lang.Short success, java.lang.String adtremark) {
        this.mobile = mobile;
        this.officetel = officetel;
        this.selltime = selltime;
        this.optime = optime;
        this.oprcode = oprcode;
        this.success = success;
        this.adtremark = adtremark;
    }

    /** default constructor */
    public MendregisterVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.util.Date getSelltime() {
        return this.selltime;
    }

    public void setSelltime(java.util.Date selltime) {
        this.selltime = selltime;
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

    public java.lang.Short getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.Short success) {
        this.success = success;
    }

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MendregisterVO) ) return false;
        MendregisterVO castOther = (MendregisterVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
