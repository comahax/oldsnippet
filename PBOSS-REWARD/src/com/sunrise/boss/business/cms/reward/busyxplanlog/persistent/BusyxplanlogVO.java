package com.sunrise.boss.business.cms.reward.busyxplanlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BusyxplanlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private String opnid;

    /** persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Double wrapfee;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;
    
    private Long noncyc ; //客户维系酬金发放期数
    
    private String prodid;
    private String planbusitype;

    public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getPlanbusitype() {
		return planbusitype;
	}

	public void setPlanbusitype(String planbusitype) {
		this.planbusitype = planbusitype;
	}

	/** full constructor */
    public BusyxplanlogVO(java.lang.Long logid, java.lang.String opnid, java.lang.Long yxplanid, java.lang.Double wrapfee, java.lang.String cityid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success,
    		java.lang.Long noncyc,java.lang.String planbusitype,java.lang.String prodid ) {
        this.logid = logid;
        this.opnid = opnid;
        this.yxplanid = yxplanid;
        this.wrapfee = wrapfee;
        this.cityid = cityid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.noncyc = noncyc;
        this.planbusitype = planbusitype;
        this.prodid = prodid;
    }

    /** default constructor */
    public BusyxplanlogVO() {
    }

    /** minimal constructor */
    public BusyxplanlogVO(java.lang.Long logid, java.lang.String opnid, java.lang.Long yxplanid) {
        this.logid = logid;
        this.opnid = opnid;
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Double getWrapfee() {
        return this.wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee) {
        this.wrapfee = wrapfee;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusyxplanlogVO) ) return false;
        BusyxplanlogVO castOther = (BusyxplanlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Long getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Long noncyc) {
		this.noncyc = noncyc;
	}

}
