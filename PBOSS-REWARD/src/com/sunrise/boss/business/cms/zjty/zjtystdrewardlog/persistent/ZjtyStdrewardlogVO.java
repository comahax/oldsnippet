package com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyStdrewardlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private String rewardname;

    /** nullable persistent field */
    private Short rewardproj;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date stopdate;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ZjtyStdrewardlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long rewardid, java.lang.String rewardname, java.lang.Short rewardproj, java.lang.Short rewardtype, java.util.Date startdate, java.util.Date stopdate, java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rewardid = rewardid;
        this.rewardname = rewardname;
        this.rewardproj = rewardproj;
        this.rewardtype = rewardtype;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.memo = memo;
    }

    /** default constructor */
    public ZjtyStdrewardlogVO() {
    }

    /** minimal constructor */
    public ZjtyStdrewardlogVO(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getRewardname() {
        return this.rewardname;
    }

    public void setRewardname(java.lang.String rewardname) {
        this.rewardname = rewardname;
    }

    public java.lang.Short getRewardproj() {
        return this.rewardproj;
    }

    public void setRewardproj(java.lang.Short rewardproj) {
        this.rewardproj = rewardproj;
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

    public java.util.Date getStopdate() {
        return this.stopdate;
    }

    public void setStopdate(java.util.Date stopdate) {
        this.stopdate = stopdate;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyStdrewardlogVO) ) return false;
        ZjtyStdrewardlogVO castOther = (ZjtyStdrewardlogVO) other;
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
