package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

public class VCityrecordList4VO extends BaseListVO {
    private String _se_wayid;
    private String _se_rewardmonth;
    private String _se_chainhead;
    private String _se_countyid;
    private String _sin_opnid;
    private String _se_mobile;
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}
	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}
	public String get_se_chainhead() {
		return _se_chainhead;
	}
	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_sin_opnid() {
		return _sin_opnid;
	}
	public void set_sin_opnid(String _sin_opnid) {
		this._sin_opnid = _sin_opnid;
	}
	public String get_se_mobile() {
		return _se_mobile;
	}
	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}
}
