package com.sunrise.boss.business.cms.chzdplatforminfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZdPlatforminfoVO implements Serializable {

    /** nullable persistent field */
    private Long seq;

    /** nullable persistent field */
    private Long productid;

    /** nullable persistent field */
    private String producttype;

    /** nullable persistent field */
    private String zdplatform;

    /** nullable persistent field */
    private Double saleprice;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private String batchno;

    /** full constructor */
    public ChZdPlatforminfoVO(java.lang.Long seq, java.lang.Long productid, java.lang.String producttype, java.lang.String zdplatform, java.lang.Double saleprice, java.util.Date starttime, java.util.Date endtime, java.lang.String batchno) {
        this.seq = seq;
        this.productid = productid;
        this.producttype = producttype;
        this.zdplatform = zdplatform;
        this.saleprice = saleprice;
        this.starttime = starttime;
        this.endtime = endtime;
        this.batchno = batchno;
    }

    /** default constructor */
    public ChZdPlatforminfoVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getProductid() {
        return this.productid;
    }

    public void setProductid(java.lang.Long productid) {
        this.productid = productid;
    }

    public java.lang.String getProducttype() {
        return this.producttype;
    }

    public void setProducttype(java.lang.String producttype) {
        this.producttype = producttype;
    }

    public java.lang.String getZdplatform() {
        return this.zdplatform;
    }

    public void setZdplatform(java.lang.String zdplatform) {
        this.zdplatform = zdplatform;
    }

    public java.lang.Double getSaleprice() {
        return this.saleprice;
    }

    public void setSaleprice(java.lang.Double saleprice) {
        this.saleprice = saleprice;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
