package com.sunrise.boss.business.cms.reward.pwdictparam.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PwDictparamVO implements Serializable {

    /** identifier field */
    private String dkey;

    /** persistent field */
    private String dvalue;

    /** nullable persistent field */
    private Byte state;

    /** nullable persistent field */
    private String dicttype;

    /** nullable persistent field */
    private String format;

    /** full constructor */
    public PwDictparamVO(java.lang.String dkey, java.lang.String dvalue, java.lang.Byte state, java.lang.String dicttype, java.lang.String format) {
        this.dkey = dkey;
        this.dvalue = dvalue;
        this.state = state;
        this.dicttype = dicttype;
        this.format = format;
    }

    /** default constructor */
    public PwDictparamVO() {
    }

    /** minimal constructor */
    public PwDictparamVO(java.lang.String dkey, java.lang.String dvalue) {
        this.dkey = dkey;
        this.dvalue = dvalue;
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

    public java.lang.String getDicttype() {
        return this.dicttype;
    }

    public void setDicttype(java.lang.String dicttype) {
        this.dicttype = dicttype;
    }

    public java.lang.String getFormat() {
        return this.format;
    }

    public void setFormat(java.lang.String format) {
        this.format = format;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("dkey", getDkey())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PwDictparamVO) ) return false;
        PwDictparamVO castOther = (PwDictparamVO) other;
        return new EqualsBuilder()
            .append(this.getDkey(), castOther.getDkey())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDkey())
            .toHashCode();
    }

}
