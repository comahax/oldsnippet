package com.gmcc.pboss.business.channel.bchcontlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BchcontlogVO extends BaseVO implements Serializable {

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

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String principal;

    /** nullable persistent field */
    private String principaltel;

    /** nullable persistent field */
    private String principalemail;

    /** nullable persistent field */
    private String principalphone;

    /** nullable persistent field */
    private String linkman;

    /** nullable persistent field */
    private String linkmantel;

    /** nullable persistent field */
    private String linkmanemail;

    /** nullable persistent field */
    private String hotline;

    /** nullable persistent field */
    private String fax;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String zipcode;

    /** nullable persistent field */
    private Short bailtype;

    /** nullable persistent field */
    private Short servbound;

    /** nullable persistent field */
    private Short coplevel;

    /** nullable persistent field */
    private String busnum;

    /** nullable persistent field */
    private Short certitype;

    /** nullable persistent field */
    private String certinum;

    /** nullable persistent field */
    private String regadress;

    /** nullable persistent field */
    private Long regcapital;

    /** nullable persistent field */
    private String company;

    /** nullable persistent field */
    private String provcode;
    
    private String brole;
    
    private String companytype;
    
    private String regid;
    
    /** full constructor */
    public BchcontlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String wayid, java.lang.String principal, java.lang.String principaltel, java.lang.String principalemail, java.lang.String principalphone, java.lang.String linkman, java.lang.String linkmantel, java.lang.String linkmanemail, java.lang.String hotline, java.lang.String fax, java.lang.String address, java.lang.String zipcode, java.lang.Short bailtype, java.lang.Short servbound, java.lang.Short coplevel, java.lang.String busnum, java.lang.Short certitype, java.lang.String certinum, java.lang.String regadress, java.lang.Long regcapital, java.lang.String company, java.lang.String provcode) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.wayid = wayid;
        this.principal = principal;
        this.principaltel = principaltel;
        this.principalemail = principalemail;
        this.principalphone = principalphone;
        this.linkman = linkman;
        this.linkmantel = linkmantel;
        this.linkmanemail = linkmanemail;
        this.hotline = hotline;
        this.fax = fax;
        this.address = address;
        this.zipcode = zipcode;
        this.bailtype = bailtype;
        this.servbound = servbound;
        this.coplevel = coplevel;
        this.busnum = busnum;
        this.certitype = certitype;
        this.certinum = certinum;
        this.regadress = regadress;
        this.regcapital = regcapital;
        this.company = company;
        this.provcode = provcode;
    }

    /** default constructor */
    public BchcontlogVO() {
    }

    /** minimal constructor */
    public BchcontlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.lang.String getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(java.lang.String principal) {
        this.principal = principal;
    }

    public java.lang.String getPrincipaltel() {
        return this.principaltel;
    }

    public void setPrincipaltel(java.lang.String principaltel) {
        this.principaltel = principaltel;
    }

    public java.lang.String getPrincipalemail() {
        return this.principalemail;
    }

    public void setPrincipalemail(java.lang.String principalemail) {
        this.principalemail = principalemail;
    }

    public java.lang.String getPrincipalphone() {
        return this.principalphone;
    }

    public void setPrincipalphone(java.lang.String principalphone) {
        this.principalphone = principalphone;
    }

    public java.lang.String getLinkman() {
        return this.linkman;
    }

    public void setLinkman(java.lang.String linkman) {
        this.linkman = linkman;
    }

    public java.lang.String getLinkmantel() {
        return this.linkmantel;
    }

    public void setLinkmantel(java.lang.String linkmantel) {
        this.linkmantel = linkmantel;
    }

    public java.lang.String getLinkmanemail() {
        return this.linkmanemail;
    }

    public void setLinkmanemail(java.lang.String linkmanemail) {
        this.linkmanemail = linkmanemail;
    }

    public java.lang.String getHotline() {
        return this.hotline;
    }

    public void setHotline(java.lang.String hotline) {
        this.hotline = hotline;
    }

    public java.lang.String getFax() {
        return this.fax;
    }

    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }

    public java.lang.String getAddress() {
        return this.address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(java.lang.String zipcode) {
        this.zipcode = zipcode;
    }

    public java.lang.Short getBailtype() {
        return this.bailtype;
    }

    public void setBailtype(java.lang.Short bailtype) {
        this.bailtype = bailtype;
    }

    public java.lang.Short getServbound() {
        return this.servbound;
    }

    public void setServbound(java.lang.Short servbound) {
        this.servbound = servbound;
    }

    public java.lang.Short getCoplevel() {
        return this.coplevel;
    }

    public void setCoplevel(java.lang.Short coplevel) {
        this.coplevel = coplevel;
    }

    public java.lang.String getBusnum() {
        return this.busnum;
    }

    public void setBusnum(java.lang.String busnum) {
        this.busnum = busnum;
    }

    public java.lang.Short getCertitype() {
        return this.certitype;
    }

    public void setCertitype(java.lang.Short certitype) {
        this.certitype = certitype;
    }

    public java.lang.String getCertinum() {
        return this.certinum;
    }

    public void setCertinum(java.lang.String certinum) {
        this.certinum = certinum;
    }

    public java.lang.String getRegadress() {
        return this.regadress;
    }

    public void setRegadress(java.lang.String regadress) {
        this.regadress = regadress;
    }

    public java.lang.Long getRegcapital() {
        return this.regcapital;
    }

    public void setRegcapital(java.lang.Long regcapital) {
        this.regcapital = regcapital;
    }

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public java.lang.String getProvcode() {
        return this.provcode;
    }

    public void setProvcode(java.lang.String provcode) {
        this.provcode = provcode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BchcontlogVO) ) return false;
        BchcontlogVO castOther = (BchcontlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getBrole() {
		return brole;
	}

	public void setBrole(String brole) {
		this.brole = brole;
	}

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

}
