/**
* auto-generated code
* Wed Aug 15 12:26:00 CST 2012
*/
package com.sunrise.boss.ui.cms.dcord;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.dcord.persistent.DcordVO;

/**
 * <p>Title: DcordForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DcordForm extends BaseActionForm {

    private java.lang.Long id;
    private java.lang.String countyid;
    private java.lang.String wayid;
    private java.lang.String wayname;
    private java.lang.Short starlevel;
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
    private String abatchno;    
    private java.util.Date condate;

    private String _se_countyid;
    private String _se_wayid;
    private String _sk_wayname;
    private String _ne_starlevel;
    private String _se_opnid;
    private String _se_upperopnid;
    private String _se_subopnid;
    private String _se_oprmonth;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_batchno;
    private String _se_abatchno;
    private String _ne_isflag;
    
    private String _subopnids;
    
    //0表示无，只能查看工号所属地市；1表示有令牌，可以查看全省
    //-1为默认值，表示尚未检查令牌权限
    //判断是否具有令牌CH_ADT_MONITOR_CON，有则可以看到整个分公司下拉框
    private Integer citypermited = -1;
    //p判断是否具有令牌CH_ADT_ADJUST_COUNTY，有则分公司下拉框只能看到登录工号所属分公司
    private Integer countypermited = -1;
    
    private boolean supportPaymonth = false;
    private String _se_paymonth;
    

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

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_se_abatchno() {
		return _se_abatchno;
	}

	public void set_se_abatchno(String _se_abatchno) {
		this._se_abatchno = _se_abatchno;
	}

	public Integer getCitypermited() {
		return citypermited;
	}

	public void setCitypermited(Integer citypermited) {
		this.citypermited = citypermited;
	}

	public Integer getCountypermited() {
		return countypermited;
	}

	public void setCountypermited(Integer countypermited) {
		this.countypermited = countypermited;
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
    public java.lang.String getWayname(){
        return wayname;
    }

    public void setWayname(java.lang.String wayname){
        this.wayname = wayname;
    }
    public java.lang.Short getStarlevel(){
        return starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel){
        this.starlevel = starlevel;
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

    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_sk_wayname(){
        return _sk_wayname;
    }

    public void set_sk_wayname(String _sk_wayname){
        this._sk_wayname = _sk_wayname;
    }
    public String get_ne_starlevel(){
        return _ne_starlevel;
    }

    public void set_ne_starlevel(String _ne_starlevel){
        this._ne_starlevel = _ne_starlevel;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_upperopnid(){
        return _se_upperopnid;
    }

    public void set_se_upperopnid(String _se_upperopnid){
        this._se_upperopnid = _se_upperopnid;
    }
    public String get_se_subopnid(){
        return _se_subopnid;
    }

    public void set_se_subopnid(String _se_subopnid){
        this._se_subopnid = _se_subopnid;
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

    public String get_subopnids() {
		return _subopnids;
	}

	public void set_subopnids(String _subopnids) {
		this._subopnids = _subopnids;
	}

	public String getAbatchno() {
		return abatchno;
	}

	public void setAbatchno(String abatchno) {
		this.abatchno = abatchno;
	}

	public java.util.Date getCondate() {
		return condate;
	}

	public void setCondate(java.util.Date condate) {
		this.condate = condate;
	}

	public String get_ne_isflag() {
		return _ne_isflag;
	}

	public void set_ne_isflag(String _ne_isflag) {
		this._ne_isflag = _ne_isflag;
	}
}
