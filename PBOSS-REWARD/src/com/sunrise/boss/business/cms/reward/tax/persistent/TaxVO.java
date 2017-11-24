package com.sunrise.boss.business.cms.reward.tax.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TaxVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Short taxtype;

    /** nullable persistent field */
    private String parameter;

    /** nullable persistent field */
    private Float value;

    /** full constructor */
    public TaxVO(java.lang.Long seq, java.lang.Short cityid, java.lang.Short taxtype, java.lang.String parameter, java.lang.Float value) {
        this.seq = seq;
        this.cityid = cityid;
        this.taxtype = taxtype;
        this.parameter = parameter;
        this.value = value;
    }

    /** default constructor */
    public TaxVO() {
    }

    /** minimal constructor */
    public TaxVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getTaxtype() {
        return this.taxtype;
    }

    public void setTaxtype(java.lang.Short taxtype) {
        this.taxtype = taxtype;
    }

    public java.lang.String getParameter() {
        return this.parameter;
    }

    public void setParameter(java.lang.String parameter) {
        this.parameter = parameter;
    }

    public java.lang.Float getValue() {
        return this.value;
    }

    public void setValue(java.lang.Float value) {
        this.value = value;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TaxVO) ) return false;
        TaxVO castOther = (TaxVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
