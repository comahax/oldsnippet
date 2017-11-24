package com.gmcc.pboss.business.resource.comtreeshow;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComtreeshowVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer cityid;

    /** identifier field */
    private Integer comclassid;

    /** identifier field */
    private Integer comtype;

    /** identifier field */
    private String wayid;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private Short state;

    /** full constructor */
    public ComtreeshowVO(java.lang.Integer cityid, java.lang.Integer comclassid, java.lang.Integer comtype, java.lang.String wayid, java.lang.String oprcode, java.lang.Short state) {
        this.cityid = cityid;
        this.comclassid = comclassid;
        this.comtype = comtype;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.state = state;
    }

    /** default constructor */
    public ComtreeshowVO() {
    }

    public java.lang.Integer getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Integer cityid) {
        this.cityid = cityid;
    }

    public java.lang.Integer getComclassid() {
        return this.comclassid;
    }

    public void setComclassid(java.lang.Integer comclassid) {
        this.comclassid = comclassid;
    }

    public java.lang.Integer getComtype() {
        return this.comtype;
    }

    public void setComtype(java.lang.Integer comtype) {
        this.comtype = comtype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("comclassid", getComclassid())
            .append("comtype", getComtype())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComtreeshowVO) ) return false;
        ComtreeshowVO castOther = (ComtreeshowVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getComclassid(), castOther.getComclassid())
            .append(this.getComtype(), castOther.getComtype())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getComclassid())
            .append(getComtype())
            .append(getWayid())
            .toHashCode();
    }

}
