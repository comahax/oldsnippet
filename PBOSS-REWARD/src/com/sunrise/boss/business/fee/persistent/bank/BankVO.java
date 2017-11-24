package com.sunrise.boss.business.fee.persistent.bank;

import java.util.Date;

public class BankVO  implements java.io.Serializable {

    // Fields    

     private String bankid;
     private String bankname;
     private String uniformcode;
     private String linkphone;
     private String addr;
     private Short container;
     private String exchangeno;
     private Integer banklevel;
     private String parentid;
     private String orgid;
     private Date createdate;
     private Short status;
     private Date statusdate;
     private String banktype;


    // Constructors

    /** default constructor */
    public BankVO() {
    }

	/** minimal constructor */
    public BankVO(String bankid) {
        this.bankid = bankid;
    }
    
    /** full constructor */
    public BankVO(String bankid, String bankname, String uniformcode, String linkphone, String addr, Short container, String exchangeno, Integer banklevel, String parentid, String orgid, Date createdate, Short status, Date statusdate) {
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

   
    // Property accessors

    public String getBankid() {
        return this.bankid;
    }
    
    
    public String getBanktype() {
		return banktype;
	}

	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

	public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return this.bankname;
    }
    
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getUniformcode() {
        return this.uniformcode;
    }
    
    public void setUniformcode(String uniformcode) {
        this.uniformcode = uniformcode;
    }

    public String getLinkphone() {
        return this.linkphone;
    }
    
    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public String getAddr() {
        return this.addr;
    }
    
    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Short getContainer() {
        return this.container;
    }
    
    public void setContainer(Short container) {
        this.container = container;
    }

    public String getExchangeno() {
        return this.exchangeno;
    }
    
    public void setExchangeno(String exchangeno) {
        this.exchangeno = exchangeno;
    }

    public Integer getBanklevel() {
        return this.banklevel;
    }
    
    public void setBanklevel(Integer banklevel) {
        this.banklevel = banklevel;
    }

    public String getParentid() {
        return this.parentid;
    }
    
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getOrgid() {
        return this.orgid;
    }
    
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Date getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }
}