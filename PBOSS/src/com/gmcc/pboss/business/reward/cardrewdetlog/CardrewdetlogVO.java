package com.gmcc.pboss.business.reward.cardrewdetlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CardrewdetlogVO extends BaseVO implements Serializable {

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

    /** persistent field */
    private Long seqid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private java.util.Date activetime;

    /** nullable persistent field */
    private Double rechargenum;

    /** nullable persistent field */
    private java.util.Date rechargetime;

    /** nullable persistent field */
    private Double rewardnum;

    /** nullable persistent field */
    private String cmonth;

    /** nullable persistent field */
    private Long rewardtype;

    /** full constructor */
    public CardrewdetlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.String wayid, java.lang.String mobile, java.util.Date activetime, java.lang.Double rechargenum, java.util.Date rechargetime, java.lang.Double rewardnum, java.lang.String cmonth, java.lang.Long rewardtype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.wayid = wayid;
        this.mobile = mobile;
        this.activetime = activetime;
        this.rechargenum = rechargenum;
        this.rechargetime = rechargetime;
        this.rewardnum = rewardnum;
        this.cmonth = cmonth;
        this.rewardtype = rewardtype;
    }

    /** default constructor */
    public CardrewdetlogVO() {
    }

    /** minimal constructor */
    public CardrewdetlogVO(java.lang.Long seqid) {
        this.seqid = seqid;
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

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.util.Date getActivetime() {
        return this.activetime;
    }

    public void setActivetime(java.util.Date activetime) {
        this.activetime = activetime;
    }

    public java.lang.Double getRechargenum() {
        return this.rechargenum;
    }

    public void setRechargenum(java.lang.Double rechargenum) {
        this.rechargenum = rechargenum;
    }

    public java.util.Date getRechargetime() {
        return this.rechargetime;
    }

    public void setRechargetime(java.util.Date rechargetime) {
        this.rechargetime = rechargetime;
    }

    public java.lang.Double getRewardnum() {
        return this.rewardnum;
    }

    public void setRewardnum(java.lang.Double rewardnum) {
        this.rewardnum = rewardnum;
    }

    public java.lang.String getCmonth() {
        return this.cmonth;
    }

    public void setCmonth(java.lang.String cmonth) {
        this.cmonth = cmonth;
    }

    public java.lang.Long getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Long rewardtype) {
        this.rewardtype = rewardtype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CardrewdetlogVO) ) return false;
        CardrewdetlogVO castOther = (CardrewdetlogVO) other;
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
