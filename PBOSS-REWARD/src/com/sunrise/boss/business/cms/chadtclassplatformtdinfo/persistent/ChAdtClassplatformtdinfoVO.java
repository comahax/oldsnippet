package com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtClassplatformtdinfoVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** persistent field */
    private Integer tdbrandid;

    /** nullable persistent field */
    private String productid;

    /** persistent field */
    private String comid;

    /** nullable persistent field */
    private String comname;

    /** persistent field */
    private java.util.Date startdate;

    /** persistent field */
    private java.util.Date enddate;

    /** persistent field */
    private Short citycode;

    /** nullable persistent field */
    private String adtremark;

    
    private java.lang.String tdbrandname;
    
    
    /** full constructor */
    public ChAdtClassplatformtdinfoVO(java.lang.Long seq, java.lang.Integer tdbrandid, java.lang.String productid, java.lang.String comid, java.lang.String comname, java.util.Date startdate, java.util.Date enddate, java.lang.Short citycode, java.lang.String adtremark) {
        this.seq = seq;
        this.tdbrandid = tdbrandid;
        this.productid = productid;
        this.comid = comid;
        this.comname = comname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.citycode = citycode;
        this.adtremark = adtremark;
    }

    /** default constructor */
    public ChAdtClassplatformtdinfoVO() {
    }

    /** minimal constructor */
    public ChAdtClassplatformtdinfoVO(java.lang.Long seq, java.lang.Integer tdbrandid, java.lang.String comid, java.util.Date startdate, java.util.Date enddate, java.lang.Short citycode) {
        this.seq = seq;
        this.tdbrandid = tdbrandid;
        this.comid = comid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.citycode = citycode;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Integer getTdbrandid() {
        return this.tdbrandid;
    }

    public void setTdbrandid(java.lang.Integer tdbrandid) {
        this.tdbrandid = tdbrandid;
    }

    public java.lang.String getProductid() {
        return this.productid;
    }

    public void setProductid(java.lang.String productid) {
        this.productid = productid;
    }

    public java.lang.String getComid() {
        return this.comid;
    }

    public void setComid(java.lang.String comid) {
        this.comid = comid;
    }

    public java.lang.String getComname() {
        return this.comname;
    }

    public void setComname(java.lang.String comname) {
        this.comname = comname;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.Short getCitycode() {
        return this.citycode;
    }

    public void setCitycode(java.lang.Short citycode) {
        this.citycode = citycode;
    }

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }
    
    public java.lang.String getTdbrandname() {
		return tdbrandname;
	}

	public void setTdbrandname(java.lang.String tdbrandname) {
		this.tdbrandname = tdbrandname;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtClassplatformtdinfoVO) ) return false;
        ChAdtClassplatformtdinfoVO castOther = (ChAdtClassplatformtdinfoVO) other;
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
