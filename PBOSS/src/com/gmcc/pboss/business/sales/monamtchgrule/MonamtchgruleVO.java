package com.gmcc.pboss.business.sales.monamtchgrule;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MonamtchgruleVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long ruleid;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private Short starlevel;

    /** persistent field */
    private String brand;

    /** persistent field */
    private Double actratelow;

    /** persistent field */
    private Double actrateup;

    /** persistent field */
    private Double times;

    /** persistent field */
    private Short effective;

    /** full constructor */
    public MonamtchgruleVO(java.lang.String cityid, java.lang.Short starlevel, java.lang.String brand, java.lang.Double actratelow, java.lang.Double actrateup, java.lang.Double times, java.lang.Short effective) {
        this.cityid = cityid;
        this.starlevel = starlevel;
        this.brand = brand;
        this.actratelow = actratelow;
        this.actrateup = actrateup;
        this.times = times;
        this.effective = effective;
    }

    /** default constructor */
    public MonamtchgruleVO() {
    }

    public java.lang.Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Long ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Double getActratelow() {
        return this.actratelow;
    }

    public void setActratelow(java.lang.Double actratelow) {
        this.actratelow = actratelow;
    }

    public java.lang.Double getActrateup() {
        return this.actrateup;
    }

    public void setActrateup(java.lang.Double actrateup) {
        this.actrateup = actrateup;
    }

    public java.lang.Double getTimes() {
        return this.times;
    }

    public void setTimes(java.lang.Double times) {
        this.times = times;
    }

    public java.lang.Short getEffective() {
        return this.effective;
    }

    public void setEffective(java.lang.Short effective) {
        this.effective = effective;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ruleid", getRuleid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MonamtchgruleVO) ) return false;
        MonamtchgruleVO castOther = (MonamtchgruleVO) other;
        return new EqualsBuilder()
            .append(this.getRuleid(), castOther.getRuleid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRuleid())
            .toHashCode();
    }

}
