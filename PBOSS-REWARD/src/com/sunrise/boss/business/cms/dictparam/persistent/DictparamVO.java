package com.sunrise.boss.business.cms.dictparam.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DictparamVO implements Serializable {

    /** identifier field */
    private String dkey;

    /** identifier field */
    private String dvalue;

    /** nullable persistent field */
    private Byte state;

    /** nullable persistent field */
    private String type;

    /** nullable persistent field */
    private String dicttype;

    /** full constructor */
    public DictparamVO(java.lang.String dkey, java.lang.String dvalue, java.lang.Byte state, java.lang.String type, java.lang.String dicttype) {
        this.dkey = dkey;
        this.dvalue = dvalue;
        this.state = state;
        this.type = type;
        this.dicttype = dicttype;
    }

    /** default constructor */
    public DictparamVO() {
    }

    /** minimal constructor */
    public DictparamVO(java.lang.String dkey, java.lang.String dvalue) {
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
            .append("dkey", getDkey())
            .append("dvalue", getDvalue())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DictparamVO) ) return false;
        DictparamVO castOther = (DictparamVO) other;
        return new EqualsBuilder()
            .append(this.getDkey(), castOther.getDkey())
            .append(this.getDvalue(), castOther.getDvalue())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDkey())
            .append(getDvalue())
            .toHashCode();
    }

}
