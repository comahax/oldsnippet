/**
 * auto-generated code
 * Sat Jun 09 10:21:12 CST 2012
 */
package com.gmcc.pboss.business.channel.checkedapply;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CheckedapplyDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CheckedapplyDBParam extends DBQueryParam {
	private String _se_cityid;
	private String _dnl_aptime;
	private String _dnm_aptime;
	
	private String _ne_applyno; 
    private String _se_applytype;
    private String _se_oprcode;
    private String _se_status;
    
    private String _sql_status;
    private String _se_oprcode2;
    private String _sql_oprcode2;
    
	// or查询条件
    private String _sql_or;
    
    private String chktype;//考核方式
    private String chgtype;//调整内容
    private String selectw;//选择的渠道编码
    private String mobileno;//手机号码
    private String oprcode2;//审核人
    private String oprcode;//申请人
    private String cityid;//地市
    private java.util.Date aptime;//申请时间 
    private String applytype;//申请类型
    private String memo;//备注
    private String applyeno;//申请单号
    private String appath;//申请表文件
    private String pptpath;//申请PPT文件
    
    private String _sk_wayid;
    private String _sk_wayname;
    
    private String _se_countyid;
    
    private String queryRange;
    
    private boolean isExcel;
    
    private boolean APPSTATUS_MULTI;
    
	public boolean isExcel() {
		return isExcel;
	}

	public void setExcel(boolean isExcel) {
		this.isExcel = isExcel;
	}

	public String getQueryRange() {
		return queryRange;
	}

	public void setQueryRange(String queryRange) {
		this.queryRange = queryRange;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}

	public String get_sk_wayname() {
		return _sk_wayname;
	}

	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}

	public String getOprcode2() {
		return oprcode2;
	}

	public void setOprcode2(String oprcode2) {
		this.oprcode2 = oprcode2;
	}

	public String get_dnl_aptime() {
		return _dnl_aptime;
	}

	public void set_dnl_aptime(String _dnl_aptime) {
		this._dnl_aptime = _dnl_aptime;
	}

	public String get_dnm_aptime() {
		return _dnm_aptime;
	}

	public void set_dnm_aptime(String _dnm_aptime) {
		this._dnm_aptime = _dnm_aptime;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_ne_applyno() {
		return _ne_applyno;
	}

	public void set_ne_applyno(String _ne_applyno) {
		this._ne_applyno = _ne_applyno;
	}

	public String get_se_applytype() {
		return _se_applytype;
	}

	public void set_se_applytype(String _se_applytype) {
		this._se_applytype = _se_applytype;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String getChktype() {
		return chktype;
	}

	public void setChktype(String chktype) {
		this.chktype = chktype;
	}

	public String getChgtype() {
		return chgtype;
	}

	public void setChgtype(String chgtype) {
		this.chgtype = chgtype;
	}

	public String getSelectw() {
		return selectw;
	}

	public void setSelectw(String selectw) {
		this.selectw = selectw;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public java.util.Date getAptime() {
		return aptime;
	}

	public void setAptime(java.util.Date aptime) {
		this.aptime = aptime;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getApplyeno() {
		return applyeno;
	}

	public void setApplyeno(String applyeno) {
		this.applyeno = applyeno;
	}

	public String getAppath() {
		return appath;
	}

	public void setAppath(String appath) {
		this.appath = appath;
	}

	public String getPptpath() {
		return pptpath;
	}

	public void setPptpath(String pptpath) {
		this.pptpath = pptpath;
	}

	public String get_se_status() {
		return _se_status;
	}

	public void set_se_status(String _se_status) {
		this._se_status = _se_status;
	}

	public String get_sql_status() {
		return _sql_status;
	}

	public void set_sql_status(String _sql_status) {
		this._sql_status = _sql_status;
	}

	public String get_se_oprcode2() {
		return _se_oprcode2;
	}

	public void set_se_oprcode2(String _se_oprcode2) {
		this._se_oprcode2 = _se_oprcode2;
	}

	public boolean isAPPSTATUS_MULTI() {
		return APPSTATUS_MULTI;
	}

	public void setAPPSTATUS_MULTI(boolean appstatus_multi) {
		APPSTATUS_MULTI = appstatus_multi;
	}

	public String get_sql_or() {
		return _sql_or;
	}

	public void set_sql_or(String _sql_or) {
		this._sql_or = _sql_or;
	}

	public String get_sql_oprcode2() {
		return _sql_oprcode2;
	}

	public void set_sql_oprcode2(String _sql_oprcode2) {
		this._sql_oprcode2 = _sql_oprcode2;
	}
}
