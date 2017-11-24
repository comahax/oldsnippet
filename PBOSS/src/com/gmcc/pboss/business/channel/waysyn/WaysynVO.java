package com.gmcc.pboss.business.channel.waysyn;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class WaysynVO extends BaseVO  {

    /** identifier field */
    private Long itemid;

    /** nullable persistent field */
    private Short opract;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String upperwayid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String waytype;

    /** nullable persistent field */
    private Short waystate;

    /** full constructor */
    public WaysynVO(java.lang.Long itemid, java.lang.Short opract, java.lang.String oprcode, java.lang.String oprtype, java.util.Date oprtime, java.lang.String wayid, java.lang.String wayname, java.lang.String upperwayid, java.lang.String cityid, java.lang.String waytype, java.lang.Short waystate) {
        this.itemid = itemid;
        this.opract = opract;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.oprtime = oprtime;
        this.wayid = wayid;
        this.wayname = wayname;
        this.upperwayid = upperwayid;
        this.cityid = cityid;
        this.waytype = waytype;
        this.waystate = waystate;
    }

    /** default constructor */
    public WaysynVO() {
    }

    /** minimal constructor */
    public WaysynVO(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.Short getOpract() {
        return this.opract;
    }

    public void setOpract(java.lang.Short opract) {
        this.opract = opract;
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

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getUpperwayid() {
        return this.upperwayid;
    }

    public void setUpperwayid(java.lang.String upperwayid) {
        this.upperwayid = upperwayid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWaytype() {
        return this.waytype;
    }

    public void setWaytype(java.lang.String waytype) {
        this.waytype = waytype;
    }

    public java.lang.Short getWaystate() {
        return this.waystate;
    }

    public void setWaystate(java.lang.Short waystate) {
        this.waystate = waystate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaysynVO) ) return false;
        WaysynVO castOther = (WaysynVO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .toHashCode();
    }

//	public Class logVOClass() {
//		return WaysynlogVO.class;
//	}

}
