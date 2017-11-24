package com.gmcc.pboss.business.resource.numtypedef;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class NumtypedefVO extends BaseVO implements Serializable ,BusinessLog{

    /** identifier field */
    private Long typeid;

    /** persistent field */
    private String typecode;

    /** persistent field */
    private String typename;

    /** nullable persistent field */
    private String typedesc;

    /** persistent field */
    private Short prilevel;

    /** persistent field */
    private Short effective;

    /** persistent field */
    private Short isdefault;

    /** full constructor */
    public NumtypedefVO(java.lang.Long typeid, java.lang.String typecode, java.lang.String typename, java.lang.String typedesc, java.lang.Short prilevel, java.lang.Short effective, java.lang.Short isdefault) {
        this.typeid = typeid;
        this.typecode = typecode;
        this.typename = typename;
        this.typedesc = typedesc;
        this.prilevel = prilevel;
        this.effective = effective;
        this.isdefault = isdefault;
    }

    /** default constructor */
    public NumtypedefVO() {
    }

    /** minimal constructor */
    public NumtypedefVO(java.lang.Long typeid, java.lang.String typecode, java.lang.String typename, java.lang.Short prilevel, java.lang.Short effective, java.lang.Short isdefault) {
        this.typeid = typeid;
        this.typecode = typecode;
        this.typename = typename;
        this.prilevel = prilevel;
        this.effective = effective;
        this.isdefault = isdefault;
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
            .append("typeid", getTypeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NumtypedefVO) ) return false;
        NumtypedefVO castOther = (NumtypedefVO) other;
        return new EqualsBuilder()
            .append(this.getTypeid(), castOther.getTypeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTypeid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return NumtypedeflogVO.class;
	}

}
