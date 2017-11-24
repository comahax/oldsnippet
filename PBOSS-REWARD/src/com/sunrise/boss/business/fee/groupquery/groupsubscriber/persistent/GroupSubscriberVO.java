package com.sunrise.boss.business.fee.groupquery.groupsubscriber.persistent;

import java.util.Date;




public class GroupSubscriberVO  implements java.io.Serializable {


    // Fields    

     private Long subsid;
     private Long region;
     private String internalid;
     private Long custid;
     private String prodid;
     private Long dependsubsid;
     private Long maxmemcount;
     private Date startdate;
     private String status;
     private Date statusdate;
     private Long custtype;
     private Long issolution;
     private Long solutionoid;
     private String productcode;
     private String billingnbr;
     private Long isintergroup;
     private Long ismaster;
     private Long paygroupoid;
     private String openordseq;
     private String interuserid;
     private String groupname;
     private Long acctid;


    // Constructors

    /** default constructor */
    public GroupSubscriberVO() {
    }

	/** minimal constructor */
    public GroupSubscriberVO(Long subsid) {
        this.subsid = subsid;
    }
    
    /** full constructor */
    public GroupSubscriberVO(Long subsid, Long region, String internalid, Long custid, String prodid, Long dependsubsid, Long maxmemcount, Date startdate, String status, Date statusdate, Long custtype, Long issolution, Long solutionoid, String productcode, String billingnbr, Long isintergroup, Long ismaster, Long paygroupoid, String openordseq, String interuserid, String groupname, Long acctid) {
        this.subsid = subsid;
        this.region = region;
        this.internalid = internalid;
        this.custid = custid;
        this.prodid = prodid;
        this.dependsubsid = dependsubsid;
        this.maxmemcount = maxmemcount;
        this.startdate = startdate;
        this.status = status;
        this.statusdate = statusdate;
        this.custtype = custtype;
        this.issolution = issolution;
        this.solutionoid = solutionoid;
        this.productcode = productcode;
        this.billingnbr = billingnbr;
        this.isintergroup = isintergroup;
        this.ismaster = ismaster;
        this.paygroupoid = paygroupoid;
        this.openordseq = openordseq;
        this.interuserid = interuserid;
        this.groupname = groupname;
        this.acctid = acctid;
    }

   
    // Property accessors

    public Long getSubsid() {
        return this.subsid;
    }
    
    public void setSubsid(Long subsid) {
        this.subsid = subsid;
    }

    public Long getRegion() {
        return this.region;
    }
    
    public void setRegion(Long region) {
        this.region = region;
    }

    public String getInternalid() {
        return this.internalid;
    }
    
    public void setInternalid(String internalid) {
        this.internalid = internalid;
    }

    public Long getCustid() {
        return this.custid;
    }
    
    public void setCustid(Long custid) {
        this.custid = custid;
    }

    public String getProdid() {
        return this.prodid;
    }
    
    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public Long getDependsubsid() {
        return this.dependsubsid;
    }
    
    public void setDependsubsid(Long dependsubsid) {
        this.dependsubsid = dependsubsid;
    }

    public Long getMaxmemcount() {
        return this.maxmemcount;
    }
    
    public void setMaxmemcount(Long maxmemcount) {
        this.maxmemcount = maxmemcount;
    }

    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return this.statusdate;
    }
    
    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public Long getCusttype() {
        return this.custtype;
    }
    
    public void setCusttype(Long custtype) {
        this.custtype = custtype;
    }

    public Long getIssolution() {
        return this.issolution;
    }
    
    public void setIssolution(Long issolution) {
        this.issolution = issolution;
    }

    public Long getSolutionoid() {
        return this.solutionoid;
    }
    
    public void setSolutionoid(Long solutionoid) {
        this.solutionoid = solutionoid;
    }

    public String getProductcode() {
        return this.productcode;
    }
    
    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getBillingnbr() {
        return this.billingnbr;
    }
    
    public void setBillingnbr(String billingnbr) {
        this.billingnbr = billingnbr;
    }

    public Long getIsintergroup() {
        return this.isintergroup;
    }
    
    public void setIsintergroup(Long isintergroup) {
        this.isintergroup = isintergroup;
    }

    public Long getIsmaster() {
        return this.ismaster;
    }
    
    public void setIsmaster(Long ismaster) {
        this.ismaster = ismaster;
    }

    public Long getPaygroupoid() {
        return this.paygroupoid;
    }
    
    public void setPaygroupoid(Long paygroupoid) {
        this.paygroupoid = paygroupoid;
    }

    public String getOpenordseq() {
        return this.openordseq;
    }
    
    public void setOpenordseq(String openordseq) {
        this.openordseq = openordseq;
    }

    public String getInteruserid() {
        return this.interuserid;
    }
    
    public void setInteruserid(String interuserid) {
        this.interuserid = interuserid;
    }

    public String getGroupname() {
        return this.groupname;
    }
    
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Long getAcctid() {
        return this.acctid;
    }
    
    public void setAcctid(Long acctid) {
        this.acctid = acctid;
    }
   








}