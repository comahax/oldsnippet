package com.gmcc.pboss.business.resource.actalarmstat;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ActalarmstatVO extends BaseVO implements Serializable {

    /** identifier field */
    private String brand;

    /** identifier field */
    private String stattype;

    /** identifier field */
    private String wayid;

    /** identifier field */
    private String yearmonth;

    /** nullable persistent field */
    private Long lhamount;

    /** nullable persistent field */
    private Long jhamount;

    /** nullable persistent field */
    private Double rate;
    
    private Integer id;
    
    private String countyid;
    
    private String mareacode;

    /** full constructor */
    public ActalarmstatVO(java.lang.String brand, java.lang.String stattype, java.lang.String wayid, java.lang.String yearmonth, java.lang.Long lhamount, java.lang.Long jhamount, java.lang.Double rate) {
        this.brand = brand;
        this.stattype = stattype;
        this.wayid = wayid;
        this.yearmonth = yearmonth;
        this.lhamount = lhamount;
        this.jhamount = jhamount;
        this.rate = rate;
    }

    /** default constructor */
    public ActalarmstatVO() {
    }

    /** minimal constructor */
    public ActalarmstatVO(java.lang.String brand, java.lang.String stattype, java.lang.String wayid, java.lang.String yearmonth) {
        this.brand = brand;
        this.stattype = stattype;
        this.wayid = wayid;
        this.yearmonth = yearmonth;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getStattype() {
        return this.stattype;
    }

    public void setStattype(java.lang.String stattype) {
        this.stattype = stattype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getYearmonth() {
        return this.yearmonth;
    }

    public void setYearmonth(java.lang.String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public java.lang.Long getLhamount() {
        return this.lhamount;
    }

    public void setLhamount(java.lang.Long lhamount) {
        this.lhamount = lhamount;
    }

    public java.lang.Long getJhamount() {
        return this.jhamount;
    }

    public void setJhamount(java.lang.Long jhamount) {
        this.jhamount = jhamount;
    }

    public java.lang.Double getRate() {
        return this.rate;
    }

    public void setRate(java.lang.Double rate) {
        this.rate = rate;
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .append("stattype", getStattype())
            .append("wayid", getWayid())
            .append("yearmonth", getYearmonth())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ActalarmstatVO) ) return false;
        ActalarmstatVO castOther = (ActalarmstatVO) other;
        return new EqualsBuilder()
            .append(this.getBrand(), castOther.getBrand())
            .append(this.getStattype(), castOther.getStattype())
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getYearmonth(), castOther.getYearmonth())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrand())
            .append(getStattype())
            .append(getWayid())
            .append(getYearmonth())
            .toHashCode();
    }

}
