package com.sunrise.boss.business.cms.examine.coefficient.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CoefficientVO implements Serializable {

    /** identifier field */
    private Integer exmnid;

    /** identifier field */
    private String exmnperiod;

    /** identifier field */
    private String wayid;

    private Double coefficientsum;
    /** nullable persistent field */
    private Double coefficient;
    


    /** full constructor */
    public CoefficientVO(java.lang.Integer exmnid, java.lang.String exmnperiod, java.lang.String wayid, java.lang.Double coefficientsum, java.lang.Double coefficient) {
        this.exmnid = exmnid;
        this.exmnperiod = exmnperiod;
        this.wayid = wayid;
        this.coefficientsum = coefficientsum;
        this.coefficient = coefficient;
    }

    /** default constructor */
    public CoefficientVO() {
    }

    /** minimal constructor */
    public CoefficientVO(java.lang.Integer exmnid, java.lang.String exmnperiod, java.lang.String wayid) {
        this.exmnid = exmnid;
        this.exmnperiod = exmnperiod;
        this.wayid = wayid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getCoefficient() {
        return this.coefficient;
    }

    public void setCoefficient(java.lang.Double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("exmnid", getExmnid())
            .append("exmnperiod", getExmnperiod())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CoefficientVO) ) return false;
        CoefficientVO castOther = (CoefficientVO) other;
        return new EqualsBuilder()
            .append(this.getExmnid(), castOther.getExmnid())
            .append(this.getExmnperiod(), castOther.getExmnperiod())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExmnid())
            .append(getExmnperiod())
            .append(getWayid())
            .toHashCode();
    }

	public Double getCoefficientsum() {
		return coefficientsum;
	}

	public void setCoefficientsum(Double coefficientsum) {
		this.coefficientsum = coefficientsum;
	}

}
