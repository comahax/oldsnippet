package com.gmcc.pboss.business.base.limitsmslog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LimitsmslogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long login;

    /** persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private Long seq;

    /** persistent field */
    private String sms;

    /** full constructor */
    public LimitsmslogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seq, java.lang.String sms) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seq = seq;
        this.sms = sms;
    }

    /** default constructor */
    public LimitsmslogVO() {
    }

    /** minimal constructor */
    public LimitsmslogVO(java.util.Date optime, java.lang.Long seq, java.lang.String sms) {
        this.optime = optime;
        this.seq = seq;
        this.sms = sms;
    }

    public java.lang.Long getLogin() {
        return this.login;
    }

    public void setLogin(java.lang.Long login) {
        this.login = login;
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

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getSms() {
        return this.sms;
    }

    public void setSms(java.lang.String sms) {
        this.sms = sms;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("login", getLogin())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LimitsmslogVO) ) return false;
        LimitsmslogVO castOther = (LimitsmslogVO) other;
        return new EqualsBuilder()
            .append(this.getLogin(), castOther.getLogin())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogin())
            .toHashCode();
    }

}
