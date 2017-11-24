package com.gmcc.pboss.business.sales.activerate;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ActiverateVO extends BaseVO implements Serializable {

    /** identifier field */
    private String brand;

    /** identifier field */
    private String wayid;

    /** persistent field */
    private Double rate;

    /** nullable persistent field */
    private Short isachieve;

    /** nullable persistent field */
    private Long difamt;

    /** nullable persistent field */
    private java.util.Date chgtime;

    /** full constructor */
    public ActiverateVO(java.lang.String brand, java.lang.String wayid, java.lang.Double rate, java.lang.Short isachieve, java.lang.Long difamt, java.util.Date chgtime) {
        this.brand = brand;
        this.wayid = wayid;
        this.rate = rate;
        this.isachieve = isachieve;
        this.difamt = difamt;
        this.chgtime = chgtime;
    }

    /** default constructor */
    public ActiverateVO() {
    }

    /** minimal constructor */
    public ActiverateVO(java.lang.String brand, java.lang.String wayid, java.lang.Double rate) {
        this.brand = brand;
        this.wayid = wayid;
        this.rate = rate;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getRate() {
        return this.rate;
    }

    public void setRate(java.lang.Double rate) {
        this.rate = rate;
    }

    public java.lang.Short getIsachieve() {
        return this.isachieve;
    }

    public void setIsachieve(java.lang.Short isachieve) {
        this.isachieve = isachieve;
    }

    public java.lang.Long getDifamt() {
        return this.difamt;
    }

    public void setDifamt(java.lang.Long difamt) {
        this.difamt = difamt;
    }

    public java.util.Date getChgtime() {
        return this.chgtime;
    }

    public void setChgtime(java.util.Date chgtime) {
        this.chgtime = chgtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ActiverateVO) ) return false;
        ActiverateVO castOther = (ActiverateVO) other;
        return new EqualsBuilder()
            .append(this.getBrand(), castOther.getBrand())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrand())
            .append(getWayid())
            .toHashCode();
    }

}
