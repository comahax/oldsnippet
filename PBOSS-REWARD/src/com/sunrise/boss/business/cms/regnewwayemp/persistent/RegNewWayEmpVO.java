package com.sunrise.boss.business.cms.regnewwayemp.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RegNewWayEmpVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String waymagcode;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String employeename;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Short brand;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String employeeid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String svccode;
    
    private String name;//所属渠道经理
    
    private String opnname;//所属渠道经理

    /** full constructor */
    public RegNewWayEmpVO(java.lang.Long seqid, java.lang.String wayid, java.lang.String wayname, java.lang.String waymagcode, java.lang.String countyid, java.lang.Short starlevel, java.lang.String employeename, java.lang.String officetel, java.lang.String mobile, java.lang.Short brand, java.lang.String opnid, java.util.Date oprtime, java.lang.String employeeid, java.lang.String oprcode, java.lang.String svccode) {
        this.seqid = seqid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.waymagcode = waymagcode;
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.employeename = employeename;
        this.officetel = officetel;
        this.mobile = mobile;
        this.brand = brand;
        this.opnid = opnid;
        this.oprtime = oprtime;
        this.employeeid = employeeid;
        this.oprcode = oprcode;
        this.svccode = svccode;
    }

    /** default constructor */
    public RegNewWayEmpVO() {
    }

    /** minimal constructor */
    public RegNewWayEmpVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getWaymagcode() {
        return this.waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getEmployeename() {
        return this.employeename;
    }

    public void setEmployeename(java.lang.String employeename) {
        this.employeename = employeename;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Short getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Short brand) {
        this.brand = brand;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RegNewWayEmpVO) ) return false;
        RegNewWayEmpVO castOther = (RegNewWayEmpVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

}
