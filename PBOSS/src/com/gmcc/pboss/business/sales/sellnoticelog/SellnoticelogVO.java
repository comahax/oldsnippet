package com.gmcc.pboss.business.sales.sellnoticelog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SellnoticelogVO extends BaseVO implements Serializable {

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
    private Long seqid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private String selltime;

    /** nullable persistent field */
    private Long sellcount;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String waymagcode;

    /** nullable persistent field */
    private Long salesstd;

    /** nullable persistent field */
    private java.lang.Double comrate;

    /** full constructor */
    public SellnoticelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.String countyid, java.lang.String mareacode, java.lang.String selltime, java.lang.Long sellcount, java.lang.Short starlevel, java.lang.String wayid, java.lang.String waymagcode, java.lang.Long salesstd, java.lang.Double comrate) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.countyid = countyid;
        this.mareacode = mareacode;
        this.selltime = selltime;
        this.sellcount = sellcount;
        this.starlevel = starlevel;
        this.wayid = wayid;
        this.waymagcode = waymagcode;
        this.salesstd = salesstd;
        this.comrate = comrate;
    }

    /** default constructor */
    public SellnoticelogVO() {
    }

    /** minimal constructor */
    public SellnoticelogVO(java.lang.Long logid) {
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

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.String getSelltime() {
        return this.selltime;
    }

    public void setSelltime(java.lang.String selltime) {
        this.selltime = selltime;
    }

    public java.lang.Long getSellcount() {
        return this.sellcount;
    }

    public void setSellcount(java.lang.Long sellcount) {
        this.sellcount = sellcount;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWaymagcode() {
        return this.waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public java.lang.Long getSalesstd() {
        return this.salesstd;
    }

    public void setSalesstd(java.lang.Long salesstd) {
        this.salesstd = salesstd;
    }

    public java.lang.Double getComrate() {
        return this.comrate;
    }

    public void setComrate(java.lang.Double comrate) {
        this.comrate = comrate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SellnoticelogVO) ) return false;
        SellnoticelogVO castOther = (SellnoticelogVO) other;
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
