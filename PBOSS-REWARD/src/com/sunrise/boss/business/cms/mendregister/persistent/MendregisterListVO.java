/**
* auto-generated code
* Mon Jun 20 09:11:28 GMT 2011
*/
package com.sunrise.boss.business.cms.mendregister.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MendregisterListVO</p>
 * <p>Description: Query Params Object for MendregisterDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class MendregisterListVO extends BaseListVO {
	private String _se_mobile;
    private String _se_officetel;
    private String _de_selltime;
    private String _de_optime;
    private String _se_success;
    private String _dnl_selltime;
    private String _dnm_selltime;
    private String _dnl_optime;
    private String _dnm_optime;

    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_se_officetel(){
        return _se_officetel;
    }

    public void set_se_officetel(String _se_officetel){
        this._se_officetel = _se_officetel;
    }
    public String get_de_selltime(){
        return _de_selltime;
    }

    public void set_de_selltime(String _de_selltime){
        this._de_selltime = _de_selltime;
    }
    public String get_de_optime(){
        return _de_optime;
    }

    public void set_de_optime(String _de_optime){
        this._de_optime = _de_optime;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
    }

	public String get_dnl_selltime() {
		return _dnl_selltime;
	}

	public void set_dnl_selltime(String _dnl_selltime) {
		this._dnl_selltime = _dnl_selltime;
	}

	public String get_dnm_selltime() {
		return _dnm_selltime;
	}

	public void set_dnm_selltime(String _dnm_selltime) {
		this._dnm_selltime = _dnm_selltime;
	}

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}

}
