/**
* auto-generated code
* Sat Feb 02 15:13:27 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busyxplan.persistent;

import java.util.ArrayList;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BusyxplanListVO</p>
 * <p>Description: Query Params Object for BusyxplanDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanListVO extends BaseListVO {
    private String _ne_yxplanid;
    private String _se_cityid;
    private String _sql_cityid;
    private String _se_opnid;
    private String _se_opnname;
    private String _se_yxplanname;
    private ArrayList _sin_opnid;
    private ArrayList _nin_yxplanid;
    private String   _se_prodid;
    private String _ne_seq;

    public String get_ne_seq() {
		return _ne_seq;
	}

	public void set_ne_seq(String _ne_seq) {
		this._ne_seq = _ne_seq;
	}

	public String get_ne_yxplanid(){
        return _ne_yxplanid;
    }

    public void set_ne_yxplanid(String _ne_yxplanid){
        this._ne_yxplanid = _ne_yxplanid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_opnname() {
		return _se_opnname;
	}

	public void set_se_opnname(String _se_opnname) {
		this._se_opnname = _se_opnname;
	}

	public String get_se_yxplanname() {
		return _se_yxplanname;
	}

	public void set_se_yxplanname(String _se_yxplanname) {
		this._se_yxplanname = _se_yxplanname;
	}

	public ArrayList get_nin_yxplanid() {
		return _nin_yxplanid;
	}

	public void set_nin_yxplanid(ArrayList _nin_yxplanid) {
		this._nin_yxplanid = _nin_yxplanid;
	}

	public ArrayList get_sin_opnid() {
		return _sin_opnid;
	}

	public void set_sin_opnid(ArrayList _sin_opnid) {
		this._sin_opnid = _sin_opnid;
	}

	public String get_sql_cityid() {
		return _sql_cityid;
	}

	public void set_sql_cityid(String _sql_cityid) {
		this._sql_cityid = _sql_cityid;
	}

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

}
