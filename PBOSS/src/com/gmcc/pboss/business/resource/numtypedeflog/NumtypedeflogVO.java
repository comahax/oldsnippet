package com.gmcc.pboss.business.resource.numtypedeflog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NumtypedeflogVO extends BaseVO implements Serializable {

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
    private Long typeid;

    /** nullable persistent field */
    private String typecode;

    /** nullable persistent field */
    private String typename;

    /** nullable persistent field */
    private String typedesc;

    /** nullable persistent field */
    private Short prilevel;

    /** nullable persistent field */
    private Short effective;

    /** nullable persistent field */
    private Short isdefault;

    /** full constructor */
    public NumtypedeflogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long typeid, java.lang.String typecode, java.lang.String typename, java.lang.String typedesc, java.lang.Short prilevel, java.lang.Short effective, java.lang.Short isdefault) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.typeid = typeid;
        this.typecode = typecode;
        this.typename = typename;
        this.typedesc = typedesc;
        this.prilevel = prilevel;
        this.effective = effective;
        this.isdefault = isdefault;
    }

    /** default constructor */
    public NumtypedeflogVO() {
    }

    /** minimal constructor */
    public NumtypedeflogVO(java.lang.Long logid) {
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

    public java.lang.Long getTypeid() {
        return this.typeid;
    }

    public void setTypeid(java.lang.Long typeid) {
        this.typeid = typeid;
    }

    public java.lang.String getTypecode() {
        return this.typecode;
    }

    public void setTypecode(java.lang.String typecode) {
        this.typecode = typecode;
    }

    public java.lang.String getTypename() {
        return this.typename;
    }

    public void setTypename(java.lang.String typename) {
        this.typename = typename;
    }

    public java.lang.String getTypedesc() {
        return this.typedesc;
    }

    public void setTypedesc(java.lang.String typedesc) {
        this.typedesc = typedesc;
    }

    public java.lang.Short getPrilevel() {
        return this.prilevel;
    }

    public void setPrilevel(java.lang.Short prilevel) {
        this.prilevel = prilevel;
    }

    public java.lang.Short getEffective() {
        return this.effective;
    }

    public void setEffective(java.lang.Short effective) {
        this.effective = effective;
    }

    public java.lang.Short getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(java.lang.Short isdefault) {
        this.isdefault = isdefault;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NumtypedeflogVO) ) return false;
        NumtypedeflogVO castOther = (NumtypedeflogVO) other;
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
