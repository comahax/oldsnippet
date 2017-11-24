package com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StdrewardutlogVO implements Serializable {

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
    private String region;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short islimt;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Integer intvmonth;

    /** nullable persistent field */
    private Integer integralnum;

    /** nullable persistent field */
    private Double unitprice;

    /** nullable persistent field */
    private String relateitem;

    /** full constructor */
    public StdrewardutlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success,java.lang.Long rewardid, java.lang.String region, java.lang.String wayid, java.lang.Short islimt, java.lang.Double rewardstd, java.lang.Integer intvmonth, java.lang.Integer integralnum, java.lang.Double unitprice, java.lang.String relateitem) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rewardid = rewardid;
        this.region = region;
        this.wayid = wayid;
        this.islimt = islimt;
        this.rewardstd = rewardstd;
        this.intvmonth = intvmonth;
        this.integralnum = integralnum;
        this.unitprice = unitprice;
        this.relateitem = relateitem;
    }

    /** default constructor */
    public StdrewardutlogVO() {
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

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getIslimt() {
        return this.islimt;
    }

    public void setIslimt(java.lang.Short islimt) {
        this.islimt = islimt;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Integer getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Integer intvmonth) {
        this.intvmonth = intvmonth;
    }

    public java.lang.Integer getIntegralnum() {
        return this.integralnum;
    }

    public void setIntegralnum(java.lang.Integer integralnum) {
        this.integralnum = integralnum;
    }

    public java.lang.Double getUnitprice() {
        return this.unitprice;
    }

    public void setUnitprice(java.lang.Double unitprice) {
        this.unitprice = unitprice;
    }

    public java.lang.String getRelateitem() {
        return this.relateitem;
    }

    public void setRelateitem(java.lang.String relateitem) {
        this.relateitem = relateitem;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardutlogVO) ) return false;
        StdrewardutlogVO castOther = (StdrewardutlogVO) other;
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
