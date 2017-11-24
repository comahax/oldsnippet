package com.gmcc.pboss.model.reward.chbbcrealtimesucc;

import java.util.Date;

import com.gmcc.pboss.common.bean.BaseModel;


public class Chbbcrealtimesucc  extends BaseModel {
    // Fields    
     private Long seq;
     private String opnid;
     private String wayid;
     private String oprcode;
     private Date oprtime;
     private String mobile;
     private Double busivalue;
     private Date creattime;
     private String src;
     private String calcopnid;
     private String calcmonth;
     private String ruleid;
     private String srcseq;
     private Byte ossrc;
     private String adtremark;


    // Constructors

    /** default constructor */
    public Chbbcrealtimesucc() {
    }

	/** minimal constructor */
    public Chbbcrealtimesucc(Long seq) {
        this.seq = seq;
    }
    
    /** full constructor */
    public Chbbcrealtimesucc(Long seq, String opnid, String wayid, String oprcode, Date oprtime, String mobile, Double busivalue, Date creattime, String src, String calcopnid, String calcmonth, String ruleid, String srcseq, Byte ossrc, String adtremark) {
        this.seq = seq;
        this.opnid = opnid;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.creattime = creattime;
        this.src = src;
        this.calcopnid = calcopnid;
        this.calcmonth = calcmonth;
        this.ruleid = ruleid;
        this.srcseq = srcseq;
        this.ossrc = ossrc;
        this.adtremark = adtremark;
    }

   
    // Property accessors

    public Long getSeq() {
        return this.seq;
    }
    
    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getOpnid() {
        return this.opnid;
    }
    
    public void setOpnid(String opnid) {
        this.opnid = opnid;
    }

    public String getWayid() {
        return this.wayid;
    }
    
    public void setWayid(String wayid) {
        this.wayid = wayid;
    }

    public String getOprcode() {
        return this.oprcode;
    }
    
    public void setOprcode(String oprcode) {
        this.oprcode = oprcode;
    }

    public Date getOprtime() {
        return this.oprtime;
    }
    
    public void setOprtime(Date oprtime) {
        this.oprtime = oprtime;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Double getBusivalue() {
        return this.busivalue;
    }
    
    public void setBusivalue(Double busivalue) {
        this.busivalue = busivalue;
    }

    public Date getCreattime() {
        return this.creattime;
    }
    
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getSrc() {
        return this.src;
    }
    
    public void setSrc(String src) {
        this.src = src;
    }

    public String getCalcopnid() {
        return this.calcopnid;
    }
    
    public void setCalcopnid(String calcopnid) {
        this.calcopnid = calcopnid;
    }

    public String getCalcmonth() {
        return this.calcmonth;
    }
    
    public void setCalcmonth(String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public String getRuleid() {
        return this.ruleid;
    }
    
    public void setRuleid(String ruleid) {
        this.ruleid = ruleid;
    }

    public String getSrcseq() {
        return this.srcseq;
    }
    
    public void setSrcseq(String srcseq) {
        this.srcseq = srcseq;
    }

    public Byte getOssrc() {
        return this.ossrc;
    }
    
    public void setOssrc(Byte ossrc) {
        this.ossrc = ossrc;
    }

    public String getAdtremark() {
        return this.adtremark;
    }
    
    public void setAdtremark(String adtremark) {
        this.adtremark = adtremark;
    }
 }