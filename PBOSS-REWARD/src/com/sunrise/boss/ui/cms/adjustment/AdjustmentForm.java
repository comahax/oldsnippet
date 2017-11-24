/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.ui.cms.adjustment;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;

/**
 * <p>Title: AdjustmentForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AdjustmentForm extends BaseActionForm {

    private java.lang.Long id;
    private java.lang.String countyid;
    private java.lang.String rewardmonth;
    private java.lang.String wayid;
    private java.lang.Double paysum;
    private java.lang.Double taxmoney;
    private java.lang.String batchno;
    private java.lang.String remark;
    private java.lang.String confirmoprcode;
    private java.util.Date confirmptime;
    private java.lang.String taxoprcode;
    private java.util.Date taxoptime;
    private java.lang.Double rpmoney;
    private java.lang.Short accttype;
    
    private java.lang.String wayname;
    private java.lang.Short starlevel;
    private java.lang.Double invoicesum;
    private java.lang.Double realpay;
    private java.lang.Double fees;
    
    private String chainhead;

    private String _se_countyid;
    private String _se_rewardmonth;
    private String _se_wayid;
    private String _ne_accttype;

    private String _sk_wayname;
    
    private Integer _checked;
    
    private String _se_batchno;
    private String _se_chainhead;
    private Short _ne_starlevel;
    private String[] _se_upperopnid;    
    
    private boolean supportPaymonth = false;
    
    private String _paymonth;
		
	public String get_paymonth() {
		return _paymonth;
	}

	public void set_paymonth(String _paymonth) {
		this._paymonth = _paymonth;
	}

	public boolean isSupportPaymonth() {
		return supportPaymonth;
	}

	public void setSupportPaymonth(boolean supportPaymonth) {
		this.supportPaymonth = supportPaymonth;
	}

	public String[] get_se_upperopnid() {
		return _se_upperopnid;
	}

	public void set_se_upperopnid(String[] _se_upperopnid) {
		this._se_upperopnid = _se_upperopnid;
	}

	private String _hasfees="0";//1存在展示手续费的系统参数且值为1、0不存在系统参数或者系统参数为0，默认不存在系统参数取0
    
    private String _hasupperopnid="0";//1支持业务大类，0不支持，默认不支持
    
    private String _hassubopnidreport="0";//1付款报表按照业务小类展示，0不支持业务小类展示（即默认的业务大类展示）
    
    public boolean suppertUpper(){
    	return ("1".equals(_hasupperopnid));
    }
    
    public boolean supportSubopnReport(){
    	return ("1".equals(_hassubopnidreport));
    }

    //0表示无，只能查看工号所属地市；1表示有令牌，可以查看全省
    //-1为默认值，表示尚未检查令牌权限
    //判断是否具有令牌CH_ADT_MONITOR_CON，有则可以看到整个分公司下拉框
    private Integer citypermited = -1;
    //p判断是否具有令牌CH_ADT_ADJUST_COUNTY，有则分公司下拉框只能看到登录工号所属分公司
    private Integer countypermited = -1;
    
    private int exporttype = 1;//1-doList导出；2-doShowreport导出
    
    public int getExporttype() {
		return exporttype;
	}

	public void setExporttype(int exporttype) {
		this.exporttype = exporttype;
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

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public Short get_ne_starlevel() {
		return _ne_starlevel;
	}

	public void set_ne_starlevel(Short _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}

	public Integer get_checked() {
		return _checked;
	}

	public void set_checked(Integer _checked) {
		this._checked = _checked;
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
    public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.Double getPaysum(){
        return paysum;
    }

    public void setPaysum(java.lang.Double paysum){
        this.paysum = paysum;
    }
    public java.lang.Double getTaxmoney(){
        return taxmoney;
    }

    public void setTaxmoney(java.lang.Double taxmoney){
        this.taxmoney = taxmoney;
    }
    public java.lang.String getBatchno(){
        return batchno;
    }

    public void setBatchno(java.lang.String batchno){
        this.batchno = batchno;
    }
    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }
    public java.lang.String getConfirmoprcode(){
        return confirmoprcode;
    }

    public void setConfirmoprcode(java.lang.String confirmoprcode){
        this.confirmoprcode = confirmoprcode;
    }
    public java.util.Date getConfirmptime(){
        return confirmptime;
    }

    public void setConfirmptime(java.util.Date confirmptime){
        this.confirmptime = confirmptime;
    }
    public java.lang.String getTaxoprcode(){
        return taxoprcode;
    }

    public void setTaxoprcode(java.lang.String taxoprcode){
        this.taxoprcode = taxoprcode;
    }
    public java.util.Date getTaxoptime(){
        return taxoptime;
    }

    public void setTaxoptime(java.util.Date taxoptime){
        this.taxoptime = taxoptime;
    }

    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
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

	public java.lang.String getWayname() {
		return wayname;
	}

	public void setWayname(java.lang.String wayname) {
		this.wayname = wayname;
	}

	public java.lang.Short getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(java.lang.Short starlevel) {
		this.starlevel = starlevel;
	}

	public java.lang.Double getInvoicesum() {
		return invoicesum;
	}

	public void setInvoicesum(java.lang.Double invoicesum) {
		this.invoicesum = invoicesum;
	}

	public java.lang.Double getRealpay() {
		return realpay;
	}

	public void setRealpay(java.lang.Double realpay) {
		this.realpay = realpay;
	}

	public java.lang.Double getRpmoney() {
		return rpmoney;
	}

	public void setRpmoney(java.lang.Double rpmoney) {
		this.rpmoney = rpmoney;
	}

	public java.lang.Short getAccttype() {
		return accttype;
	}

	public void setAccttype(java.lang.Short accttype) {
		this.accttype = accttype;
	}

	public String get_ne_accttype() {
		return _ne_accttype;
	}

	public void set_ne_accttype(String _ne_accttype) {
		this._ne_accttype = _ne_accttype;
	}

	public java.lang.Double getFees() {
		return fees;
	}

	public void setFees(java.lang.Double fees) {
		this.fees = fees;
	}

	public String get_hasfees() {
		return _hasfees;
	}

	public void set_hasfees(String _hasfees) {
		this._hasfees = _hasfees;
	}

	public String get_hasupperopnid() {
		return _hasupperopnid;
	}

	public void set_hasupperopnid(String _hasupperopnid) {
		this._hasupperopnid = _hasupperopnid;
	}

	public String get_hassubopnidreport() {
		return _hassubopnidreport;
	}

	public void set_hassubopnidreport(String _hassubopnidreport) {
		this._hassubopnidreport = _hassubopnidreport;
	}
}
