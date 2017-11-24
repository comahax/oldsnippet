package com.gmcc.pboss.business.channel.waytype;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaytypeVO extends BaseVO implements Serializable {

    /** identifier field */
    private String waytypecode;

    /** nullable persistent field */
    private String waytypename;

    /** nullable persistent field */
    private String uppercode;

    /** nullable persistent field */
    private String desp;

    /** full constructor */
    public WaytypeVO(java.lang.String waytypecode, java.lang.String waytypename, java.lang.String uppercode, java.lang.String desp) {
        this.waytypecode = waytypecode;
        this.waytypename = waytypename;
        this.uppercode = uppercode;
        this.desp = desp;
    }

    /** default constructor */
    public WaytypeVO() {
    }

    /** minimal constructor */
    public WaytypeVO(java.lang.String waytypecode) {
        this.waytypecode = waytypecode;
    }

    public java.lang.String getWaytypecode() {
        return this.waytypecode;
    }

    public void setWaytypecode(java.lang.String waytypecode) {
        this.waytypecode = waytypecode;
    }

    public java.lang.String getWaytypename() {
        return this.waytypename;
    }

    public void setWaytypename(java.lang.String waytypename) {
        this.waytypename = waytypename;
    }

    public java.lang.String getUppercode() {
        return this.uppercode;
    }

    public void setUppercode(java.lang.String uppercode) {
        this.uppercode = uppercode;
    }

    public java.lang.String getDesp() {
        return this.desp;
    }

    public void setDesp(java.lang.String desp) {
        this.desp = desp;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("waytypecode", getWaytypecode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaytypeVO) ) return false;
        WaytypeVO castOther = (WaytypeVO) other;
        return new EqualsBuilder()
            .append(this.getWaytypecode(), castOther.getWaytypecode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWaytypecode())
            .toHashCode();
    }

}
