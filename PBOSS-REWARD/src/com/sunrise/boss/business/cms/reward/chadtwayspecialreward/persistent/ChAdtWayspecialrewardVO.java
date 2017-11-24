package com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtWayspecialrewardVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** persistent field */
    private String wayspetype;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** full constructor */
    public ChAdtWayspecialrewardVO(java.lang.String wayid, java.lang.String wayspetype, java.lang.String cityid, java.util.Date createdate) {
        this.wayid = wayid;
        this.wayspetype = wayspetype;
        this.cityid = cityid;
        this.createdate = createdate;
    }

    /** default constructor */
    public ChAdtWayspecialrewardVO() {
    }

    /** minimal constructor */
    public ChAdtWayspecialrewardVO(java.lang.String wayid, java.lang.String wayspetype, java.lang.String cityid) {
        this.wayid = wayid;
        this.wayspetype = wayspetype;
        this.cityid = cityid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayspetype() {
        return this.wayspetype;
    }

    public void setWayspetype(java.lang.String wayspetype) {
        this.wayspetype = wayspetype;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtWayspecialrewardVO) ) return false;
        ChAdtWayspecialrewardVO castOther = (ChAdtWayspecialrewardVO) other;
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
