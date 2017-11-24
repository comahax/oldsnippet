package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import com.sunrise.boss.ui.base.BaseActionForm;

public class ZjtyRewarddetailForm extends BaseActionForm {
	//ListVO
	private String _se_opnid;

	private String _se_wayid;

	private String _se_rewardtype;

	private String _se_acctype;

	private String _snl_rewardmont;

	private String _snm_rewardmont;
	
	private String _se_rewardmont;

	//VO
	/** identifier field */
	private Long rewardlistid;

	/** nullable persistent field */
	private Long operseq;

	/** nullable persistent field */
	private String opnid;

	/** nullable persistent field */
	private String wayid;

	/** nullable persistent field */
	private String wayopercode;

	/** nullable persistent field */
	private Long rewardid;

	/** nullable persistent field */
	private Short rewardtype;

	/** nullable persistent field */
	private Double rewardstd;

	/** nullable persistent field */
	private Short acctype;

	/** nullable persistent field */
	private Double coef1;

	/** nullable persistent field */
	private Double coef2;

	/** nullable persistent field */
	private Double coef3;

	/** nullable persistent field */
	private Double coef4;

	/** nullable persistent field */
	private String rewardmont;

	/** nullable persistent field */
	private Double totalsum;

	/** nullable persistent field */
	private Double paysum;

	/** nullable persistent field */
	private String batchnum;

	public String get_snl_rewardmont() {
		return _snl_rewardmont;
	}

	public void set_snl_rewardmont(String _snl_rewardmont) {
		this._snl_rewardmont = _snl_rewardmont;
	}

	public String get_snm_rewardmont() {
		return _snm_rewardmont;
	}

	public void set_snm_rewardmont(String _snm_rewardmont) {
		this._snm_rewardmont = _snm_rewardmont;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_acctype() {
		return _se_acctype;
	}

	public void set_se_acctype(String _se_acctype) {
		this._se_acctype = _se_acctype;
	}

	public String get_se_rewardtype() {
		return _se_rewardtype;
	}

	public void set_se_rewardtype(String _se_rewardtype) {
		this._se_rewardtype = _se_rewardtype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public Short getAcctype() {
		return acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}

	public String getBatchnum() {
		return batchnum;
	}

	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}

	public Double getCoef1() {
		return coef1;
	}

	public void setCoef1(Double coef1) {
		this.coef1 = coef1;
	}

	public Double getCoef2() {
		return coef2;
	}

	public void setCoef2(Double coef2) {
		this.coef2 = coef2;
	}

	public Double getCoef3() {
		return coef3;
	}

	public void setCoef3(Double coef3) {
		this.coef3 = coef3;
	}

	public Double getCoef4() {
		return coef4;
	}

	public void setCoef4(Double coef4) {
		this.coef4 = coef4;
	}

	public Long getOperseq() {
		return operseq;
	}

	public void setOperseq(Long operseq) {
		this.operseq = operseq;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public Double getPaysum() {
		return paysum;
	}

	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public Long getRewardlistid() {
		return rewardlistid;
	}

	public void setRewardlistid(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	public String getRewardmont() {
		return rewardmont;
	}

	public void setRewardmont(String rewardmont) {
		this.rewardmont = rewardmont;
	}

	public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public Double getTotalsum() {
		return totalsum;
	}

	public void setTotalsum(Double totalsum) {
		this.totalsum = totalsum;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayopercode() {
		return wayopercode;
	}

	public void setWayopercode(String wayopercode) {
		this.wayopercode = wayopercode;
	}

	public String get_se_rewardmont() {
		return _se_rewardmont;
	}

	public void set_se_rewardmont(String _se_rewardmont) {
		this._se_rewardmont = _se_rewardmont;
	}
}
