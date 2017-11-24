package com.gmcc.pboss.business.sales.alaordercol;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AlaordercolVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String coldate;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String macode;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String alarmlevel;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Long amount;

    /** nullable persistent field */
    private Integer orderamt;

    /** nullable persistent field */
    private Integer cancelamt;

    /** nullable persistent field */
    private Integer overamt;

    /** nullable persistent field */
    private java.util.Date updatetime;

    /** full constructor */
    public AlaordercolVO(java.lang.String coldate, java.lang.String countyid, java.lang.String svccode, java.lang.String macode, java.lang.Short starlevel, java.lang.String alarmlevel, java.lang.String brand, java.lang.Long amount, java.lang.Integer orderamt, java.lang.Integer cancelamt, java.lang.Integer overamt, java.util.Date updatetime) {
        this.coldate = coldate;
        this.countyid = countyid;
        this.svccode = svccode;
        this.macode = macode;
        this.starlevel = starlevel;
        this.alarmlevel = alarmlevel;
        this.brand = brand;
        this.amount = amount;
        this.orderamt = orderamt;
        this.cancelamt = cancelamt;
        this.overamt = overamt;
        this.updatetime = updatetime;
    }

    /** default constructor */
    public AlaordercolVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getColdate() {
        return this.coldate;
    }

    public void setColdate(java.lang.String coldate) {
        this.coldate = coldate;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getMacode() {
        return this.macode;
    }

    public void setMacode(java.lang.String macode) {
        this.macode = macode;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getAlarmlevel() {
        return this.alarmlevel;
    }

    public void setAlarmlevel(java.lang.String alarmlevel) {
        this.alarmlevel = alarmlevel;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Long getAmount() {
        return this.amount;
    }

    public void setAmount(java.lang.Long amount) {
        this.amount = amount;
    }

    public java.lang.Integer getOrderamt() {
        return this.orderamt;
    }

    public void setOrderamt(java.lang.Integer orderamt) {
        this.orderamt = orderamt;
    }

    public java.lang.Integer getCancelamt() {
        return this.cancelamt;
    }

    public void setCancelamt(java.lang.Integer cancelamt) {
        this.cancelamt = cancelamt;
    }

    public java.lang.Integer getOveramt() {
        return this.overamt;
    }

    public void setOveramt(java.lang.Integer overamt) {
        this.overamt = overamt;
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
        if ( !(other instanceof AlaordercolVO) ) return false;
        AlaordercolVO castOther = (AlaordercolVO) other;
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
