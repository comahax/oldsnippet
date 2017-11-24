package com.sunrise.boss.business.fee.billing.rhtouchrule.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class RhTouchRuleVO extends BaseVO {

    /** identifier field */
    private Long ruleid;

    /** nullable persistent field */
    private java.util.Date settime;

    /** nullable persistent field */
    private Integer validbillcyc;

    /** nullable persistent field */
    private Short flstate;

    /** nullable persistent field */
    private Short flischeck;

    /** nullable persistent field */
    private java.util.Date flstime;

    /** nullable persistent field */
    private java.util.Date fletime;

    /** nullable persistent field */
    private Short lzstate;

    /** nullable persistent field */
    private Short lzischeck;

    /** nullable persistent field */
    private java.util.Date lzstime;

    /** nullable persistent field */
    private java.util.Date lzetime;

    /** nullable persistent field */
    private Short lzstate2;

    /** nullable persistent field */
    private Short lzischeck2;

    /** nullable persistent field */
    private java.util.Date lzstime2;

    /** nullable persistent field */
    private java.util.Date lzetime2;
    
    private Integer region;

    public Integer getRegion() {
    	return region;
    }

    public void setRegion(Integer region) {
    	this.region = region;
    }

    /** full constructor */
    public RhTouchRuleVO(java.lang.Long ruleid, java.util.Date settime, java.lang.Integer validbillcyc, java.lang.Short flstate, java.lang.Short flischeck, java.util.Date flstime, java.util.Date fletime, java.lang.Short lzstate, java.lang.Short lzischeck, java.util.Date lzstime, java.util.Date lzetime, java.lang.Short lzstate2, java.lang.Short lzischeck2, java.util.Date lzstime2, java.util.Date lzetime2) {
        this.ruleid = ruleid;
        this.settime = settime;
        this.validbillcyc = validbillcyc;
        this.flstate = flstate;
        this.flischeck = flischeck;
        this.flstime = flstime;
        this.fletime = fletime;
        this.lzstate = lzstate;
        this.lzischeck = lzischeck;
        this.lzstime = lzstime;
        this.lzetime = lzetime;
        this.lzstate2 = lzstate2;
        this.lzischeck2 = lzischeck2;
        this.lzstime2 = lzstime2;
        this.lzetime2 = lzetime2;
    }

    /** default constructor */
    public RhTouchRuleVO() {
    }

    /** minimal constructor */
    public RhTouchRuleVO(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.util.Date getSettime() {
        return this.settime;
    }

    public void setSettime(java.util.Date settime) {
        this.settime = settime;
    }

    public java.lang.Integer getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Integer validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Short getFlstate() {
        return this.flstate;
    }

    public void setFlstate(java.lang.Short flstate) {
        this.flstate = flstate;
    }

    public java.lang.Short getFlischeck() {
        return this.flischeck;
    }

    public void setFlischeck(java.lang.Short flischeck) {
        this.flischeck = flischeck;
    }

    public java.util.Date getFlstime() {
        return this.flstime;
    }

    public void setFlstime(java.util.Date flstime) {
        this.flstime = flstime;
    }

    public java.util.Date getFletime() {
        return this.fletime;
    }

    public void setFletime(java.util.Date fletime) {
        this.fletime = fletime;
    }

    public java.lang.Short getLzstate() {
        return this.lzstate;
    }

    public void setLzstate(java.lang.Short lzstate) {
        this.lzstate = lzstate;
    }

    public java.lang.Short getLzischeck() {
        return this.lzischeck;
    }

    public void setLzischeck(java.lang.Short lzischeck) {
        this.lzischeck = lzischeck;
    }

    public java.util.Date getLzstime() {
        return this.lzstime;
    }

    public void setLzstime(java.util.Date lzstime) {
        this.lzstime = lzstime;
    }

    public java.util.Date getLzetime() {
        return this.lzetime;
    }

    public void setLzetime(java.util.Date lzetime) {
        this.lzetime = lzetime;
    }

    public java.lang.Short getLzstate2() {
        return this.lzstate2;
    }

    public void setLzstate2(java.lang.Short lzstate2) {
        this.lzstate2 = lzstate2;
    }

    public java.lang.Short getLzischeck2() {
        return this.lzischeck2;
    }

    public void setLzischeck2(java.lang.Short lzischeck2) {
        this.lzischeck2 = lzischeck2;
    }

    public java.util.Date getLzstime2() {
        return this.lzstime2;
    }

    public void setLzstime2(java.util.Date lzstime2) {
        this.lzstime2 = lzstime2;
    }

    public java.util.Date getLzetime2() {
        return this.lzetime2;
    }

    public void setLzetime2(java.util.Date lzetime2) {
        this.lzetime2 = lzetime2;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RhTouchRuleVO) ) return false;
        RhTouchRuleVO castOther = (RhTouchRuleVO) other;
        return new EqualsBuilder()
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRuleid())
            .toHashCode();
    }

}
