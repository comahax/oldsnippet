package com.gmcc.pboss.business.sales.realtimeamt;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RealtimeamtVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** persistent field */
    private String brand;

    /** nullable persistent field */
    private Long monordered;

    /** nullable persistent field */
    private Long dayordered;

    /** nullable persistent field */
    private Long nowstock;

    /** nullable persistent field */
    private java.util.Date uptime;

    /** full constructor */
    public RealtimeamtVO(java.lang.String brand, java.lang.Long monordered, java.lang.Long dayordered, java.lang.Long nowstock, java.util.Date uptime) {
        this.brand = brand;
        this.monordered = monordered;
        this.dayordered = dayordered;
        this.nowstock = nowstock;
        this.uptime = uptime;
    }

    /** default constructor */
    public RealtimeamtVO() {
    }

    /** minimal constructor */
    public RealtimeamtVO(java.lang.String brand) {
        this.brand = brand;
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

    public java.lang.Long getMonordered() {
        return this.monordered;
    }

    public void setMonordered(java.lang.Long monordered) {
        this.monordered = monordered;
    }

    public java.lang.Long getDayordered() {
        return this.dayordered;
    }

    public void setDayordered(java.lang.Long dayordered) {
        this.dayordered = dayordered;
    }

    public java.lang.Long getNowstock() {
        return this.nowstock;
    }

    public void setNowstock(java.lang.Long nowstock) {
        this.nowstock = nowstock;
    }

    public java.util.Date getUptime() {
        return this.uptime;
    }

    public void setUptime(java.util.Date uptime) {
        this.uptime = uptime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RealtimeamtVO) ) return false;
        RealtimeamtVO castOther = (RealtimeamtVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

}
