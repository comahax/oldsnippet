package com.sunrise.boss.business.cms.reward.busitosmplog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BusitosmplogVO implements Serializable {

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
    private Integer comclassid;

    /** nullable persistent field */
    private Byte brand;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Long comprice;

    private Long comid;
    /** full constructor */
    public BusitosmplogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String opnid, java.lang.Integer comclassid, java.lang.Byte brand, java.lang.String cityid, java.lang.Long comprice) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.opnid = opnid;
        this.comclassid = comclassid;
        this.brand = brand;
        this.cityid = cityid;
        this.comprice = comprice;
    }

    public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	/** default constructor */
    public BusitosmplogVO() {
    }

    /** minimal constructor */
    public BusitosmplogVO(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.Integer getComclassid() {
        return this.comclassid;
    }

    public void setComclassid(java.lang.Integer comclassid) {
        this.comclassid = comclassid;
    }

    public java.lang.Byte getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Byte brand) {
        this.brand = brand;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getComprice() {
        return this.comprice;
    }

    public void setComprice(java.lang.Long comprice) {
        this.comprice = comprice;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusitosmplogVO) ) return false;
        BusitosmplogVO castOther = (BusitosmplogVO) other;
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
