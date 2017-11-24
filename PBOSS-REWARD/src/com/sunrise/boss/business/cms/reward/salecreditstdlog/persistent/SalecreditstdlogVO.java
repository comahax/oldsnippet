package com.sunrise.boss.business.cms.reward.salecreditstdlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SalecreditstdlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private Long seq;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Long busitype;

    /** nullable persistent field */
    private Double creditstd;

    /** nullable persistent field */
    private Double limited;

    /** full constructor */
    public SalecreditstdlogVO(java.lang.Long logid, java.lang.String oprcode, java.util.Date optime, java.lang.String success, java.lang.String oprtype, java.lang.Long seq, java.lang.Short cityid, java.lang.Long busitype, java.lang.Double creditstd, java.lang.Double limited) {
        this.logid = logid;
        this.oprcode = oprcode;
        this.optime = optime;
        this.success = success;
        this.oprtype = oprtype;
        this.seq = seq;
        this.cityid = cityid;
        this.busitype = busitype;
        this.creditstd = creditstd;
        this.limited = limited;
    }

    /** default constructor */
    public SalecreditstdlogVO() {
    }

    /** minimal constructor */
    public SalecreditstdlogVO(java.lang.Long logid) {
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

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.Long busitype) {
        this.busitype = busitype;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }

    public java.lang.Double getLimited() {
        return this.limited;
    }

    public void setLimited(java.lang.Double limited) {
        this.limited = limited;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SalecreditstdlogVO) ) return false;
        SalecreditstdlogVO castOther = (SalecreditstdlogVO) other;
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
