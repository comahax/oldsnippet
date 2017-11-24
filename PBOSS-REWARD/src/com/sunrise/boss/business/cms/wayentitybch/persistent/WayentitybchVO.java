package com.sunrise.boss.business.cms.wayentitybch.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.entitybchlog.persistent.*;
import com.sunrise.boss.business.common.dblog.*;

/** @author Hibernate CodeGenerator */
public class WayentitybchVO implements OperationLog {

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

    /** nullable persistent field */
    private Short constrtype;

    /** persistent field */
    private java.sql.Date opentime;

    /** persistent field */
    private java.sql.Date worktime;

    /** nullable persistent field */
    private String bussupply;

    /** persistent field */
    private Short busstate;

    /** persistent field */
    private Integer employcnt;

    /** nullable persistent field */
    private Short buytype;

    /** nullable persistent field */
    private Double byeprice;

    /** nullable persistent field */
    private String rentunit;

    /** nullable persistent field */
    private String rentperiod;

    /** nullable persistent field */
    private Double rent;

    /** nullable persistent field */
    private Double decinvest;

    /** nullable persistent field */
    private Double compactarea;

    /** nullable persistent field */
    private String envdescp;

    /** nullable persistent field */
    private String bossarea;

    /** full constructor */
    public WayentitybchVO(java.lang.String wayid, java.lang.String bchtype, java.lang.String ownedby, java.lang.String wayarea, java.lang.String areaattr, java.lang.Short constrtype, java.sql.Date opentime, java.sql.Date worktime, java.lang.String bussupply, java.lang.Short busstate, java.lang.Integer employcnt, java.lang.Short buytype, java.lang.Double byeprice, java.lang.String rentunit, java.lang.String rentperiod, java.lang.Double rent, java.lang.Double decinvest, java.lang.Double compactarea, java.lang.String envdescp, java.lang.String bossarea) {
        this.wayid = wayid;
        this.bchtype = bchtype;
        this.ownedby = ownedby;
        this.wayarea = wayarea;
        this.areaattr = areaattr;
        this.constrtype = constrtype;
        this.opentime = opentime;
        this.worktime = worktime;
        this.bussupply = bussupply;
        this.busstate = busstate;
        this.employcnt = employcnt;
        this.buytype = buytype;
        this.byeprice = byeprice;
        this.rentunit = rentunit;
        this.rentperiod = rentperiod;
        this.rent = rent;
        this.decinvest = decinvest;
        this.compactarea = compactarea;
        this.envdescp = envdescp;
        this.bossarea = bossarea;
    }

    /** default constructor */
    public WayentitybchVO() {
    }

    /** minimal constructor */
    public WayentitybchVO(java.lang.String wayid, java.lang.String wayarea, java.sql.Date opentime, java.sql.Date worktime, java.lang.Short busstate, java.lang.Integer employcnt) {
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

    public java.lang.Short getConstrtype() {
        return this.constrtype;
    }

    public void setConstrtype(java.lang.Short constrtype) {
        this.constrtype = constrtype;
    }

    public java.sql.Date getOpentime() {
        return this.opentime;
    }

    public void setOpentime(java.sql.Date opentime) {
        this.opentime = opentime;
    }

    public java.sql.Date getWorktime() {
        return this.worktime;
    }

    public void setWorktime(java.sql.Date worktime) {
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

    public java.lang.Short getBuytype() {
        return this.buytype;
    }

    public void setBuytype(java.lang.Short buytype) {
        this.buytype = buytype;
    }

    public java.lang.Double getByeprice() {
        return this.byeprice;
    }

    public void setByeprice(java.lang.Double byeprice) {
        this.byeprice = byeprice;
    }

    public java.lang.String getRentunit() {
        return this.rentunit;
    }

    public void setRentunit(java.lang.String rentunit) {
        this.rentunit = rentunit;
    }

    public java.lang.String getRentperiod() {
        return this.rentperiod;
    }

    public void setRentperiod(java.lang.String rentperiod) {
        this.rentperiod = rentperiod;
    }

    public java.lang.Double getRent() {
        return this.rent;
    }

    public void setRent(java.lang.Double rent) {
        this.rent = rent;
    }

    public java.lang.Double getDecinvest() {
        return this.decinvest;
    }

    public void setDecinvest(java.lang.Double decinvest) {
        this.decinvest = decinvest;
    }

    public java.lang.Double getCompactarea() {
        return this.compactarea;
    }

    public void setCompactarea(java.lang.Double compactarea) {
        this.compactarea = compactarea;
    }

    public java.lang.String getEnvdescp() {
        return this.envdescp;
    }

    public void setEnvdescp(java.lang.String envdescp) {
        this.envdescp = envdescp;
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
        if ( !(other instanceof WayentitybchVO) ) return false;
        WayentitybchVO castOther = (WayentitybchVO) other;
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
    	return EntitybchlogVO.class;
    }
}
