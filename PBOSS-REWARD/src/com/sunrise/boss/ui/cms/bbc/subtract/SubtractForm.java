package com.sunrise.boss.ui.cms.bbc.subtract;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: SubtractForm
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
 * @author Yangdaren
 * @version 1.0
 */
public class SubtractForm extends BaseActionForm {

    // 流水号
    private Long seq;

    // 一次性支付业务编码
    private String onceopnid;

    // 分月支付业务编码
    private String intvopnid;

    // 内部员工号码
    private String empmobile;

    // 黑名单号码 
    private String blackmobile;

    // 计酬月份
    private String calcmonth;
    
    private String _sk_onceopnid;
    
    private String _sk_intvopnid;
    
    private String _sk_empmobile;
    
    private String _sk_blackmobile;

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getOnceopnid() {
		return onceopnid;
	}

	public void setOnceopnid(String onceopnid) {
		this.onceopnid = onceopnid;
	}

	public String getIntvopnid() {
		return intvopnid;
	}

	public void setIntvopnid(String intvopnid) {
		this.intvopnid = intvopnid;
	}

	public String getEmpmobile() {
		return empmobile;
	}

	public void setEmpmobile(String empmobile) {
		this.empmobile = empmobile;
	}

	public String getBlackmobile() {
		return blackmobile;
	}

	public void setBlackmobile(String blackmobile) {
		this.blackmobile = blackmobile;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String get_sk_onceopnid() {
		return _sk_onceopnid;
	}

	public void set_sk_onceopnid(String _sk_onceopnid) {
		this._sk_onceopnid = _sk_onceopnid;
	}

	public String get_sk_intvopnid() {
		return _sk_intvopnid;
	}

	public void set_sk_intvopnid(String _sk_intvopnid) {
		this._sk_intvopnid = _sk_intvopnid;
	}

	public String get_sk_empmobile() {
		return _sk_empmobile;
	}

	public void set_sk_empmobile(String _sk_empmobile) {
		this._sk_empmobile = _sk_empmobile;
	}

	public String get_sk_blackmobile() {
		return _sk_blackmobile;
	}

	public void set_sk_blackmobile(String _sk_blackmobile) {
		this._sk_blackmobile = _sk_blackmobile;
	}
	
}
