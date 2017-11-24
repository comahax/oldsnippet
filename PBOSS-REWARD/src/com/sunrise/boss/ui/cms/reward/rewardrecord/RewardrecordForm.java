/**
 * auto-generated code
 * Sat Feb 02 14:33:50 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rewardrecord;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;


/**
 * <p>
 * Title: RewardrecordForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RewardrecordForm extends BaseActionForm {

	private Long rewardlistid;

	private Long operseq;

	private String opnid;

	private String wayid;

	private String wayoprcode;

	private Short slv;

	private Long rewardid;

	private Short rewardtype;

	private String rewardmonth;

	private Short isbudget;

	private Double totalsum;

	private Double paysum;

	private String paymonth1;

	private Double paymoney1;

	private String paymonth2;

	private Double paymoney2;

	private String paymonth3;

	private Double paymoney3;

	private java.util.Date runtime;
	
	private Short acctype;
	
	private String mobile;
	
	private String rewardstd;
	
	private String rewardstdnew;
	
	private Double assegrade;
	
	private String opermobile;
	
    private Date oprtime;
    
    private Double busivalue;
    
    private Short rewardflag;
    
    private String repairmonth;
    
    private Long relateid;
    
    private String batchno;
    
    private Short noncyc;
    
    private String ruleid;
    
    private String bakinfo2;
    
    private Double bakinfo3;
    
    private Double wrapfee;
    
    private String adjustkind;
    
    private Double assegrade2;
    
    private Short adtflag;
    private String prodid;
    private Double bakinfo4;
    private Double bakinfo5;
    private String bakinfo6;
    private String bakinfo7;
    private String bakinfo8;
    private String bakinfo9;
    private String bakinfo10;  
    

	// 查询条件 渠道标识（渠道树）、酬金标识（弹出框）、酬金类型（下拉框）、星级（弹出框）、发放月份、预估标志
	private String _sk_wayid;

	private String _ne_rewardlistid;

	private String _ne_rewardtype;
	private String _ne_noncyc;
	private String _ne_slv;

	private String _se_rewardmonth;

	private String _ne_isbudget;
	
	private String _se_paymonth;
	
	private Double _ne_assegrade;
	
	private String _se_opermobile;
	
	private String _ne_rewardid;
	
	private String _sk_opnid;
	
	private String _ne_rewardflag;
	
	private String _se_repairmonth;
	
	private String _se_batchno;

	private String _sql_condintion;
	
	private String checked;
	
	private String fruit;
	
	private String _se_mobile;
	
	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_ne_noncyc() {
		return _ne_noncyc;
	}

	public void set_ne_noncyc(String _ne_noncyc) {
		this._ne_noncyc = _ne_noncyc;
	}

	public String get_ne_rewardflag() {
		return _ne_rewardflag;
	}

	public void set_ne_rewardflag(String _ne_rewardflag) {
		this._ne_rewardflag = _ne_rewardflag;
	}

	public String get_se_repairmonth() {
		return _se_repairmonth;
	}

	public void set_se_repairmonth(String _se_repairmonth) {
		this._se_repairmonth = _se_repairmonth;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_sk_opnid() {
		return _sk_opnid;
	}

	public void set_sk_opnid(String _sk_opnid) {
		this._sk_opnid = _sk_opnid;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_se_paymonth() {
		return _se_paymonth;
	}

	public void set_se_paymonth(String _se_paymonth) {
		this._se_paymonth = _se_paymonth;
	}

	public Long getRewardlistid() {
		return rewardlistid;
	}

	public void setRewardlistid(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	public Long getOperseq() {
		return operseq;
	}

	public void setOperseq(Long operseq) {
		this.operseq = operseq;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayoprcode() {
		return wayoprcode;
	}

	public void setWayoprcode(String wayoprcode) {
		this.wayoprcode = wayoprcode;
	}

	public Short getSlv() {
		return slv;
	}

	public void setSlv(Short slv) {
		this.slv = slv;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public Short getIsbudget() {
		return isbudget;
	}

	public void setIsbudget(Short isbudget) {
		this.isbudget = isbudget;
	}

	public Double getTotalsum() {
		return totalsum;
	}

	public void setTotalsum(Double totalsum) {
		this.totalsum = totalsum;
	}

	public Double getPaysum() {
		return paysum;
	}

	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}

	public String getPaymonth1() {
		return paymonth1;
	}

	public void setPaymonth1(String paymonth1) {
		this.paymonth1 = paymonth1;
	}

	public Double getPaymoney1() {
		return paymoney1;
	}

	public void setPaymoney1(Double paymoney1) {
		this.paymoney1 = paymoney1;
	}

	public String getPaymonth2() {
		return paymonth2;
	}

	public void setPaymonth2(String paymonth2) {
		this.paymonth2 = paymonth2;
	}

	public Double getPaymoney2() {
		return paymoney2;
	}

	public void setPaymoney2(Double paymoney2) {
		this.paymoney2 = paymoney2;
	}

	public String getPaymonth3() {
		return paymonth3;
	}

	public void setPaymonth3(String paymonth3) {
		this.paymonth3 = paymonth3;
	}

	public Double getPaymoney3() {
		return paymoney3;
	}

	public void setPaymoney3(Double paymoney3) {
		this.paymoney3 = paymoney3;
	}

	public java.util.Date getRuntime() {
		return runtime;
	}

	public void setRuntime(java.util.Date runtime) {
		this.runtime = runtime;
	}

	public String get_ne_isbudget() {
		return _ne_isbudget;
	}

	public void set_ne_isbudget(String _ne_isbudget) {
		this._ne_isbudget = _ne_isbudget;
	}

	public String get_ne_rewardlistid() {
		return _ne_rewardlistid;
	}

	public void set_ne_rewardlistid(String _ne_rewardlistid) {
		this._ne_rewardlistid = _ne_rewardlistid;
	}

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_ne_slv() {
		return _ne_slv;
	}

	public void set_ne_slv(String _ne_slv) {
		this._ne_slv = _ne_slv;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}


	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Short getAcctype() {
		return acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}

	public String getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(String rewardstd) {
		this.rewardstd = rewardstd;
	}

	public String getRewardstdnew() {
		return rewardstdnew;
	}

	public void setRewardstdnew(String rewardstdnew) {
		this.rewardstdnew = rewardstdnew;
	}

	public Double getAssegrade() {
		return assegrade;
	}

	public void setAssegrade(Double assegrade) {
		this.assegrade = assegrade;
	}

	public String getOpermobile() {
		return opermobile;
	}

	public void setOpermobile(String opermobile) {
		this.opermobile = opermobile;
	}

	public Double get_ne_assegrade() {
		return _ne_assegrade;
	}

	public void set_ne_assegrade(Double _ne_assegrade) {
		this._ne_assegrade = _ne_assegrade;
	}

	public String get_se_opermobile() {
		return _se_opermobile;
	}

	public void set_se_opermobile(String _se_opermobile) {
		this._se_opermobile = _se_opermobile;
	}

	public Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public Double getBusivalue() {
		return busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public Short getRewardflag() {
		return rewardflag;
	}

	public void setRewardflag(Short rewardflag) {
		this.rewardflag = rewardflag;
	}

	public String getRepairmonth() {
		return repairmonth;
	}

	public void setRepairmonth(String repairmonth) {
		this.repairmonth = repairmonth;
	}

	public Long getRelateid() {
		return relateid;
	}

	public void setRelateid(Long relateid) {
		this.relateid = relateid;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Short getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
	}

	public String get_sql_condintion() {
		return _sql_condintion;
	}

	public void set_sql_condintion(String _sql_condintion) {
		this._sql_condintion = _sql_condintion;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getBakinfo2() {
		return bakinfo2;
	}

	public void setBakinfo2(String bakinfo2) {
		this.bakinfo2 = bakinfo2;
	}

	public Double getBakinfo3() {
		return bakinfo3;
	}

	public void setBakinfo3(Double bakinfo3) {
		this.bakinfo3 = bakinfo3;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}

	public String getAdjustkind() {
		return adjustkind;
	}

	public void setAdjustkind(String adjustkind) {
		this.adjustkind = adjustkind;
	}

	public Double getAssegrade2() {
		return assegrade2;
	}

	public void setAssegrade2(Double assegrade2) {
		this.assegrade2 = assegrade2;
	}

	public Short getAdtflag() {
		return adtflag;
	}

	public void setAdtflag(Short adtflag) {
		this.adtflag = adtflag;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public Double getBakinfo4() {
		return bakinfo4;
	}

	public void setBakinfo4(Double bakinfo4) {
		this.bakinfo4 = bakinfo4;
	}

	public Double getBakinfo5() {
		return bakinfo5;
	}

	public void setBakinfo5(Double bakinfo5) {
		this.bakinfo5 = bakinfo5;
	}

	public String getBakinfo6() {
		return bakinfo6;
	}

	public void setBakinfo6(String bakinfo6) {
		this.bakinfo6 = bakinfo6;
	}

	public String getBakinfo7() {
		return bakinfo7;
	}

	public void setBakinfo7(String bakinfo7) {
		this.bakinfo7 = bakinfo7;
	}

	public String getBakinfo8() {
		return bakinfo8;
	}

	public void setBakinfo8(String bakinfo8) {
		this.bakinfo8 = bakinfo8;
	}

	public String getBakinfo9() {
		return bakinfo9;
	}

	public void setBakinfo9(String bakinfo9) {
		this.bakinfo9 = bakinfo9;
	}

	public String getBakinfo10() {
		return bakinfo10;
	}

	public void setBakinfo10(String bakinfo10) {
		this.bakinfo10 = bakinfo10;
	}

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}	
	
}
