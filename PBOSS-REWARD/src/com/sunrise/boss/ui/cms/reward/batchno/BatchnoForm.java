package com.sunrise.boss.ui.cms.reward.batchno;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: AdtcodeForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author 	Linli
 * @version 1.0
 */
public class BatchnoForm extends BaseActionForm {
	   /** persistent field */
    private String batchno;

    /** persistent field */
    private String batchtype;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String remark;
    
    private String rewardkind;
    
    private String _se_batchno;
    
    private String _se_batchtype;
    
	private String _sk_name;
	
	private String _rewardmonth;

	public String get_rewardmonth() {
		return _rewardmonth;
	}

	public void set_rewardmonth(String _rewardmonth) {
		this._rewardmonth = _rewardmonth;
	}

	public String get_sk_name() {
		return _sk_name;
	}

	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_se_batchtype() {
		return _se_batchtype;
	}

	public void set_se_batchtype(String _se_batchtype) {
		this._se_batchtype = _se_batchtype;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getBatchtype() {
		return batchtype;
	}

	public void setBatchtype(String batchtype) {
		this.batchtype = batchtype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRewardkind() {
		return rewardkind;
	}

	public void setRewardkind(String rewardkind) {
		this.rewardkind = rewardkind;
	}
}
