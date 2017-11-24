/**
* auto-generated code
* Wed Sep 02 16:37:07 CST 2009
*/
package com.sunrise.boss.ui.cms.bbc.unvfaildataquery;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: UnvFaildataqueryForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvFaildataqueryForm extends BaseActionForm {

    private java.lang.Long failid;
    private java.lang.String rcno;
    private java.lang.String mobileno;
    private java.lang.String opnid;
    private java.lang.String rcmonth;
    private java.util.Date rcdate;
    private java.lang.String reason;
    private java.lang.Short ossrc;
    private String adtcode;
    private String wayid;
    private String calcmonth;
    private String mobile;
    private String employeeid;
    private String batchno;
    private java.util.Date oprtime;
    private String status;
	private String _se_wayid;
    private String _ne_totalid;
    private String _ne_rewardtype;
    private String _se_rcmonth;
    private String _se_ossrc;
    private String _se_rcno;
    private String _se_opnid;
    private String _se_employeeid;
    private String _se_calcmonth;
    private String _se_wayname;
    private String _sk_employeename;
    private String _sk_employeeid;
    private String _se_batchno;
    private String _sin_batchno;
    
    private String _se_telephone;
    private String _ne_citycompid;
    private Boolean hasPurview;
    private Boolean hasProvAgentView;

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_sin_batchno() {
		return _sin_batchno;
	}

	public void set_sin_batchno(String _sin_batchno) {
		this._sin_batchno = _sin_batchno;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String get_sk_employeename() {
		return _sk_employeename;
	}

	public void set_sk_employeename(String _sk_employeename) {
		this._sk_employeename = _sk_employeename;
	}

	public String get_se_wayname() {
		return _se_wayname;
	}

	public void set_se_wayname(String _se_wayname) {
		this._se_wayname = _se_wayname;
	}

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

	public String get_se_employeeid() {
		return _se_employeeid;
	}

	public void set_se_employeeid(String _se_employeeid) {
		this._se_employeeid = _se_employeeid;
	}

	public String getAdtcode() {
		return adtcode;
	}

	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}

	public java.lang.Long getFailid(){
        return failid;
    }

    public void setFailid(java.lang.Long failid){
        this.failid = failid;
    }
    public java.lang.String getRcno(){
        return rcno;
    }

    public void setRcno(java.lang.String rcno){
        this.rcno = rcno;
    }
    public java.lang.String getMobileno(){
        return mobileno;
    }

    public void setMobileno(java.lang.String mobileno){
        this.mobileno = mobileno;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getRcmonth(){
        return rcmonth;
    }

    public void setRcmonth(java.lang.String rcmonth){
        this.rcmonth = rcmonth;
    }
    public java.util.Date getRcdate(){
        return rcdate;
    }

    public void setRcdate(java.util.Date rcdate){
        this.rcdate = rcdate;
    }
    public java.lang.String getReason(){
        return reason;
    }

    public void setReason(java.lang.String reason){
        this.reason = reason;
    }
    public java.lang.Short getOssrc(){
        return ossrc;
    }

    public void setOssrc(java.lang.Short ossrc){
        this.ossrc = ossrc;
    }

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_totalid() {
		return _ne_totalid;
	}

	public void set_ne_totalid(String _ne_totalid) {
		this._ne_totalid = _ne_totalid;
	}

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_se_rcmonth() {
		return _se_rcmonth;
	}

	public void set_se_rcmonth(String _se_rcmonth) {
		this._se_rcmonth = _se_rcmonth;
	}

	public String get_se_ossrc() {
		return _se_ossrc;
	}

	public void set_se_ossrc(String _se_ossrc) {
		this._se_ossrc = _se_ossrc;
	}

	public String get_se_rcno() {
		return _se_rcno;
	}

	public void set_se_rcno(String _se_rcno) {
		this._se_rcno = _se_rcno;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String get_sk_employeeid() {
		return _sk_employeeid;
	}

	public void set_sk_employeeid(String _sk_employeeid) {
		this._sk_employeeid = _sk_employeeid;
	}

	public String get_ne_citycompid() {
		return _ne_citycompid;
	}

	public void set_ne_citycompid(String _ne_citycompid) {
		this._ne_citycompid = _ne_citycompid;
	}

	public Boolean getHasPurview() {
		return hasPurview;
	}

	public void setHasPurview(Boolean hasPurview) {
		this.hasPurview = hasPurview;
	}

	public String get_se_telephone() {
		return _se_telephone;
	}

	public void set_se_telephone(String _se_telephone) {
		this._se_telephone = _se_telephone;
	}

	public java.util.Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Boolean getHasProvAgentView() {
		return hasProvAgentView;
	}

	public void setHasProvAgentView(Boolean hasProvAgentView) {
		this.hasProvAgentView = hasProvAgentView;
	}
}
