package com.gmcc.pboss.business.sales.orderresdet;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class VOrderresdetDBParam extends DBQueryParam {
    private String _se_countyid;
    private String _se_svccode;
    private String _se_mareacode;
    private String _se_wayid;
    private String _sk_wayname;
    private String _ne_starlevel;
    private String _se_comcategory;
    private String _se_orderid;
    private String _se_orderstate;
    
    
    
    
	public VOrderresdetDBParam() {
		super();
		// TODO Auto-generated constructor stub
	}




	public VOrderresdetDBParam(String _se_countyid, String _se_svccode,
			String _se_mareacode, String _se_wayid, String _sk_wayname,
			String _ne_starlevel, String _se_comcategory, String _se_orderid,
			String _se_orderstate) {
		super();
		this._se_countyid = _se_countyid;
		this._se_svccode = _se_svccode;
		this._se_mareacode = _se_mareacode;
		this._se_wayid = _se_wayid;
		this._sk_wayname = _sk_wayname;
		this._ne_starlevel = _ne_starlevel;
		this._se_comcategory = _se_comcategory;
		this._se_orderid = _se_orderid;
		this._se_orderstate = _se_orderstate;
	}




	public String get_se_countyid() {
		return _se_countyid;
	}




	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}




	public String get_se_svccode() {
		return _se_svccode;
	}




	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}




	public String get_se_mareacode() {
		return _se_mareacode;
	}




	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}




	public String get_se_wayid() {
		return _se_wayid;
	}




	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}




	public String get_sk_wayname() {
		return _sk_wayname;
	}




	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}




	public String get_ne_starlevel() {
		return _ne_starlevel;
	}




	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}




	public String get_se_comcategory() {
		return _se_comcategory;
	}




	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}




	public String get_se_orderid() {
		return _se_orderid;
	}




	public void set_se_orderid(String _se_orderid) {
		this._se_orderid = _se_orderid;
	}




	public String get_se_orderstate() {
		return _se_orderstate;
	}




	public void set_se_orderstate(String _se_orderstate) {
		this._se_orderstate = _se_orderstate;
	}
    
	
	
	
}
