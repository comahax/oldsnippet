package com.gmcc.pboss.business.sales.stockalarm;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class StockalarmVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String brand;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String alarmvalue;

    /** nullable persistent field */
    private Long maxstock;
    
    /** nullable persistent field */
    private String updatechannel;
    
    /** nullable persistent field */
    private Double stdvalue;

    /** nullable persistent field */
    private Double quotiety;

    /** nullable persistent field */
    private Double aveactnum;
    
    private String memo;
    
    private java.util.Date chgtime;
    
    private String extendAlarmValue;
	private String countyid;
	private Short starlevel;// ÐÇ¼¶
	private Short waystate;

    /** full constructor */
    public StockalarmVO(java.lang.String brand, java.lang.String wayid, java.lang.String alarmvalue, java.lang.Long maxstock, java.lang.String updatechannel, java.lang.Double stdvalue, java.lang.Double quotiety, java.lang.Double aveactnum, java.lang.String memo, java.util.Date chgtime) {
        this.brand = brand;
        this.wayid = wayid;
        this.alarmvalue = alarmvalue;
        this.maxstock = maxstock;
        this.updatechannel = updatechannel;
        this.stdvalue = stdvalue;
        this.quotiety = quotiety;
        this.aveactnum = aveactnum;
        this.memo = memo;
        this.chgtime = chgtime;
    }

    /** default constructor */
    public StockalarmVO() {
    }

    /** minimal constructor */
    public StockalarmVO(java.lang.String brand, java.lang.String wayid) {
        this.brand = brand;
        this.wayid = wayid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
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

    public String getUpdatechannel() {
		return updatechannel;
	}

	public void setUpdatechannel(String updatechannel) {
		this.updatechannel = updatechannel;
	}

	public Double getStdvalue() {
		return stdvalue;
	}

	public void setStdvalue(Double stdvalue) {
		this.stdvalue = stdvalue;
	}

	public Double getQuotiety() {
		return quotiety;
	}

	public void setQuotiety(Double quotiety) {
		this.quotiety = quotiety;
	}

	public Double getAveactnum() {
		return aveactnum;
	}

	public void setAveactnum(Double aveactnum) {
		this.aveactnum = aveactnum;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public java.util.Date getChgtime() {
		return chgtime;
	}

	public void setChgtime(java.util.Date chgtime) {
		this.chgtime = chgtime;
	}

	public String getExtendAlarmValue() {
		return extendAlarmValue;
	}

	public void setExtendAlarmValue(String extendAlarmValue) {
		this.extendAlarmValue = extendAlarmValue;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public Short getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Short starlevel) {
		this.starlevel = starlevel;
	}

	public Short getWaystate() {
		return waystate;
	}

	public void setWaystate(Short waystate) {
		this.waystate = waystate;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StockalarmVO) ) return false;
        StockalarmVO castOther = (StockalarmVO) other;
        return new EqualsBuilder()
            .append(this.getBrand(), castOther.getBrand())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrand())
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return StockalarmlogVO.class;
	}

}
