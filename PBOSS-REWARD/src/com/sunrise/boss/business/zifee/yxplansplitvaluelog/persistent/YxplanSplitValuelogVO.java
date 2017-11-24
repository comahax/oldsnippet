package com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxplanSplitValuelogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.sql.Timestamp optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Integer billcycle;

    /** nullable persistent field */
    private String brandid;

    /** nullable persistent field */
    private String itemid;

    /** nullable persistent field */
    private Double splitfee;

    /** full constructor */
    public YxplanSplitValuelogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer billcycle, java.lang.String brandid, java.lang.String itemid, java.lang.Double splitfee) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.billcycle = billcycle;
        this.brandid = brandid;
        this.itemid = itemid;
        this.splitfee = splitfee;
    }

    /** default constructor */
    public YxplanSplitValuelogVO() {
    }

    /** minimal constructor */
    public YxplanSplitValuelogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.sql.Timestamp getOptime() {
        return this.optime;
    }

    public void setOptime(java.sql.Timestamp optime) {
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

    public java.lang.Integer getBillcycle() {
        return this.billcycle;
    }

    public void setBillcycle(java.lang.Integer billcycle) {
        this.billcycle = billcycle;
    }

    public java.lang.String getBrandid() {
        return this.brandid;
    }

    public void setBrandid(java.lang.String brandid) {
        this.brandid = brandid;
    }

    public java.lang.String getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.String itemid) {
        this.itemid = itemid;
    }

    public java.lang.Double getSplitfee() {
        return this.splitfee;
    }

    public void setSplitfee(java.lang.Double splitfee) {
        this.splitfee = splitfee;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxplanSplitValuelogVO) ) return false;
        YxplanSplitValuelogVO castOther = (YxplanSplitValuelogVO) other;
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
