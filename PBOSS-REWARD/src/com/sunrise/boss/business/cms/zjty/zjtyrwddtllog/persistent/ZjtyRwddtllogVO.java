package com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyRwddtllogVO implements Serializable {

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
    private Long rewardlistid;

    /** nullable persistent field */
    private Long operseq;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayopercode;

    /** nullable persistent field */
    private String rewardid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double coef1;

    /** nullable persistent field */
    private Double coef2;

    /** nullable persistent field */
    private Double coef3;

    /** nullable persistent field */
    private Double coef4;

    /** nullable persistent field */
    private String rewardmont;

    /** nullable persistent field */
    private Double totalsum;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private String batchnum;

    /** full constructor */
    public ZjtyRwddtllogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long rewardlistid, java.lang.Long operseq, java.lang.String opnid, java.lang.String wayid, java.lang.String wayopercode, java.lang.String rewardid, java.lang.Short rewardtype, java.lang.Double rewardstd, java.lang.Short acctype, java.lang.Double coef1, java.lang.Double coef2, java.lang.Double coef3, java.lang.Double coef4, java.lang.String rewardmont, java.lang.Double totalsum, java.lang.Double paysum, java.lang.String batchnum) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rewardlistid = rewardlistid;
        this.operseq = operseq;
        this.opnid = opnid;
        this.wayid = wayid;
        this.wayopercode = wayopercode;
        this.rewardid = rewardid;
        this.rewardtype = rewardtype;
        this.rewardstd = rewardstd;
        this.acctype = acctype;
        this.coef1 = coef1;
        this.coef2 = coef2;
        this.coef3 = coef3;
        this.coef4 = coef4;
        this.rewardmont = rewardmont;
        this.totalsum = totalsum;
        this.paysum = paysum;
        this.batchnum = batchnum;
    }

    /** default constructor */
    public ZjtyRwddtllogVO() {
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

    public java.lang.Long getRewardlistid() {
        return this.rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public java.lang.Long getOperseq() {
        return this.operseq;
    }

    public void setOperseq(java.lang.Long operseq) {
        this.operseq = operseq;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayopercode() {
        return this.wayopercode;
    }

    public void setWayopercode(java.lang.String wayopercode) {
        this.wayopercode = wayopercode;
    }

    public java.lang.String getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.String rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getCoef1() {
        return this.coef1;
    }

    public void setCoef1(java.lang.Double coef1) {
        this.coef1 = coef1;
    }

    public java.lang.Double getCoef2() {
        return this.coef2;
    }

    public void setCoef2(java.lang.Double coef2) {
        this.coef2 = coef2;
    }

    public java.lang.Double getCoef3() {
        return this.coef3;
    }

    public void setCoef3(java.lang.Double coef3) {
        this.coef3 = coef3;
    }

    public java.lang.Double getCoef4() {
        return this.coef4;
    }

    public void setCoef4(java.lang.Double coef4) {
        this.coef4 = coef4;
    }

    public java.lang.String getRewardmont() {
        return this.rewardmont;
    }

    public void setRewardmont(java.lang.String rewardmont) {
        this.rewardmont = rewardmont;
    }

    public java.lang.Double getTotalsum() {
        return this.totalsum;
    }

    public void setTotalsum(java.lang.Double totalsum) {
        this.totalsum = totalsum;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public java.lang.String getBatchnum() {
        return this.batchnum;
    }

    public void setBatchnum(java.lang.String batchnum) {
        this.batchnum = batchnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyRwddtllogVO) ) return false;
        ZjtyRwddtllogVO castOther = (ZjtyRwddtllogVO) other;
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
