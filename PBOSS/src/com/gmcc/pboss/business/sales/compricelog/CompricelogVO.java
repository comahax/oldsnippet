package com.gmcc.pboss.business.sales.compricelog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CompricelogVO extends BaseVO implements Serializable {

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
    private Long recid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String cooptype;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String pricediftype;

    /** nullable persistent field */
    private Double price1;

    /** nullable persistent field */
    private Double price2;

    /** full constructor */
    public CompricelogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long recid, java.lang.String cityid, java.lang.String countyid, java.lang.Short starlevel, java.lang.String cooptype, java.lang.String comcategory, java.lang.String pricediftype, java.lang.Double price1, java.lang.Double price2) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.recid = recid;
        this.cityid = cityid;
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.cooptype = cooptype;
        this.comcategory = comcategory;
        this.pricediftype = pricediftype;
        this.price1 = price1;
        this.price2 = price2;
    }

    /** default constructor */
    public CompricelogVO() {
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

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getCooptype() {
        return this.cooptype;
    }

    public void setCooptype(java.lang.String cooptype) {
        this.cooptype = cooptype;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getPricediftype() {
        return this.pricediftype;
    }

    public void setPricediftype(java.lang.String pricediftype) {
        this.pricediftype = pricediftype;
    }

    public java.lang.Double getPrice1() {
        return this.price1;
    }

    public void setPrice1(java.lang.Double price1) {
        this.price1 = price1;
    }

    public java.lang.Double getPrice2() {
        return this.price2;
    }

    public void setPrice2(java.lang.Double price2) {
        this.price2 = price2;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CompricelogVO) ) return false;
        CompricelogVO castOther = (CompricelogVO) other;
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
