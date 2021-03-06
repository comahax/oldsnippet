package com.gmcc.pboss.business.channel.microarea;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MicroareaVO extends BaseVO implements Serializable {

    /** identifier field */
    private String macode;

    /** identifier field */
    private String maname;

    /** identifier field */
    private String svccode;

    /** nullable persistent field */
    private Short matype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;

    /** nullable persistent field */
    private String adacode;

    /** nullable persistent field */
    private String longitude;

    /** nullable persistent field */
    private String latitude;

    /** full constructor */
    public MicroareaVO(java.lang.String macode, java.lang.String maname, java.lang.String svccode, java.lang.Short matype, java.lang.String agent, java.lang.String billingcode, java.lang.String adacode, java.lang.String longitude, java.lang.String latitude) {
        this.macode = macode;
        this.maname = maname;
        this.svccode = svccode;
        this.matype = matype;
        this.agent = agent;
        this.billingcode = billingcode;
        this.adacode = adacode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /** default constructor */
    public MicroareaVO() {
    }

    /** minimal constructor */
    public MicroareaVO(java.lang.String macode, java.lang.String maname, java.lang.String svccode) {
        this.macode = macode;
        this.maname = maname;
        this.svccode = svccode;
    }

    public java.lang.String getMacode() {
        return this.macode;
    }

    public void setMacode(java.lang.String macode) {
        this.macode = macode;
    }

    public java.lang.String getManame() {
        return this.maname;
    }

    public void setManame(java.lang.String maname) {
        this.maname = maname;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.Short getMatype() {
        return this.matype;
    }

    public void setMatype(java.lang.Short matype) {
        this.matype = matype;
    }

    public java.lang.String getAgent() {
        return this.agent;
    }

    public void setAgent(java.lang.String agent) {
        this.agent = agent;
    }

    public java.lang.String getBillingcode() {
        return this.billingcode;
    }

    public void setBillingcode(java.lang.String billingcode) {
        this.billingcode = billingcode;
    }

    public java.lang.String getAdacode() {
        return this.adacode;
    }

    public void setAdacode(java.lang.String adacode) {
        this.adacode = adacode;
    }

    public java.lang.String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(java.lang.String longitude) {
        this.longitude = longitude;
    }

    public java.lang.String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(java.lang.String latitude) {
        this.latitude = latitude;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("macode", getMacode())
            .append("maname", getManame())
            .append("svccode", getSvccode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MicroareaVO) ) return false;
        MicroareaVO castOther = (MicroareaVO) other;
        return new EqualsBuilder()
            .append(this.getMacode(), castOther.getMacode())
            .append(this.getManame(), castOther.getManame())
            .append(this.getSvccode(), castOther.getSvccode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMacode())
            .append(getManame())
            .append(getSvccode())
            .toHashCode();
    }

}
