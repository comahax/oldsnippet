package com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.provagent.chpdrewardrulelog.persistent.ChPdRewardrulelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChPdRewardruleVO implements OperationLog, Serializable {

    /** identifier field */
    private Long ruleid;

    /** nullable persistent field */
    private Byte coopertype;

    /** nullable persistent field */
    private Float cooperrate;

    /** nullable persistent field */
    private String subcategory;

    /** nullable persistent field */
    private Short phase1;

    /** nullable persistent field */
    private Float phase1rate;

    /** nullable persistent field */
    private Short phase2;

    /** nullable persistent field */
    private Float phase2rate;

    /** nullable persistent field */
    private Float phase3rate;

    /** nullable persistent field */
    private java.util.Date inusetime;

    /** nullable persistent field */
    private java.util.Date outusetime;

    /** nullable persistent field */
    private Float version;

    /** full constructor */
    public ChPdRewardruleVO(java.lang.Long ruleid, java.lang.Byte coopertype, java.lang.Float cooperrate, java.lang.String subcategory, java.lang.Short phase1, java.lang.Float phase1rate, java.lang.Short phase2, java.lang.Float phase2rate, java.lang.Float phase3rate, java.util.Date inusetime, java.util.Date outusetime, java.lang.Float version) {
        this.ruleid = ruleid;
        this.coopertype = coopertype;
        this.cooperrate = cooperrate;
        this.subcategory = subcategory;
        this.phase1 = phase1;
        this.phase1rate = phase1rate;
        this.phase2 = phase2;
        this.phase2rate = phase2rate;
        this.phase3rate = phase3rate;
        this.inusetime = inusetime;
        this.outusetime = outusetime;
        this.version = version;
    }

    /** default constructor */
    public ChPdRewardruleVO() {
    }

    /** minimal constructor */
    public ChPdRewardruleVO(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Byte getCoopertype() {
        return this.coopertype;
    }

    public void setCoopertype(java.lang.Byte coopertype) {
        this.coopertype = coopertype;
    }

    public java.lang.Float getCooperrate() {
        return this.cooperrate;
    }

    public void setCooperrate(java.lang.Float cooperrate) {
        this.cooperrate = cooperrate;
    }

    public java.lang.String getSubcategory() {
        return this.subcategory;
    }

    public void setSubcategory(java.lang.String subcategory) {
        this.subcategory = subcategory;
    }

    public java.lang.Short getPhase1() {
        return this.phase1;
    }

    public void setPhase1(java.lang.Short phase1) {
        this.phase1 = phase1;
    }

    public java.lang.Float getPhase1rate() {
        return this.phase1rate;
    }

    public void setPhase1rate(java.lang.Float phase1rate) {
        this.phase1rate = phase1rate;
    }

    public java.lang.Short getPhase2() {
        return this.phase2;
    }

    public void setPhase2(java.lang.Short phase2) {
        this.phase2 = phase2;
    }

    public java.lang.Float getPhase2rate() {
        return this.phase2rate;
    }

    public void setPhase2rate(java.lang.Float phase2rate) {
        this.phase2rate = phase2rate;
    }

    public java.lang.Float getPhase3rate() {
        return this.phase3rate;
    }

    public void setPhase3rate(java.lang.Float phase3rate) {
        this.phase3rate = phase3rate;
    }

    public java.util.Date getInusetime() {
        return this.inusetime;
    }

    public void setInusetime(java.util.Date inusetime) {
        this.inusetime = inusetime;
    }

    public java.util.Date getOutusetime() {
        return this.outusetime;
    }

    public void setOutusetime(java.util.Date outusetime) {
        this.outusetime = outusetime;
    }

    public java.lang.Float getVersion() {
        return this.version;
    }

    public void setVersion(java.lang.Float version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdRewardruleVO) ) return false;
        ChPdRewardruleVO castOther = (ChPdRewardruleVO) other;
        return new EqualsBuilder()
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRuleid())
            .toHashCode();
    }

	public Class logVOClass() {
		return ChPdRewardrulelogVO.class;
	}

}
