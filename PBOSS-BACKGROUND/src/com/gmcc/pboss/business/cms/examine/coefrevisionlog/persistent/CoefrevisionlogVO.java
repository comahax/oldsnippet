package com.gmcc.pboss.business.cms.examine.coefrevisionlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class CoefrevisionlogVO  extends BaseVO implements Serializable {

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
    private String wayid;

    /** nullable persistent field */
    private String exmnperiod;

    /** nullable persistent field */
    private Double coefficient;

    /** full constructor */
    public CoefrevisionlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.Integer exmnid, java.lang.String wayid, java.lang.String exmnperiod, java.lang.Double coefficient) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.wayid = wayid;
        this.exmnperiod = exmnperiod;
        this.coefficient = coefficient;
    }

    /** default constructor */
    public CoefrevisionlogVO() {
    }

    /** minimal constructor */
    public CoefrevisionlogVO(java.lang.Long logid) {
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.Double getCoefficient() {
        return this.coefficient;
    }

    public void setCoefficient(java.lang.Double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CoefrevisionlogVO) ) return false;
        CoefrevisionlogVO castOther = (CoefrevisionlogVO) other;
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
