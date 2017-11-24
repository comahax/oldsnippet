package com.gmcc.pboss.business.sales.orderstd;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderstdVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String cooptype;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private String stdtype;

    /** nullable persistent field */
    private Double loweststd;

    /** nullable persistent field */
    private Short effective;

    /** full constructor */
    public OrderstdVO(java.lang.String cityid, java.lang.String countyid, java.lang.String cooptype, java.lang.Short starlevel, java.lang.String brand, java.lang.String stdtype, java.lang.Double loweststd, java.lang.Short effective) {
        this.cityid = cityid;
        this.countyid = countyid;
        this.cooptype = cooptype;
        this.starlevel = starlevel;
        this.brand = brand;
        this.stdtype = stdtype;
        this.loweststd = loweststd;
        this.effective = effective;
    }

    /** default constructor */
    public OrderstdVO() {
    }

    /** minimal constructor */
    public OrderstdVO(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getCooptype() {
        return this.cooptype;
    }

    public void setCooptype(java.lang.String cooptype) {
        this.cooptype = cooptype;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getStdtype() {
        return this.stdtype;
    }

    public void setStdtype(java.lang.String stdtype) {
        this.stdtype = stdtype;
    }

    public java.lang.Double getLoweststd() {
        return this.loweststd;
    }

    public void setLoweststd(java.lang.Double loweststd) {
        this.loweststd = loweststd;
    }

    public java.lang.Short getEffective() {
        return this.effective;
    }

    public void setEffective(java.lang.Short effective) {
        this.effective = effective;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderstdVO) ) return false;
        OrderstdVO castOther = (OrderstdVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
