package com.gmcc.pboss.business.sales.stockalarmlog;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class StockalarmlogVO extends BaseVO implements Serializable {

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
    private String wayid;

    /** nullable persistent field */
    private String brand;

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

    /** full constructor */
    public StockalarmlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String wayid, java.lang.String brand, java.lang.String alarmvalue, java.lang.Long maxstock, java.lang.String updatechannel, java.lang.Double stdvalue, java.lang.Double quotiety, java.lang.Double aveactnum, java.lang.String memo, java.util.Date chgtime) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.wayid = wayid;
        this.brand = brand;
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
    public StockalarmlogVO() {
    }

    /** minimal constructor */
    public StockalarmlogVO(java.lang.Long logid) {
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
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

	public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StockalarmlogVO) ) return false;
        StockalarmlogVO castOther = (StockalarmlogVO) other;
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
