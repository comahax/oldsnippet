package com.sunrise.boss.business.zifee.minconsumelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MinconsumelogVO implements Serializable {

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
    private Long yxplanid;

    /** nullable persistent field */
    private Integer effectiveinterval;

    /** nullable persistent field */
    private Long consumecycle;

    /** nullable persistent field */
    private Integer cyclecount;

    /** nullable persistent field */
    private String effectivetype;

    /** nullable persistent field */
    private Double minconsume;

    /** full constructor */
    public MinconsumelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long yxplanid, java.lang.Integer effectiveinterval, java.lang.Long consumecycle, java.lang.Integer cyclecount, java.lang.String effectivetype, java.lang.Double minconsume) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.yxplanid = yxplanid;
        this.effectiveinterval = effectiveinterval;
        this.consumecycle = consumecycle;
        this.cyclecount = cyclecount;
        this.effectivetype = effectivetype;
        this.minconsume = minconsume;
    }

    /** default constructor */
    public MinconsumelogVO() {
    }

    /** minimal constructor */
    public MinconsumelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.logid = logid;
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

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Integer getEffectiveinterval() {
        return this.effectiveinterval;
    }

    public void setEffectiveinterval(java.lang.Integer effectiveinterval) {
        this.effectiveinterval = effectiveinterval;
    }

    public java.lang.Long getConsumecycle() {
        return this.consumecycle;
    }

    public void setConsumecycle(java.lang.Long consumecycle) {
        this.consumecycle = consumecycle;
    }

    public java.lang.Integer getCyclecount() {
        return this.cyclecount;
    }

    public void setCyclecount(java.lang.Integer cyclecount) {
        this.cyclecount = cyclecount;
    }

    public java.lang.String getEffectivetype() {
        return this.effectivetype;
    }

    public void setEffectivetype(java.lang.String effectivetype) {
        this.effectivetype = effectivetype;
    }

    public java.lang.Double getMinconsume() {
        return this.minconsume;
    }

    public void setMinconsume(java.lang.Double minconsume) {
        this.minconsume = minconsume;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MinconsumelogVO) ) return false;
        MinconsumelogVO castOther = (MinconsumelogVO) other;
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
