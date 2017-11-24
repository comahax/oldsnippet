package com.sunrise.boss.business.common.customer.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CustomerVO implements Serializable {

    /** identifier field */
    private Long custid;

    /** persistent field */
    private Integer region;

    /** nullable persistent field */
    private String custname;

    /** nullable persistent field */
    private String shortname;

    /** nullable persistent field */
    private String custtype;

    /** persistent field */
    private String viptype;

    /** nullable persistent field */
    private Byte foreigner;

    /** nullable persistent field */
    private String custclass1;

    /** nullable persistent field */
    private String custclass2;

    /** nullable persistent field */
    private String nationality;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String certid;

    /** nullable persistent field */
    private String certtype;

    /** nullable persistent field */
    private String certaddr;

    /** nullable persistent field */
    private String linkman;

    /** nullable persistent field */
    private String linkphone;

    /** nullable persistent field */
    private String hometel;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private String mobiletel;

    /** nullable persistent field */
    private String postcode;

    /** nullable persistent field */
    private String linkaddr;

    /** nullable persistent field */
    private String email;

    /** nullable persistent field */
    private String homepage;

    /** nullable persistent field */
    private Byte ismergebill;

    /** nullable persistent field */
    private String orgid;

    /** nullable persistent field */
    private String creditlevel;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private String notes;

    /** nullable persistent field */
    private String status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** nullable persistent field */
    private String responsecustmgr;

    /** nullable persistent field */
    private String currentcustmgr;

    /** full constructor */
    public CustomerVO(java.lang.Long custid, java.lang.Integer region, java.lang.String custname, java.lang.String shortname, java.lang.String custtype, java.lang.String viptype, java.lang.Byte foreigner, java.lang.String custclass1, java.lang.String custclass2, java.lang.String nationality, java.lang.String address, java.lang.String certid, java.lang.String certtype, java.lang.String certaddr, java.lang.String linkman, java.lang.String linkphone, java.lang.String hometel, java.lang.String officetel, java.lang.String mobiletel, java.lang.String postcode, java.lang.String linkaddr, java.lang.String email, java.lang.String homepage, java.lang.Byte ismergebill, java.lang.String orgid, java.lang.String creditlevel, java.util.Date createdate, java.lang.String notes, java.lang.String status, java.util.Date statusdate, java.lang.String responsecustmgr, java.lang.String currentcustmgr) {
        this.custid = custid;
        this.region = region;
        this.custname = custname;
        this.shortname = shortname;
        this.custtype = custtype;
        this.viptype = viptype;
        this.foreigner = foreigner;
        this.custclass1 = custclass1;
        this.custclass2 = custclass2;
        this.nationality = nationality;
        this.address = address;
        this.certid = certid;
        this.certtype = certtype;
        this.certaddr = certaddr;
        this.linkman = linkman;
        this.linkphone = linkphone;
        this.hometel = hometel;
        this.officetel = officetel;
        this.mobiletel = mobiletel;
        this.postcode = postcode;
        this.linkaddr = linkaddr;
        this.email = email;
        this.homepage = homepage;
        this.ismergebill = ismergebill;
        this.orgid = orgid;
        this.creditlevel = creditlevel;
        this.createdate = createdate;
        this.notes = notes;
        this.status = status;
        this.statusdate = statusdate;
        this.responsecustmgr = responsecustmgr;
        this.currentcustmgr = currentcustmgr;
    }

    /** default constructor */
    public CustomerVO() {
    }

    /** minimal constructor */
    public CustomerVO(java.lang.Long custid, java.lang.Integer region, java.lang.String viptype) {
        this.custid = custid;
        this.region = region;
        this.viptype = viptype;
    }

    public java.lang.Long getCustid() {
        return this.custid;
    }

    public void setCustid(java.lang.Long custid) {
        this.custid = custid;
    }

    public java.lang.Integer getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.Integer region) {
        this.region = region;
    }

    public java.lang.String getCustname() {
        return this.custname;
    }

    public void setCustname(java.lang.String custname) {
        this.custname = custname;
    }

    public java.lang.String getShortname() {
        return this.shortname;
    }

    public void setShortname(java.lang.String shortname) {
        this.shortname = shortname;
    }

    public java.lang.String getCusttype() {
        return this.custtype;
    }

    public void setCusttype(java.lang.String custtype) {
        this.custtype = custtype;
    }

    public java.lang.String getViptype() {
        return this.viptype;
    }

    public void setViptype(java.lang.String viptype) {
        this.viptype = viptype;
    }

    public java.lang.Byte getForeigner() {
        return this.foreigner;
    }

    public void setForeigner(java.lang.Byte foreigner) {
        this.foreigner = foreigner;
    }

    public java.lang.String getCustclass1() {
        return this.custclass1;
    }

    public void setCustclass1(java.lang.String custclass1) {
        this.custclass1 = custclass1;
    }

    public java.lang.String getCustclass2() {
        return this.custclass2;
    }

    public void setCustclass2(java.lang.String custclass2) {
        this.custclass2 = custclass2;
    }

    public java.lang.String getNationality() {
        return this.nationality;
    }

    public void setNationality(java.lang.String nationality) {
        this.nationality = nationality;
    }

    public java.lang.String getAddress() {
        return this.address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getCertid() {
        return this.certid;
    }

    public void setCertid(java.lang.String certid) {
        this.certid = certid;
    }

    public java.lang.String getCerttype() {
        return this.certtype;
    }

    public void setCerttype(java.lang.String certtype) {
        this.certtype = certtype;
    }

    public java.lang.String getCertaddr() {
        return this.certaddr;
    }

    public void setCertaddr(java.lang.String certaddr) {
        this.certaddr = certaddr;
    }

    public java.lang.String getLinkman() {
        return this.linkman;
    }

    public void setLinkman(java.lang.String linkman) {
        this.linkman = linkman;
    }

    public java.lang.String getLinkphone() {
        return this.linkphone;
    }

    public void setLinkphone(java.lang.String linkphone) {
        this.linkphone = linkphone;
    }

    public java.lang.String getHometel() {
        return this.hometel;
    }

    public void setHometel(java.lang.String hometel) {
        this.hometel = hometel;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.lang.String getMobiletel() {
        return this.mobiletel;
    }

    public void setMobiletel(java.lang.String mobiletel) {
        this.mobiletel = mobiletel;
    }

    public java.lang.String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(java.lang.String postcode) {
        this.postcode = postcode;
    }

    public java.lang.String getLinkaddr() {
        return this.linkaddr;
    }

    public void setLinkaddr(java.lang.String linkaddr) {
        this.linkaddr = linkaddr;
    }

    public java.lang.String getEmail() {
        return this.email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getHomepage() {
        return this.homepage;
    }

    public void setHomepage(java.lang.String homepage) {
        this.homepage = homepage;
    }

    public java.lang.Byte getIsmergebill() {
        return this.ismergebill;
    }

    public void setIsmergebill(java.lang.Byte ismergebill) {
        this.ismergebill = ismergebill;
    }

    public java.lang.String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(java.lang.String orgid) {
        this.orgid = orgid;
    }

    public java.lang.String getCreditlevel() {
        return this.creditlevel;
    }

    public void setCreditlevel(java.lang.String creditlevel) {
        this.creditlevel = creditlevel;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.String getNotes() {
        return this.notes;
    }

    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public java.lang.String getResponsecustmgr() {
        return this.responsecustmgr;
    }

    public void setResponsecustmgr(java.lang.String responsecustmgr) {
        this.responsecustmgr = responsecustmgr;
    }

    public java.lang.String getCurrentcustmgr() {
        return this.currentcustmgr;
    }

    public void setCurrentcustmgr(java.lang.String currentcustmgr) {
        this.currentcustmgr = currentcustmgr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("custid", getCustid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CustomerVO) ) return false;
        CustomerVO castOther = (CustomerVO) other;
        return new EqualsBuilder()
            .append(this.getCustid(), castOther.getCustid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCustid())
            .toHashCode();
    }

}
