package com.sunrise.boss.business.fee.hangbill.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BillcheckVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String checkcode;

    /** nullable persistent field */
    private Double amt;

    /** nullable persistent field */
    private String reason;

    /** nullable persistent field */
    private String checkresult;

    /** nullable persistent field */
    private Long checkaction;

    /** full constructor */
    public BillcheckVO(java.lang.Long logid, java.lang.String oprcode, java.lang.String checkcode, java.lang.Double amt, java.lang.String reason, java.lang.String checkresult, java.lang.Long checkaction) {
        this.logid = logid;
        this.oprcode = oprcode;
        this.checkcode = checkcode;
        this.amt = amt;
        this.reason = reason;
        this.checkresult = checkresult;
        this.checkaction = checkaction;
    }

    /** default constructor */
    public BillcheckVO() {
    }

    /** minimal constructor */
    public BillcheckVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getCheckcode() {
        return this.checkcode;
    }

    public void setCheckcode(java.lang.String checkcode) {
        this.checkcode = checkcode;
    }

    public java.lang.Double getAmt() {
        return this.amt;
    }

    public void setAmt(java.lang.Double amt) {
        this.amt = amt;
    }

    public java.lang.String getReason() {
        return this.reason;
    }

    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    public java.lang.String getCheckresult() {
        return this.checkresult;
    }

    public void setCheckresult(java.lang.String checkresult) {
        this.checkresult = checkresult;
    }

    public java.lang.Long getCheckaction() {
        return this.checkaction;
    }

    public void setCheckaction(java.lang.Long checkaction) {
        this.checkaction = checkaction;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BillcheckVO) ) return false;
        BillcheckVO castOther = (BillcheckVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
