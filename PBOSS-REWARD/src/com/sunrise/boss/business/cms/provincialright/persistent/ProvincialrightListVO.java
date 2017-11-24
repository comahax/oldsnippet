package com.sunrise.boss.business.cms.provincialright.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class ProvincialrightListVO extends BaseListVO {
	private String _se_proopr;
	private String _se_rightid;
	public ProvincialrightListVO() {
		// TODO Auto-generated constructor stub
	}
	public String get_se_proopr() {
		return _se_proopr;
	}
	public void set_se_proopr(String _se_proopr) {
		this._se_proopr = _se_proopr;
	}
	public String get_se_rightid() {
		return _se_rightid;
	}
	public void set_se_rightid(String _se_rightid) {
		this._se_rightid = _se_rightid;
	}
	
}
