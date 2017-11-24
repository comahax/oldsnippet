package com.sunrise.boss.business.fee.groupquery.groupsubscriber.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

public class GroupSubscriberListVO extends BaseListVO {
	
	private List _sin_custid;

	private String _snk_status;
	
	private String _sne_status;
	
	private String _se_billingnbr;
	
    private String _se_productcode;
	
	public List get_sin_custid() {
		return _sin_custid;
	}

	public void set_sin_custid(List _sin_custid) {
		this._sin_custid = _sin_custid;
	}

	public String get_sne_status() {
		return _sne_status;
	}

	public void set_sne_status(String _sne_status) {
		this._sne_status = _sne_status;
	}

	public String get_snk_status() {
		return _snk_status;
	}

	public void set_snk_status(String _snk_status) {
		this._snk_status = _snk_status;
	}

	public String get_se_productcode() {
		return _se_productcode;
	}

	public void set_se_productcode(String _se_productcode) {
		this._se_productcode = _se_productcode;
	}

	public String get_se_billingnbr() {
		return _se_billingnbr;
	}

	public void set_se_billingnbr(String _se_billingnbr) {
		this._se_billingnbr = _se_billingnbr;
	}	

	
	
	
	
}