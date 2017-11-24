package com.gmcc.pboss.business.sales.orderuplimitlog;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class OrderuplimitlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long recid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String cooptype;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Long monlimit;

    /** nullable persistent field */
    private Long daylimit;

    /** nullable persistent field */
    private Long stdstock;

    /** nullable persistent field */
    private String maxamtmode;

    /** nullable persistent field */
    private String alarmvalue;

    /** nullable persistent field */
    private Long maxstock;

    /** nullable persistent field */
    private String limitmode;
    
    private String restype;
    
    private String comcategory;

    /** full constructor */
    public OrderuplimitlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long recid, java.lang.String cityid, java.lang.String countyid, java.lang.String cooptype, java.lang.Short starlevel, java.lang.String brand, java.lang.Long monlimit, java.lang.Long daylimit, java.lang.Long stdstock, java.lang.String maxamtmode, java.lang.String alarmvalue, java.lang.Long maxstock, java.lang.String limitmode,String restype,String comcategory) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.recid = recid;
        this.cityid = cityid;
        this.countyid = countyid;
        this.cooptype = cooptype;
        this.starlevel = starlevel;
        this.brand = brand;
        this.monlimit = monlimit;
        this.daylimit = daylimit;
        this.stdstock = stdstock;
        this.maxamtmode = maxamtmode;
        this.alarmvalue = alarmvalue;
        this.maxstock = maxstock;
        this.limitmode = limitmode;
        this.restype = restype;
        this.comcategory = comcategory;
    }

    /** default constructor */
    public OrderuplimitlogVO() {
    }

    /** minimal constructor */
    public OrderuplimitlogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getCooptype() {
        return this.cooptype;
    }

    public void setCooptype(java.lang.String cooptype) {
        this.cooptype = cooptype;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Long getMonlimit() {
        return this.monlimit;
    }

    public void setMonlimit(java.lang.Long monlimit) {
        this.monlimit = monlimit;
    }

    public java.lang.Long getDaylimit() {
        return this.daylimit;
    }

    public void setDaylimit(java.lang.Long daylimit) {
        this.daylimit = daylimit;
    }

    public java.lang.Long getStdstock() {
        return this.stdstock;
    }

    public void setStdstock(java.lang.Long stdstock) {
        this.stdstock = stdstock;
    }

    public java.lang.String getMaxamtmode() {
        return this.maxamtmode;
    }

    public void setMaxamtmode(java.lang.String maxamtmode) {
        this.maxamtmode = maxamtmode;
    }

    public java.lang.String getAlarmvalue() {
        return this.alarmvalue;
    }

    public void setAlarmvalue(java.lang.String alarmvalue) {
        this.alarmvalue = alarmvalue;
    }

    public java.lang.Long getMaxstock() {
        return this.maxstock;
    }

    public void setMaxstock(java.lang.Long maxstock) {
        this.maxstock = maxstock;
    }

    public java.lang.String getLimitmode() {
        return this.limitmode;
    }

    public void setLimitmode(java.lang.String limitmode) {
        this.limitmode = limitmode;
    }
    
    public String getRestype() {
		return restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderuplimitlogVO) ) return false;
        OrderuplimitlogVO castOther = (OrderuplimitlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
