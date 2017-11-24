/**
 * auto-generated code
 * Mon Dec 08 10:50:04 CST 2008
 */
package com.sunrise.boss.ui.cms.bbc.bbcrewardtotal;

import java.util.List;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: WayintegraltransruleForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BbcRewardtotalForm extends BaseActionForm {

	 private Long totalid;
     private String wayid;
     private Long rewardtype;
     private String rewardmonth;
     private Double paymoney;
     private String countycompname;
     private String wayname;
     private Long starlevel;
 	 private Integer ossrc;
     private String _se_wayid;
     private String _ne_totalid;
     private String _ne_rewardtype;
     private String _se_rewardmonth;
     private String _se_ossrc;
     private String _sql_ossrc = "ossrc in ('0','1','2')";
     private String _se_batchno;
     private List _sin_batchno;
     
 	public String get_sql_ossrc() {
		return _sql_ossrc;
	}
	public void set_sql_ossrc(String _sql_ossrc) {
		this._sql_ossrc = _sql_ossrc;
	}
	public String get_se_ossrc() {
 		return _se_ossrc;
 	}
 	public void set_se_ossrc(String _se_ossrc) {
 		this._se_ossrc = _se_ossrc;
 	}
	public Long getTotalid() {
		return totalid;
	}
	public void setTotalid(Long totalid) {
		this.totalid = totalid;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public Long getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(Long rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getRewardmonth() {
		return rewardmonth;
	}
	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
	public Double getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
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
	public String getCountycompname() {
		return countycompname;
	}
	public void setCountycompname(String countycompname) {
		this.countycompname = countycompname;
	}
	public Long getStarlevel() {
		return starlevel;
	}
	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public Integer getOssrc() {
		return ossrc;
	}
	public void setOssrc(Integer ossrc) {
		this.ossrc = ossrc;
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

}
