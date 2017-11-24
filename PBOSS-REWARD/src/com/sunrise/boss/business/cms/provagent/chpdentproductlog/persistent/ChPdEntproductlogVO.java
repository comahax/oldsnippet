package com.sunrise.boss.business.cms.provagent.chpdentproductlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdEntproductlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private String prodid;

    /** nullable persistent field */
    private String prodname;

    /** nullable persistent field */
    private String category;

    /** nullable persistent field */
    private String subcategory;

    /** full constructor */
    public ChPdEntproductlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String prodid, java.lang.String prodname, java.lang.String category, java.lang.String subcategory) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.prodid = prodid;
        this.prodname = prodname;
        this.category = category;
        this.subcategory = subcategory;
    }

    /** default constructor */
    public ChPdEntproductlogVO() {
    }

    /** minimal constructor */
    public ChPdEntproductlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String prodid) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.prodid = prodid;
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

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getProdname() {
        return this.prodname;
    }

    public void setProdname(java.lang.String prodname) {
        this.prodname = prodname;
    }

    public java.lang.String getCategory() {
        return this.category;
    }

    public void setCategory(java.lang.String category) {
        this.category = category;
    }

    public java.lang.String getSubcategory() {
        return this.subcategory;
    }

    public void setSubcategory(java.lang.String subcategory) {
        this.subcategory = subcategory;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdEntproductlogVO) ) return false;
        ChPdEntproductlogVO castOther = (ChPdEntproductlogVO) other;
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
