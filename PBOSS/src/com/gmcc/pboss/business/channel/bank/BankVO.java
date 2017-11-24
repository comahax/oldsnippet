package com.gmcc.pboss.business.channel.bank;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BankVO extends BaseVO implements Serializable {

    /** identifier field */
    private String bankid;

    /** nullable persistent field */
    private String bankname;

    /** nullable persistent field */
    private String uniformcode;

    /** nullable persistent field */
    private String linkphone;

    /** nullable persistent field */
    private String addr;

    /** nullable persistent field */
    private Byte container;

    /** nullable persistent field */
    private String exchangeno;

    /** nullable persistent field */
    private Short banklevel;

    /** nullable persistent field */
    private String parentid;

    /** nullable persistent field */
    private String orgid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public BankVO(java.lang.String bankid, java.lang.String bankname, java.lang.String uniformcode, java.lang.String linkphone, java.lang.String addr, java.lang.Byte container, java.lang.String exchangeno, java.lang.Short banklevel, java.lang.String parentid, java.lang.String orgid, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate) {
        this.bankid = bankid;
        this.bankname = bankname;
        this.uniformcode = uniformcode;
        this.linkphone = linkphone;
        this.addr = addr;
        this.container = container;
        this.exchangeno = exchangeno;
        this.banklevel = banklevel;
        this.parentid = parentid;
        this.orgid = orgid;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public BankVO() {
    }

    /** minimal constructor */
    public BankVO(java.lang.String bankid) {
        this.bankid = bankid;
    }

    public java.lang.String getBankid() {
        return this.bankid;
    }

    public void setBankid(java.lang.String bankid) {
        this.bankid = bankid;
    }

    public java.lang.String getBankname() {
        return this.bankname;
    }

    public void setBankname(java.lang.String bankname) {
        this.bankname = bankname;
    }

    public java.lang.String getUniformcode() {
        return this.uniformcode;
    }

    public void setUniformcode(java.lang.String uniformcode) {
        this.uniformcode = uniformcode;
    }

    public java.lang.String getLinkphone() {
        return this.linkphone;
    }

    public void setLinkphone(java.lang.String linkphone) {
        this.linkphone = linkphone;
    }

    public java.lang.String getAddr() {
        return this.addr;
    }

    public void setAddr(java.lang.String addr) {
        this.addr = addr;
    }

    public java.lang.Byte getContainer() {
        return this.container;
    }

    public void setContainer(java.lang.Byte container) {
        this.container = container;
    }

    public java.lang.String getExchangeno() {
        return this.exchangeno;
    }

    public void setExchangeno(java.lang.String exchangeno) {
        this.exchangeno = exchangeno;
    }

    public java.lang.Short getBanklevel() {
        return this.banklevel;
    }

    public void setBanklevel(java.lang.Short banklevel) {
        this.banklevel = banklevel;
    }

    public java.lang.String getParentid() {
        return this.parentid;
    }

    public void setParentid(java.lang.String parentid) {
        this.parentid = parentid;
    }

    public java.lang.String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(java.lang.String orgid) {
        this.orgid = orgid;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("bankid", getBankid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BankVO) ) return false;
        BankVO castOther = (BankVO) other;
        return new EqualsBuilder()
            .append(this.getBankid(), castOther.getBankid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBankid())
            .toHashCode();
    }

}
