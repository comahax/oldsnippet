/**
* auto-generated code
* Fri Oct 20 10:53:27 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplanlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: YxplanlogListVO</p>
 * <p>Description: Query Params Object for YxplanlogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class YxplanlogListVO extends BaseListVO {
	private String _dnl_optime;
	
	private String _dnm_optime;
	
	private String _sk_oprcode;
	
	private String _se_oprtype;
	
	private String _se_success;
	
	private String _sql_areacode;
	
	private String _ne_groupflag;
	
	private String _se_yxplanid;
	
	private String _sk_yxplanname;

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		if(null!=_dnm_optime && _dnm_optime.length()>0){
	    	String _dnm_optime_end = _dnm_optime + " 23:59:59";
			this._dnm_optime = _dnm_optime_end;
		}else{
			this._dnm_optime = _dnm_optime;
		}
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
	}
	public String get_sql_areacode() {
		return _sql_areacode;
	}
	public void set_sql_areacode(String _sql_areacode) {
		this._sql_areacode = _sql_areacode;
	}
	public String get_ne_groupflag() {
		return _ne_groupflag;
	}
	public void set_ne_groupflag(String _ne_groupflag) {
		this._ne_groupflag = _ne_groupflag;
	}

	public String get_se_yxplanid() {
		return _se_yxplanid;
	}

	public void set_se_yxplanid(String _se_yxplanid) {
		this._se_yxplanid = _se_yxplanid;
	}

	public String get_sk_yxplanname() {
		return _sk_yxplanname;
	}

	public void set_sk_yxplanname(String _sk_yxplanname) {
		this._sk_yxplanname = _sk_yxplanname;
	}
	
}
