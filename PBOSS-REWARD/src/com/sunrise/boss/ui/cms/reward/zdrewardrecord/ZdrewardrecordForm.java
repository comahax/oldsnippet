/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.ui.cms.reward.zdrewardrecord;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ZdrewardrecordForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ZdrewardrecordForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String calcmonth;
    private java.lang.String opnid;
    private java.lang.String name;
    private java.lang.String wayid;
    private java.lang.String wayname;
    private java.lang.String oprcode;
    private java.lang.String mobile;
    private java.util.Date oprtime;
    private java.util.Date runtime;
    private java.lang.String ruleid;
    private java.lang.String resultflag;
    private java.lang.Short adtflag;
    private java.lang.String adtcode;
    private java.lang.String adtremark;
    private java.lang.String rewardtype;
    private java.lang.Short rewardflag;
    private java.lang.String repairmonth;
    private java.lang.String batchno;
    private java.lang.String bakinfo;
    private java.lang.String bakinfo2;
    private java.lang.Double bakinfo3;
    private java.lang.Double wrapfee;
    private java.lang.Short noncyc;
    private java.lang.Double totalsum;
    private java.lang.Double paysum;
    private java.lang.Double paymoney1;
    
    /** nullable persistent field */
    private java.lang.Double assegrade2;
    /** nullable persistent field */
    private java.lang.String prodid;
    /** nullable persistent field */
    private java.lang.Double bakinfo4;
    /** nullable persistent field */
    private java.lang.Double bakinfo5;
    /** nullable persistent field */
    private java.lang.String bakinfo6;
    /** nullable persistent field */
    private java.lang.String bakinfo7;
    /** nullable persistent field */
    private java.lang.String bakinfo8;
    /** nullable persistent field */
    private java.lang.String bakinfo9;
    /** nullable persistent field */
    private java.lang.String bakinfo10;

    private String _se_calcmonth;
    private String _se_wayid;
    private String _se_oprcode;
    private String _se_mobile;
    private String _dnm_oprtime;
    private String _dnl_oprtime;
    private String _se_batchno;
    private String _se_bakinfo;
    private String _ne_noncyc;
    private String _se_zdreward;
    private String _se_repairmonth;
    
    private boolean query;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getName(){
        return name;
    }

    public void setName(java.lang.String name){
        this.name = name;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getWayname(){
        return wayname;
    }

    public void setWayname(java.lang.String wayname){
        this.wayname = wayname;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }
    public java.util.Date getRuntime(){
        return runtime;
    }

    public void setRuntime(java.util.Date runtime){
        this.runtime = runtime;
    }
    public java.lang.String getRuleid(){
        return ruleid;
    }

    public void setRuleid(java.lang.String ruleid){
        this.ruleid = ruleid;
    }
    public java.lang.String getResultflag(){
        return resultflag;
    }

    public void setResultflag(java.lang.String resultflag){
        this.resultflag = resultflag;
    }
    public java.lang.Short getAdtflag(){
        return adtflag;
    }

    public void setAdtflag(java.lang.Short adtflag){
        this.adtflag = adtflag;
    }
    public java.lang.String getAdtcode(){
        return adtcode;
    }

    public void setAdtcode(java.lang.String adtcode){
        this.adtcode = adtcode;
    }
    public java.lang.String getAdtremark(){
        return adtremark;
    }

    public void setAdtremark(java.lang.String adtremark){
        this.adtremark = adtremark;
    }
    public java.lang.String getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.String rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.lang.Short getRewardflag(){
        return rewardflag;
    }

    public void setRewardflag(java.lang.Short rewardflag){
        this.rewardflag = rewardflag;
    }
    public java.lang.String getRepairmonth(){
        return repairmonth;
    }

    public void setRepairmonth(java.lang.String repairmonth){
        this.repairmonth = repairmonth;
    }
    public java.lang.String getBatchno(){
        return batchno;
    }

    public void setBatchno(java.lang.String batchno){
        this.batchno = batchno;
    }
    public java.lang.String getBakinfo(){
        return bakinfo;
    }

    public void setBakinfo(java.lang.String bakinfo){
        this.bakinfo = bakinfo;
    }
    public java.lang.String getBakinfo2(){
        return bakinfo2;
    }

    public void setBakinfo2(java.lang.String bakinfo2){
        this.bakinfo2 = bakinfo2;
    }
    public java.lang.Double getBakinfo3(){
        return bakinfo3;
    }

    public void setBakinfo3(java.lang.Double bakinfo3){
        this.bakinfo3 = bakinfo3;
    }
    public java.lang.Double getWrapfee(){
        return wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee){
        this.wrapfee = wrapfee;
    }
    public java.lang.Short getNoncyc(){
        return noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc){
        this.noncyc = noncyc;
    }
    public java.lang.Double getTotalsum(){
        return totalsum;
    }

    public void setTotalsum(java.lang.Double totalsum){
        this.totalsum = totalsum;
    }
    public java.lang.Double getPaysum(){
        return paysum;
    }

    public void setPaysum(java.lang.Double paysum){
        this.paysum = paysum;
    }
    public java.lang.Double getPaymoney1(){
        return paymoney1;
    }

    public void setPaymoney1(java.lang.Double paymoney1){
        this.paymoney1 = paymoney1;
    }

    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_dnm_oprtime(){
        return _dnm_oprtime;
    }

    public void set_dnm_oprtime(String _dnm_oprtime){
        this._dnm_oprtime = _dnm_oprtime;
    }
    public String get_dnl_oprtime(){
        return _dnl_oprtime;
    }

    public void set_dnl_oprtime(String _dnl_oprtime){
        this._dnl_oprtime = _dnl_oprtime;
    }
    public String get_se_batchno(){
        return _se_batchno;
    }

    public void set_se_batchno(String _se_batchno){
        this._se_batchno = _se_batchno;
    }
    public String get_se_bakinfo(){
        return _se_bakinfo;
    }

    public void set_se_bakinfo(String _se_bakinfo){
        this._se_bakinfo = _se_bakinfo;
    }
    public String get_ne_noncyc(){
        return _ne_noncyc;
    }

    public void set_ne_noncyc(String _ne_noncyc){
        this._ne_noncyc = _ne_noncyc;
    }

	public String get_se_zdreward() {
		return _se_zdreward;
	}

	public void set_se_zdreward(String _se_zdreward) {
		this._se_zdreward = _se_zdreward;
	}

	public java.lang.Double getAssegrade2() {
		return assegrade2;
	}

	public void setAssegrade2(java.lang.Double assegrade2) {
		this.assegrade2 = assegrade2;
	}

	public java.lang.String getProdid() {
		return prodid;
	}

	public void setProdid(java.lang.String prodid) {
		this.prodid = prodid;
	}

	public java.lang.Double getBakinfo4() {
		return bakinfo4;
	}

	public void setBakinfo4(java.lang.Double bakinfo4) {
		this.bakinfo4 = bakinfo4;
	}

	public java.lang.Double getBakinfo5() {
		return bakinfo5;
	}

	public void setBakinfo5(java.lang.Double bakinfo5) {
		this.bakinfo5 = bakinfo5;
	}

	public java.lang.String getBakinfo6() {
		return bakinfo6;
	}

	public void setBakinfo6(java.lang.String bakinfo6) {
		this.bakinfo6 = bakinfo6;
	}

	public java.lang.String getBakinfo7() {
		return bakinfo7;
	}

	public void setBakinfo7(java.lang.String bakinfo7) {
		this.bakinfo7 = bakinfo7;
	}

	public java.lang.String getBakinfo8() {
		return bakinfo8;
	}

	public void setBakinfo8(java.lang.String bakinfo8) {
		this.bakinfo8 = bakinfo8;
	}

	public java.lang.String getBakinfo9() {
		return bakinfo9;
	}

	public void setBakinfo9(java.lang.String bakinfo9) {
		this.bakinfo9 = bakinfo9;
	}

	public java.lang.String getBakinfo10() {
		return bakinfo10;
	}

	public void setBakinfo10(java.lang.String bakinfo10) {
		this.bakinfo10 = bakinfo10;
	}

	public String get_se_repairmonth() {
		return _se_repairmonth;
	}

	public void set_se_repairmonth(String seRepairmonth) {
		_se_repairmonth = seRepairmonth;
	}

	public boolean isQuery() {
		return query;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}

}
