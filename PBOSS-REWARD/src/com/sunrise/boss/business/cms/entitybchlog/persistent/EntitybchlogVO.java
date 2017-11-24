package com.sunrise.boss.business.cms.entitybchlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class EntitybchlogVO implements Serializable { 

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
    private Short constrtype;

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
    public EntitybchlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String wayid, java.lang.Short bchtype, java.lang.String ownedby, java.lang.String wayarea, java.lang.String areaattr, java.lang.Short constrtype, java.util.Date opentime, java.util.Date worktime, java.lang.String bussupply, java.lang.Short busstate, java.lang.Integer employcnt, java.lang.Short buytype, java.lang.Double byeprice, java.lang.String rentunit, java.lang.String rentperiod, java.lang.Double rent, java.lang.Double decinvest, java.lang.Double compactarea, java.lang.String envdescp, java.lang.String bossarea) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
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
    public EntitybchlogVO() {
    }

    /** minimal constructor */
    public EntitybchlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.lang.Short getConstrtype() {
        return this.constrtype;
    }

    public void setConstrtype(java.lang.Short constrtype) {
        this.constrtype = constrtype;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EntitybchlogVO) ) return false;
        EntitybchlogVO castOther = (EntitybchlogVO) other;
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
