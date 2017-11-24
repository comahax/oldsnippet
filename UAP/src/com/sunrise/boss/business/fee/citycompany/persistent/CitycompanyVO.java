package com.sunrise.boss.business.fee.citycompany.persistent;

import org.apache.commons.lang.builder.*;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.ManageLog;

/** @author Hibernate CodeGenerator */
public class CitycompanyVO extends BaseVO implements ManageLog {

    /** identifier field */
    private String citycompid;

    /** nullable persistent field */
    private String centerid;

    /** nullable persistent field */
    private String citycompname;

    /** nullable persistent field */
    private Short citycomptype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;
    
    private String areacode;
    
    /** nullable persistent field */
    private String adacode;

    /** nullable persistent field */
    private String longitude;

    /** nullable persistent field */
    private String latitude;

    /** full constructor */
    public CitycompanyVO(java.lang.String citycompid, java.lang.String centerid, java.lang.String citycompname, java.lang.Short citycomptype, java.lang.String agent, java.lang.String billingcode, java.lang.String adacode, java.lang.String longitude, java.lang.String latitude) {
        this.citycompid = citycompid;
        this.centerid = centerid;
        this.citycompname = citycompname;
        this.citycomptype = citycomptype;
        this.agent = agent;
        this.billingcode = billingcode;
        this.adacode = adacode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /** default constructor */
    public CitycompanyVO() {
    }

    /** minimal constructor */
    public CitycompanyVO(java.lang.String citycompid) {
        this.citycompid = citycompid;
    }

    public java.lang.String getCitycompid() {
        return this.citycompid;
    }

    public void setCitycompid(java.lang.String citycompid) {
        this.citycompid = citycompid;
    }

    public java.lang.String getCenterid() {
        return this.centerid;
    }

    public void setCenterid(java.lang.String centerid) {
        this.centerid = centerid;
    }

    public java.lang.String getCitycompname() {
        return this.citycompname;
    }

    public void setCitycompname(java.lang.String citycompname) {
        this.citycompname = citycompname;
    }

    public java.lang.Short getCitycomptype() {
        return this.citycomptype;
    }

    public void setCitycomptype(java.lang.Short citycomptype) {
        this.citycomptype = citycomptype;
    }

    public java.lang.String getAgent() {
        return this.agent;
    }

    public void setAgent(java.lang.String agent) {
        this.agent = agent;
    }

    public java.lang.String getBillingcode() {
        return this.billingcode;
    }

    public void setBillingcode(java.lang.String billingcode) {
        this.billingcode = billingcode;
    }

    public String getAdacode() {
		return adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("citycompid", getCitycompid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CitycompanyVO) ) return false;
        CitycompanyVO castOther = (CitycompanyVO) other;
        return new EqualsBuilder()
            .append(this.getCitycompid(), castOther.getCitycompid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCitycompid())
            .toHashCode();
    }
    
	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

}
