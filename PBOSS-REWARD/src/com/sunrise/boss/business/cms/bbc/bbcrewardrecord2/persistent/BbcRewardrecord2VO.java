package com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BbcRewardrecord2VO implements Serializable {

    /** identifier field */
    private Long rewardlistid;

    /** nullable persistent field */
    private String operseq;

    /** nullable persistent field */
    private String datasrc;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayoprcode;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Double totalsum;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private java.util.Date runtime;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Short noncyc;

    /** nullable persistent field */
    private Short ossrc;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String mobile;

    /** full constructor */
    public BbcRewardrecord2VO(java.lang.Long rewardlistid, java.lang.String operseq, java.lang.String datasrc, java.lang.String opnid, java.lang.String wayid, java.lang.String wayoprcode, java.lang.Long rewardid, java.lang.Short rewardtype, java.lang.Double rewardstd, java.lang.String rewardmonth, java.lang.Double totalsum, java.lang.Double paysum, java.util.Date runtime, java.util.Date oprtime, java.lang.Short noncyc, java.lang.Short ossrc, java.lang.String batchno, java.lang.String mobile) {
        this.rewardlistid = rewardlistid;
        this.operseq = operseq;
        this.datasrc = datasrc;
        this.opnid = opnid;
        this.wayid = wayid;
        this.wayoprcode = wayoprcode;
        this.rewardid = rewardid;
        this.rewardtype = rewardtype;
        this.rewardstd = rewardstd;
        this.rewardmonth = rewardmonth;
        this.totalsum = totalsum;
        this.paysum = paysum;
        this.runtime = runtime;
        this.oprtime = oprtime;
        this.noncyc = noncyc;
        this.ossrc = ossrc;
        this.batchno = batchno;
        this.mobile = mobile;
    }

    /** default constructor */
    public BbcRewardrecord2VO() {
    }

    /** minimal constructor */
    public BbcRewardrecord2VO(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public java.lang.Long getRewardlistid() {
        return this.rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public java.lang.String getOperseq() {
        return this.operseq;
    }

    public void setOperseq(java.lang.String operseq) {
        this.operseq = operseq;
    }

    public java.lang.String getDatasrc() {
        return this.datasrc;
    }

    public void setDatasrc(java.lang.String datasrc) {
        this.datasrc = datasrc;
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

    public java.lang.String getWayoprcode() {
        return this.wayoprcode;
    }

    public void setWayoprcode(java.lang.String wayoprcode) {
        this.wayoprcode = wayoprcode;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
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

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
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

    public java.util.Date getRuntime() {
        return this.runtime;
    }

    public void setRuntime(java.util.Date runtime) {
        this.runtime = runtime;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Short getNoncyc() {
        return this.noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc) {
        this.noncyc = noncyc;
    }

    public java.lang.Short getOssrc() {
        return this.ossrc;
    }

    public void setOssrc(java.lang.Short ossrc) {
        this.ossrc = ossrc;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardlistid", getRewardlistid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BbcRewardrecord2VO) ) return false;
        BbcRewardrecord2VO castOther = (BbcRewardrecord2VO) other;
        return new EqualsBuilder()
            .append(this.getRewardlistid(), castOther.getRewardlistid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardlistid())
            .toHashCode();
    }

}
