package com.gmcc.pboss.business.sales.monorderinfo;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MonorderinfoVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private String month;

    /** persistent field */
    private String brand;

    /** nullable persistent field */
    private Long topamt;

    /** nullable persistent field */
    private Long actualamt;

    /** nullable persistent field */
    private Long actamt;

    /** nullable persistent field */
    private java.util.Date updatetime;

    /** full constructor */
    public MonorderinfoVO(java.lang.String wayid, java.lang.String month, java.lang.String brand, java.lang.Long topamt, java.lang.Long actualamt, java.lang.Long actamt, java.util.Date updatetime) {
        this.wayid = wayid;
        this.month = month;
        this.brand = brand;
        this.topamt = topamt;
        this.actualamt = actualamt;
        this.actamt = actamt;
        this.updatetime = updatetime;
    }

    /** default constructor */
    public MonorderinfoVO() {
    }

    /** minimal constructor */
    public MonorderinfoVO(java.lang.String wayid, java.lang.String month, java.lang.String brand) {
        this.wayid = wayid;
        this.month = month;
        this.brand = brand;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getMonth() {
        return this.month;
    }

    public void setMonth(java.lang.String month) {
        this.month = month;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Long getTopamt() {
        return this.topamt;
    }

    public void setTopamt(java.lang.Long topamt) {
        this.topamt = topamt;
    }

    public java.lang.Long getActualamt() {
        return this.actualamt;
    }

    public void setActualamt(java.lang.Long actualamt) {
        this.actualamt = actualamt;
    }

    public java.lang.Long getActamt() {
        return this.actamt;
    }

    public void setActamt(java.lang.Long actamt) {
        this.actamt = actamt;
    }

    public java.util.Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime) {
        this.updatetime = updatetime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MonorderinfoVO) ) return false;
        MonorderinfoVO castOther = (MonorderinfoVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
