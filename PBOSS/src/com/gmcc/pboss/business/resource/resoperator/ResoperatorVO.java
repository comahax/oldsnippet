package com.gmcc.pboss.business.resource.resoperator;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResoperatorVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String operid;
    
    private String wayname;

    /** full constructor */
    public ResoperatorVO(java.lang.String cityid, java.lang.String operid) {
        this.cityid = cityid;
        this.operid = operid;
    }

    /** default constructor */
    public ResoperatorVO() {
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResoperatorVO) ) return false;
        ResoperatorVO castOther = (ResoperatorVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

}
