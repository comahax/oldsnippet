package com.sunrise.boss.business.cms.chadtdictparam.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.chadtdictparamlog.persistent.ChAdtDictparamlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChAdtDictparamVO implements OperationLog {

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
    public ChAdtDictparamVO(java.lang.String dkey, java.lang.String dvalue, java.lang.Byte state, java.lang.String type, java.lang.String dicttype) {
        this.dkey = dkey;
        this.dvalue = dvalue;
        this.state = state;
        this.type = type;
        this.dicttype = dicttype;
    }

    /** default constructor */
    public ChAdtDictparamVO() {
    }

    /** minimal constructor */
    public ChAdtDictparamVO(java.lang.String dkey, java.lang.String dvalue) {
        this.dkey = dkey;
        this.dvalue = dvalue;
    }
    public ChAdtDictparamVO(java.lang.String dkey) {
        this.dkey = dkey;
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
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtDictparamVO) ) return false;
        ChAdtDictparamVO castOther = (ChAdtDictparamVO) other;
        return new EqualsBuilder()
            .append(this.getDkey(), castOther.getDkey())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDkey())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ChAdtDictparamlogVO.class;
	}

}
