package com.sunrise.boss.business.cms.empmodellog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EmpmodellogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private Long empmodelid;

    /** nullable persistent field */
    private String employeeid;

    /** nullable persistent field */
    private String model;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;
    
    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;


    /** full constructor */
    public EmpmodellogVO(java.lang.Long logid, java.lang.Long empmodelid, java.lang.String employeeid, java.lang.String model, java.lang.Short state, java.util.Date optime, java.lang.String oprcode) {
        this.logid = logid;
        this.empmodelid = empmodelid;
        this.employeeid = employeeid;
        this.model = model;
        this.state = state;
        this.optime = optime;
        this.oprcode = oprcode;
    }

    /** default constructor */
    public EmpmodellogVO() {
    }

    /** minimal constructor */
    public EmpmodellogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmpmodellogVO) ) return false;
        EmpmodellogVO castOther = (EmpmodellogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}
