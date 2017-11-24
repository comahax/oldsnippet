package com.sunrise.boss.business.fee.persistent.mwcode;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MwCodeListVO</p>
 * <p>Description: 梦网代码信息管理List VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class MwCodeListVO extends BaseListVO{
	
	 private String _se_portid;
	    private String _ne_bustype;
	    private String _se_subbuscode;
	    private String _dnl_begintime;
	    private String _dnm_begintime;
	    private String _dnl_endtime;
	    private String _dnm_endtime;
	    
	    private String startindex;
	    private String endindex;
	    
	    
		public String get_ne_bustype() {
			return _ne_bustype;
		}
		public void set_ne_bustype(String _ne_bustype) {
			this._ne_bustype = _ne_bustype;
		}
		public String get_se_portid() {
			return _se_portid;
		}
		public void set_se_portid(String _se_portid) {
			this._se_portid = _se_portid;
		}
		public String get_se_subbuscode() {
			return _se_subbuscode;
		}
		public void set_se_subbuscode(String _se_subbuscode) {
			this._se_subbuscode = _se_subbuscode;
		}
		public String get_dnl_begintime() {
			return _dnl_begintime;
		}
		public void set_dnl_begintime(String _dnl_begintime) {
			this._dnl_begintime = _dnl_begintime;
		}
		public String get_dnl_endtime() {
			return _dnl_endtime;
		}
		public void set_dnl_endtime(String _dnl_endtime) {
			this._dnl_endtime = _dnl_endtime;
		}
		public String get_dnm_begintime() {
			return _dnm_begintime;
		}
		public void set_dnm_begintime(String _dnm_begintime) {
			this._dnm_begintime = _dnm_begintime;
		}
		public String get_dnm_endtime() {
			return _dnm_endtime;
		}
		public void set_dnm_endtime(String _dnm_endtime) {
			this._dnm_endtime = _dnm_endtime;
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
}
