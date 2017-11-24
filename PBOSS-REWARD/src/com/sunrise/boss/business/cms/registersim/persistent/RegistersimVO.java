package com.sunrise.boss.business.cms.registersim.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RegistersimVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String posvalid;

    /** nullable persistent field */
    private Short posdiff;

    /** nullable persistent field */
    private Short brand;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String imei;

    /** nullable persistent field */
    private String imsi;

    /** nullable persistent field */
    private java.util.Date addtime;

    /** nullable persistent field */
    private Integer comclassid;

    /** nullable persistent field */
    private Long comprice;

    /** nullable persistent field */
    private Short mendfalg;
    
    private java.util.Date mendtime;
    private String scontent;
    

    /** full constructor */
    public RegistersimVO(java.lang.String cityid, java.lang.String oprcode, java.lang.String wayid, java.lang.String opnid, java.lang.String mobile, java.lang.String posvalid, java.lang.Short posdiff, java.lang.Short brand, java.util.Date oprtime, java.lang.String imei, java.lang.String imsi, java.util.Date addtime, java.lang.Integer comclassid, java.lang.Long comprice, java.lang.Short mendfalg,java.util.Date mendtime,java.lang.String scontent) {
        this.cityid = cityid;
        this.oprcode = oprcode;
        this.wayid = wayid;
        this.opnid = opnid;
        this.mobile = mobile;
        this.posvalid = posvalid;
        this.posdiff = posdiff;
        this.brand = brand;
        this.oprtime = oprtime;
        this.imei = imei;
        this.imsi = imsi;
        this.addtime = addtime;
        this.comclassid = comclassid;
        this.comprice = comprice;
        this.mendfalg = mendfalg;
        this.mendtime = mendtime;
        this.scontent = scontent;
    }

    /** default constructor */
    public RegistersimVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getPosvalid() {
        return this.posvalid;
    }

    public void setPosvalid(java.lang.String posvalid) {
        this.posvalid = posvalid;
    }

    public java.lang.Short getPosdiff() {
        return this.posdiff;
    }

    public void setPosdiff(java.lang.Short posdiff) {
        this.posdiff = posdiff;
    }

    public java.lang.Short getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Short brand) {
        this.brand = brand;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getImei() {
        return this.imei;
    }

    public void setImei(java.lang.String imei) {
        this.imei = imei;
    }

    public java.lang.String getImsi() {
        return this.imsi;
    }

    public void setImsi(java.lang.String imsi) {
        this.imsi = imsi;
    }

    public java.util.Date getAddtime() {
        return this.addtime;
    }

    public void setAddtime(java.util.Date addtime) {
        this.addtime = addtime;
    }

    public java.lang.Integer getComclassid() {
        return this.comclassid;
    }

    public void setComclassid(java.lang.Integer comclassid) {
        this.comclassid = comclassid;
    }

    public java.lang.Long getComprice() {
        return this.comprice;
    }

    public void setComprice(java.lang.Long comprice) {
        this.comprice = comprice;
    }

    public java.lang.Short getMendfalg() {
        return this.mendfalg;
    }

    public void setMendfalg(java.lang.Short mendfalg) {
        this.mendfalg = mendfalg;
    }

    public java.util.Date getMendtime() {
		return mendtime;
	}

	public void setMendtime(java.util.Date mendtime) {
		this.mendtime = mendtime;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RegistersimVO) ) return false;
        RegistersimVO castOther = (RegistersimVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
