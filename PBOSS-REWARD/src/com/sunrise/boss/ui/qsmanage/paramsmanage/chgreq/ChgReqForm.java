/**
* auto-generated code
* Fri Jul 11 10:08:50 CST 2008
*/
package com.sunrise.boss.ui.qsmanage.paramsmanage.chgreq;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: ChgReqForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChgReqForm extends BaseActionForm {
	private String _se_tabname;

	private String _ne_tabtype;

	private String _se_oprtype;
	
	private String _ne_chgtype;
	
	private String _se_oprcode;
	
	private String _dnl_oprtime; 
	
	private String _dnm_oprtime;
	
	private String _ne_matchid;
	
	private String _sk_mainvalue;
	
	private String _ne_oprstate;
	
	private String reqidstr;
	
	private Long reqid;
	private String tabname;
	private Long tabtype;
	private String oprtype;
	private String mainkey;
	private String mainvalue;
	private Date oprtime;
	private String oprcode;
	private Long oprstate;
	private String chkinfo;
	private Long matchid;
	private String oprtdate;
	private String chgreason;
	
	private String mainkeystr;
	
	private String tabnamestr;

	public String getOprtdate() {
		return oprtdate;
	}

	public void setOprtdate(String oprtdate) {
		this.oprtdate = oprtdate;
	}

	public String getChkinfo() {
		return chkinfo;
	}

	public void setChkinfo(String chkinfo) {
		this.chkinfo = chkinfo;
	}

	public Long getMatchid() {
		return matchid;
	}

	public void setMatchid(Long matchid) {
		this.matchid = matchid;
	}

	public String getMainkey() {
		return mainkey;
	}

	public void setMainkey(String mainkey) {
		this.mainkey = mainkey;
	}

	public String getMainvalue() {
		return mainvalue;
	}

	public void setMainvalue(String mainvalue) {
		this.mainvalue = mainvalue;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Long getOprstate() {
		return oprstate;
	}

	public void setOprstate(Long oprstate) {
		this.oprstate = oprstate;
	}

	public Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
		this.oprtdate = PublicUtils.utilDateToStr(oprtime);
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
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

	public Long getTabtype() {
		return tabtype;
	}

	public void setTabtype(Long tabtype) {
		this.tabtype = tabtype;
	}

	public String get_ne_tabtype() {
		return _ne_tabtype;
	}

	public void set_ne_tabtype(String _ne_tabtype) {
		this._ne_tabtype = _ne_tabtype;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_tabname() {
		return _se_tabname;
	}

	public void set_se_tabname(String _se_tabname) {
		this._se_tabname = _se_tabname;
	}

	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}

	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}

	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}

	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}

	public String get_ne_chgtype() {
		return _ne_chgtype;
	}

	public void set_ne_chgtype(String _ne_chgtype) {
		this._ne_chgtype = _ne_chgtype;
	}

	public String get_ne_matchid() {
		return _ne_matchid;
	}

	public void set_ne_matchid(String _ne_matchid) {
		this._ne_matchid = _ne_matchid;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String getMainkeystr() {
		return mainkeystr;
	}

	public void setMainkeystr(String mainkeystr) {
		this.mainkeystr = mainkeystr;
	}

	public String getTabnamestr() {
		return tabnamestr;
	}

	public void setTabnamestr(String tabnamestr) {
		this.tabnamestr = tabnamestr;
	}

	public String get_ne_oprstate() {
		return _ne_oprstate;
	}

	public void set_ne_oprstate(String _ne_oprstate) {
		this._ne_oprstate = _ne_oprstate;
	}

	public String get_sk_mainvalue() {
		return _sk_mainvalue;
	}

	public void set_sk_mainvalue(String _sk_mainvalue) {
		this._sk_mainvalue = _sk_mainvalue;
	}

	public String getReqidstr() {
		return reqidstr;
	}

	public void setReqidstr(String reqidstr) {
		this.reqidstr = reqidstr;
	}

	public String getChgreason() {
		return chgreason;
	}

	public void setChgreason(String chgreason) {
		this.chgreason = chgreason;
	}

}
