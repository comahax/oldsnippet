package com.sunrise.boss.business.fee.persistent.cicsinfo;

import com.sunrise.boss.common.base.db.BaseListVO;

public class CicsInfoListVO extends BaseListVO {
	private String _se_regionid; //ÇøÓò±àºÅ
	private String _se_regionname; //ÇøÓò¼ò³Æ
	
	public String get_se_regionid() {
		return _se_regionid;
	}
	public void set_se_regionid(String _se_regionid) {
		this._se_regionid = _se_regionid;
	}
	public String get_se_regionname() {
		return _se_regionname;
	}
	public void set_se_regionname(String _se_regionname) {
		this._se_regionname = _se_regionname;
	}
}
