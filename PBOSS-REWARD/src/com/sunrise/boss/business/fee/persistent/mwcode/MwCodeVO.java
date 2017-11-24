package com.sunrise.boss.business.fee.persistent.mwcode;

import java.util.Date;

public class MwCodeVO  implements java.io.Serializable {


    // Fields    

	private String portid;
    private Long bustype;
    private String subbuscode;
    private Date begintime;
     private String icpcode;
     private String spid;
     private String spname;
     private Integer province;
     private Date endtime;


    // Constructors

    /** default constructor */
    public MwCodeVO() {
    }

	/** minimal constructor */
    public MwCodeVO(String portid, Long bustype,  String subbuscode, Date begintime ) {
        this.portid = portid;
        this.bustype = bustype;
        this.subbuscode = subbuscode;
        this.begintime = begintime;
    }
    
    /** full constructor */
    public MwCodeVO(String portid, Long bustype,  String subbuscode, Date begintime, String icpcode, String spid, String spname, Integer province, Date endtime) {
    	this.portid = portid;
        this.bustype = bustype;
        this.subbuscode = subbuscode;
        this.begintime = begintime;
        this.icpcode = icpcode;
        this.spid = spid;
        this.spname = spname;
        this.province = province;
        this.endtime = endtime;
    }

   
    // Property accessors

    public String getIcpcode() {
        return this.icpcode;
    }
    
    public void setIcpcode(String icpcode) {
        this.icpcode = icpcode;
    }

    public String getSpid() {
        return this.spid;
    }
    
    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return this.spname;
    }
    
    public void setSpname(String spname) {
        this.spname = spname;
    }

    public Integer getProvince() {
        return this.province;
    }
    
    public void setProvince(Integer province) {
        this.province = province;
    }

    public Date getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
   
    public String getPortid() {
        return this.portid;
    }
    
    public void setPortid(String portid) {
        this.portid = portid;
    }

    public Long getBustype() {
        return this.bustype;
    }
    
    public void setBustype(Long bustype) {
        this.bustype = bustype;
    }

    public String getSubbuscode() {
        return this.subbuscode;
    }
    
    public void setSubbuscode(String subbuscode) {
        this.subbuscode = subbuscode;
    }

    public Date getBegintime() {
        return this.begintime;
    }
    
    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

}