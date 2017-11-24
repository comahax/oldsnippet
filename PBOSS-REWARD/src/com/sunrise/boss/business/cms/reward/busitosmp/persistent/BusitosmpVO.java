package com.sunrise.boss.business.cms.reward.busitosmp.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.busitosmplog.persistent.BusitosmplogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BusitosmpVO implements OperationLog {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private Integer comclassid;

    /** identifier field */
    private Long comprice;

    /** identifier field */
    private String opnid;

    /** nullable persistent field */
    private Byte brand;
    
    private Long comid;

    /** full constructor */
    public BusitosmpVO(java.lang.String cityid, java.lang.Integer comclassid, java.lang.Long comprice, java.lang.String opnid, java.lang.Byte brand) {
        this.cityid = cityid;
        this.comclassid = comclassid;
        this.comprice = comprice;
        this.opnid = opnid;
        this.brand = brand;
    }

    /** default constructor */
    public BusitosmpVO() {
    }

    /** minimal constructor */
    public BusitosmpVO(java.lang.String cityid, java.lang.Integer comclassid, java.lang.Long comprice, java.lang.String opnid) {
        this.cityid = cityid;
        this.comclassid = comclassid;
        this.comprice = comprice;
        this.opnid = opnid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("comclassid", getComclassid())
            .append("comprice", getComprice())
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusitosmpVO) ) return false;
        BusitosmpVO castOther = (BusitosmpVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getComclassid(), castOther.getComclassid())
            .append(this.getComprice(), castOther.getComprice())
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getComclassid())
            .append(getComprice())
            .append(getOpnid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return BusitosmplogVO.class;
	}

}
