package com.gmcc.pboss.business.channel.employeeextend;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class EmployeeextendVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String employeeid;

    /** nullable persistent field */
    private String password;

    /** full constructor */
    public EmployeeextendVO(java.lang.String employeeid, java.lang.String password) {
        this.employeeid = employeeid;
        this.password = password;
    }

    /** default constructor */
    public EmployeeextendVO() {
    }

    /** minimal constructor */
    public EmployeeextendVO(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("employeeid", getEmployeeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmployeeextendVO) ) return false;
        EmployeeextendVO castOther = (EmployeeextendVO) other;
        return new EqualsBuilder()
            .append(this.getEmployeeid(), castOther.getEmployeeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmployeeid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return EmployeeextendlogVO.class;
    }

}
