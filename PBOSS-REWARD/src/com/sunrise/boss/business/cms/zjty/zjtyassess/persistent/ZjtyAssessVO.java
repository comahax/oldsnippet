package com.sunrise.boss.business.cms.zjty.zjtyassess.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyAssessVO implements Serializable {

    /** identifier field */
    private String calcmonth;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Float coef1;

    /** nullable persistent field */
    private Float coef2;

    /** nullable persistent field */
    private Float coef3;

    /** nullable persistent field */
    private Short cityid;
    
    /** nullable persistent field */
    private Integer empnum;

    /** full constructor */
    public ZjtyAssessVO(java.lang.String calcmonth, java.lang.String wayid, java.lang.Float coef1, java.lang.Float coef2, java.lang.Float coef3, java.lang.Short cityid, java.lang.Integer empnum) {
        this.calcmonth = calcmonth;
        this.wayid = wayid;
        this.coef1 = coef1;
        this.coef2 = coef2;
        this.coef3 = coef3;
        this.cityid = cityid;
        this.empnum = empnum;
    }

    /** default constructor */
    public ZjtyAssessVO() {
    }

    /** minimal constructor */
    public ZjtyAssessVO(java.lang.String calcmonth, java.lang.String wayid) {
        this.calcmonth = calcmonth;
        this.wayid = wayid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Float getCoef1() {
        return this.coef1;
    }

    public void setCoef1(java.lang.Float coef1) {
        this.coef1 = coef1;
    }

    public java.lang.Float getCoef2() {
        return this.coef2;
    }

    public void setCoef2(java.lang.Float coef2) {
        this.coef2 = coef2;
    }

    public java.lang.Float getCoef3() {
        return this.coef3;
    }

    public void setCoef3(java.lang.Float coef3) {
        this.coef3 = coef3;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public Integer getEmpnum() {
		return empnum;
	}

	public void setEmpnum(Integer empnum) {
		this.empnum = empnum;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("calcmonth", getCalcmonth())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyAssessVO) ) return false;
        ZjtyAssessVO castOther = (ZjtyAssessVO) other;
        return new EqualsBuilder()
            .append(this.getCalcmonth(), castOther.getCalcmonth())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCalcmonth())
            .append(getWayid())
            .toHashCode();
    }

}
