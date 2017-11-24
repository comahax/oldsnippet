/**
* auto-generated code
* Thu Dec 28 11:46:46 CST 2006
*/
package com.sunrise.boss.business.fee.common.multinode.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;


public class MultiNodeListVO extends BaseListVO {

	private String _se_areacode;
	private String _snm_beginno;  	//beginno <= ?
	private String _snl_endno; 		//  endno >= ?
	private String _se_nodeid;
	private String _dnm_starttime;
	private String _ne_nosectstate;
	
	public String get_dnm_starttime() {
		return _dnm_starttime;
	}
	public void set_dnm_starttime(String _dnm_starttime) {
		this._dnm_starttime = _dnm_starttime;
	}
	public String get_ne_nosectstate() {
		return _ne_nosectstate;
	}
	public void set_ne_nosectstate(String _ne_nosectstate) {
		this._ne_nosectstate = _ne_nosectstate;
	}
	public String get_se_areacode() {
		return _se_areacode;
	}
	public void set_se_areacode(String _se_areacode) {
		this._se_areacode = _se_areacode;
	}
	public String get_snm_beginno() {
		return _snm_beginno;
	}
	public void set_snm_beginno(String _snm_beginno) {
		this._snm_beginno = _snm_beginno;
	}
	public String get_snl_endno() {
		return _snl_endno;
	}
	public void set_snl_endno(String _snl_endno) {
		this._snl_endno = _snl_endno;
	}
	public String get_se_nodeid() {
		return _se_nodeid;
	}
	public void set_se_nodeid(String _se_nodeid) {
		this._se_nodeid = _se_nodeid;
	}
	
}
