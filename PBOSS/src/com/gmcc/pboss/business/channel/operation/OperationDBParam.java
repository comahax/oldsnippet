/**
 * auto-generated code
 * Sun Sep 13 11:38:11 CST 2009
 */
package com.gmcc.pboss.business.channel.operation;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OperationDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class OperationDBParam extends DBQueryParam {

	 private String _sk_name;
	    private String _nne_state;
	    private String _ne_state;
	    private String _sql_condition;
	    private String _se_opnid;
	    private String _se_parentid;
	    private String _ne_busikind;
	    private String _ne_opnlevel;
	    private String _ne_isbusi;
	  
	    private String _dnl_startdate;
	    private String _dnm_startdate;
	    private String _dnl_enddate;
	    private String _dnm_enddate;
	    private String _se_busibelong;
	    
	    
	    
	    public String get_ne_isbusi() {
			return _ne_isbusi;
		}

		public void set_ne_isbusi(String _ne_isbusi) {
			this._ne_isbusi = _ne_isbusi;
		}

		

		public String get_ne_opnlevel() {
			return _ne_opnlevel;
		}

		public void set_ne_opnlevel(String _ne_opnlevel) {
			this._ne_opnlevel = _ne_opnlevel;
		}

		public String get_ne_busikind() {
			return _ne_busikind;
		}

		public void set_ne_busikind(String _ne_busikind) {
			this._ne_busikind = _ne_busikind;
		}

		public String get_se_opnid() {
			return _se_opnid;
		}

		public void set_se_opnid(String _ne_id) {
			this._se_opnid = _ne_id;
		}

		public String get_sql_condition() {
			return _sql_condition;
		}

		public void set_sql_condition(String _sql_condition) {
			this._sql_condition = _sql_condition;
		}

		public String get_sk_name(){
	        return _sk_name;
	    }

	    public void set_sk_name(String _sk_name){
	        this._sk_name = _sk_name;
	    }

		public String get_se_parentid() {
			return _se_parentid;
		}

		public void set_se_parentid(String _se_parentid) {
			this._se_parentid = _se_parentid;
		}

		public String get_nne_state() {
			return _nne_state;
		}

		public void set_nne_state(String _nne_state) {
			this._nne_state = _nne_state;
		}

		public String get_ne_state() {
			return _ne_state;
		}

		public void set_ne_state(String _ne_state) {
			this._ne_state = _ne_state;
		}

		public String get_dnl_enddate() {
			return _dnl_enddate;
		}

		public void set_dnl_enddate(String _dnl_enddate) {
			this._dnl_enddate = _dnl_enddate;
		}

		public String get_dnl_startdate() {
			return _dnl_startdate;
		}

		public void set_dnl_startdate(String _dnl_startdate) {
			this._dnl_startdate = _dnl_startdate;
		}

		public String get_dnm_enddate() {
			return _dnm_enddate;
		}

		public void set_dnm_enddate(String _dnm_enddate) {
			this._dnm_enddate = _dnm_enddate;
		}

		public String get_dnm_startdate() {
			return _dnm_startdate;
		}

		public void set_dnm_startdate(String _dnm_startdate) {
			this._dnm_startdate = _dnm_startdate;
		}

		public String get_se_busibelong() {
			return _se_busibelong;
		}

		public void set_se_busibelong(String _se_busibelong) {
			this._se_busibelong = _se_busibelong;
		}
	
}
