/**
* auto-generated code
* Fri Dec 08 11:45:12 CST 2006
*/
package com.sunrise.boss.business.cms.fee.yxfeaprv.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: YxfeaprvListVO</p>
 * <p>Description: Query Params Object for YxfeaprvDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxfeaprvListVO extends BaseListVO {

	private String _sk_wayid;
	private String _se_state;
	private String _se_appoprcode;
	private String _dnl_apptime;
	private String _dnm_apptime;
	private String _se_exoprcode;
	private String _dnl_extime;
	private String _dnm_extime;

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}	

	public String get_se_state() {
		return _se_state;
	}

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}	

	public String get_se_appoprcode() {
		return _se_appoprcode;
	}

	public void set_se_appoprcode(String _se_appoprcode) {
		this._se_appoprcode = _se_appoprcode;
	}	
	
	public String get_dnl_apptime() {
		return _dnl_apptime;
	}

	public void set_dnl_apptime(String _dnl_apptime) {
		this._dnl_apptime = _dnl_apptime;
	}

	public String get_dnm_apptime() {
		return _dnm_apptime;
	}

	public void set_dnm_apptime(String _dnm_apptime) {
		if(null!=_dnm_apptime && _dnm_apptime.length()>0){
			this._dnm_apptime = _dnm_apptime + " 23:59:59";
		}else{
			this._dnm_apptime = _dnm_apptime;
		}
	}
	
	
	public String get_se_exoprcode() {
		return _se_exoprcode;
	}

	public void set_se_exoprcode(String _se_exoprcode) {
		this._se_exoprcode = _se_exoprcode;
	}	
	
	public String get_dnl_extime() {
		return _dnl_extime;
	}

	public void set_dnl_extime(String _dnl_extime) {
		this._dnl_extime = _dnl_extime;
	}

	public String get_dnm_extime() {
		return _dnm_extime;
	}

	public void set_dnm_extime(String _dnm_extime) {
		if(_dnm_extime!=null && _dnm_extime.length()>0){
			this._dnm_extime = _dnm_extime+" 23:59:59";
		}else{
			this._dnm_extime = _dnm_extime;
		}
	}
}
