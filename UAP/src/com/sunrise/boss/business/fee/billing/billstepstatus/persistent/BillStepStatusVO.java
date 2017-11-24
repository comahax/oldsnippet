package com.sunrise.boss.business.fee.billing.billstepstatus.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class BillStepStatusVO extends BaseVO {

    /** identifier field */
    private Long stepno;

    /** identifier field */
    private Long validbillcyc;

    /** nullable persistent field */
    private Short taskstatus;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private String errorreason;

    /** nullable persistent field */
    private java.util.Date upttime;
    
    private Integer region;

    public Integer getRegion() {
    	return region;
    }

    public void setRegion(Integer region) {
    	this.region = region;
    }


    /** full constructor */
    public BillStepStatusVO(java.lang.Long stepno, java.lang.Long validbillcyc, java.lang.Short taskstatus, java.util.Date startdate, java.util.Date enddate, java.lang.String errorreason, java.util.Date upttime) {
        this.stepno = stepno;
        this.validbillcyc = validbillcyc;
        this.taskstatus = taskstatus;
        this.startdate = startdate;
        this.enddate = enddate;
        this.errorreason = errorreason;
        this.upttime = upttime;
    }

    /** default constructor */
    public BillStepStatusVO() {
    }

    /** minimal constructor */
    public BillStepStatusVO(java.lang.Long stepno, java.lang.Long validbillcyc) {
        this.stepno = stepno;
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Long getStepno() {
        return this.stepno;
    }

    public void setStepno(java.lang.Long stepno) {
        this.stepno = stepno;
    }

    public java.lang.Long getValidbillcyc() {
        return this.validbillcyc;
    }

    public void setValidbillcyc(java.lang.Long validbillcyc) {
        this.validbillcyc = validbillcyc;
    }

    public java.lang.Short getTaskstatus() {
        return this.taskstatus;
    }

    public void setTaskstatus(java.lang.Short taskstatus) {
        this.taskstatus = taskstatus;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.String getErrorreason() {
        return this.errorreason;
    }

    public void setErrorreason(java.lang.String errorreason) {
        this.errorreason = errorreason;
    }

    public java.util.Date getUpttime() {
        return this.upttime;
    }

    public void setUpttime(java.util.Date upttime) {
        this.upttime = upttime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("stepno", getStepno())
            .append("validbillcyc", getValidbillcyc())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BillStepStatusVO) ) return false;
        BillStepStatusVO castOther = (BillStepStatusVO) other;
        return new EqualsBuilder()
            .append(this.getStepno(), castOther.getStepno())
            .append(this.getValidbillcyc(), castOther.getValidbillcyc())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStepno())
            .append(getValidbillcyc())
            .toHashCode();
    }

}
