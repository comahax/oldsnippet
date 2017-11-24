package com.sunrise.boss.business.cms.bbc.subtractlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SubtractlogVO implements Serializable {

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
    private String onceopnid;

    /** nullable persistent field */
    private String intvopnid;

    /** nullable persistent field */
    private String empmobile;

    /** nullable persistent field */
    private String blackmobile;

    /** nullable persistent field */
    private String calcmonth;

    /** full constructor */
    public SubtractlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String onceopnid, java.lang.String intvopnid, java.lang.String empmobile, java.lang.String blackmobile, java.lang.String calcmonth) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.onceopnid = onceopnid;
        this.intvopnid = intvopnid;
        this.empmobile = empmobile;
        this.blackmobile = blackmobile;
        this.calcmonth = calcmonth;
    }

    /** default constructor */
    public SubtractlogVO() {
    }

    /** minimal constructor */
    public SubtractlogVO(java.lang.Long logid) {
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

    public java.lang.String getOnceopnid() {
        return this.onceopnid;
    }

    public void setOnceopnid(java.lang.String onceopnid) {
        this.onceopnid = onceopnid;
    }

    public java.lang.String getIntvopnid() {
        return this.intvopnid;
    }

    public void setIntvopnid(java.lang.String intvopnid) {
        this.intvopnid = intvopnid;
    }

    public java.lang.String getEmpmobile() {
        return this.empmobile;
    }

    public void setEmpmobile(java.lang.String empmobile) {
        this.empmobile = empmobile;
    }

    public java.lang.String getBlackmobile() {
        return this.blackmobile;
    }

    public void setBlackmobile(java.lang.String blackmobile) {
        this.blackmobile = blackmobile;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SubtractlogVO) ) return false;
        SubtractlogVO castOther = (SubtractlogVO) other;
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
