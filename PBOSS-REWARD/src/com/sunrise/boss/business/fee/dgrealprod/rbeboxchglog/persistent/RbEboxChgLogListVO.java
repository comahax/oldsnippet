/**
* auto-generated code
* Fri Apr 18 17:19:00 CST 2008
*/
package com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RbEboxChgLogListVO</p>
 * <p>Description: Query Params Object for RbEboxChgLogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
public class RbEboxChgLogListVO extends BaseListVO {
private String _ne_subsid;
private String _se_reason;
private String _se_opercode;
private String _dnm_chgtime;
private String _dnl_chgtime;
private String _ne_baltype;
private String startindex;
private String endindex;
public String getEndindex() {
	return endindex;
}
public void setEndindex(String endindex) {
	this.endindex = endindex;
}
public String getStartindex() {
	return startindex;
}
public void setStartindex(String startindex) {
	this.startindex = startindex;
}
public String get_dnl_chgtime() {
	return _dnl_chgtime;
}
public void set_dnl_chgtime(String _dnl_chgtime) {
	this._dnl_chgtime = _dnl_chgtime;
}
public String get_dnm_chgtime() {
	return _dnm_chgtime;
}
public void set_dnm_chgtime(String _dnm_chgtime) {
	this._dnm_chgtime = _dnm_chgtime;
}
public String get_ne_subsid() {
	return _ne_subsid;
}
public void set_ne_subsid(String _ne_subsid) {
	this._ne_subsid = _ne_subsid;
}
public String get_se_opercode() {
	return _se_opercode;
}
public void set_se_opercode(String _se_opercode) {
	this._se_opercode = _se_opercode;
}
public String get_se_reason() {
	return _se_reason;
}
public void set_se_reason(String _se_reason) {
	this._se_reason = _se_reason;
}
public String get_ne_baltype() {
	return _ne_baltype;
}
public void set_ne_baltype(String _ne_baltype) {
	this._ne_baltype = _ne_baltype;
}

}
