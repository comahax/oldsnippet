package com.sunrise.boss.business.cms.provagent.chpdrewardrulelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdRewardrulelogVO implements Serializable {

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

    /** persistent field */
    private Long ruleid;

    /** nullable persistent field */
    private Byte coopertype;

    /** nullable persistent field */
    private Float cooperrate;

    /** nullable persistent field */
    private String subcatogray;

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
    public ChPdRewardrulelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long ruleid, java.lang.Byte coopertype, java.lang.Float cooperrate, java.lang.String subcatogray, java.lang.Short phase1, java.lang.Float phase1rate, java.lang.Short phase2, java.lang.Float phase2rate, java.lang.Float phase3rate, java.util.Date inusetime, java.util.Date outusetime, java.lang.Float version) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.ruleid = ruleid;
        this.coopertype = coopertype;
        this.cooperrate = cooperrate;
        this.subcatogray = subcatogray;
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
    public ChPdRewardrulelogVO() {
    }

    /** minimal constructor */
    public ChPdRewardrulelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long ruleid) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.ruleid = ruleid;
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

    public java.lang.String getSubcatogray() {
        return this.subcatogray;
    }

    public void setSubcatogray(java.lang.String subcatogray) {
        this.subcatogray = subcatogray;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdRewardrulelogVO) ) return false;
        ChPdRewardrulelogVO castOther = (ChPdRewardrulelogVO) other;
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
