package com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyImportrecVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Byte brand;

    /** nullable persistent field */
    private String datasource;

    /** nullable persistent field */
    private Short validflag;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public ZjtyImportrecVO(java.lang.Long seq, java.lang.String calcmonth, java.lang.String opnid, java.lang.String wayid, java.util.Date oprtime, java.lang.String oprcode, java.lang.String mobile, java.lang.Double busivalue, java.lang.Byte brand, java.lang.String datasource, java.lang.Short validflag, java.lang.String remark) {
        this.seq = seq;
        this.calcmonth = calcmonth;
        this.opnid = opnid;
        this.wayid = wayid;
        this.oprtime = oprtime;
        this.oprcode = oprcode;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.brand = brand;
        this.datasource = datasource;
        this.validflag = validflag;
        this.remark = remark;
    }

    /** default constructor */
    public ZjtyImportrecVO() {
    }

    /** minimal constructor */
    public ZjtyImportrecVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Byte getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Byte brand) {
        this.brand = brand;
    }

    public java.lang.String getDatasource() {
        return this.datasource;
    }

    public void setDatasource(java.lang.String datasource) {
        this.datasource = datasource;
    }

    public java.lang.Short getValidflag() {
        return this.validflag;
    }

    public void setValidflag(java.lang.Short validflag) {
        this.validflag = validflag;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyImportrecVO) ) return false;
        ZjtyImportrecVO castOther = (ZjtyImportrecVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
