/**
* auto-generated code
* Mon Sep 03 20:43:09 CST 2012
*/
package com.sunrise.boss.ui.cms.chadtcityrecordhis;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisVO;

/**
 * <p>Title: ChAdtCityrecordhisForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtCityrecordhisForm extends BaseActionForm {

    private java.lang.Long recordid;
    private java.lang.String opnid;
    private java.lang.String wayid;
    private java.lang.Short rewardtype;
    private java.lang.String rewardmonth;
    private java.lang.String mobile;
    private java.lang.Short brand;
    private java.util.Date oprtime;
    private java.lang.Double busivalue;
    private java.lang.Double paysum;
    private java.lang.Double paymoney;
    private java.lang.String approveid;
    private java.lang.Short isflag;
    private java.lang.String oprcode;
    private java.util.Date optime;
    private java.lang.String accountoprcode;
    private java.util.Date accountoptime;
    private java.lang.Short systemflag;
    private java.lang.Long rewardlistid;
    private java.lang.Long taskid;
    private java.lang.String mbatchno;

    private String _se_opnid;
    private String _se_wayid;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_mobile;
    private String _de_oprtime;
    private String _ne_isflag;
    private String _ne_systemflag;
    private String _sin_opnid;
    private String _sql_opnid;
    private String _se_oprmonth;
    private String _ne_taskid;
    
    private String _se_countyid;
    private int iscountyoperid = -1;
    
    private String _se_paymonth;
    
    private boolean supportPaymonth = false;

	public boolean isSupportPaymonth() {
		return supportPaymonth;
	}

	public void setSupportPaymonth(boolean supportPaymonth) {
		this.supportPaymonth = supportPaymonth;
	}

	public String get_se_paymonth() {
		return _se_paymonth;
	}

	public void set_se_paymonth(String _se_paymonth) {
		this._se_paymonth = _se_paymonth;
	}

	public int getIscountyoperid() {
		return iscountyoperid;
	}

	public void setIscountyoperid(int iscountyoperid) {
		this.iscountyoperid = iscountyoperid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public String get_ne_taskid() {
		return _ne_taskid;
	}

	public void set_ne_taskid(String _ne_taskid) {
		this._ne_taskid = _ne_taskid;
	}

	public java.lang.Long getRecordid(){
        return recordid;
    }

    public void setRecordid(java.lang.Long recordid){
        this.recordid = recordid;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.Short getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
    }
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.lang.Short getBrand(){
        return brand;
    }

    public void setBrand(java.lang.Short brand){
        this.brand = brand;
    }
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }
    public java.lang.Double getBusivalue(){
        return busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue){
        this.busivalue = busivalue;
    }
    public java.lang.Double getPaysum(){
        return paysum;
    }

    public void setPaysum(java.lang.Double paysum){
        this.paysum = paysum;
    }
    public java.lang.Double getPaymoney(){
        return paymoney;
    }

    public void setPaymoney(java.lang.Double paymoney){
        this.paymoney = paymoney;
    }
    public java.lang.String getApproveid(){
        return approveid;
    }

    public void setApproveid(java.lang.String approveid){
        this.approveid = approveid;
    }
    public java.lang.Short getIsflag(){
        return isflag;
    }

    public void setIsflag(java.lang.Short isflag){
        this.isflag = isflag;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.util.Date getOptime(){
        return optime;
    }

    public void setOptime(java.util.Date optime){
        this.optime = optime;
    }
    public java.lang.String getAccountoprcode(){
        return accountoprcode;
    }

    public void setAccountoprcode(java.lang.String accountoprcode){
        this.accountoprcode = accountoprcode;
    }
    public java.util.Date getAccountoptime(){
        return accountoptime;
    }

    public void setAccountoptime(java.util.Date accountoptime){
        this.accountoptime = accountoptime;
    }
    public java.lang.Short getSystemflag(){
        return systemflag;
    }

    public void setSystemflag(java.lang.Short systemflag){
        this.systemflag = systemflag;
    }
    public java.lang.Long getRewardlistid(){
        return rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid){
        this.rewardlistid = rewardlistid;
    }
    public java.lang.Long getTaskid(){
        return taskid;
    }

    public void setTaskid(java.lang.Long taskid){
        this.taskid = taskid;
    }
    public java.lang.String getMbatchno(){
        return mbatchno;
    }

    public void setMbatchno(java.lang.String mbatchno){
        this.mbatchno = mbatchno;
    }

    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_de_oprtime(){
        return _de_oprtime;
    }

    public void set_de_oprtime(String _de_oprtime){
        this._de_oprtime = _de_oprtime;
    }
    public String get_ne_isflag(){
        return _ne_isflag;
    }

    public void set_ne_isflag(String _ne_isflag){
        this._ne_isflag = _ne_isflag;
    }
    public String get_ne_systemflag(){
        return _ne_systemflag;
    }

    public void set_ne_systemflag(String _ne_systemflag){
        this._ne_systemflag = _ne_systemflag;
    }

	public String get_sin_opnid() {
		return _sin_opnid;
	}

	public void set_sin_opnid(String _sin_opnid) {
		this._sin_opnid = _sin_opnid;
	}

	public String get_sql_opnid() {
		return _sql_opnid;
	}

	public void set_sql_opnid(String _sql_opnid) {
		this._sql_opnid = _sql_opnid;
	}

	public String get_se_oprmonth() {
		return _se_oprmonth;
	}

	public void set_se_oprmonth(String _se_oprmonth) {
		this._se_oprmonth = _se_oprmonth;
	}

}
