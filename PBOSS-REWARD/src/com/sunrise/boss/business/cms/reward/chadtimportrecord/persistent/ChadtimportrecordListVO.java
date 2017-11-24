/**
* auto-generated code
* Fri Jun 24 11:00:35 CST 2011
*/
package com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtImportrecordListVO</p>
 * <p>Description: Query Params Object for ChAdtImportrecordDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ChadtimportrecordListVO extends BaseListVO {
    private String _se_wayid;
    private String _dnm_oprtime;
    private String _dnl_oprtime;
    private String _ne_importtype;
    private String _se_mobile;
    private String _se_opnid;
    private String _de_oprtime;
    private String _ne_amt;
    private String _ne_assegrade;
    
    public String get_ne_assegrade() {
		return _ne_assegrade;
	}

	public void set_ne_assegrade(String _ne_assegrade) {
		this._ne_assegrade = _ne_assegrade;
	}

	private String _sql_importtype;
    
    public String get_ne_amt() {
		return _ne_amt;
	}

	public void set_ne_amt(String _ne_amt) {
		this._ne_amt = _ne_amt;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_de_oprtime() {
		return _de_oprtime;
	}

	public void set_de_oprtime(String _de_oprtime) {
		this._de_oprtime = _de_oprtime;
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
    public String get_ne_importtype(){
        return _ne_importtype;
    }

    public void set_ne_importtype(String _ne_importtype){
        this._ne_importtype = _ne_importtype;
    }

	public String get_sql_importtype() {
		return _sql_importtype;
	}

	public void set_sql_importtype(String sqlImporttype) {
		_sql_importtype = sqlImporttype;
	}

}
