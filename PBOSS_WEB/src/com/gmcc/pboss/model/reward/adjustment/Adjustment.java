package com.gmcc.pboss.model.reward.adjustment;

import java.util.Date;
import com.gmcc.pboss.common.bean.BaseModel;

/**
 * Adjustment entity. @author MyEclipse Persistence Tools
 */

public class Adjustment extends BaseModel {


    // Fields    

     private Long id;
     private String countyid;
     private String rewardmonth;
     private String wayid;
     private Double paysum;
     private Double taxmoney;
     private String batchno;
     private String remark;
     private String confirmoprcode;
     private Date confirmptime;
     private String taxoprcode;
     private Date taxoptime;
     private Double rpmoney;
     private Double fees;
     private String upperopnid;


    // Constructors

    /** default constructor */
    public Adjustment() {
    }

	/** minimal constructor */
    public Adjustment(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public Adjustment(Long id, String countyid, String rewardmonth, String wayid, Double paysum, Double taxmoney, String batchno, String remark, String confirmoprcode, Date confirmptime, String taxoprcode, Date taxoptime, Double rpmoney, Double fees, String upperopnid) {
        this.id = id;
        this.countyid = countyid;
        this.rewardmonth = rewardmonth;
        this.wayid = wayid;
        this.paysum = paysum;
        this.taxmoney = taxmoney;
        this.batchno = batchno;
        this.remark = remark;
        this.confirmoprcode = confirmoprcode;
        this.confirmptime = confirmptime;
        this.taxoprcode = taxoprcode;
        this.taxoptime = taxoptime;
        this.rpmoney = rpmoney;
        this.fees = fees;
        this.upperopnid = upperopnid;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getCountyid() {
        return this.countyid;
    }
    
    public void setCountyid(String countyid) {
        this.countyid = countyid;
    }

    public String getRewardmonth() {
        return this.rewardmonth;
    }
    
    public void setRewardmonth(String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public String getWayid() {
        return this.wayid;
    }
    
    public void setWayid(String wayid) {
        this.wayid = wayid;
    }

    public Double getPaysum() {
        return this.paysum;
    }
    
    public void setPaysum(Double paysum) {
        this.paysum = paysum;
    }

    public Double getTaxmoney() {
        return this.taxmoney;
    }
    
    public void setTaxmoney(Double taxmoney) {
        this.taxmoney = taxmoney;
    }

    public String getBatchno() {
        return this.batchno;
    }
    
    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getConfirmoprcode() {
        return this.confirmoprcode;
    }
    
    public void setConfirmoprcode(String confirmoprcode) {
        this.confirmoprcode = confirmoprcode;
    }

    public Date getConfirmptime() {
        return this.confirmptime;
    }
    
    public void setConfirmptime(Date confirmptime) {
        this.confirmptime = confirmptime;
    }

    public String getTaxoprcode() {
        return this.taxoprcode;
    }
    
    public void setTaxoprcode(String taxoprcode) {
        this.taxoprcode = taxoprcode;
    }

    public Date getTaxoptime() {
        return this.taxoptime;
    }
    
    public void setTaxoptime(Date taxoptime) {
        this.taxoptime = taxoptime;
    }

    public Double getRpmoney() {
        return this.rpmoney;
    }
    
    public void setRpmoney(Double rpmoney) {
        this.rpmoney = rpmoney;
    }

    public Double getFees() {
        return this.fees;
    }
    
    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getUpperopnid() {
        return this.upperopnid;
    }
    
    public void setUpperopnid(String upperopnid) {
        this.upperopnid = upperopnid;
    }
   








}