package com.sunrise.boss.business.cms.zjty.zjtycompact.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyCompactVO implements Serializable {

    /** identifier field */
    private Float conef;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date opertime;

    /** nullable persistent field */
    private String opercode;
    
    /** nullable persistent field */
    private Short cityid;
    
    /** nullable persistent field */
    private Integer fixednum;

    /** full constructor */
    public ZjtyCompactVO(java.lang.String wayid, java.lang.Float conef, java.util.Date opertime, java.lang.String opercode, java.lang.Short cityid, java.lang.Integer fixednum) {
    	this.wayid = wayid;
    	this.conef = conef;
        this.opertime = opertime;
        this.opercode = opercode;
        this.cityid = cityid;
        this.fixednum = fixednum;
    }

    /** default constructor */
    public ZjtyCompactVO() {
    }

    /** minimal constructor */
//    public ZjtyCompactVO(java.lang.Float conef, java.lang.String wayid) {
//        this.conef = conef;
//        this.wayid = wayid;
//    }
    
    public ZjtyCompactVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Float getConef() {
        return this.conef;
    }

    public void setConef(java.lang.Float conef) {
        this.conef = conef;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getOpertime() {
        return this.opertime;
    }

    public void setOpertime(java.util.Date opertime) {
        this.opertime = opertime;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }

    public Short getCityid() {
		return cityid;
	}

	public void setCityid(Short cityid) {
		this.cityid = cityid;
	}

	public Integer getFixednum() {
		return fixednum;
	}

	public void setFixednum(Integer fixednum) {
		this.fixednum = fixednum;
	}

	public String toString() {
        return new ToStringBuilder(this)
//            .append("conef", getConef())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyCompactVO) ) return false;
        ZjtyCompactVO castOther = (ZjtyCompactVO) other;
        return new EqualsBuilder()
//            .append(this.getConef(), castOther.getConef())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
//            .append(getConef())
            .append(getWayid())
            .toHashCode();
    }

}
