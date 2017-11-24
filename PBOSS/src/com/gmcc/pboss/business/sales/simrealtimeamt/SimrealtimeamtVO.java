package com.gmcc.pboss.business.sales.simrealtimeamt;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SimrealtimeamtVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;
    
    private String comcategory;

	/** nullable persistent field */
    private Long monordered;

    /** nullable persistent field */
    private Long dayordered;

    /** nullable persistent field */
    private Long nowstock;

    /** nullable persistent field */
    private java.util.Date uptime;

    /** full constructor */
    public SimrealtimeamtVO(java.lang.String wayid, java.lang.String comcategory, java.lang.Long monordered, java.lang.Long dayordered, java.lang.Long nowstock, java.util.Date uptime) {
        this.wayid = wayid;
        this.comcategory = comcategory;
        this.monordered = monordered;
        this.dayordered = dayordered;
        this.nowstock = nowstock;
        this.uptime = uptime;
    }

    /** default constructor */
    public SimrealtimeamtVO() {
    }

    /** minimal constructor */
    public SimrealtimeamtVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
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

    public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .append("comcategory", getComcategory())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SimrealtimeamtVO) ) return false;
        SimrealtimeamtVO castOther = (SimrealtimeamtVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getComcategory(), castOther.getComcategory())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .append(getComcategory())
            .toHashCode();
    }

}
