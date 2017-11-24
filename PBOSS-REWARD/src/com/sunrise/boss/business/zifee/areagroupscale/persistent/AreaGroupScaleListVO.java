/**
* auto-generated code
* Mon Aug 21 20:59:07 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupscale.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AreaGroupScaleListVO</p>
 * <p>Description: Query Params Object for AreaGroupScaleDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class AreaGroupScaleListVO extends BaseListVO {
	private String _dnl_effdate;
	private String _dnm_expdate;
	private String _ne_areagroupid;
	private String _sk_areacode;
	private String _se_areacode;
	
	public java.lang.String get_sk_areacode() {
        return this._sk_areacode;
    }

    public void set_sk_areacode(java.lang.String _sk_areacode) {
        this._sk_areacode = _sk_areacode;
    }
    
    public java.lang.String get_se_areacode() {
        return this._se_areacode;
    }

    public void set_se_areacode(java.lang.String _se_areacode) {
        this._se_areacode = _se_areacode;
    }
    public java.lang.String get_dnl_effdate() {
        return this._dnl_effdate;
    }

    public void set_dnl_effdate(java.lang.String _dnl_effdate) {
        this._dnl_effdate = _dnl_effdate;
    }
	

    public java.lang.String get_dnm_expdate() {
        return this._dnm_expdate;
    }

    public void set_dnm_expdate(java.lang.String _dnm_expdate) {
        this._dnm_expdate = _dnm_expdate;
    }
    public java.lang.String get_ne_areagroupid(){
    	return this._ne_areagroupid;
    }
    public void set_ne_areagroupid(java.lang.String _ne_areagroupid){
    	this._ne_areagroupid=_ne_areagroupid;
    }
}
