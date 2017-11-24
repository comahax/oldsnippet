package com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZdEtsaleinfoVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String city;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String zdplatform;

    /** nullable persistent field */
    private String producttype;

    /** nullable persistent field */
    private String imei;

    /** nullable persistent field */
    private Float saleprice;

    /** nullable persistent field */
    private Float lsaleprice;

    /** nullable persistent field */
    private Integer salenum;

    /** nullable persistent field */
    private java.util.Date saleday;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String note;

    /** full constructor */
    public ChZdEtsaleinfoVO(java.lang.Long seq, java.lang.String city, java.lang.String wayid, java.lang.String wayname, java.lang.String oprcode, java.lang.String zdplatform, java.lang.String producttype, java.lang.String imei, java.lang.Float saleprice, java.lang.Float lsaleprice, java.lang.Integer salenum, java.util.Date saleday, java.lang.String batchno, java.lang.String note) {
        this.seq = seq;
        this.city = city;
        this.wayid = wayid;
        this.wayname = wayname;
        this.oprcode = oprcode;
        this.zdplatform = zdplatform;
        this.producttype = producttype;
        this.imei = imei;
        this.saleprice = saleprice;
        this.lsaleprice = lsaleprice;
        this.salenum = salenum;
        this.saleday = saleday;
        this.batchno = batchno;
        this.note = note;
    }

    /** default constructor */
    public ChZdEtsaleinfoVO() {
    }

    /** minimal constructor */
    public ChZdEtsaleinfoVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getCity() {
        return this.city;
    }

    public void setCity(java.lang.String city) {
        this.city = city;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getZdplatform() {
        return this.zdplatform;
    }

    public void setZdplatform(java.lang.String zdplatform) {
        this.zdplatform = zdplatform;
    }

    public java.lang.String getProducttype() {
        return this.producttype;
    }

    public void setProducttype(java.lang.String producttype) {
        this.producttype = producttype;
    }

    public java.lang.String getImei() {
        return this.imei;
    }

    public void setImei(java.lang.String imei) {
        this.imei = imei;
    }

    public java.lang.Float getSaleprice() {
        return this.saleprice;
    }

    public void setSaleprice(java.lang.Float saleprice) {
        this.saleprice = saleprice;
    }

    public java.lang.Float getLsaleprice() {
        return this.lsaleprice;
    }

    public void setLsaleprice(java.lang.Float lsaleprice) {
        this.lsaleprice = lsaleprice;
    }

    public java.lang.Integer getSalenum() {
        return this.salenum;
    }

    public void setSalenum(java.lang.Integer salenum) {
        this.salenum = salenum;
    }

    public java.util.Date getSaleday() {
        return this.saleday;
    }

    public void setSaleday(java.util.Date saleday) {
        this.saleday = saleday;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
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
        if ( !(other instanceof ChZdEtsaleinfoVO) ) return false;
        ChZdEtsaleinfoVO castOther = (ChZdEtsaleinfoVO) other;
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
