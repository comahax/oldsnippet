package com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ZjtyBusitosmpVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private Long comid;

    /** identifier field */
    private String opnid;

    /** nullable persistent field */
    private Byte brand;

    /** nullable persistent field */
    private Long comprice;

    /** nullable persistent field */
    private String sort;

    /** full constructor */
    public ZjtyBusitosmpVO(java.lang.String cityid, java.lang.Long comid, java.lang.String opnid, java.lang.Byte brand, java.lang.Long comprice, java.lang.String sort) {
        this.cityid = cityid;
        this.comid = comid;
        this.opnid = opnid;
        this.brand = brand;
        this.comprice = comprice;
        this.sort = sort;
    }

    /** default constructor */
    public ZjtyBusitosmpVO() {
    }

    /** minimal constructor */
    public ZjtyBusitosmpVO(java.lang.String cityid, java.lang.Long comid, java.lang.String opnid) {
        this.cityid = cityid;
        this.comid = comid;
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

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Byte getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Byte brand) {
        this.brand = brand;
    }

    public java.lang.Long getComprice() {
        return this.comprice;
    }

    public void setComprice(java.lang.Long comprice) {
        this.comprice = comprice;
    }

    public java.lang.String getSort() {
        return this.sort;
    }

    public void setSort(java.lang.String sort) {
        this.sort = sort;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("comid", getComid())
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyBusitosmpVO) ) return false;
        ZjtyBusitosmpVO castOther = (ZjtyBusitosmpVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getComid(), castOther.getComid())
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getComid())
            .append(getOpnid())
            .toHashCode();
    }

//	public Class logVOClass() {
//		// TODO Auto-generated method stub
//		return ZjtyBusitosmplogVO.class;
//	}

}
