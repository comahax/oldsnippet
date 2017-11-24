package com.sunrise.boss.business.cms.fdauditdef.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FdauditdefVO implements Serializable {

    /** identifier field */
    private String field;

    /** identifier field */
    private String tablename;

    /** persistent field */
    private String tablechname;

    /** persistent field */
    private String fieldchname;

    /** nullable persistent field */
    private Short fieldtype;

    /** persistent field */
    private String pkname;

    /** nullable persistent field */
    private Short pktype;

    /** nullable persistent field */
    private String pkname2;

    /** nullable persistent field */
    private Short pktype2;

    /** persistent field */
    private String typename;

    /** persistent field */
    private String typechname;
    
    private Short state;

    /** full constructor */
    public FdauditdefVO(java.lang.String field, java.lang.String tablename, java.lang.String tablechname, java.lang.String fieldchname, Short fieldtype, java.lang.String pkname, Short pktype, java.lang.String pkname2, Short pktype2, java.lang.String typename, java.lang.String typechname,Short state) {
        this.field = field;
        this.tablename = tablename;
        this.tablechname = tablechname;
        this.fieldchname = fieldchname;
        this.fieldtype = fieldtype;
        this.pkname = pkname;
        this.pktype = pktype;
        this.pkname2 = pkname2;
        this.pktype2 = pktype2;
        this.typename = typename;
        this.typechname = typechname;
        this.state = state;
    }

    /** default constructor */
    public FdauditdefVO() {
    }

    /** minimal constructor */
    public FdauditdefVO(java.lang.String field, java.lang.String tablename, java.lang.String tablechname, java.lang.String fieldchname,java.lang.String typename, java.lang.String typechname) {
        this.field = field;
        this.tablename = tablename;
        this.tablechname = tablechname;
        this.fieldchname = fieldchname;
        //this.pkname = pkname;
        this.typename = typename;
        this.typechname = typechname;
    }

    public java.lang.String getField() {
        return this.field;
    }

    public void setField(java.lang.String field) {
        this.field = field;
    }

    public java.lang.String getTablename() {
        return this.tablename;
    }

    public void setTablename(java.lang.String tablename) {
        this.tablename = tablename;
    }

    public java.lang.String getTablechname() {
        return this.tablechname;
    }

    public void setTablechname(java.lang.String tablechname) {
        this.tablechname = tablechname;
    }

    public java.lang.String getFieldchname() {
        return this.fieldchname;
    }

    public void setFieldchname(java.lang.String fieldchname) {
        this.fieldchname = fieldchname;
    }

    public Short getFieldtype() {
        return this.fieldtype;
    }

    public void setFieldtype(Short fieldtype) {
        this.fieldtype = fieldtype;
    }

    public java.lang.String getPkname() {
        return this.pkname;
    }

    public void setPkname(java.lang.String pkname) {
        this.pkname = pkname;
    }

    public Short getPktype() {
        return this.pktype;
    }

    public void setPktype(Short pktype) {
        this.pktype = pktype;
    }

    public java.lang.String getPkname2() {
        return this.pkname2;
    }

    public void setPkname2(java.lang.String pkname2) {
        this.pkname2 = pkname2;
    }

    public Short getPktype2() {
        return this.pktype2;
    }

    public void setPktype2(Short pktype2) {
        this.pktype2 = pktype2;
    }

    public java.lang.String getTypename() {
        return this.typename;
    }

    public void setTypename(java.lang.String typename) {
        this.typename = typename;
    }

    public java.lang.String getTypechname() {
        return this.typechname;
    }

    public void setTypechname(java.lang.String typechname) {
        this.typechname = typechname;
    }

    public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("field", getField())
            .append("tablename", getTablename())
            .append("typename", getTypename())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FdauditdefVO) ) return false;
        FdauditdefVO castOther = (FdauditdefVO) other;
        return new EqualsBuilder()
            .append(this.getField(), castOther.getField())
            .append(this.getTablename(), castOther.getTablename())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getField())
            .append(getTablename())
            .toHashCode();
    }

	

}
