package com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyOprtcostlogVO implements Serializable {

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
    private Short citylevel;

    /** nullable persistent field */
    private Short ctype;

    /** nullable persistent field */
    private Double cost;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ChZjtyOprtcostlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Short citylevel, java.lang.Short ctype, java.lang.Double cost, java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.citylevel = citylevel;
        this.ctype = ctype;
        this.cost = cost;
        this.memo = memo;
    }

    /** default constructor */
    public ChZjtyOprtcostlogVO() {
    }

    /** minimal constructor */
    public ChZjtyOprtcostlogVO(java.lang.Long logid) {
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

    public java.lang.Short getCitylevel() {
        return this.citylevel;
    }

    public void setCitylevel(java.lang.Short citylevel) {
        this.citylevel = citylevel;
    }

    public java.lang.Short getCtype() {
        return this.ctype;
    }

    public void setCtype(java.lang.Short ctype) {
        this.ctype = ctype;
    }

    public java.lang.Double getCost() {
        return this.cost;
    }

    public void setCost(java.lang.Double cost) {
        this.cost = cost;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyOprtcostlogVO) ) return false;
        ChZjtyOprtcostlogVO castOther = (ChZjtyOprtcostlogVO) other;
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
