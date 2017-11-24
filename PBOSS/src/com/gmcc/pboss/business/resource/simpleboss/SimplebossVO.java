package com.gmcc.pboss.business.resource.simpleboss;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SimplebossVO extends BaseVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String wayid;

    /** persistent field */
    private Short state;

    /** nullable persistent field */
    private String oprcode;

    /** full constructor */
    public SimplebossVO(java.lang.String cityid, java.lang.String wayid, java.lang.Short state, java.lang.String oprcode) {
        this.cityid = cityid;
        this.wayid = wayid;
        this.state = state;
        this.oprcode = oprcode;
    }

    /** default constructor */
    public SimplebossVO() {
    }

    /** minimal constructor */
    public SimplebossVO(java.lang.String cityid, java.lang.String wayid, java.lang.Short state) {
        this.cityid = cityid;
        this.wayid = wayid;
        this.state = state;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SimplebossVO) ) return false;
        SimplebossVO castOther = (SimplebossVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getWayid())
            .toHashCode();
    }

}
