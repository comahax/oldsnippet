package com.sunrise.boss.business.cms.reward.busitocom.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BusitocomVO implements OperationLog {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private Long comid;

    /** identifier field */
    private String comresid;

    /** identifier field */
    private Integer comtype;

    /** identifier field */
    private String opnid;

    /** nullable persistent field */
    private Integer comclassid;

    /** nullable persistent field */
    private Long pricelow;

    /** nullable persistent field */
    private Long pricetop;

    /** nullable persistent field */
    private String busitype;

    /** full constructor */
    public BusitocomVO(java.lang.String cityid, java.lang.Long comid, java.lang.String comresid, java.lang.Integer comtype, java.lang.String opnid, java.lang.Integer comclassid, java.lang.Long pricelow, java.lang.Long pricetop, java.lang.String busitype) {
        this.cityid = cityid;
        this.comid = comid;
        this.comresid = comresid;
        this.comtype = comtype;
        this.opnid = opnid;
        this.comclassid = comclassid;
        this.pricelow = pricelow;
        this.pricetop = pricetop;
        this.busitype = busitype;
    }

    /** default constructor */
    public BusitocomVO() {
    }

    /** minimal constructor */
    public BusitocomVO(java.lang.String cityid, java.lang.Long comid, java.lang.String comresid, java.lang.Integer comtype, java.lang.String opnid) {
        this.cityid = cityid;
        this.comid = comid;
        this.comresid = comresid;
        this.comtype = comtype;
        this.opnid = opnid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
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

    public java.lang.Integer getComtype() {
        return this.comtype;
    }

    public void setComtype(java.lang.Integer comtype) {
        this.comtype = comtype;
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
            .append("cityid", getCityid())
            .append("comid", getComid())
            .append("comresid", getComresid())
            .append("comtype", getComtype())
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusitocomVO) ) return false;
        BusitocomVO castOther = (BusitocomVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getComid(), castOther.getComid())
            .append(this.getComresid(), castOther.getComresid())
            .append(this.getComtype(), castOther.getComtype())
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getComid())
            .append(getComresid())
            .append(getComtype())
            .append(getOpnid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return BusitocomlogVO.class;
	}

}
