package com.gmcc.pboss.business.promotion.presentingalog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PresentingalogVO extends BaseVO implements Serializable {

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
    private String comcategory;

    /** nullable persistent field */
    private Short quantity;

    /** nullable persistent field */
    private String pcomcategory;

    /** nullable persistent field */
    private Short pquantity;

    /** full constructor */
    public PresentingalogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer ruleid, java.lang.String comcategory, java.lang.Short quantity, java.lang.String pcomcategory, java.lang.Short pquantity) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.ruleid = ruleid;
        this.comcategory = comcategory;
        this.quantity = quantity;
        this.pcomcategory = pcomcategory;
        this.pquantity = pquantity;
    }

    /** default constructor */
    public PresentingalogVO() {
    }

    /** minimal constructor */
    public PresentingalogVO(java.lang.Long logid) {
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

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Short getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.lang.Short quantity) {
        this.quantity = quantity;
    }

    public java.lang.String getPcomcategory() {
        return this.pcomcategory;
    }

    public void setPcomcategory(java.lang.String pcomcategory) {
        this.pcomcategory = pcomcategory;
    }

    public java.lang.Short getPquantity() {
        return this.pquantity;
    }

    public void setPquantity(java.lang.Short pquantity) {
        this.pquantity = pquantity;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PresentingalogVO) ) return false;
        PresentingalogVO castOther = (PresentingalogVO) other;
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
