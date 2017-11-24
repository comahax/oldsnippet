package com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UnvRewardrecordEmployeeVO implements Serializable {

	private String employeeid;
	private String employeename;
	
	public UnvRewardrecordEmployeeVO(String employeeid,String employeename) {
		this.employeeid = employeeid;
		this.employeename = employeename;
	}
	
	public UnvRewardrecordEmployeeVO() {
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	public String toString() {
        return new ToStringBuilder(this)
            .append("employeeid", getEmployeeid())
            .append("employeename",getEmployeename())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof UnvRewardrecordEmployeeVO) ) return false;
        UnvRewardrecordEmployeeVO castOther = (UnvRewardrecordEmployeeVO) other;
        return new EqualsBuilder()
            .append(this.getEmployeeid(), castOther.getEmployeeid())
            .append(this.getEmployeename(), castOther.getEmployeename())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmployeeid())
            .append(getEmployeename())
            .toHashCode();
    }
	
}
