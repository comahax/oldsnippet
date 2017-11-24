package com.sunrise.boss.business.cms.stdrewardbsslog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StdrewardbsslogVO implements Serializable {

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
    private String slv;

    /** nullable persistent field */
    private Double mpcitystd;

    /** nullable persistent field */
    private Double mpcountrystd;

    /** nullable persistent field */
    private Integer mpintvmonth;

    /** nullable persistent field */
    private Double secitystd;

    /** nullable persistent field */
    private Double secountrystd;

    /** nullable persistent field */
    private Integer seintvmonth;

    /** full constructor */
    public StdrewardbsslogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long rewardid, java.lang.String region, java.lang.String slv, java.lang.Double mpcitystd, java.lang.Double mpcountrystd, java.lang.Integer mpintvmonth, java.lang.Double secitystd, java.lang.Double secountrystd, java.lang.Integer seintvmonth) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rewardid = rewardid;
        this.region = region;
        this.slv = slv;
        this.mpcitystd = mpcitystd;
        this.mpcountrystd = mpcountrystd;
        this.mpintvmonth = mpintvmonth;
        this.secitystd = secitystd;
        this.secountrystd = secountrystd;
        this.seintvmonth = seintvmonth;
    }

    /** default constructor */
    public StdrewardbsslogVO() {
    }

    /** minimal constructor */
    public StdrewardbsslogVO(java.lang.Long logid) {
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

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.String getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.String slv) {
        this.slv = slv;
    }

    public java.lang.Double getMpcitystd() {
        return this.mpcitystd;
    }

    public void setMpcitystd(java.lang.Double mpcitystd) {
        this.mpcitystd = mpcitystd;
    }

    public java.lang.Double getMpcountrystd() {
        return this.mpcountrystd;
    }

    public void setMpcountrystd(java.lang.Double mpcountrystd) {
        this.mpcountrystd = mpcountrystd;
    }

    public java.lang.Integer getMpintvmonth() {
        return this.mpintvmonth;
    }

    public void setMpintvmonth(java.lang.Integer mpintvmonth) {
        this.mpintvmonth = mpintvmonth;
    }

    public java.lang.Double getSecitystd() {
        return this.secitystd;
    }

    public void setSecitystd(java.lang.Double secitystd) {
        this.secitystd = secitystd;
    }

    public java.lang.Double getSecountrystd() {
        return this.secountrystd;
    }

    public void setSecountrystd(java.lang.Double secountrystd) {
        this.secountrystd = secountrystd;
    }

    public java.lang.Integer getSeintvmonth() {
        return this.seintvmonth;
    }

    public void setSeintvmonth(java.lang.Integer seintvmonth) {
        this.seintvmonth = seintvmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardbsslogVO) ) return false;
        StdrewardbsslogVO castOther = (StdrewardbsslogVO) other;
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
