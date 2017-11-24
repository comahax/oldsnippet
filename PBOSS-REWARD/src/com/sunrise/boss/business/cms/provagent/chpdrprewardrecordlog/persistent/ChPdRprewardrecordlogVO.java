package com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdRprewardrecordlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private Long rpseqid;

    /** nullable persistent field */
    private String provagentid;

    /** nullable persistent field */
    private String prodno;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Short phase;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Double rpmoney;

    /** nullable persistent field */
    private Long adcrewardid;

    /** full constructor */
    public ChPdRprewardrecordlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long rpseqid, java.lang.String provagentid, java.lang.String prodno, java.lang.String rewardmonth, java.lang.Short phase, java.lang.String cityid, java.lang.Double rpmoney, java.lang.Long adcrewardid) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.rpseqid = rpseqid;
        this.provagentid = provagentid;
        this.prodno = prodno;
        this.rewardmonth = rewardmonth;
        this.phase = phase;
        this.cityid = cityid;
        this.rpmoney = rpmoney;
        this.adcrewardid = adcrewardid;
    }

    /** default constructor */
    public ChPdRprewardrecordlogVO() {
    }

    /** minimal constructor */
    public ChPdRprewardrecordlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long rpseqid) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.rpseqid = rpseqid;
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

    public java.lang.Long getRpseqid() {
        return this.rpseqid;
    }

    public void setRpseqid(java.lang.Long rpseqid) {
        this.rpseqid = rpseqid;
    }

    public java.lang.String getProvagentid() {
        return this.provagentid;
    }

    public void setProvagentid(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getProdno() {
        return this.prodno;
    }

    public void setProdno(java.lang.String prodno) {
        this.prodno = prodno;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.Short getPhase() {
        return this.phase;
    }

    public void setPhase(java.lang.Short phase) {
        this.phase = phase;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Double getRpmoney() {
        return this.rpmoney;
    }

    public void setRpmoney(java.lang.Double rpmoney) {
        this.rpmoney = rpmoney;
    }

    public java.lang.Long getAdcrewardid() {
        return this.adcrewardid;
    }

    public void setAdcrewardid(java.lang.Long adcrewardid) {
        this.adcrewardid = adcrewardid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdRprewardrecordlogVO) ) return false;
        ChPdRprewardrecordlogVO castOther = (ChPdRprewardrecordlogVO) other;
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
