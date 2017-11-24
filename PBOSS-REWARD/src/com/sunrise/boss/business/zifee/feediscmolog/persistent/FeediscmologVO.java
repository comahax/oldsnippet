package com.sunrise.boss.business.zifee.feediscmolog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FeediscmologVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long discid;

    /** nullable persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Short disctype;

    /** nullable persistent field */
    private Double discvalue;

    /** nullable persistent field */
    private Integer presentprio;

    /** nullable persistent field */
    private Byte presentbalanceflag;

    /** nullable persistent field */
    private String discbill;

    /** nullable persistent field */
    private String excludebill;

    /** full constructor */
    public FeediscmologVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long discid, java.lang.Long yxplanid, java.lang.Short disctype, java.lang.Double discvalue, java.lang.Integer presentprio, java.lang.Byte presentbalanceflag, java.lang.String discbill, java.lang.String excludebill) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.discid = discid;
        this.yxplanid = yxplanid;
        this.disctype = disctype;
        this.discvalue = discvalue;
        this.presentprio = presentprio;
        this.presentbalanceflag = presentbalanceflag;
        this.discbill = discbill;
        this.excludebill = excludebill;
    }

    /** default constructor */
    public FeediscmologVO() {
    }

    /** minimal constructor */
    public FeediscmologVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
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

    public java.lang.Long getDiscid() {
        return this.discid;
    }

    public void setDiscid(java.lang.Long discid) {
        this.discid = discid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Short getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.Short disctype) {
        this.disctype = disctype;
    }

    public java.lang.Double getDiscvalue() {
        return this.discvalue;
    }

    public void setDiscvalue(java.lang.Double discvalue) {
        this.discvalue = discvalue;
    }

    public java.lang.Integer getPresentprio() {
        return this.presentprio;
    }

    public void setPresentprio(java.lang.Integer presentprio) {
        this.presentprio = presentprio;
    }

    public java.lang.Byte getPresentbalanceflag() {
        return this.presentbalanceflag;
    }

    public void setPresentbalanceflag(java.lang.Byte presentbalanceflag) {
        this.presentbalanceflag = presentbalanceflag;
    }

    public java.lang.String getDiscbill() {
        return this.discbill;
    }

    public void setDiscbill(java.lang.String discbill) {
        this.discbill = discbill;
    }

    public java.lang.String getExcludebill() {
        return this.excludebill;
    }

    public void setExcludebill(java.lang.String excludebill) {
        this.excludebill = excludebill;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FeediscmologVO) ) return false;
        FeediscmologVO castOther = (FeediscmologVO) other;
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
