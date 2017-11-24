package com.sunrise.boss.business.cms.reward.registersimvw.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RegistersimvwVO implements Serializable {

    /** identifier field */
    private java.util.Date activedate;

    /** identifier field */
    private String employeeid;

    /** nullable persistent field */
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
    private String svccode;

    /** nullable persistent field */
    private String employeename;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String oprcode;

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
    
    private String opnname; // 业务名称
    
    private Short comclassid;//商品类型
    private Long comprice;//商品价格
    private Short mendfalg;//补登标识

    //add by liuchao 20111101
    private Short comtype;
    private String comname;
    
    
    public Short getComtype() {
		return comtype;
	}

	public void setComtype(Short comtype) {
		this.comtype = comtype;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	/** full constructor */
    public RegistersimvwVO(java.util.Date activedate, java.lang.String employeeid, java.lang.Long seqid, java.lang.String wayid, java.lang.String wayname, java.lang.String waymagcode, java.lang.String countyid, java.lang.Short starlevel, java.lang.String svccode, java.lang.String employeename, java.lang.String name, java.lang.String oprcode, java.lang.String officetel, java.lang.String mobile, java.lang.Short brand, java.lang.String opnid, java.util.Date oprtime) {
        this.activedate = activedate;
        this.employeeid = employeeid;
        this.seqid = seqid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.waymagcode = waymagcode;
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.svccode = svccode;
        this.employeename = employeename;
        this.name = name;
        this.oprcode = oprcode;
        this.officetel = officetel;
        this.mobile = mobile;
        this.brand = brand;
        this.opnid = opnid;
        this.oprtime = oprtime;
    }

    /** default constructor */
    public RegistersimvwVO() {
    }

    /** minimal constructor */
    public RegistersimvwVO(java.util.Date activedate, java.lang.String employeeid) {
        this.activedate = activedate;
        this.employeeid = employeeid;
    }

    public java.util.Date getActivedate() {
        return this.activedate;
    }

    public void setActivedate(java.util.Date activedate) {
        this.activedate = activedate;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
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

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getEmployeename() {
        return this.employeename;
    }

    public void setEmployeename(java.lang.String employeename) {
        this.employeename = employeename;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RegistersimvwVO) ) return false;
        RegistersimvwVO castOther = (RegistersimvwVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public Short getComclassid() {
		return comclassid;
	}

	public void setComclassid(Short comclassid) {
		this.comclassid = comclassid;
	}

	public Long getComprice() {
		return comprice;
	}

	public void setComprice(Long comprice) {
		this.comprice = comprice;
	}

	public Short getMendfalg() {
		return mendfalg;
	}

	public void setMendfalg(Short mendfalg) {
		this.mendfalg = mendfalg;
	}

}
