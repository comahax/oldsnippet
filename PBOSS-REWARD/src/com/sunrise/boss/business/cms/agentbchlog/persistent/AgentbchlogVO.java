package com.sunrise.boss.business.cms.agentbchlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AgentbchlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short bchtype;

    /** nullable persistent field */
    private String ownedby;

    /** nullable persistent field */
    private String wayarea;

    /** nullable persistent field */
    private String areaattr;

    /** nullable persistent field */
    private java.util.Date opentime;

    /** nullable persistent field */
    private java.util.Date worktime;

    /** nullable persistent field */
    private String bussupply;

    /** nullable persistent field */
    private Short busstate;

    /** nullable persistent field */
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
    public AgentbchlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String wayid, java.lang.Short bchtype, java.lang.String ownedby, java.lang.String wayarea, java.lang.String areaattr, java.util.Date opentime, java.util.Date worktime, java.lang.String bussupply, java.lang.Short busstate, java.lang.Integer employcnt, java.lang.String bossoprcode, java.lang.Integer busarea, java.lang.Integer seatcnt, java.lang.String envmemo, java.lang.String bossarea) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
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
    public AgentbchlogVO() {
    }

    /** minimal constructor */
    public AgentbchlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
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

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getBchtype() {
        return this.bchtype;
    }

    public void setBchtype(java.lang.Short bchtype) {
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AgentbchlogVO) ) return false;
        AgentbchlogVO castOther = (AgentbchlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
