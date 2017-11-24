package com.gmcc.pboss.business.sales.orderuplimit;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class OrderuplimitVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long recid;

    /** persistent field */
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
    
    private String alarmvalue;
    
    private Long maxstock;
    
    private String limitmode;
    
    private String restype;
    
    private String comcategory;
    
    private String extendAlarmValue;
    
    private Long oncelimit;
    

    public Long getOncelimit() {
		return oncelimit;
	}

	public void setOncelimit(Long oncelimit) {
		this.oncelimit = oncelimit;
	}

	/** full constructor */
    public OrderuplimitVO(java.lang.String cityid, java.lang.String countyid, java.lang.String cooptype, java.lang.Short starlevel, java.lang.String brand, java.lang.Long monlimit, java.lang.Long daylimit, java.lang.Long stdstock, java.lang.String maxamtmode,String alarmvalue,Long maxstock,String limitmode,String restype,String comcategory,Long oncelimit) {
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
        this.oncelimit=oncelimit;
    }

    /** default constructor */
    public OrderuplimitVO() {
    }

    /** minimal constructor */
    public OrderuplimitVO(java.lang.String cityid) {
        this.cityid = cityid;
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

    public String getAlarmvalue() {
		return alarmvalue;
	}

	public void setAlarmvalue(String alarmvalue) {
		this.alarmvalue = alarmvalue;
	}

	public Long getMaxstock() {
		return maxstock;
	}

	public void setMaxstock(Long maxstock) {
		this.maxstock = maxstock;
	}

	public String getLimitmode() {
		return limitmode;
	}

	public void setLimitmode(String limitmode) {
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
	
	public String getExtendAlarmValue() {
		return extendAlarmValue;
	}
	
	public void setExtendAlarmValue(String extendAlarmValue) {
		this.extendAlarmValue = extendAlarmValue;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderuplimitVO) ) return false;
        OrderuplimitVO castOther = (OrderuplimitVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return OrderuplimitlogVO.class;
	}

}
