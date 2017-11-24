package com.sunrise.boss.business.cms.wayhzwg.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayhzwgVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** identifier field */
    private String wgmonth;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private String remark;
    
    private String calcmonth;

    /** full constructor */
    public WayhzwgVO(java.lang.String wayid, java.lang.String wgmonth, java.lang.Short state, java.lang.String remark, java.lang.String calcmonth) {
        this.wayid = wayid;
        this.wgmonth = wgmonth;
        this.state = state;
        this.remark = remark;
        this.calcmonth = calcmonth;
    }

    /** default constructor */
    public WayhzwgVO() {
    }

    /** minimal constructor */
    public WayhzwgVO(java.lang.String wayid, java.lang.String wgmonth) {
        this.wayid = wayid;
        this.wgmonth = wgmonth;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWgmonth() {
        return this.wgmonth;
    }

    public void setWgmonth(java.lang.String wgmonth) {
        this.wgmonth = wgmonth;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .append("wgmonth", getWgmonth())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayhzwgVO) ) return false;
        WayhzwgVO castOther = (WayhzwgVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getWgmonth(), castOther.getWgmonth())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .append(getWgmonth())
            .toHashCode();
    }

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

}
