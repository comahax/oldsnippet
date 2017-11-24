package com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtRewardsyninfoVO implements Serializable {

    /** identifier field */
    private Long taskid;

    /** persistent field */
    private String rewardmonth;

    /** persistent field */
    private Short systemflag;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String chainhead;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String opnids;

    /** nullable persistent field */
    private Byte taskstate;

    /** nullable persistent field */
    private String operid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String resultfile;

    /** nullable persistent field */
    private java.util.Date finishtime;

    /** nullable persistent field */
    private Integer totalcount;

    /** nullable persistent field */
    private Double successsum;

    /** full constructor */
    public ChAdtRewardsyninfoVO(java.lang.Long taskid, java.lang.String rewardmonth, java.lang.Short systemflag, java.lang.String countyid, java.lang.String wayid, java.lang.String chainhead, java.lang.String mobile, java.lang.String opnids, java.lang.Byte taskstate, java.lang.String operid, java.util.Date optime, java.lang.String resultfile, java.util.Date finishtime, java.lang.Integer totalcount, java.lang.Double successsum) {
        this.taskid = taskid;
        this.rewardmonth = rewardmonth;
        this.systemflag = systemflag;
        this.countyid = countyid;
        this.wayid = wayid;
        this.chainhead = chainhead;
        this.mobile = mobile;
        this.opnids = opnids;
        this.taskstate = taskstate;
        this.operid = operid;
        this.optime = optime;
        this.resultfile = resultfile;
        this.finishtime = finishtime;
        this.totalcount = totalcount;
        this.successsum = successsum;
    }

    /** default constructor */
    public ChAdtRewardsyninfoVO() {
    }

    /** minimal constructor */
    public ChAdtRewardsyninfoVO(java.lang.Long taskid, java.lang.String rewardmonth, java.lang.Short systemflag) {
        this.taskid = taskid;
        this.rewardmonth = rewardmonth;
        this.systemflag = systemflag;
    }

    public java.lang.Long getTaskid() {
        return this.taskid;
    }

    public void setTaskid(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.Short getSystemflag() {
        return this.systemflag;
    }

    public void setSystemflag(java.lang.Short systemflag) {
        this.systemflag = systemflag;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getChainhead() {
        return this.chainhead;
    }

    public void setChainhead(java.lang.String chainhead) {
        this.chainhead = chainhead;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getOpnids() {
        return this.opnids;
    }

    public void setOpnids(java.lang.String opnids) {
        this.opnids = opnids;
    }

    public java.lang.Byte getTaskstate() {
        return this.taskstate;
    }

    public void setTaskstate(java.lang.Byte taskstate) {
        this.taskstate = taskstate;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getResultfile() {
        return this.resultfile;
    }

    public void setResultfile(java.lang.String resultfile) {
        this.resultfile = resultfile;
    }

    public java.util.Date getFinishtime() {
        return this.finishtime;
    }

    public void setFinishtime(java.util.Date finishtime) {
        this.finishtime = finishtime;
    }

    public java.lang.Integer getTotalcount() {
        return this.totalcount;
    }

    public void setTotalcount(java.lang.Integer totalcount) {
        this.totalcount = totalcount;
    }

    public java.lang.Double getSuccesssum() {
        return this.successsum;
    }

    public void setSuccesssum(java.lang.Double successsum) {
        this.successsum = successsum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("taskid", getTaskid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtRewardsyninfoVO) ) return false;
        ChAdtRewardsyninfoVO castOther = (ChAdtRewardsyninfoVO) other;
        return new EqualsBuilder()
            .append(this.getTaskid(), castOther.getTaskid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTaskid())
            .toHashCode();
    }

}
