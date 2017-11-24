package com.sunrise.boss.business.cms.chadtwaymod.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChAdtWaymodVO implements OperationLog {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Float vi;

    /** nullable persistent field */
    private Float area;

    /** nullable persistent field */
    private Float doorhead;

    /** nullable persistent field */
    private Float backboard;

    /** nullable persistent field */
    private Float propaganda;

    /** full constructor */
    public ChAdtWaymodVO(java.lang.String wayid, java.lang.Short cityid, java.lang.Float vi, java.lang.Float area, java.lang.Float doorhead, java.lang.Float backboard, java.lang.Float propaganda) {
        this.wayid = wayid;
        this.cityid = cityid;
        this.vi = vi;
        this.area = area;
        this.doorhead = doorhead;
        this.backboard = backboard;
        this.propaganda = propaganda;
    }

    /** default constructor */
    public ChAdtWaymodVO() {
    }

    /** minimal constructor */
    public ChAdtWaymodVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Float getVi() {
        return this.vi;
    }

    public void setVi(java.lang.Float vi) {
        this.vi = vi;
    }

    public java.lang.Float getArea() {
        return this.area;
    }

    public void setArea(java.lang.Float area) {
        this.area = area;
    }

    public java.lang.Float getDoorhead() {
        return this.doorhead;
    }

    public void setDoorhead(java.lang.Float doorhead) {
        this.doorhead = doorhead;
    }

    public java.lang.Float getBackboard() {
        return this.backboard;
    }

    public void setBackboard(java.lang.Float backboard) {
        this.backboard = backboard;
    }

    public java.lang.Float getPropaganda() {
        return this.propaganda;
    }

    public void setPropaganda(java.lang.Float propaganda) {
        this.propaganda = propaganda;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtWaymodVO) ) return false;
        ChAdtWaymodVO castOther = (ChAdtWaymodVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		return ChAdtWaymodlogVO.class;
	}

}
