package com.gmcc.pboss.business.sales.vrealtimeamt;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VrealtimeamtVO extends BaseVO implements Serializable {



    /** identifier field */
    private String wayid;
    
    /** identifier field */
    private String comcategory;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private Long monordered;

    /** nullable persistent field */
    private Long dayordered;

    /** nullable persistent field */
    private Long nowstock;

    /** nullable persistent field */
    private java.util.Date uptime;

    private String wayname;
    
    private Long orderdstock; 
    
    private String restype;
    
    private String brand;
    
    private Long total;
    
    /** full constructor */
    public VrealtimeamtVO(java.lang.String brand,java.lang.Long orderdstock, java.lang.String wayid,java.lang.String  wayname, java.lang.String countyid, java.lang.String svccode, java.lang.String mareacode, java.lang.Short starlevel, java.lang.Long monordered, java.lang.Long dayordered, java.lang.Long nowstock, java.util.Date uptime,java.lang.String restype,java.lang.String comcategory,java.lang.Long total) {
        this.brand = brand;
        this.wayid = wayid;
        this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.starlevel = starlevel;
        this.monordered = monordered;
        this.dayordered = dayordered;
        this.nowstock = nowstock;
        this.uptime = uptime;
        this.wayname=wayname;
        this.orderdstock=orderdstock;
        this.restype=restype;
        this.comcategory=comcategory;
        this.total=total;
    }

    /** default constructor */
    public VrealtimeamtVO() {
    }

    /** minimal constructor */
    public VrealtimeamtVO( java.lang.String wayid,java.lang.String comcategory) {
        this.wayid = wayid;
        this.comcategory=comcategory;
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

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
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
            .append("comcategory",getComcategory())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VrealtimeamtVO) ) return false;
        VrealtimeamtVO castOther = (VrealtimeamtVO) other;
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

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Long getOrderdstock() {
		return orderdstock;
	}

	public void setOrderdstock(Long orderdstock) {
		this.orderdstock = orderdstock;
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

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
