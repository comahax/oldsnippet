package com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyRewardcoeflogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Short coefid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String effectiblemonth;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Double providecoef;

    /** nullable persistent field */
    private String result;

    /** nullable persistent field */
    private Short ispass;

    /** full constructor */
    public ZjtyRewardcoeflogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Short coefid, java.lang.String wayid, java.lang.String effectiblemonth, java.lang.String cityid, java.lang.Double providecoef, java.lang.String result, java.lang.Short ispass) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.coefid = coefid;
        this.wayid = wayid;
        this.effectiblemonth = effectiblemonth;
        this.cityid = cityid;
        this.providecoef = providecoef;
        this.result = result;
        this.ispass = ispass;
    }

    /** default constructor */
    public ZjtyRewardcoeflogVO() {
    }

    /** minimal constructor */
    public ZjtyRewardcoeflogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Short getCoefid() {
        return this.coefid;
    }

    public void setCoefid(java.lang.Short coefid) {
        this.coefid = coefid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getEffectiblemonth() {
        return this.effectiblemonth;
    }

    public void setEffectiblemonth(java.lang.String effectiblemonth) {
        this.effectiblemonth = effectiblemonth;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Double getProvidecoef() {
        return this.providecoef;
    }

    public void setProvidecoef(java.lang.Double providecoef) {
        this.providecoef = providecoef;
    }

    public java.lang.String getResult() {
        return this.result;
    }

    public void setResult(java.lang.String result) {
        this.result = result;
    }

    public java.lang.Short getIspass() {
        return this.ispass;
    }

    public void setIspass(java.lang.Short ispass) {
        this.ispass = ispass;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyRewardcoeflogVO) ) return false;
        ZjtyRewardcoeflogVO castOther = (ZjtyRewardcoeflogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
