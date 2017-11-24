/**
* auto-generated code
* Wed Oct 18 21:00:42 CST 2006
*/
package com.sunrise.boss.business.zifee.fixfeedisclog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: FixfeedisclogListVO</p>
 * <p>Description: Query Params Object for FixfeedisclogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class FixfeedisclogListVO extends BaseListVO {

	/** identifier field */
    private Long _ne_logid;

    /** persistent field */
    private String _dnl_optime;
    
    /** persistent field */
    private String _dnm_optime;

    /** persistent field */
    private String _se_oprcode;

    /** persistent field */
    private String _se_oprtype;

    /** nullable persistent field */
    private String _se_success;
    
    private String _se_yxplanid;
    

    public java.lang.Long get_ne_logid() {
        return this._ne_logid;
    }

    public void set_ne_logid(java.lang.Long _ne_logid) {
        this._ne_logid = _ne_logid;
    }

    public String get_dnl_optime() {
        return this._dnl_optime;
    }
    
    public void set_dnl_optime(String _dnl_optime) {
        this._dnl_optime = _dnl_optime;
    }

    public void set_dnm_optime(String _dnm_optime) {
    	if(null!=_dnm_optime && _dnm_optime.length()>0){
	    	String _dnm_optime_end = _dnm_optime + " 23:59:59";
			this._dnm_optime = _dnm_optime_end;
		}else{
			this._dnm_optime = _dnm_optime;
		}
    }
    
    public String get_dnm_optime() {
        return this._dnm_optime;
    }

    

    public java.lang.String get_se_oprcode() {
        return this._se_oprcode;
    }

    public void set_se_oprcode(java.lang.String _se_oprcode) {
        this._se_oprcode = _se_oprcode;
    }

    public java.lang.String get_se_oprtype() {
        return this._se_oprtype;
    }

    public void set_se_oprtype(java.lang.String _se_oprtype) {
        this._se_oprtype = _se_oprtype;
    }

    public java.lang.String get_se_success() {
        return this._se_success;
    }

    public void set_se_success(java.lang.String _se_success) {
        this._se_success = _se_success;
    }

	public String get_se_yxplanid() {
		return _se_yxplanid;
	}

	public void set_se_yxplanid(String _se_yxplanid) {
		this._se_yxplanid = _se_yxplanid;
	}
    
}
