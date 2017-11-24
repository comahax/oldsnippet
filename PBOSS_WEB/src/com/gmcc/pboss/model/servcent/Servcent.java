package com.gmcc.pboss.model.servcent;

/** @author Hibernate CodeGenerator */
public class Servcent extends com.gmcc.pboss.common.bean.CodeReverse
implements java.io.Serializable {

    /** identifier field */
    private String svccode;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svcname;

    /** nullable persistent field */
    private Short svctype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;

    /** nullable persistent field */
    private String adacode;

    /** nullable persistent field */
    private String longitude;

    /** nullable persistent field */
    private String latitude;

    /** full constructor */
    public Servcent(java.lang.String svccode, java.lang.String countyid, java.lang.String svcname, java.lang.Short svctype, java.lang.String agent, java.lang.String billingcode, java.lang.String adacode, java.lang.String longitude, java.lang.String latitude) {
        this.svccode = svccode;
        this.countyid = countyid;
        this.svcname = svcname;
        this.svctype = svctype;
        this.agent = agent;
        this.billingcode = billingcode;
        this.adacode = adacode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /** default constructor */
    public Servcent() {
    }

    /** minimal constructor */
    public Servcent(java.lang.String svccode,java.lang.String svcname) {
        this.svccode = svccode;
        this.svcname = svcname;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvcname() {
        return this.svcname;
    }

    public void setSvcname(java.lang.String svcname) {
        this.svcname = svcname;
    }

    public java.lang.Short getSvctype() {
        return this.svctype;
    }

    public void setSvctype(java.lang.Short svctype) {
        this.svctype = svctype;
    }

    public java.lang.String getAgent() {
        return this.agent;
    }

    public void setAgent(java.lang.String agent) {
        this.agent = agent;
    }

    public java.lang.String getBillingcode() {
        return this.billingcode;
    }

    public void setBillingcode(java.lang.String billingcode) {
        this.billingcode = billingcode;
    }

    public java.lang.String getAdacode() {
        return this.adacode;
    }

    public void setAdacode(java.lang.String adacode) {
        this.adacode = adacode;
    }

    public java.lang.String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(java.lang.String longitude) {
        this.longitude = longitude;
    }

    public java.lang.String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(java.lang.String latitude) {
        this.latitude = latitude;
    }
}
