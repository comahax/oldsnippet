package com.gmcc.pboss.business.sales.vsimstockalarm;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VsimstockalarmVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;

    private String comcategory;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private Short waystate;

    /** nullable persistent field */
    private Long maxstock;

    /** nullable persistent field */
    private String alarmvalue;

    /** full constructor */
    public VsimstockalarmVO(java.lang.String wayid, java.lang.String comcategory, java.lang.String countyid, java.lang.Short starlevel, java.lang.Short waystate, java.lang.Long maxstock, java.lang.String alarmvalue) {
        this.wayid = wayid;
        this.comcategory = comcategory;
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.waystate = waystate;
        this.maxstock = maxstock;
        this.alarmvalue = alarmvalue;
    }

    /** default constructor */
    public VsimstockalarmVO() {
    }

    /** minimal constructor */
    public VsimstockalarmVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
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

    public java.lang.Long getMaxstock() {
        return this.maxstock;
    }

    public void setMaxstock(java.lang.Long maxstock) {
        this.maxstock = maxstock;
    }

    public java.lang.String getAlarmvalue() {
        return this.alarmvalue;
    }

    public void setAlarmvalue(java.lang.String alarmvalue) {
        this.alarmvalue = alarmvalue;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .append("comcategory", getComcategory())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VsimstockalarmVO) ) return false;
        VsimstockalarmVO castOther = (VsimstockalarmVO) other;
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

	public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

}
