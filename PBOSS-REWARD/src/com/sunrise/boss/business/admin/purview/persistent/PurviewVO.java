package com.sunrise.boss.business.admin.purview.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PurviewVO implements Serializable {

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String companyname;

    /** nullable persistent field */
    private String shortname;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private Long capital;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private String bank;

    /** nullable persistent field */
    private String account;

    /** nullable persistent field */
    private Byte state;

    /** full constructor */
    public PurviewVO(java.lang.Long id, java.lang.String companyname, java.lang.String shortname, java.lang.String address, java.lang.Long capital, java.util.Date createdate, java.lang.String bank, java.lang.String account, java.lang.Byte state) {
        this.id = id;
        this.companyname = companyname;
        this.shortname = shortname;
        this.address = address;
        this.capital = capital;
        this.createdate = createdate;
        this.bank = bank;
        this.account = account;
        this.state = state;
    }

    /** default constructor */
    public PurviewVO() {
    }

    /** minimal constructor */
    public PurviewVO(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getCompanyname() {
        return this.companyname;
    }

    public void setCompanyname(java.lang.String companyname) {
        this.companyname = companyname;
    }

    public java.lang.String getShortname() {
        return this.shortname;
    }

    public void setShortname(java.lang.String shortname) {
        this.shortname = shortname;
    }

    public java.lang.String getAddress() {
        return this.address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.Long getCapital() {
        return this.capital;
    }

    public void setCapital(java.lang.Long capital) {
        this.capital = capital;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.String getBank() {
        return this.bank;
    }

    public void setBank(java.lang.String bank) {
        this.bank = bank;
    }

    public java.lang.String getAccount() {
        return this.account;
    }

    public void setAccount(java.lang.String account) {
        this.account = account;
    }

    public java.lang.Byte getState() {
        return this.state;
    }

    public void setState(java.lang.Byte state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PurviewVO) ) return false;
        PurviewVO castOther = (PurviewVO) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
