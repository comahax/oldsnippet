package com.gmcc.pboss.business.cms.waylog.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: WaylogListVO</p>
 * <p>Description: Query Params Object for WaylogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaylogListVO extends DBQueryParam {
    private String _dnl_optime;
    private String _dnm_optime;
    private String _sk_oprcode;
    private String _se_oprtype;
    private String _se_success;
    
    private String _se_waytype;
    private String _sql_waystate;
    private String _se_waysubtype;
    
    public String get_sql_waystate() {
		return _sql_waystate;
	}

	public void set_sql_waystate(String _sql_waystate) {
		this._sql_waystate = _sql_waystate;
	}

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

	public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }
    public String get_sk_oprcode(){
        return _sk_oprcode;
    }

    public void set_sk_oprcode(String _sk_oprcode){
        this._sk_oprcode = _sk_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
    }

    public String get_se_waysubtype() {
        return _se_waysubtype;
    }

    public void set_se_waysubtype(String _se_waysubtype) {
        this._se_waysubtype = _se_waysubtype;
    }
}
