package com.sunrise.boss.business.cms.provagent.chpdsubscriptionlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdSubscriptionlogVO implements Serializable {

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

    /** persistent field */
    private String provagentid;

    /** persistent field */
    private String prodno;

    /** nullable persistent field */
    private String custid;

    /** nullable persistent field */
    private String custname;

    /** nullable persistent field */
    private String prodid;

    /** nullable persistent field */
    private java.util.Date inbosstime;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String salesi;

    /** nullable persistent field */
    private String servsi;

    /** nullable persistent field */
    private String agenteeid;

    /** nullable persistent field */
    private Byte coopertype;

    /** nullable persistent field */
    private java.util.Date incomstime;

    /** nullable persistent field */
    private Byte validation;

    /** nullable persistent field */
    private Byte origin;

    /** full constructor */
    public ChPdSubscriptionlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String provagentid, java.lang.String prodno, java.lang.String custid, java.lang.String custname, java.lang.String prodid, java.util.Date inbosstime, java.lang.String cityid, java.lang.String salesi, java.lang.String servsi, java.lang.String agenteeid, java.lang.Byte coopertype, java.util.Date incomstime, java.lang.Byte validation, java.lang.Byte origin) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.provagentid = provagentid;
        this.prodno = prodno;
        this.custid = custid;
        this.custname = custname;
        this.prodid = prodid;
        this.inbosstime = inbosstime;
        this.cityid = cityid;
        this.salesi = salesi;
        this.servsi = servsi;
        this.agenteeid = agenteeid;
        this.coopertype = coopertype;
        this.incomstime = incomstime;
        this.validation = validation;
        this.origin = origin;
    }

    /** default constructor */
    public ChPdSubscriptionlogVO() {
    }

    /** minimal constructor */
    public ChPdSubscriptionlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String provagentid, java.lang.String prodno) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.provagentid = provagentid;
        this.prodno = prodno;
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

    public java.lang.String getProvagentid() {
        return this.provagentid;
    }

    public void setProvagentid(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getProdno() {
        return this.prodno;
    }

    public void setProdno(java.lang.String prodno) {
        this.prodno = prodno;
    }

    public java.lang.String getCustid() {
        return this.custid;
    }

    public void setCustid(java.lang.String custid) {
        this.custid = custid;
    }

    public java.lang.String getCustname() {
        return this.custname;
    }

    public void setCustname(java.lang.String custname) {
        this.custname = custname;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.util.Date getInbosstime() {
        return this.inbosstime;
    }

    public void setInbosstime(java.util.Date inbosstime) {
        this.inbosstime = inbosstime;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getSalesi() {
        return this.salesi;
    }

    public void setSalesi(java.lang.String salesi) {
        this.salesi = salesi;
    }

    public java.lang.String getServsi() {
        return this.servsi;
    }

    public void setServsi(java.lang.String servsi) {
        this.servsi = servsi;
    }

    public java.lang.String getAgenteeid() {
        return this.agenteeid;
    }

    public void setAgenteeid(java.lang.String agenteeid) {
        this.agenteeid = agenteeid;
    }

    public java.lang.Byte getCoopertype() {
        return this.coopertype;
    }

    public void setCoopertype(java.lang.Byte coopertype) {
        this.coopertype = coopertype;
    }

    public java.util.Date getIncomstime() {
        return this.incomstime;
    }

    public void setIncomstime(java.util.Date incomstime) {
        this.incomstime = incomstime;
    }

    public java.lang.Byte getValidation() {
        return this.validation;
    }

    public void setValidation(java.lang.Byte validation) {
        this.validation = validation;
    }

    public java.lang.Byte getOrigin() {
        return this.origin;
    }

    public void setOrigin(java.lang.Byte origin) {
        this.origin = origin;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdSubscriptionlogVO) ) return false;
        ChPdSubscriptionlogVO castOther = (ChPdSubscriptionlogVO) other;
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
