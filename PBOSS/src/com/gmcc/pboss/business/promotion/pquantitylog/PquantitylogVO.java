package com.gmcc.pboss.business.promotion.pquantitylog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PquantitylogVO extends BaseVO implements Serializable {

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
    private Integer ruleid;

    /** nullable persistent field */
    private String prodid;

    /** nullable persistent field */
    private String incat;

    /** nullable persistent field */
    private Float incratio;

    /** full constructor */
    public PquantitylogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer ruleid, java.lang.String prodid, java.lang.String incat, java.lang.Float incratio) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.ruleid = ruleid;
        this.prodid = prodid;
        this.incat = incat;
        this.incratio = incratio;
    }

    /** default constructor */
    public PquantitylogVO() {
    }

    /** minimal constructor */
    public PquantitylogVO(java.lang.Long logid) {
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

    public java.lang.Integer getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Integer ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getIncat() {
        return this.incat;
    }

    public void setIncat(java.lang.String incat) {
        this.incat = incat;
    }

    public java.lang.Float getIncratio() {
        return this.incratio;
    }

    public void setIncratio(java.lang.Float incratio) {
        this.incratio = incratio;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PquantitylogVO) ) return false;
        PquantitylogVO castOther = (PquantitylogVO) other;
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
