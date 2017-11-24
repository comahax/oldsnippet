package com.gmcc.pboss.business.channel.empmodel;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class EmpmodelVO extends BaseVO implements BusinessLog,Serializable {

    /** identifier field */
    private Long empmodelid;

    /** nullable persistent field */
    private String employeeid;

    /** nullable persistent field */
    private String model;

    /** nullable persistent field */
    private Short state;

    /** full constructor */
    public EmpmodelVO(java.lang.String employeeid, java.lang.String model, java.lang.Short state) {
        this.employeeid = employeeid;
        this.model = model;
        this.state = state;
    }

    /** default constructor */
    public EmpmodelVO() {
    }

    public java.lang.Long getEmpmodelid() {
        return this.empmodelid;
    }

    public void setEmpmodelid(java.lang.Long empmodelid) {
        this.empmodelid = empmodelid;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getModel() {
        return this.model;
    }

    public void setModel(java.lang.String model) {
        this.model = model;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("empmodelid", getEmpmodelid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmpmodelVO) ) return false;
        EmpmodelVO castOther = (EmpmodelVO) other;
        return new EqualsBuilder()
            .append(this.getEmpmodelid(), castOther.getEmpmodelid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmpmodelid())
            .toHashCode();
    }
    
	public Class logVOClass() {
		// TODO Auto-generated method stub
		return EmpmodellogVO.class;
	}

}
