package com.sunrise.boss.business.common.viptype.persistent;

import java.util.Date;



public class VipTypeVO  implements java.io.Serializable {


    // Fields    

     private String itemid;
     private String itemname;
     private String sourcetype;
     private Short status;
     private Date statusdate;
     private String typename;
     private String vipcode;


    // Constructors

    /** default constructor */
    public VipTypeVO() {
    }

	/** minimal constructor */
    public VipTypeVO(String itemid) {
        this.itemid = itemid;
    }
    
    /** full constructor */
    public VipTypeVO(String itemid, String itemname, String sourcetype, Short status, Date statusdate, String typename, String vipcode) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.sourcetype = sourcetype;
        this.status = status;
        this.statusdate = statusdate;
        this.typename = typename;
        this.vipcode = vipcode;
    }

   
    // Property accessors

    public String getItemid() {
        return this.itemid;
    }
    
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return this.itemname;
    }
    
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getSourcetype() {
        return this.sourcetype;
    }
    
    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype;
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

    public String getTypename() {
        return this.typename;
    }
    
    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getVipcode() {
        return this.vipcode;
    }
    
    public void setVipcode(String vipcode) {
        this.vipcode = vipcode;
    }
   








}