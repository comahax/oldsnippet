/**
* auto-generated code
* Fri Jul 11 10:06:27 CST 2008
*/
package com.sunrise.boss.ui.qsmanage.paramsmanage.chghis;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisVO;

/**
 * <p>Title: ChgHisForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChgHisForm extends BaseActionForm {
	private String _se_tabname;
	private String _ne_tabtype;
	private String _se_oprtype;
	//private String _se_mainkey;
	//private String _se_mainvalue;
	private String _dnl_oprtime;
	private String _dnm_oprtime;
	private String _se_oprcode;
	//private String _ne_oprstate;
	//private String _se_oldvalue;
	//private String _se_newvalue;
	private String _ne_chgtype;
	private String _ne_matchid;
	
	private String startindex;
	private String endindex;
	
	private Long reqid;
	private String tabname;
	private Byte tabtype;
	private String oprtype;
	private String mainkey;
	private String mainvalue;
	private java.util.Date oprtime;
	private String oprcode;
	private Short oprstate;
	private String oldvalue;
	private String newvalue;
	private Short chgtype;
	private Long matchid;
	private String chgreason;
	private String chkinfo;
	private Long logid;  
	public String getChgreason() {
		return chgreason;
	}
	public void setChgreason(String chgreason) {
		this.chgreason = chgreason;
	}
	public Short getChgtype() {
		return chgtype;
	}
	public void setChgtype(Short chgtype) {
		this.chgtype = chgtype;
	}
	public String getChkinfo() {
		return chkinfo;
	}
	public void setChkinfo(String chkinfo) {
		this.chkinfo = chkinfo;
	}
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
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
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Short getOprstate() {
		return oprstate;
	}
	public void setOprstate(Short oprstate) {
		this.oprstate = oprstate;
	}
	public java.util.Date getOprtime() {
		return oprtime;
	}
	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
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
	public Byte getTabtype() {
		return tabtype;
	}
	public void setTabtype(Byte tabtype) {
		this.tabtype = tabtype;
	}
	
	public String get_ne_tabtype() {
		return _ne_tabtype;
	}
	public void set_ne_tabtype(String _ne_tabtype) {
		this._ne_tabtype = _ne_tabtype;
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
	public String get_se_oprcode() {
		return _se_oprcode;
	}
	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
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
}
