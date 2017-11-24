package com.sunrise.boss.business.cms.costcard.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class CostcardVO implements Serializable ,OperationLog{

    /** identifier field */
    private String calcmonth;

    /** identifier field */
    private String opnid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Integer salenum;

    /** full constructor */
    public CostcardVO(java.lang.String calcmonth, java.lang.String opnid, java.lang.String wayid, java.lang.Integer salenum) {
        this.calcmonth = calcmonth;
        this.opnid = opnid;
        this.wayid = wayid;
        this.salenum = salenum;
    }

    /** default constructor */
    public CostcardVO() {
    }

    /** minimal constructor */
    public CostcardVO(java.lang.String calcmonth, java.lang.String opnid, java.lang.String wayid) {
        this.calcmonth = calcmonth;
        this.opnid = opnid;
        this.wayid = wayid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Integer getSalenum() {
        return this.salenum;
    }

    public void setSalenum(java.lang.Integer salenum) {
        this.salenum = salenum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("calcmonth", getCalcmonth())
            .append("opnid", getOpnid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CostcardVO) ) return false;
        CostcardVO castOther = (CostcardVO) other;
        return new EqualsBuilder()
            .append(this.getCalcmonth(), castOther.getCalcmonth())
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCalcmonth())
            .append(getOpnid())
            .append(getWayid())
            .toHashCode();
    }
    public Class logVOClass() {
		return CostcardlogVO.class;
	}
}
