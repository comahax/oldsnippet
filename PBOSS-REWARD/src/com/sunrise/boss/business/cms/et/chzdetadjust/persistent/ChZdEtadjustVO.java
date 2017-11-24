package com.sunrise.boss.business.cms.et.chzdetadjust.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZdEtadjustVO implements Serializable {

    /** identifier field */
    private String batchno;

    /** identifier field */
    private String producttype;

    /** identifier field */
    private String wayid;

    /** identifier field */
    private String platform;

    /** nullable persistent field */
    private Long seq;

    /** nullable persistent field */
    private Double money;

    /** nullable persistent field */
    private String note;

    /** full constructor */
    public ChZdEtadjustVO(java.lang.String batchno, java.lang.String producttype, java.lang.String wayid, java.lang.String platform, java.lang.Long seq, java.lang.Double money, java.lang.String note) {
        this.batchno = batchno;
        this.producttype = producttype;
        this.wayid = wayid;
        this.platform = platform;
        this.seq = seq;
        this.money = money;
        this.note = note;
    }

    /** default constructor */
    public ChZdEtadjustVO() {
    }

    /** minimal constructor */
    public ChZdEtadjustVO(java.lang.Long seq, java.lang.String batchno, java.lang.String producttype, java.lang.String wayid, java.lang.String platform) {
    	this.seq = seq;
        this.batchno = batchno;
        this.producttype = producttype;
        this.wayid = wayid;
        this.platform = platform;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getProducttype() {
        return this.producttype;
    }

    public void setProducttype(java.lang.String producttype) {
        this.producttype = producttype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getPlatform() {
        return this.platform;
    }

    public void setPlatform(java.lang.String platform) {
        this.platform = platform;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Double getMoney() {
        return this.money;
    }

    public void setMoney(java.lang.Double money) {
        this.money = money;
    }

    public java.lang.String getNote() {
        return this.note;
    }

    public void setNote(java.lang.String note) {
        this.note = note;
    }

    public String toString() {
    	return new ToStringBuilder(this)
        .append("seq", getSeq())
        .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZdEtadjustVO) ) return false;
        ChZdEtadjustVO castOther = (ChZdEtadjustVO) other;
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
