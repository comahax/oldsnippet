package com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ZjtyBusyxplanVO implements Serializable {

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String prodid;

    /** nullable persistent field */
    private Double wrapfee;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String planbusitype;

    /** full constructor */
    public ZjtyBusyxplanVO(java.lang.String opnid, java.lang.String prodid, java.lang.Double wrapfee, java.lang.String cityid, java.lang.String planbusitype) {
        this.opnid = opnid;
        this.prodid = prodid;
        this.wrapfee = wrapfee;
        this.cityid = cityid;
        this.planbusitype = planbusitype;
    }

    /** default constructor */
    public ZjtyBusyxplanVO() {
    }

    /** minimal constructor */
    public ZjtyBusyxplanVO(java.lang.String opnid, java.lang.String prodid, java.lang.String cityid) {
        this.opnid = opnid;
        this.prodid = prodid;
        this.cityid = cityid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
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

    public java.lang.String getPlanbusitype() {
        return this.planbusitype;
    }

    public void setPlanbusitype(java.lang.String planbusitype) {
        this.planbusitype = planbusitype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .append("prodid", getProdid())
            .append("cityid", getCityid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyBusyxplanVO) ) return false;
        ZjtyBusyxplanVO castOther = (ZjtyBusyxplanVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getProdid(), castOther.getProdid())
            .append(this.getCityid(), castOther.getCityid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getProdid())
            .append(getCityid())
            .toHashCode();
    }

//	public Class logVOClass() {
//		// TODO Auto-generated method stub
//		return ZjtyBusyxplanlogVO.class;
//	}

}
