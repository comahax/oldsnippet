package com.sunrise.boss.business.cms.rewardranlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardranlogVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String paccount;

    /** nullable persistent field */
    private String raccount;

    /** nullable persistent field */
    private Double remark;

    /** nullable persistent field */
    private java.util.Date ptime;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String opercode;

    /** nullable persistent field */
    private java.util.Date opertime;

    /** nullable persistent field */
    private String opertype;

    /** full constructor */
    public RewardranlogVO(java.lang.Long seq, java.lang.String wayid, java.lang.String paccount, java.lang.String raccount, java.lang.Double remark, java.util.Date ptime, java.lang.String calcmonth, java.lang.String memo, java.lang.String opercode, java.util.Date opertime, java.lang.String opertype) {
        this.seq = seq;
        this.wayid = wayid;
        this.paccount = paccount;
        this.raccount = raccount;
        this.remark = remark;
        this.ptime = ptime;
        this.calcmonth = calcmonth;
        this.memo = memo;
        this.opercode = opercode;
        this.opertime = opertime;
        this.opertype = opertype;
    }

    /** default constructor */
    public RewardranlogVO() {
    }

    /** minimal constructor */
    public RewardranlogVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getPaccount() {
        return this.paccount;
    }

    public void setPaccount(java.lang.String paccount) {
        this.paccount = paccount;
    }

    public java.lang.String getRaccount() {
        return this.raccount;
    }

    public void setRaccount(java.lang.String raccount) {
        this.raccount = raccount;
    }

    public java.lang.Double getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.Double remark) {
        this.remark = remark;
    }

    public java.util.Date getPtime() {
        return this.ptime;
    }

    public void setPtime(java.util.Date ptime) {
        this.ptime = ptime;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }

    public java.util.Date getOpertime() {
        return this.opertime;
    }

    public void setOpertime(java.util.Date opertime) {
        this.opertime = opertime;
    }

    public java.lang.String getOpertype() {
        return this.opertype;
    }

    public void setOpertype(java.lang.String opertype) {
        this.opertype = opertype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardranlogVO) ) return false;
        RewardranlogVO castOther = (RewardranlogVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
