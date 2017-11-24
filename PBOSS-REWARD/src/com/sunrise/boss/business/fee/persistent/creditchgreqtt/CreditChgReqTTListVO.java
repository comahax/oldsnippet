/**
* auto-generated code
* Fri Sep 08 14:14:03 CST 2006
*/
package com.sunrise.boss.business.fee.persistent.creditchgreqtt;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CreditChgReqTTListVO</p>
 * <p>Description: Query Params Object for CreditChgReqTTDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author mys
 * @version 1.0
 */
public class CreditChgReqTTListVO extends BaseListVO {
	  
	    private String _ne_subsid;
        private String _ne_reqtype;
        private String _ne_reqsource;
        private String _ne_dealstate;
	    private String _dnl_reqtime;
	    private String _dnm_reqtime;
		
		public String get_dnl_reqtime() {
			return _dnl_reqtime;
		}
		public void set_dnl_reqtime(String _dnl_reqtime) {
			this._dnl_reqtime = _dnl_reqtime;
		}
		public String get_dnm_reqtime() {
			return _dnm_reqtime;
		}
		public void set_dnm_reqtime(String _dnm_reqtime) {
			this._dnm_reqtime = _dnm_reqtime;
		}
		public String get_ne_reqsource() {
			return _ne_reqsource;
		}
		public void set_ne_reqsource(String _ne_reqsource) {
			this._ne_reqsource = _ne_reqsource;
		}
		public String get_ne_reqtype() {
			return _ne_reqtype;
		}
		public void set_ne_reqtype(String _ne_reqtype) {
			this._ne_reqtype = _ne_reqtype;
		}
		public String get_ne_subsid() {
			return _ne_subsid;
		}
		public void set_ne_subsid(String _ne_subsid) {
			this._ne_subsid = _ne_subsid;
		}
		public String get_ne_dealstate() {
			return _ne_dealstate;
		}
		public void set_ne_dealstate(String _ne_dealstate) {
			this._ne_dealstate = _ne_dealstate;
		}



}
