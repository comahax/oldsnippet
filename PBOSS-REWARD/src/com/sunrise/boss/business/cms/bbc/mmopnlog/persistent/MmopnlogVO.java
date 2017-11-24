package com.sunrise.boss.business.cms.bbc.mmopnlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MmopnlogVO implements Serializable {

    /** identifier field */
    private String logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String entid;

    /** nullable persistent field */
    private String busiid;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Byte state;

    /** nullable persistent field */
    private Short ossrc;

    /** nullable persistent field */
    private String shortopn;

    /** nullable persistent field */
    private String wapurl;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String opnmon;

    /** full constructor */
    public MmopnlogVO(java.lang.String logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String opnid, java.lang.String name, java.lang.String entid, java.lang.String busiid, java.lang.Short acctype, java.lang.Double rewardstd, java.lang.Byte state, java.lang.Short ossrc, java.lang.String shortopn, java.lang.String wapurl, java.lang.String memo, java.lang.String opnmon) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.opnid = opnid;
        this.name = name;
        this.entid = entid;
        this.busiid = busiid;
        this.acctype = acctype;
        this.rewardstd = rewardstd;
        this.state = state;
        this.ossrc = ossrc;
        this.shortopn = shortopn;
        this.wapurl = wapurl;
        this.memo = memo;
        this.opnmon = opnmon;
    }

    /** default constructor */
    public MmopnlogVO() {
    }

    /** minimal constructor */
    public MmopnlogVO(java.lang.String logid) {
        this.logid = logid;
    }

    public java.lang.String getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.String logid) {
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

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getEntid() {
        return this.entid;
    }

    public void setEntid(java.lang.String entid) {
        this.entid = entid;
    }

    public java.lang.String getBusiid() {
        return this.busiid;
    }

    public void setBusiid(java.lang.String busiid) {
        this.busiid = busiid;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Byte getState() {
        return this.state;
    }

    public void setState(java.lang.Byte state) {
        this.state = state;
    }

    public java.lang.Short getOssrc() {
        return this.ossrc;
    }

    public void setOssrc(java.lang.Short ossrc) {
        this.ossrc = ossrc;
    }

    public java.lang.String getShortopn() {
        return this.shortopn;
    }

    public void setShortopn(java.lang.String shortopn) {
        this.shortopn = shortopn;
    }

    public java.lang.String getWapurl() {
        return this.wapurl;
    }

    public void setWapurl(java.lang.String wapurl) {
        this.wapurl = wapurl;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getOpnmon() {
        return this.opnmon;
    }

    public void setOpnmon(java.lang.String opnmon) {
        this.opnmon = opnmon;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MmopnlogVO) ) return false;
        MmopnlogVO castOther = (MmopnlogVO) other;
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
