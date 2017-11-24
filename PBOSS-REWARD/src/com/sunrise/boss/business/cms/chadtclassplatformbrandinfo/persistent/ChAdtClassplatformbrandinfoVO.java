package com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtClassplatformbrandinfoVO implements Serializable {

    /** identifier field */
    private Long brandid;

    /** nullable persistent field */
    private String brandname;

    /** persistent field */
    private Short state;

    /** nullable persistent field */
    private String adtremark;

    /** full constructor */
    public ChAdtClassplatformbrandinfoVO(java.lang.Long brandid, java.lang.String brandname, java.lang.Short state, java.lang.String adtremark) {
        this.brandid = brandid;
        this.brandname = brandname;
        this.state = state;
        this.adtremark = adtremark;
    }

    /** default constructor */
    public ChAdtClassplatformbrandinfoVO() {
    }

    /** minimal constructor */
    public ChAdtClassplatformbrandinfoVO(java.lang.Long brandid, java.lang.Short state) {
        this.brandid = brandid;
        this.state = state;
    }

    public java.lang.Long getBrandid() {
        return this.brandid;
    }

    public void setBrandid(java.lang.Long brandid) {
        this.brandid = brandid;
    }

    public java.lang.String getBrandname() {
        return this.brandname;
    }

    public void setBrandname(java.lang.String brandname) {
        this.brandname = brandname;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("brandid", getBrandid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtClassplatformbrandinfoVO) ) return false;
        ChAdtClassplatformbrandinfoVO castOther = (ChAdtClassplatformbrandinfoVO) other;
        return new EqualsBuilder()
            .append(this.getBrandid(), castOther.getBrandid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrandid())
            .toHashCode();
    }

}
