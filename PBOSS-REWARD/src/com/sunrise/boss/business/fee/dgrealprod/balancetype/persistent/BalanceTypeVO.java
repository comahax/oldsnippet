package com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BalanceTypeVO implements Serializable {

    /** identifier field */
    private String brand;

    /** nullable persistent field */
    private Long eboxunitid1;

    /** nullable persistent field */
    private Long eboxunitid2;

    /** nullable persistent field */
    private Long eboxunitid3;

    /** nullable persistent field */
    private Long eboxunitid4;

    /** nullable persistent field */
    private Long eboxunitid5;

    /** nullable persistent field */
    private Long eboxunitid6;

    /** nullable persistent field */
    private Long eboxunitid7;

    /** nullable persistent field */
    private Long eboxunitid8;

    /** nullable persistent field */
    private Integer balancetype;

   

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Long getEboxunitid1() {
        return this.eboxunitid1;
    }

    public void setEboxunitid1(java.lang.Long eboxunitid1) {
        this.eboxunitid1 = eboxunitid1;
    }

    public java.lang.Long getEboxunitid2() {
        return this.eboxunitid2;
    }

    public void setEboxunitid2(java.lang.Long eboxunitid2) {
        this.eboxunitid2 = eboxunitid2;
    }

    public java.lang.Long getEboxunitid3() {
        return this.eboxunitid3;
    }

    public void setEboxunitid3(java.lang.Long eboxunitid3) {
        this.eboxunitid3 = eboxunitid3;
    }

    public java.lang.Long getEboxunitid4() {
        return this.eboxunitid4;
    }

    public void setEboxunitid4(java.lang.Long eboxunitid4) {
        this.eboxunitid4 = eboxunitid4;
    }

    public java.lang.Long getEboxunitid5() {
        return this.eboxunitid5;
    }

    public void setEboxunitid5(java.lang.Long eboxunitid5) {
        this.eboxunitid5 = eboxunitid5;
    }

    public java.lang.Long getEboxunitid6() {
        return this.eboxunitid6;
    }

    public void setEboxunitid6(java.lang.Long eboxunitid6) {
        this.eboxunitid6 = eboxunitid6;
    }

    public java.lang.Long getEboxunitid7() {
        return this.eboxunitid7;
    }

    public void setEboxunitid7(java.lang.Long eboxunitid7) {
        this.eboxunitid7 = eboxunitid7;
    }

    public java.lang.Long getEboxunitid8() {
        return this.eboxunitid8;
    }

    public void setEboxunitid8(java.lang.Long eboxunitid8) {
        this.eboxunitid8 = eboxunitid8;
    }

    public java.lang.Integer getBalancetype() {
        return this.balancetype;
    }

    public void setBalancetype(java.lang.Integer balancetype) {
        this.balancetype = balancetype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BalanceTypeVO) ) return false;
        BalanceTypeVO castOther = (BalanceTypeVO) other;
        return new EqualsBuilder()
            .append(this.getBrand(), castOther.getBrand())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrand())
            .toHashCode();
    }

}
