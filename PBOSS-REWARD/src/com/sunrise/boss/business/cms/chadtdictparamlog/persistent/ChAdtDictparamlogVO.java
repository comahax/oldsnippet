package com.sunrise.boss.business.cms.chadtdictparamlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtDictparamlogVO implements Serializable {

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
    private String dkey;

    /** persistent field */
    private String dvalue;

    /** nullable persistent field */
    private Byte state;

    /** nullable persistent field */
    private String type;

    /** nullable persistent field */
    private String dicttype;

    /** full constructor */
    public ChAdtDictparamlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String dkey, java.lang.String dvalue, java.lang.Byte state, java.lang.String type, java.lang.String dicttype) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.dkey = dkey;
        this.dvalue = dvalue;
        this.state = state;
        this.type = type;
        this.dicttype = dicttype;
    }

    /** default constructor */
    public ChAdtDictparamlogVO() {
    }

    /** minimal constructor */
    public ChAdtDictparamlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String dkey, java.lang.String dvalue) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.dkey = dkey;
        this.dvalue = dvalue;
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

    public java.lang.String getDkey() {
        return this.dkey;
    }

    public void setDkey(java.lang.String dkey) {
        this.dkey = dkey;
    }

    public java.lang.String getDvalue() {
        return this.dvalue;
    }

    public void setDvalue(java.lang.String dvalue) {
        this.dvalue = dvalue;
    }

    public java.lang.Byte getState() {
        return this.state;
    }

    public void setState(java.lang.Byte state) {
        this.state = state;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getDicttype() {
        return this.dicttype;
    }

    public void setDicttype(java.lang.String dicttype) {
        this.dicttype = dicttype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtDictparamlogVO) ) return false;
        ChAdtDictparamlogVO castOther = (ChAdtDictparamlogVO) other;
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
