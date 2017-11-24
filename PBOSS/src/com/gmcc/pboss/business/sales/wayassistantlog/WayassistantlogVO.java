package com.gmcc.pboss.business.sales.wayassistantlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayassistantlogVO extends BaseVO implements Serializable {

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
    private String wayid;

    /** nullable persistent field */
    private Short canorder;

    /** nullable persistent field */
    private Short printinvoice;

    /** nullable persistent field */
    private String paytype;

    /** nullable persistent field */
    private String delitype;

    /** nullable persistent field */
    private Short orderbetterno;

    /** full constructor */
    public WayassistantlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String wayid, java.lang.Short canorder, java.lang.Short printinvoice, java.lang.String paytype, java.lang.String delitype, java.lang.Short orderbetterno) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.wayid = wayid;
        this.canorder = canorder;
        this.printinvoice = printinvoice;
        this.paytype = paytype;
        this.delitype = delitype;
        this.orderbetterno = orderbetterno;
    }

    /** default constructor */
    public WayassistantlogVO() {
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getCanorder() {
        return this.canorder;
    }

    public void setCanorder(java.lang.Short canorder) {
        this.canorder = canorder;
    }

    public java.lang.Short getPrintinvoice() {
        return this.printinvoice;
    }

    public void setPrintinvoice(java.lang.Short printinvoice) {
        this.printinvoice = printinvoice;
    }

    public java.lang.String getPaytype() {
        return this.paytype;
    }

    public void setPaytype(java.lang.String paytype) {
        this.paytype = paytype;
    }

    public java.lang.String getDelitype() {
        return this.delitype;
    }

    public void setDelitype(java.lang.String delitype) {
        this.delitype = delitype;
    }

    public java.lang.Short getOrderbetterno() {
        return this.orderbetterno;
    }

    public void setOrderbetterno(java.lang.Short orderbetterno) {
        this.orderbetterno = orderbetterno;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayassistantlogVO) ) return false;
        WayassistantlogVO castOther = (WayassistantlogVO) other;
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
