package com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.persistent.ChZjtyEmpltotallogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChZjtyEmpltotalVO implements Serializable,OperationLog{

    /** identifier field */
    private String wayid;

    /** identifier field */
    private String yearmonth;

    /** nullable persistent field */
    private Double amount;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ChZjtyEmpltotalVO(java.lang.String wayid, java.lang.String yearmonth, java.lang.Double amount, java.lang.String memo) {
        this.wayid = wayid;
        this.yearmonth = yearmonth;
        this.amount = amount;
        this.memo = memo;
    }

    /** default constructor */
    public ChZjtyEmpltotalVO() {
    }

    /** minimal constructor */
    public ChZjtyEmpltotalVO(java.lang.String wayid, java.lang.String yearmonth) {
        this.wayid = wayid;
        this.yearmonth = yearmonth;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getYearmonth() {
        return this.yearmonth;
    }

    public void setYearmonth(java.lang.String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public java.lang.Double getAmount() {
        return this.amount;
    }

    public void setAmount(java.lang.Double amount) {
        this.amount = amount;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .append("yearmonth", getYearmonth())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyEmpltotalVO) ) return false;
        ChZjtyEmpltotalVO castOther = (ChZjtyEmpltotalVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getYearmonth(), castOther.getYearmonth())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .append(getYearmonth())
            .toHashCode();
    }
    public Class logVOClass() {
    	// TODO Auto-generated method stub
    	return ChZjtyEmpltotallogVO.class;
    }
}
