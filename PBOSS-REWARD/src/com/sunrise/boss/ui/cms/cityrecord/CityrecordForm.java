/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.ui.cms.cityrecord;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: CityrecordForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CityrecordForm extends BaseActionForm {

    private java.lang.Long recordid;
    private java.lang.String opnid;
    private java.lang.String wayid;
    private java.lang.Short rewardtype;
    private java.lang.String rewardmonth;
    private java.lang.String mobile;
    private java.util.Date oprtime;
    private java.lang.Double busivalue;
    private java.lang.Double paysum;
    private java.lang.String approveid;
    private java.lang.Short isflag;
    private java.lang.String oprcode;
    private java.util.Date optime;
    private java.lang.Short systemflag;
    private java.lang.Long rewardlistid;
    private String accountoprcode;
    private String adjustoprcode;
    private String paymentoprcode;
    private String batchno;
    private java.util.Date accountoptime;
    private java.util.Date adjustoptime;
    private java.util.Date paymentoptime;
    private Long brank;

    private String _ne_recordid;
    private String _se_opnid;
    private String _se_opnid2;
    private String _subopnids;
    private String _sin_opnid;
    private String _se_wayid;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_approveid;
    private String _ne_isflag;
    private String _ne_systemflag;
    private String _nne_systemflag;
    private String _ne_rewardlistid;
    private String _se_waylike;
    private String _sql_opnid;
    private String _sql_isflag;
    private String sqlopnid;

    private String _se_chainhead;
    private String _ne_taskid;
    private String _se_countyid;
    
    private String prePageno;
    private String preWayid;
    private String preOpnid;
    private String preRewardtype;
    private String preRewardmonth;
    //确认明细页面需要的参数
    private String opnid2;
    private String oprmonth;
    private String _se_mobile;
    private String _sk_opnid;
    private String selectedStr;
    private String _se_oprmonth;
    
    private int iscountyoperid = -1;//1分公司工号；0市公司工号
    private String paymonth;  //付款月份 单号：（2013）NBBOSS-D00200
    private String _se_paymonth; 
    private boolean supportPaymonth = false;
    
    private  java.lang.Long dcordid;
	public int getIscountyoperid() {
		return iscountyoperid;
	}

	public void setIscountyoperid(int iscountyoperid) {
		this.iscountyoperid = iscountyoperid;
	}

	public String get_se_oprmonth() {
		return _se_oprmonth;
	}

	public void set_se_oprmonth(String _se_oprmonth) {
		this._se_oprmonth = _se_oprmonth;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String getOprmonth() {
		return oprmonth;
	}

	public String getOpnid2() {
		return opnid2;
	}

	public void setOpnid2(String opnid2) {
		this.opnid2 = opnid2;
	}

	public String get_ne_taskid() {
		return _ne_taskid;
	}

	public void set_ne_taskid(String _ne_taskid) {
		this._ne_taskid = _ne_taskid;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
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

    public String get_ne_recordid(){
        return _ne_recordid;
    }

    public void set_ne_recordid(String _ne_recordid){
        this._ne_recordid = _ne_recordid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_sin_opnid(){
        return _sin_opnid;
    }

    public void set_sin_opnid(String _sin_opnid){
        this._sin_opnid = _sin_opnid;
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
    public String get_se_approveid(){
        return _se_approveid;
    }

    public void set_se_approveid(String _se_approveid){
        this._se_approveid = _se_approveid;
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
    public String get_nne_systemflag(){
        return _nne_systemflag;
    }

    public void set_nne_systemflag(String _nne_systemflag){
        this._nne_systemflag = _nne_systemflag;
    }
    public String get_ne_rewardlistid(){
        return _ne_rewardlistid;
    }

    public void set_ne_rewardlistid(String _ne_rewardlistid){
        this._ne_rewardlistid = _ne_rewardlistid;
    }
    
    public String get_se_waylike() {
		return _se_waylike;
	}

	public void set_se_waylike(String _se_waylike) {
		this._se_waylike = _se_waylike;
	}
	
	public String get_sql_opnid() {
		return _sql_opnid;
	}
	
	public void set_sql_opnid(String _sql_opnid) {
		this._sql_opnid = _sql_opnid;
	}

	public String get_sql_isflag() {
		return _sql_isflag;
	}

	public void set_sql_isflag(String _sql_isflag) {
		this._sql_isflag = _sql_isflag;
	}

	public String getSqlopnid() {
		return sqlopnid;
	}

	public void setSqlopnid(String sqlopnid) {
		this.sqlopnid = sqlopnid;
	}

	public String getPrePageno() {
		return prePageno;
	}

	public void setPrePageno(String prePageno) {
		this.prePageno = prePageno;
	}

	public String getPreWayid() {
		return preWayid;
	}

	public void setPreWayid(String preWayid) {
		this.preWayid = preWayid;
	}

	public String getPreOpnid() {
		return preOpnid;
	}

	public void setPreOpnid(String preOpnid) {
		this.preOpnid = preOpnid;
	}

	public String getPreRewardtype() {
		return preRewardtype;
	}

	public void setPreRewardtype(String preRewardtype) {
		this.preRewardtype = preRewardtype;
	}

	public String getPreRewardmonth() {
		return preRewardmonth;
	}

	public void setPreRewardmonth(String preRewardmonth) {
		this.preRewardmonth = preRewardmonth;
	}

	public void setOprmonth(String oprmonth) {
		this.oprmonth = oprmonth;
	}

	public String get_sk_opnid() {
		return _sk_opnid;
	}

	public void set_sk_opnid(String _sk_opnid) {
		this._sk_opnid = _sk_opnid;
	}

	public String getSelectedStr() {
		return selectedStr;
	}

	public void setSelectedStr(String selectedStr) {
		this.selectedStr = selectedStr;
	}

	public String getAccountoprcode() {
		return accountoprcode;
	}

	public void setAccountoprcode(String accountoprcode) {
		this.accountoprcode = accountoprcode;
	}

	public String getAdjustoprcode() {
		return adjustoprcode;
	}

	public void setAdjustoprcode(String adjustoprcode) {
		this.adjustoprcode = adjustoprcode;
	}

	public String getPaymentoprcode() {
		return paymentoprcode;
	}

	public void setPaymentoprcode(String paymentoprcode) {
		this.paymentoprcode = paymentoprcode;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public java.util.Date getAccountoptime() {
		return accountoptime;
	}

	public void setAccountoptime(java.util.Date accountoptime) {
		this.accountoptime = accountoptime;
	}

	public java.util.Date getAdjustoptime() {
		return adjustoptime;
	}

	public void setAdjustoptime(java.util.Date adjustoptime) {
		this.adjustoptime = adjustoptime;
	}

	public java.util.Date getPaymentoptime() {
		return paymentoptime;
	}

	public void setPaymentoptime(java.util.Date paymentoptime) {
		this.paymentoptime = paymentoptime;
	}

	public Long getBrank() {
		return brank;
	}

	public void setBrank(Long brank) {
		this.brank = brank;
	}

	public String get_se_opnid2() {
		return _se_opnid2;
	}

	public void set_se_opnid2(String _se_opnid2) {
		this._se_opnid2 = _se_opnid2;
	}

	public String get_subopnids() {
		return _subopnids;
	}

	public void set_subopnids(String _subopnids) {
		this._subopnids = _subopnids;
	}

	public boolean isSupportPaymonth() {
		return supportPaymonth;
	}

	public void setSupportPaymonth(boolean supportPaymonth) {
		this.supportPaymonth = supportPaymonth;
	}

	public java.lang.Long getDcordid() {
		return dcordid;
	}

	public void setDcordid(java.lang.Long dcordid) {
		this.dcordid = dcordid;
	}

	public String get_se_paymonth() {
		return _se_paymonth;
	}

	public void set_se_paymonth(String _se_paymonth) {
		this._se_paymonth = _se_paymonth;
	}

	public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	} 
}
