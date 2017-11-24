package com.sunrise.boss.business.cms.chbbcmarketact.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChBbcMarketactVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String rewardmonth;

    /** nullable persistent field */
    private String acttype;

    /** nullable persistent field */
    private String actprofile;

    /** nullable persistent field */
    private java.util.Date updatetime;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public ChBbcMarketactVO(java.lang.String cityid, java.lang.String opnid, java.lang.String rewardmonth, java.lang.String acttype, java.lang.String actprofile, java.util.Date updatetime, java.lang.String remark) {
        this.cityid = cityid;
        this.opnid = opnid;
        this.rewardmonth = rewardmonth;
        this.acttype = acttype;
        this.actprofile = actprofile;
        this.updatetime = updatetime;
        this.remark = remark;
    }

    /** default constructor */
    public ChBbcMarketactVO() {
    }

    /** minimal constructor */
    public ChBbcMarketactVO(java.lang.String cityid, java.lang.String opnid, java.lang.String rewardmonth) {
        this.cityid = cityid;
        this.opnid = opnid;
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getActtype() {
        return this.acttype;
    }

    public void setActtype(java.lang.String acttype) {
        this.acttype = acttype;
    }

    public java.lang.String getActprofile() {
        return this.actprofile;
    }

    public void setActprofile(java.lang.String actprofile) {
        this.actprofile = actprofile;
    }

    public java.util.Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime) {
        this.updatetime = updatetime;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("opnid", getOpnid())
            .append("rewardmonth", getRewardmonth())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChBbcMarketactVO) ) return false;
        ChBbcMarketactVO castOther = (ChBbcMarketactVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getRewardmonth(), castOther.getRewardmonth())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getOpnid())
            .append(getRewardmonth())
            .toHashCode();
    }

}
