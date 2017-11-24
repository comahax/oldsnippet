package com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ExmnperiodlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Integer seqid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private Short beginmonth;

    /** nullable persistent field */
    private Short endmonth;

    /** full constructor */
    public ExmnperiodlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer seqid, java.lang.Integer exmnid, java.lang.Short beginmonth, java.lang.Short endmonth) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.beginmonth = beginmonth;
        this.endmonth = endmonth;
    }

    /** default constructor */
    public ExmnperiodlogVO() {
    }

    /** minimal constructor */
    public ExmnperiodlogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.Integer getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Integer seqid) {
        this.seqid = seqid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.Short getBeginmonth() {
        return this.beginmonth;
    }

    public void setBeginmonth(java.lang.Short beginmonth) {
        this.beginmonth = beginmonth;
    }

    public java.lang.Short getEndmonth() {
        return this.endmonth;
    }

    public void setEndmonth(java.lang.Short endmonth) {
        this.endmonth = endmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExmnperiodlogVO) ) return false;
        ExmnperiodlogVO castOther = (ExmnperiodlogVO) other;
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
