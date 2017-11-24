package com.sunrise.boss.business.cms.reward.busitocomlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BusitocomlogVO implements Serializable {

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
    private String opnid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Integer comtype;

    /** nullable persistent field */
    private Long comid;

    /** nullable persistent field */
    private String comresid;

    /** nullable persistent field */
    private Integer comclassid;

    /** nullable persistent field */
    private Long pricelow;

    /** nullable persistent field */
    private Long pricetop;

    /** nullable persistent field */
    private String busitype;

    /** full constructor */
    public BusitocomlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String opnid, java.lang.String cityid, java.lang.Integer comtype, java.lang.Long comid, java.lang.String comresid, java.lang.Integer comclassid, java.lang.Long pricelow, java.lang.Long pricetop, java.lang.String busitype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.opnid = opnid;
        this.cityid = cityid;
        this.comtype = comtype;
        this.comid = comid;
        this.comresid = comresid;
        this.comclassid = comclassid;
        this.pricelow = pricelow;
        this.pricetop = pricetop;
        this.busitype = busitype;
    }

    /** default constructor */
    public BusitocomlogVO() {
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

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Integer getComtype() {
        return this.comtype;
    }

    public void setComtype(java.lang.Integer comtype) {
        this.comtype = comtype;
    }

    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
    }

    public java.lang.Integer getComclassid() {
        return this.comclassid;
    }

    public void setComclassid(java.lang.Integer comclassid) {
        this.comclassid = comclassid;
    }

    public java.lang.Long getPricelow() {
        return this.pricelow;
    }

    public void setPricelow(java.lang.Long pricelow) {
        this.pricelow = pricelow;
    }

    public java.lang.Long getPricetop() {
        return this.pricetop;
    }

    public void setPricetop(java.lang.Long pricetop) {
        this.pricetop = pricetop;
    }

    public java.lang.String getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.String busitype) {
        this.busitype = busitype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusitocomlogVO) ) return false;
        BusitocomlogVO castOther = (BusitocomlogVO) other;
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
