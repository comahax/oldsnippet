package com.sunrise.boss.business.fee.billing.rhruledeta.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class RhRuleDetaVO extends BaseVO {

    /** identifier field */
    private Long ruleid;

    /** nullable persistent field */
    private Integer validbillcyc;

    /** nullable persistent field */
    private Integer day;

    /** nullable persistent field */
    private Short rhphase;

    /** nullable persistent field */
    private Short type;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private String memo;

    private Integer region;

    public Integer getRegion() {
    	return region;
    }

    public void setRegion(Integer region) {
    	this.region = region;
    }


    /** full constructor */
    public RhRuleDetaVO(java.lang.Long ruleid, java.lang.Integer validbillcyc, java.lang.Integer day, java.lang.Short rhphase, java.lang.Short type, java.lang.Short state, java.lang.String memo) {
        this.ruleid = ruleid;
        this.validbillcyc = validbillcyc;
        this.day = day;
        this.rhphase = rhphase;
        this.type = type;
        this.state = state;
        this.memo = memo;
    }

    /** default constructor */
    public RhRuleDetaVO() {
    }

    /** minimal constructor */
    public RhRuleDetaVO(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Integer getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Integer validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Integer getDay() {
        return this.day;
    }

    public void setDay(java.lang.Integer day) {
        this.day = day;
    }

    public java.lang.Short getRhphase() {
        return this.rhphase;
    }

    public void setRhphase(java.lang.Short rhphase) {
        this.rhphase = rhphase;
    }

    public java.lang.Short getType() {
        return this.type;
    }

    public void setType(java.lang.Short type) {
        this.type = type;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RhRuleDetaVO) ) return false;
        RhRuleDetaVO castOther = (RhRuleDetaVO) other;
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
