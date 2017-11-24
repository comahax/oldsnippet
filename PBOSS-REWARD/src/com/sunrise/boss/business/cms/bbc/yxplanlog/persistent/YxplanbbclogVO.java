package com.sunrise.boss.business.cms.bbc.yxplanlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxplanbbclogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Double wrapfee;

    /** full constructor */
    public YxplanbbclogVO(java.lang.Long logid, java.lang.String oprcode, java.util.Date optime, java.lang.String success, java.lang.String cityid, java.lang.String opnid, java.lang.String oprtype, java.lang.Long yxplanid, java.lang.Double wrapfee) {
        this.logid = logid;
        this.oprcode = oprcode;
        this.optime = optime;
        this.success = success;
        this.cityid = cityid;
        this.opnid = opnid;
        this.oprtype = oprtype;
        this.yxplanid = yxplanid;
        this.wrapfee = wrapfee;
    }

    /** default constructor */
    public YxplanbbclogVO() {
    }

    /** minimal constructor */
    public YxplanbbclogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Double getWrapfee() {
        return this.wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee) {
        this.wrapfee = wrapfee;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxplanbbclogVO) ) return false;
        YxplanbbclogVO castOther = (YxplanbbclogVO) other;
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
