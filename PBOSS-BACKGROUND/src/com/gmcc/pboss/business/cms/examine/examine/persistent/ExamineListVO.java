package com.gmcc.pboss.business.cms.examine.examine.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: ExamineListVO</p>
 * <p>Description: Query Params Object for ExamineDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExamineListVO extends DBQueryParam {
    private String _ne_exmnid;
    private String _sk_exmnname;
    private String _se_state;
    private String _se_adtype;
    private String _sk_adtype;
    private String _se_starlevel;
    private String _sk_starlevel;
    private String _se_cityid;

    public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_ne_exmnid(){
        return _ne_exmnid;
    }

    public void set_ne_exmnid(String _ne_exmnid){
        this._ne_exmnid = _ne_exmnid;
    }
    public String get_sk_exmnname(){
        return _sk_exmnname;
    }

    public void set_sk_exmnname(String _sk_exmnname){
        this._sk_exmnname = _sk_exmnname;
    }
    public String get_se_state(){
        return _se_state;
    }

    public void set_se_state(String _se_state){
        this._se_state = _se_state;
    }
    public String get_se_adtype(){
        return _se_adtype;
    }

    public void set_se_adtype(String _se_adtype){
        this._se_adtype = _se_adtype;
    }
    public String get_sk_adtype(){
        return _sk_adtype;
    }

    public void set_sk_adtype(String _sk_adtype){
        this._sk_adtype = _sk_adtype;
    }
    public String get_se_starlevel(){
        return _se_starlevel;
    }

    public void set_se_starlevel(String _se_starlevel){
        this._se_starlevel = _se_starlevel;
    }
    public String get_sk_starlevel(){
        return _sk_starlevel;
    }

    public void set_sk_starlevel(String _sk_starlevel){
        this._sk_starlevel = _sk_starlevel;
    }

}
