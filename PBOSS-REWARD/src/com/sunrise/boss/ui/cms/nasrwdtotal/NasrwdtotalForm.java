/**
 * auto-generated code
 * Mon Jun 29 11:25:27 CST 2009
 */
package com.sunrise.boss.ui.cms.nasrwdtotal;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: NasrwdtotalForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class NasrwdtotalForm extends BaseActionForm {
	private String _ne_totalid;

	private String _se_rewardmonth;

	private String _ne_rewardtype;

	private String _se_wayid;

	/** identifier field */
	private Long totalid;

	/** nullable persistent field */
	private String wayid;

	/** nullable persistent field */
	private Short rewardtype;

	/** nullable persistent field */
	private String rewardmonth;

	/** nullable persistent field */
	private Double paymoney;

	/** nullable persistent field */
	private Short ossrc;

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_ne_totalid() {
		return _ne_totalid;
	}

	public void set_ne_totalid(String _ne_totalid) {
		this._ne_totalid = _ne_totalid;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public Short getOssrc() {
		return ossrc;
	}

	public void setOssrc(Short ossrc) {
		this.ossrc = ossrc;
	}

	public Double getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
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

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
