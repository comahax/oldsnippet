package com.gmcc.pboss.business.sales.vstockalarm;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VstockalarmVO extends BaseVO implements Serializable {

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

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private java.util.Date chgtime;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private Short waystate;

    /** full constructor */
    public VstockalarmVO(java.lang.String brand, java.lang.String wayid, java.lang.String alarmvalue, java.lang.Long maxstock, java.lang.String updatechannel, java.lang.Double stdvalue, java.lang.Double quotiety, java.lang.Double aveactnum, java.lang.String memo, java.util.Date chgtime, java.lang.String countyid, java.lang.Short starlevel, java.lang.Short waystate) {
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
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.waystate = waystate;
    }

    /** default constructor */
    public VstockalarmVO() {
    }

    /** minimal constructor */
    public VstockalarmVO(java.lang.String brand, java.lang.String wayid) {
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

    public java.lang.String getUpdatechannel() {
        return this.updatechannel;
    }

    public void setUpdatechannel(java.lang.String updatechannel) {
        this.updatechannel = updatechannel;
    }

    public java.lang.Double getStdvalue() {
        return this.stdvalue;
    }

    public void setStdvalue(java.lang.Double stdvalue) {
        this.stdvalue = stdvalue;
    }

    public java.lang.Double getQuotiety() {
        return this.quotiety;
    }

    public void setQuotiety(java.lang.Double quotiety) {
        this.quotiety = quotiety;
    }

    public java.lang.Double getAveactnum() {
        return this.aveactnum;
    }

    public void setAveactnum(java.lang.Double aveactnum) {
        this.aveactnum = aveactnum;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.util.Date getChgtime() {
        return this.chgtime;
    }

    public void setChgtime(java.util.Date chgtime) {
        this.chgtime = chgtime;
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

    public java.lang.Short getWaystate() {
        return this.waystate;
    }

    public void setWaystate(java.lang.Short waystate) {
        this.waystate = waystate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VstockalarmVO) ) return false;
        VstockalarmVO castOther = (VstockalarmVO) other;
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

}
