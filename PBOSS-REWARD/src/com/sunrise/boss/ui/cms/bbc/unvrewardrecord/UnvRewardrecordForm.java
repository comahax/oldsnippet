/**
* auto-generated code
* Wed Sep 02 15:01:47 CST 2009
*/
package com.sunrise.boss.ui.cms.bbc.unvrewardrecord;

import java.util.List;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: UnvRewardrecordForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvRewardrecordForm extends BaseActionForm {

    private java.lang.Long rewardlistid;
    private java.lang.String operseq;
    private java.lang.String datasrc;
    private java.lang.String opnid;
    private java.lang.String wayid;
    private java.lang.String wayoprcode;
    private java.lang.Long rewardid;
    private java.lang.Short rewardtype;
    private java.lang.Double rewardstd;
    private java.lang.String rewardmonth;
    private java.lang.Double totalsum;
    private java.lang.Double paysum;
    private java.util.Date runtime;
    private java.util.Date oprtime;
    private java.lang.Short noncyc;
    private java.lang.Short ossrc;
    private java.lang.String batchno;
    private java.lang.String mobile;

	private String _se_wayid;
    private String _ne_totalid;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_ossrc;
    private String _se_opnid;
    private String _se_wayoprcode;
    private String _se_wayname;
    private String _sk_wayoprcode;
    private String _sk_employeename;
    private String _se_batchno;
    private List _sin_batchno;

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

	public List get_sin_batchno() {
		return _sin_batchno;
	}

	public void set_sin_batchno(List _sin_batchno) {
		this._sin_batchno = _sin_batchno;
	}

	public java.lang.String getBatchno() {
		return batchno;
	}

	public void setBatchno(java.lang.String batchno) {
		this.batchno = batchno;
	}

	public String get_sk_wayoprcode() {
		return _sk_wayoprcode;
	}

	public void set_sk_wayoprcode(String _sk_wayoprcode) {
		this._sk_wayoprcode = _sk_wayoprcode;
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

	public String get_se_wayoprcode() {
		return _se_wayoprcode;
	}

	public void set_se_wayoprcode(String _se_wayoprcode) {
		this._se_wayoprcode = _se_wayoprcode;
	}

	public java.lang.Long getRewardlistid(){
        return rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid){
        this.rewardlistid = rewardlistid;
    }
    public java.lang.String getOperseq(){
        return operseq;
    }

    public void setOperseq(java.lang.String operseq){
        this.operseq = operseq;
    }
    public java.lang.String getDatasrc(){
        return datasrc;
    }

    public void setDatasrc(java.lang.String datasrc){
        this.datasrc = datasrc;
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
    public java.lang.String getWayoprcode(){
        return wayoprcode;
    }

    public void setWayoprcode(java.lang.String wayoprcode){
        this.wayoprcode = wayoprcode;
    }
    public java.lang.Long getRewardid(){
        return rewardid;
    }

    public void setRewardid(java.lang.Long rewardid){
        this.rewardid = rewardid;
    }
    public java.lang.Short getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.lang.Double getRewardstd(){
        return rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd){
        this.rewardstd = rewardstd;
    }
    public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
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
    public java.util.Date getRuntime(){
        return runtime;
    }

    public void setRuntime(java.util.Date runtime){
        this.runtime = runtime;
    }
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }
    public java.lang.Short getNoncyc(){
        return noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc){
        this.noncyc = noncyc;
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

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public String get_se_ossrc() {
		return _se_ossrc;
	}

	public void set_se_ossrc(String _se_ossrc) {
		this._se_ossrc = _se_ossrc;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public java.lang.String getMobile() {
		return mobile;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public String get_se_telephone() {
		return _se_telephone;
	}

	public void set_se_telephone(String _se_telephone) {
		this._se_telephone = _se_telephone;
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
	
	public Boolean getHasProvAgentView() {
		return hasProvAgentView;
	}

	public void setHasProvAgentView(Boolean hasProvAgentView) {
		this.hasProvAgentView = hasProvAgentView;
	}
}
