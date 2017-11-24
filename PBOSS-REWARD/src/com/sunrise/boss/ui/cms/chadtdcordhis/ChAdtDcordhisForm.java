/**
* auto-generated code
* Tue Aug 21 12:28:54 CST 2012
*/
package com.sunrise.boss.ui.cms.chadtdcordhis;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChAdtDcordhisForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtDcordhisForm extends BaseActionForm {

    private java.lang.Long id;
    private java.lang.String countyid;
    private java.lang.String wayid;
    private java.lang.String opnid;
    private java.lang.String upperopnid;
    private java.lang.String subopnid;
    private java.lang.String oprmonth;
    private java.lang.Short rewardtype;
    private java.lang.String rewardmonth;
    private java.lang.Long gotonebusivalue;
    private java.lang.Double gotonemoney;
    private java.lang.Long szxbusivalue;
    private java.lang.Double szxmoney;
    private java.lang.Long mzonebusivalue;
    private java.lang.Double mzonemoney;
    private java.lang.Long tdbusivalue;
    private java.lang.Double tdmoney;
    private java.lang.Long otherbusivalue;
    private java.lang.Double othermoney;
    private java.lang.Long busivaluesum;
    private java.lang.Double moneysum;
    private java.lang.Short isflag;
    private java.lang.String adjustoprcode;
    private java.util.Date adjustoptime;
    private java.lang.String paymentoprcode;
    private java.util.Date paymentoptime;
    private java.lang.String batchno;
    private java.lang.String mbatchno;
    private java.lang.Short systemflag;
    private java.lang.String mobile;
    
    private String _ne_systemflag;
    private String _se_mobile;

    private String _se_wayid;
    private String _se_opnid;
    private String _se_oprmonth;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _ne_isflag;
    private String _sin_opnid;
    private String _sql_opnid;
   

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

	public java.lang.Long getId(){
        return id;
    }

    public void setId(java.lang.Long id){
        this.id = id;
    }
    public java.lang.String getCountyid(){
        return countyid;
    }

    public void setCountyid(java.lang.String countyid){
        this.countyid = countyid;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getUpperopnid(){
        return upperopnid;
    }

    public void setUpperopnid(java.lang.String upperopnid){
        this.upperopnid = upperopnid;
    }
    public java.lang.String getSubopnid(){
        return subopnid;
    }

    public void setSubopnid(java.lang.String subopnid){
        this.subopnid = subopnid;
    }
    public java.lang.String getOprmonth(){
        return oprmonth;
    }

    public void setOprmonth(java.lang.String oprmonth){
        this.oprmonth = oprmonth;
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
    public java.lang.Long getGotonebusivalue(){
        return gotonebusivalue;
    }

    public void setGotonebusivalue(java.lang.Long gotonebusivalue){
        this.gotonebusivalue = gotonebusivalue;
    }
    public java.lang.Double getGotonemoney(){
        return gotonemoney;
    }

    public void setGotonemoney(java.lang.Double gotonemoney){
        this.gotonemoney = gotonemoney;
    }
    public java.lang.Long getSzxbusivalue(){
        return szxbusivalue;
    }

    public void setSzxbusivalue(java.lang.Long szxbusivalue){
        this.szxbusivalue = szxbusivalue;
    }
    public java.lang.Double getSzxmoney(){
        return szxmoney;
    }

    public void setSzxmoney(java.lang.Double szxmoney){
        this.szxmoney = szxmoney;
    }
    public java.lang.Long getMzonebusivalue(){
        return mzonebusivalue;
    }

    public void setMzonebusivalue(java.lang.Long mzonebusivalue){
        this.mzonebusivalue = mzonebusivalue;
    }
    public java.lang.Double getMzonemoney(){
        return mzonemoney;
    }

    public void setMzonemoney(java.lang.Double mzonemoney){
        this.mzonemoney = mzonemoney;
    }
    public java.lang.Long getTdbusivalue(){
        return tdbusivalue;
    }

    public void setTdbusivalue(java.lang.Long tdbusivalue){
        this.tdbusivalue = tdbusivalue;
    }
    public java.lang.Double getTdmoney(){
        return tdmoney;
    }

    public void setTdmoney(java.lang.Double tdmoney){
        this.tdmoney = tdmoney;
    }
    public java.lang.Long getOtherbusivalue(){
        return otherbusivalue;
    }

    public void setOtherbusivalue(java.lang.Long otherbusivalue){
        this.otherbusivalue = otherbusivalue;
    }
    public java.lang.Double getOthermoney(){
        return othermoney;
    }

    public void setOthermoney(java.lang.Double othermoney){
        this.othermoney = othermoney;
    }
    public java.lang.Long getBusivaluesum(){
        return busivaluesum;
    }

    public void setBusivaluesum(java.lang.Long busivaluesum){
        this.busivaluesum = busivaluesum;
    }
    public java.lang.Double getMoneysum(){
        return moneysum;
    }

    public void setMoneysum(java.lang.Double moneysum){
        this.moneysum = moneysum;
    }
    public java.lang.Short getIsflag(){
        return isflag;
    }

    public void setIsflag(java.lang.Short isflag){
        this.isflag = isflag;
    }
    public java.lang.String getAdjustoprcode(){
        return adjustoprcode;
    }

    public void setAdjustoprcode(java.lang.String adjustoprcode){
        this.adjustoprcode = adjustoprcode;
    }
    public java.util.Date getAdjustoptime(){
        return adjustoptime;
    }

    public void setAdjustoptime(java.util.Date adjustoptime){
        this.adjustoptime = adjustoptime;
    }
    public java.lang.String getPaymentoprcode(){
        return paymentoprcode;
    }

    public void setPaymentoprcode(java.lang.String paymentoprcode){
        this.paymentoprcode = paymentoprcode;
    }
    public java.util.Date getPaymentoptime(){
        return paymentoptime;
    }

    public void setPaymentoptime(java.util.Date paymentoptime){
        this.paymentoptime = paymentoptime;
    }
    public java.lang.String getBatchno(){
        return batchno;
    }

    public void setBatchno(java.lang.String batchno){
        this.batchno = batchno;
    }
    public java.lang.String getMbatchno(){
        return mbatchno;
    }

    public void setMbatchno(java.lang.String mbatchno){
        this.mbatchno = mbatchno;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_oprmonth(){
        return _se_oprmonth;
    }

    public void set_se_oprmonth(String _se_oprmonth){
        this._se_oprmonth = _se_oprmonth;
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
    public String get_ne_isflag(){
        return _ne_isflag;
    }

    public void set_ne_isflag(String _ne_isflag){
        this._ne_isflag = _ne_isflag;
    }

	public java.lang.Short getSystemflag() {
		return systemflag;
	}

	public void setSystemflag(java.lang.Short systemflag) {
		this.systemflag = systemflag;
	}

	public java.lang.String getMobile() {
		return mobile;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public String get_ne_systemflag() {
		return _ne_systemflag;
	}

	public void set_ne_systemflag(String _ne_systemflag) {
		this._ne_systemflag = _ne_systemflag;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

}
