package com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChZjtyOprtcostVO implements Serializable,OperationLog {

    /** identifier field */
    private Short citylevel;

    /** identifier field */
    private Short ctype;

    /** nullable persistent field */
    private Double cost;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ChZjtyOprtcostVO(java.lang.Short citylevel, java.lang.Short ctype, java.lang.Double cost, java.lang.String memo) {
        this.citylevel = citylevel;
        this.ctype = ctype;
        this.cost = cost;
        this.memo = memo;
    }

    /** default constructor */
    public ChZjtyOprtcostVO() {
    }

    /** minimal constructor */
    public ChZjtyOprtcostVO(java.lang.Short citylevel, java.lang.Short ctype) {
        this.citylevel = citylevel;
        this.ctype = ctype;
    }

    public java.lang.Short getCitylevel() {
        return this.citylevel;
    }

    public void setCitylevel(java.lang.Short citylevel) {
        this.citylevel = citylevel;
    }

    public java.lang.Short getCtype() {
        return this.ctype;
    }

    public void setCtype(java.lang.Short ctype) {
        this.ctype = ctype;
    }

    public java.lang.Double getCost() {
        return this.cost;
    }

    public void setCost(java.lang.Double cost) {
        this.cost = cost;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("citylevel", getCitylevel())
            .append("ctype", getCtype())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyOprtcostVO) ) return false;
        ChZjtyOprtcostVO castOther = (ChZjtyOprtcostVO) other;
        return new EqualsBuilder()
            .append(this.getCitylevel(), castOther.getCitylevel())
            .append(this.getCtype(), castOther.getCtype())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCitylevel())
            .append(getCtype())
            .toHashCode();
    }
    public Class logVOClass() {
    	// TODO Auto-generated method stub
    	return ChZjtyOprtcostlogVO.class;
    }
}
