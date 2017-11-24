/**
* auto-generated code
* Fri Jul 11 10:07:46 CST 2008
*/
package com.sunrise.boss.ui.qsmanage.paramsmanage.chgreglog;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChgReglogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChgReglogForm extends BaseActionForm {
	private String _ne_reqid;
	private String _se_chgcode;
	private String _se_tabname;
	private String _dnm_chgtime;
	private String _dnl_chgtime;
	
	private Long logid;
	private Date chgtime;
	private String chgcode;
	private Long reqid;
	private String tabname;
	private String oldvalue;
	private String newvalue;
	public String get_ne_reqid() {
		return _ne_reqid;
	}
	public void set_ne_reqid(String _ne_reqid) {
		this._ne_reqid = _ne_reqid;
	}
	public String get_se_chgcode() {
		return _se_chgcode;
	}
	public void set_se_chgcode(String _se_chgcode) {
		this._se_chgcode = _se_chgcode;
	}

	public String get_se_tabname() {
		return _se_tabname;
	}
	public void set_se_tabname(String _se_tabname) {
		this._se_tabname = _se_tabname;
	}
	public String getChgcode() {
		return chgcode;
	}
	public void setChgcode(String chgcode) {
		this.chgcode = chgcode;
	}
	public Date getChgtime() {
		return chgtime;
	}
	public void setChgtime(Date chgtime) {
		this.chgtime = chgtime;
	}
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
	}
	public String getNewvalue() {
		return newvalue;
	}
	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}
	public String getOldvalue() {
		return oldvalue;
	}
	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}
	public Long getReqid() {
		return reqid;
	}
	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}
	public String getTabname() {
		return tabname;
	}
	public void setTabname(String tabname) {
		this.tabname = tabname;
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
}
