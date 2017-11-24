/**
* auto-generated code
* Wed Sep 02 10:14:50 CST 2009
*/
package com.sunrise.boss.ui.cms.bbc.unvrewardtotal;

import java.util.List;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: UnvRewardtotalForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvRewardtotalForm extends BaseActionForm {

    private java.lang.Long totalid;
    private java.lang.Double paymoney;
    private java.lang.Short rewardtype;
    private java.lang.String rewardmonth;
    private java.lang.String wayid;
    private java.lang.String batchno;
    
	private String _se_wayid;
    private String _ne_totalid;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_batchno;
    private List _sin_batchno;
    

	public java.lang.Long getTotalid(){
        return totalid;
    }

    public void setTotalid(java.lang.Long totalid){
        this.totalid = totalid;
    }
    public java.lang.Double getPaymoney(){
        return paymoney;
    }

    public void setPaymoney(java.lang.Double paymoney){
        this.paymoney = paymoney;
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
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
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



}
