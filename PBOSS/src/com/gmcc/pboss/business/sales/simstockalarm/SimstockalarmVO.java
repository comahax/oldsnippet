package com.gmcc.pboss.business.sales.simstockalarm;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class SimstockalarmVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String wayid;

    private String comcategory;

    /** nullable persistent field */
    private String alarmvalue;

    /** nullable persistent field */
    private Long maxstock;
    
    private String countyid;
	private Short starlevel;
	private Short waystate;
	private String extendAlarmValue;
	
    /** full constructor */
    public SimstockalarmVO(java.lang.String alarmvalue, java.lang.Long maxstock) {
        this.alarmvalue = alarmvalue;
        this.maxstock = maxstock;
    }

    /** default constructor */
    public SimstockalarmVO() {
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
	public String getExtendAlarmValue() {
		return extendAlarmValue;
	}
	public void setExtendAlarmValue(String extendAlarmValue) {
		this.extendAlarmValue = extendAlarmValue;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .append("comcategory", getComcategory())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SimstockalarmVO) ) return false;
        SimstockalarmVO castOther = (SimstockalarmVO) other;
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
    
    public Class logVOClass() {
		// TODO Auto-generated method stub
		return SimstockalarmlogVO.class;
	}

	public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

}
