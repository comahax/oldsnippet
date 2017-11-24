package com.sunrise.boss.business.fee.billing.yhfeelstate.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class YhfeelstateVO extends BaseVO {

    /** identifier field */
    private Long validbillcyc;

    /** nullable persistent field */
    private Short smsfilestate;

    /** nullable persistent field */
    private java.util.Date filestarttime;

    /** nullable persistent field */
    private java.util.Date fileendtime;

    /** nullable persistent field */
    private Short smssendstate;

    /** nullable persistent field */
    private java.util.Date smsstarttime;

    /** nullable persistent field */
    private java.util.Date smsendtime;

    /** nullable persistent field */
    private String oprcode;

    /** full constructor */
    public YhfeelstateVO(java.lang.Long validbillcyc, java.lang.Short smsfilestate, java.util.Date filestarttime, java.util.Date fileendtime, java.lang.Short smssendstate, java.util.Date smsstarttime, java.util.Date smsendtime, java.lang.String oprcode) {
        this.validbillcyc = validbillcyc;
        this.smsfilestate = smsfilestate;
        this.filestarttime = filestarttime;
        this.fileendtime = fileendtime;
        this.smssendstate = smssendstate;
        this.smsstarttime = smsstarttime;
        this.smsendtime = smsendtime;
        this.oprcode = oprcode;
    }

    /** default constructor */
    public YhfeelstateVO() {
    }

    /** minimal constructor */
    public YhfeelstateVO(java.lang.Long validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Long getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Long validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Short getSmsfilestate() {
        return this.smsfilestate;
    }

    public void setSmsfilestate(java.lang.Short smsfilestate) {
        this.smsfilestate = smsfilestate;
    }

    public java.util.Date getFilestarttime() {
        return this.filestarttime;
    }

    public void setFilestarttime(java.util.Date filestarttime) {
        this.filestarttime = filestarttime;
    }

    public java.util.Date getFileendtime() {
        return this.fileendtime;
    }

    public void setFileendtime(java.util.Date fileendtime) {
        this.fileendtime = fileendtime;
    }

    public java.lang.Short getSmssendstate() {
        return this.smssendstate;
    }

    public void setSmssendstate(java.lang.Short smssendstate) {
        this.smssendstate = smssendstate;
    }

    public java.util.Date getSmsstarttime() {
        return this.smsstarttime;
    }

    public void setSmsstarttime(java.util.Date smsstarttime) {
        this.smsstarttime = smsstarttime;
    }

    public java.util.Date getSmsendtime() {
        return this.smsendtime;
    }

    public void setSmsendtime(java.util.Date smsendtime) {
        this.smsendtime = smsendtime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("validbillcyc", getValidbillcyc())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YhfeelstateVO) ) return false;
        YhfeelstateVO castOther = (YhfeelstateVO) other;
        return new EqualsBuilder()
            .append(this.getValidbillcyc(), castOther.getValidbillcyc())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getValidbillcyc())
            .toHashCode();
    }

}
