package com.sunrise.boss.business.cms.et.chetstdreward.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChEtStdrewardVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** persistent field */
    private String opnid;

    /** persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Short intvmonth;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private Short acctype;

    /** full constructor */
    public ChEtStdrewardVO(java.lang.String opnid, java.lang.Short cityid, java.lang.Double rewardstd, java.lang.Short intvmonth, java.lang.String ruleid, java.lang.Short rewardtype, java.util.Date startdate, java.util.Date enddate, java.lang.Long rewardid, java.lang.Short acctype) {
        this.opnid = opnid;
        this.cityid = cityid;
        this.rewardstd = rewardstd;
        this.intvmonth = intvmonth;
        this.ruleid = ruleid;
        this.rewardtype = rewardtype;
        this.startdate = startdate;
        this.enddate = enddate;
        this.rewardid = rewardid;
        this.acctype = acctype;
    }

    /** default constructor */
    public ChEtStdrewardVO() {
    }

    /** minimal constructor */
    public ChEtStdrewardVO(java.lang.String opnid, java.lang.Short cityid) {
        this.opnid = opnid;
        this.cityid = cityid;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Short getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Short intvmonth) {
        this.intvmonth = intvmonth;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
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

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChEtStdrewardVO) ) return false;
        ChEtStdrewardVO castOther = (ChEtStdrewardVO) other;
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
