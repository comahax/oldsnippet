package com.sunrise.boss.business.cms.examine.mappinglog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MappinglogVO implements Serializable {

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
    private Long seqid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String mmode;

    /** nullable persistent field */
    private Double markul;

    /** nullable persistent field */
    private Double markll;

    /** nullable persistent field */
    private Double coeforbase;

    /** full constructor */
    public MappinglogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.Integer exmnid, java.lang.String cityid, java.lang.String mmode, java.lang.Double markul, java.lang.Double markll, java.lang.Double coeforbase) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.cityid = cityid;
        this.mmode = mmode;
        this.markul = markul;
        this.markll = markll;
        this.coeforbase = coeforbase;
    }

    /** default constructor */
    public MappinglogVO() {
    }

    /** minimal constructor */
    public MappinglogVO(java.lang.Long logid) {
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

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getMmode() {
        return this.mmode;
    }

    public void setMmode(java.lang.String mmode) {
        this.mmode = mmode;
    }

    public java.lang.Double getMarkul() {
        return this.markul;
    }

    public void setMarkul(java.lang.Double markul) {
        this.markul = markul;
    }

    public java.lang.Double getMarkll() {
        return this.markll;
    }

    public void setMarkll(java.lang.Double markll) {
        this.markll = markll;
    }

    public java.lang.Double getCoeforbase() {
        return this.coeforbase;
    }

    public void setCoeforbase(java.lang.Double coeforbase) {
        this.coeforbase = coeforbase;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MappinglogVO) ) return false;
        MappinglogVO castOther = (MappinglogVO) other;
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
