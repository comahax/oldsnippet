package com.gmcc.pboss.model.reward.adjustment;

import java.util.Date;


/**
 * Paymentbatch entity. @author MyEclipse Persistence Tools
 */

public class Paymentbatch  implements java.io.Serializable {


    // Fields    

     private String batchno;
     private Long cityid;
     private Long paymentflag;
     private String paymentoprcode;
     private Date paymentoprtime;
     private Long listflag;
     private Long endflag;
     private String paymonth;
     private String endoprcode;
     private Date endtime;


    // Constructors

    /** default constructor */
    public Paymentbatch() {
    }

	/** minimal constructor */
    public Paymentbatch(String batchno) {
        this.batchno = batchno;
    }
    
    /** full constructor */
    public Paymentbatch(String batchno, Long cityid, Long paymentflag, String paymentoprcode, Date paymentoprtime, Long listflag, Long endflag, String paymonth, String endoprcode, Date endtime) {
        this.batchno = batchno;
        this.cityid = cityid;
        this.paymentflag = paymentflag;
        this.paymentoprcode = paymentoprcode;
        this.paymentoprtime = paymentoprtime;
        this.listflag = listflag;
        this.endflag = endflag;
        this.paymonth = paymonth;
        this.endoprcode = endoprcode;
        this.endtime = endtime;
    }

   
    // Property accessors

    public String getBatchno() {
        return this.batchno;
    }
    
    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public Long getCityid() {
        return this.cityid;
    }
    
    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public Long getPaymentflag() {
        return this.paymentflag;
    }
    
    public void setPaymentflag(Long paymentflag) {
        this.paymentflag = paymentflag;
    }

    public String getPaymentoprcode() {
        return this.paymentoprcode;
    }
    
    public void setPaymentoprcode(String paymentoprcode) {
        this.paymentoprcode = paymentoprcode;
    }

    public Date getPaymentoprtime() {
        return this.paymentoprtime;
    }
    
    public void setPaymentoprtime(Date paymentoprtime) {
        this.paymentoprtime = paymentoprtime;
    }

    public Long getListflag() {
        return this.listflag;
    }
    
    public void setListflag(Long listflag) {
        this.listflag = listflag;
    }

    public Long getEndflag() {
        return this.endflag;
    }
    
    public void setEndflag(Long endflag) {
        this.endflag = endflag;
    }

    public String getPaymonth() {
        return this.paymonth;
    }
    
    public void setPaymonth(String paymonth) {
        this.paymonth = paymonth;
    }

    public String getEndoprcode() {
        return this.endoprcode;
    }
    
    public void setEndoprcode(String endoprcode) {
        this.endoprcode = endoprcode;
    }

    public Date getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
   








}