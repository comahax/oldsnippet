package com.sunrise.boss.business.common.combineinput.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

public class CombineinputListVO extends BaseListVO {
	private String _sk_id = ""; // 标识
	private String _sk_name = ""; // 名称
	private String _ssw_id = "";
	private String _ssw_name = "";
	private String _se_upid = ""; // 上级标识
	private String _se_extend1;
	private List _sin_extend1;
	private List _sin_id;
	
	
	public String get_sk_id() {
		return _sk_id;
	}
	public void set_sk_id(String _sk_id) {
		this._sk_id = _sk_id;
	}
	public String get_sk_name() {
		return _sk_name;
	}
	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}
	public String get_se_upid() {
		return _se_upid;
	}
	public void set_se_upid(String _se_upid) {
		this._se_upid = _se_upid;
	}
	public String get_ssw_id() {
		return _ssw_id;
	}
	public void set_ssw_id(String _ssw_id) {
		this._ssw_id = _ssw_id;
	}
	public String get_ssw_name() {
		return _ssw_name;
	}
	public void set_ssw_name(String _ssw_name) {
		this._ssw_name = _ssw_name;
	}
	public String get_se_extend1() {
		return _se_extend1;
	}
	public void set_se_extend1(String _se_extend1) {
		this._se_extend1 = _se_extend1;
	}
	public List get_sin_extend1() {
		return _sin_extend1;
	}
	public void set_sin_extend1(List _sin_extend1) {
		this._sin_extend1 = _sin_extend1;
	}
	public List get_sin_id() {
		return _sin_id;
	}
	public void set_sin_id(List _sin_id) {
		this._sin_id = _sin_id;
	}
}
