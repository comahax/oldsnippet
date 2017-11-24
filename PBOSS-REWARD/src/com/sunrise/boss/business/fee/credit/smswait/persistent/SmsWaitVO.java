package com.sunrise.boss.business.fee.credit.smswait.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SmsWaitVO implements Serializable {

    /** identifier field */
    private Long smswaitid;

    /** nullable persistent field */
    private String servnumber;

    /** nullable persistent field */
    private java.util.Date sendtime;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private Long smstype;

    /** nullable persistent field */
    private Long smsruleid;

    /** nullable persistent field */
    private String smscontent;

    /** full constructor */
    public SmsWaitVO(java.lang.Long smswaitid, java.lang.String servnumber, java.util.Date sendtime, java.util.Date createtime, java.lang.Long smstype, java.lang.Long smsruleid, java.lang.String smscontent) {
        this.smswaitid = smswaitid;
        this.servnumber = servnumber;
        this.sendtime = sendtime;
        this.createtime = createtime;
        this.smstype = smstype;
        this.smsruleid = smsruleid;
        this.smscontent = smscontent;
    }

    /** default constructor */
    public SmsWaitVO() {
    }

    /** minimal constructor */
    public SmsWaitVO(java.lang.Long smswaitid) {
        this.smswaitid = smswaitid;
    }

    public java.lang.Long getSmswaitid() {
        return this.smswaitid;
    }

    public void setSmswaitid(java.lang.Long smswaitid) {
        this.smswaitid = smswaitid;
    }

    public java.lang.String getServnumber() {
        return this.servnumber;
    }

    public void setServnumber(java.lang.String servnumber) {
        this.servnumber = servnumber;
    }

    public java.util.Date getSendtime() {
        return this.sendtime;
    }

    public void setSendtime(java.util.Date sendtime) {
        this.sendtime = sendtime;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.Long getSmstype() {
        return this.smstype;
    }

    public void setSmstype(java.lang.Long smstype) {
        this.smstype = smstype;
    }

    public java.lang.Long getSmsruleid() {
        return this.smsruleid;
    }

    public void setSmsruleid(java.lang.Long smsruleid) {
        this.smsruleid = smsruleid;
    }

    public java.lang.String getSmscontent() {
        return this.smscontent;
    }

    public void setSmscontent(java.lang.String smscontent) {
        this.smscontent = smscontent;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("smswaitid", getSmswaitid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmsWaitVO) ) return false;
        SmsWaitVO castOther = (SmsWaitVO) other;
        return new EqualsBuilder()
            .append(this.getSmswaitid(), castOther.getSmswaitid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSmswaitid())
            .toHashCode();
    }

}
