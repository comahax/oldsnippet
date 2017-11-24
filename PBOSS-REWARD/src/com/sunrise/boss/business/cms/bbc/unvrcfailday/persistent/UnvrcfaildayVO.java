package com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class UnvrcfaildayVO implements Serializable {

    /** identifier field */
    private Long failid;

    /** nullable persistent field */
    private String rcno;

    /** nullable persistent field */
    private String mobileno;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String rcmonth;

    /** nullable persistent field */
    private java.util.Date rcdate;

    /** nullable persistent field */
    private String reason;

    /** nullable persistent field */
    private Short ossrc;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String src;

    /** full constructor */
    public UnvrcfaildayVO(java.lang.String rcno, java.lang.String mobileno, java.lang.String opnid, java.lang.String rcmonth, java.util.Date rcdate, java.lang.String reason, java.lang.Short ossrc, java.lang.String wayid, java.lang.String src) {
        this.rcno = rcno;
        this.mobileno = mobileno;
        this.opnid = opnid;
        this.rcmonth = rcmonth;
        this.rcdate = rcdate;
        this.reason = reason;
        this.ossrc = ossrc;
        this.wayid = wayid;
        this.src = src;
    }

    /** default constructor */
    public UnvrcfaildayVO() {
    }

    public java.lang.Long getFailid() {
        return this.failid;
    }

    public void setFailid(java.lang.Long failid) {
        this.failid = failid;
    }

    public java.lang.String getRcno() {
        return this.rcno;
    }

    public void setRcno(java.lang.String rcno) {
        this.rcno = rcno;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getRcmonth() {
        return this.rcmonth;
    }

    public void setRcmonth(java.lang.String rcmonth) {
        this.rcmonth = rcmonth;
    }

    public java.util.Date getRcdate() {
        return this.rcdate;
    }

    public void setRcdate(java.util.Date rcdate) {
        this.rcdate = rcdate;
    }

    public java.lang.String getReason() {
        return this.reason;
    }

    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    public java.lang.Short getOssrc() {
        return this.ossrc;
    }

    public void setOssrc(java.lang.Short ossrc) {
        this.ossrc = ossrc;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getSrc() {
        return this.src;
    }

    public void setSrc(java.lang.String src) {
        this.src = src;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("failid", getFailid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof UnvrcfaildayVO) ) return false;
        UnvrcfaildayVO castOther = (UnvrcfaildayVO) other;
        return new EqualsBuilder()
            .append(this.getFailid(), castOther.getFailid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFailid())
            .toHashCode();
    }

}
