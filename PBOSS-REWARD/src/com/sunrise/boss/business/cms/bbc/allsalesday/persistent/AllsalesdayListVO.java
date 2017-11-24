/**
* auto-generated code
* Fri Dec 09 10:35:29 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.allsalesday.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AllsalesdayListVO</p>
 * <p>Description: Query Params Object for AllsalesdayDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AllsalesdayListVO extends BaseListVO {
    private String _se_opnid;
    private String _se_wayid;
    private String _dnm_oprtime;
    private String _dnl_oprtime;
    private String _se_oprcode;
    private String _sk_opnname;
    private String _ne_empattr2;

    public String get_sk_opnname() {
		return _sk_opnname;
	}

	public void set_sk_opnname(String _sk_opnname) {
		this._sk_opnname = _sk_opnname;
	}

	public String get_ne_empattr2() {
		return _ne_empattr2;
	}

	public void set_ne_empattr2(String _ne_empattr2) {
		this._ne_empattr2 = _ne_empattr2;
	}

	public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_dnm_oprtime(){
        return _dnm_oprtime;
    }

    public void set_dnm_oprtime(String _dnm_oprtime){
        this._dnm_oprtime = _dnm_oprtime;
    }
    public String get_dnl_oprtime(){
        return _dnl_oprtime;
    }

    public void set_dnl_oprtime(String _dnl_oprtime){
        this._dnl_oprtime = _dnl_oprtime;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }

}
