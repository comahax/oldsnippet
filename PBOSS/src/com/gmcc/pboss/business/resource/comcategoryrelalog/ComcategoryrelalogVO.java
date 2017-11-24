package com.gmcc.pboss.business.resource.comcategoryrelalog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComcategoryrelalogVO extends BaseVO implements Serializable {

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
    private Long relaid;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private Long comid;

    /** nullable persistent field */
    private String restype;
    private String brand;

    /** full constructor */
    public ComcategoryrelalogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long relaid, java.lang.String comcategory, java.lang.Long comid, java.lang.String restype,String brand) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.relaid = relaid;
        this.comcategory = comcategory;
        this.comid = comid;
        this.restype = restype;
        this.brand=brand;
    }

    /** default constructor */
    public ComcategoryrelalogVO() {
    }

    /** minimal constructor */
    public ComcategoryrelalogVO(java.lang.Long logid) {
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

    public java.lang.Long getRelaid() {
        return this.relaid;
    }

    public void setRelaid(java.lang.Long relaid) {
        this.relaid = relaid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.String getRestype() {
        return this.restype;
    }

    public void setRestype(java.lang.String restype) {
        this.restype = restype;
    }
    

    public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComcategoryrelalogVO) ) return false;
        ComcategoryrelalogVO castOther = (ComcategoryrelalogVO) other;
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
