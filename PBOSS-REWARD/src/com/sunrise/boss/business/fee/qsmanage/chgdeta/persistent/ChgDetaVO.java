package com.sunrise.boss.business.fee.qsmanage.chgdeta.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChgDetaVO implements Serializable {

    /** identifier field */
    private Integer createdate;

    /** identifier field */
    private String mainvalue;

    /** identifier field */
    private String paramtable;

    /** nullable persistent field */
    private Byte chgtype;

    /** nullable persistent field */
    private String mainkey;

    /** nullable persistent field */
    private String columns;

    /** nullable persistent field */
    private String oldvalue;

    /** nullable persistent field */
    private String newvalue;

    /** nullable persistent field */
    private String memo;
    
    private String his;

    /** full constructor */
    public ChgDetaVO(java.lang.Integer createdate, java.lang.String mainvalue, java.lang.String paramtable, java.lang.Byte chgtype, java.lang.String mainkey, java.lang.String columns, java.lang.String oldvalue, java.lang.String newvalue, java.lang.String memo, java.lang.String his) {
        this.createdate = createdate;
        this.mainvalue = mainvalue;
        this.paramtable = paramtable;
        this.chgtype = chgtype;
        this.mainkey = mainkey;
        this.columns = columns;
        this.oldvalue = oldvalue;
        this.newvalue = newvalue;
        this.memo = memo;
        this.his = his;
    }

    /** default constructor */
    public ChgDetaVO() {
    }

    /** minimal constructor */
    public ChgDetaVO(java.lang.Integer createdate, java.lang.String mainvalue, java.lang.String paramtable) {
        this.createdate = createdate;
        this.mainvalue = mainvalue;
        this.paramtable = paramtable;
    }

    public java.lang.Integer getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.lang.Integer createdate) {
        this.createdate = createdate;
    }

    public java.lang.String getMainvalue() {
        return this.mainvalue;
    }

    public void setMainvalue(java.lang.String mainvalue) {
        this.mainvalue = mainvalue;
    }

    public java.lang.String getParamtable() {
        return this.paramtable;
    }

    public void setParamtable(java.lang.String paramtable) {
        this.paramtable = paramtable;
    }

    public java.lang.Byte getChgtype() {
        return this.chgtype;
    }

    public void setChgtype(java.lang.Byte chgtype) {
        this.chgtype = chgtype;
    }

    public java.lang.String getMainkey() {
        return this.mainkey;
    }

    public void setMainkey(java.lang.String mainkey) {
        this.mainkey = mainkey;
    }

    public java.lang.String getColumns() {
        return this.columns;
    }

    public void setColumns(java.lang.String columns) {
        this.columns = columns;
    }

    public java.lang.String getOldvalue() {
        return this.oldvalue;
    }

    public void setOldvalue(java.lang.String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public java.lang.String getNewvalue() {
        return this.newvalue;
    }

    public void setNewvalue(java.lang.String newvalue) {
        this.newvalue = newvalue;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("createdate", getCreatedate())
            .append("mainvalue", getMainvalue())
            .append("paramtable", getParamtable())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChgDetaVO) ) return false;
        ChgDetaVO castOther = (ChgDetaVO) other;
        return new EqualsBuilder()
            .append(this.getCreatedate(), castOther.getCreatedate())
            .append(this.getMainvalue(), castOther.getMainvalue())
            .append(this.getParamtable(), castOther.getParamtable())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCreatedate())
            .append(getMainvalue())
            .append(getParamtable())
            .toHashCode();
    }

	public String getHis() {
		return his;
	}

	public void setHis(String his) {
		this.his = his;
	}

}
