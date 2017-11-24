package com.sunrise.boss.business.cms.wayagentbch.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.agentbchlog.persistent.*;
import com.sunrise.boss.business.common.dblog.*;

/** @author Hibernate CodeGenerator */
public class WayagentbchVO implements OperationLog {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String bchtype;

    /** nullable persistent field */
    private String ownedby;

    /** persistent field */
    private String wayarea;

    /** nullable persistent field */
    private String areaattr;

    /** persistent field */
    private java.util.Date opentime;

    /** persistent field */
    private java.util.Date worktime;

    /** nullable persistent field */
    private String bussupply;

    /** persistent field */
    private Short busstate;

    /** persistent field */
    private Integer employcnt;

    /** nullable persistent field */
    private String bossoprcode;

    /** nullable persistent field */
    private Integer busarea;

    /** nullable persistent field */
    private Integer seatcnt;

    /** nullable persistent field */
    private String envmemo;

    /** nullable persistent field */
    private String bossarea;

    /** full constructor */
    public WayagentbchVO(java.lang.String wayid, java.lang.String bchtype, java.lang.String ownedby, java.lang.String wayarea, java.lang.String areaattr, java.util.Date opentime, java.util.Date worktime, java.lang.String bussupply, java.lang.Short busstate, java.lang.Integer employcnt, java.lang.String bossoprcode, java.lang.Integer busarea, java.lang.Integer seatcnt, java.lang.String envmemo, java.lang.String bossarea) {
        this.wayid = wayid;
        this.bchtype = bchtype;
        this.ownedby = ownedby;
        this.wayarea = wayarea;
        this.areaattr = areaattr;
        this.opentime = opentime;
        this.worktime = worktime;
        this.bussupply = bussupply;
        this.busstate = busstate;
        this.employcnt = employcnt;
        this.bossoprcode = bossoprcode;
        this.busarea = busarea;
        this.seatcnt = seatcnt;
        this.envmemo = envmemo;
        this.bossarea = bossarea;
    }

    /** default constructor */
    public WayagentbchVO() {
    }

    /** minimal constructor */
    public WayagentbchVO(java.lang.String wayid, java.lang.String wayarea, java.util.Date opentime, java.util.Date worktime, java.lang.Short busstate, java.lang.Integer employcnt) {
        this.wayid = wayid;
        this.wayarea = wayarea;
        this.opentime = opentime;
        this.worktime = worktime;
        this.busstate = busstate;
        this.employcnt = employcnt;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getBchtype() {
        return this.bchtype;
    }

    public void setBchtype(java.lang.String bchtype) {
        this.bchtype = bchtype;
    }

    public java.lang.String getOwnedby() {
        return this.ownedby;
    }

    public void setOwnedby(java.lang.String ownedby) {
        this.ownedby = ownedby;
    }

    public java.lang.String getWayarea() {
        return this.wayarea;
    }

    public void setWayarea(java.lang.String wayarea) {
        this.wayarea = wayarea;
    }

    public java.lang.String getAreaattr() {
        return this.areaattr;
    }

    public void setAreaattr(java.lang.String areaattr) {
        this.areaattr = areaattr;
    }

    public java.util.Date getOpentime() {
        return this.opentime;
    }

    public void setOpentime(java.util.Date opentime) {
        this.opentime = opentime;
    }

    public java.util.Date getWorktime() {
        return this.worktime;
    }

    public void setWorktime(java.util.Date worktime) {
        this.worktime = worktime;
    }

    public java.lang.String getBussupply() {
        return this.bussupply;
    }

    public void setBussupply(java.lang.String bussupply) {
        this.bussupply = bussupply;
    }

    public java.lang.Short getBusstate() {
        return this.busstate;
    }

    public void setBusstate(java.lang.Short busstate) {
        this.busstate = busstate;
    }

    public java.lang.Integer getEmploycnt() {
        return this.employcnt;
    }

    public void setEmploycnt(java.lang.Integer employcnt) {
        this.employcnt = employcnt;
    }

    public java.lang.String getBossoprcode() {
        return this.bossoprcode;
    }

    public void setBossoprcode(java.lang.String bossoprcode) {
        this.bossoprcode = bossoprcode;
    }

    public java.lang.Integer getBusarea() {
        return this.busarea;
    }

    public void setBusarea(java.lang.Integer busarea) {
        this.busarea = busarea;
    }

    public java.lang.Integer getSeatcnt() {
        return this.seatcnt;
    }

    public void setSeatcnt(java.lang.Integer seatcnt) {
        this.seatcnt = seatcnt;
    }

    public java.lang.String getEnvmemo() {
        return this.envmemo;
    }

    public void setEnvmemo(java.lang.String envmemo) {
        this.envmemo = envmemo;
    }

    public java.lang.String getBossarea() {
        return this.bossarea;
    }

    public void setBossarea(java.lang.String bossarea) {
        this.bossarea = bossarea;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayagentbchVO) ) return false;
        WayagentbchVO castOther = (WayagentbchVO) other;
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
    	return AgentbchlogVO.class;
    }

}
