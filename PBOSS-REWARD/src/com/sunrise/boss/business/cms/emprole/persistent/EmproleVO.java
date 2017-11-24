package com.sunrise.boss.business.cms.emprole.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.emprolelog.persistent.EmprolelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class EmproleVO implements Serializable,OperationLog {

    /** identifier field */
    private String ekey;

    /** identifier field */
    private String employeeid;

    /** nullable persistent field */
    private String evalue;

    /** full constructor */
    public EmproleVO(java.lang.String ekey, java.lang.String employeeid, java.lang.String evalue) {
        this.ekey = ekey;
        this.employeeid = employeeid;
        this.evalue = evalue;
    }

    /** default constructor */
    public EmproleVO() {
    }

    /** minimal constructor */
    public EmproleVO(java.lang.String ekey, java.lang.String employeeid) {
        this.ekey = ekey;
        this.employeeid = employeeid;
    }

    public java.lang.String getEkey() {
        return this.ekey;
    }

    public void setEkey(java.lang.String ekey) {
        this.ekey = ekey;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getEvalue() {
        return this.evalue;
    }

    public void setEvalue(java.lang.String evalue) {
        this.evalue = evalue;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ekey", getEkey())
            .append("employeeid", getEmployeeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmproleVO) ) return false;
        EmproleVO castOther = (EmproleVO) other;
        return new EqualsBuilder()
            .append(this.getEkey(), castOther.getEkey())
            .append(this.getEmployeeid(), castOther.getEmployeeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEkey())
            .append(getEmployeeid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return EmprolelogVO.class;
	}

}
