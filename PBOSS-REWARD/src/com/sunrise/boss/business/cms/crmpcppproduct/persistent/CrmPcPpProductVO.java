package com.sunrise.boss.business.cms.crmpcppproduct.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CrmPcPpProductVO implements Serializable {

    /** persistent field */
    private String prodid;

    /** nullable persistent field */
    private String prodname;

    /** persistent field */
    private String catalogid;

    /** persistent field */
    private Byte issolution;

    /** nullable persistent field */
    private Byte isoverregion;

    /** persistent field */
    private java.util.Date availabledate;

    /** persistent field */
    private java.util.Date enddate;

    /** persistent field */
    private String status;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private Integer region;

    /** nullable persistent field */
    private Byte isupload;

    /** full constructor */
    public CrmPcPpProductVO(java.lang.String prodid, java.lang.String prodname, java.lang.String catalogid, java.lang.Byte issolution, java.lang.Byte isoverregion, java.util.Date availabledate, java.util.Date enddate, java.lang.String status, java.lang.String description, java.lang.Integer region, java.lang.Byte isupload) {
        this.prodid = prodid;
        this.prodname = prodname;
        this.catalogid = catalogid;
        this.issolution = issolution;
        this.isoverregion = isoverregion;
        this.availabledate = availabledate;
        this.enddate = enddate;
        this.status = status;
        this.description = description;
        this.region = region;
        this.isupload = isupload;
    }

    /** default constructor */
    public CrmPcPpProductVO() {
    }

    /** minimal constructor */
    public CrmPcPpProductVO(java.lang.String prodid, java.lang.String catalogid, java.lang.Byte issolution, java.util.Date availabledate, java.util.Date enddate, java.lang.String status) {
        this.prodid = prodid;
        this.catalogid = catalogid;
        this.issolution = issolution;
        this.availabledate = availabledate;
        this.enddate = enddate;
        this.status = status;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getProdname() {
        return this.prodname;
    }

    public void setProdname(java.lang.String prodname) {
        this.prodname = prodname;
    }

    public java.lang.String getCatalogid() {
        return this.catalogid;
    }

    public void setCatalogid(java.lang.String catalogid) {
        this.catalogid = catalogid;
    }

    public java.lang.Byte getIssolution() {
        return this.issolution;
    }

    public void setIssolution(java.lang.Byte issolution) {
        this.issolution = issolution;
    }

    public java.lang.Byte getIsoverregion() {
        return this.isoverregion;
    }

    public void setIsoverregion(java.lang.Byte isoverregion) {
        this.isoverregion = isoverregion;
    }

    public java.util.Date getAvailabledate() {
        return this.availabledate;
    }

    public void setAvailabledate(java.util.Date availabledate) {
        this.availabledate = availabledate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.Integer getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.Integer region) {
        this.region = region;
    }

    public java.lang.Byte getIsupload() {
        return this.isupload;
    }

    public void setIsupload(java.lang.Byte isupload) {
        this.isupload = isupload;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
