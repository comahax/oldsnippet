/**
* auto-generated code
* Thu Oct 09 13:08:46 CST 2008
*/
package com.sunrise.boss.business.cms.iodaudit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: IodauditListVO</p>
 * <p>Description: Query Params Object for IodauditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class IodauditListVO extends BaseListVO {
    private String _se_mobile;
    private String _dnl_iodtime;
    private String _dnm_iodtime;
    private String _se_officetel;
    private String _ne_adtcode;
    private String _ne_compare;
    private String _ne_mendflag;
    
    

    public String get_ne_mendflag() {
		return _ne_mendflag;
	}

	public void set_ne_mendflag(String _ne_mendflag) {
		this._ne_mendflag = _ne_mendflag;
	}

	public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_dnl_iodtime(){
        return _dnl_iodtime;
    }

    public void set_dnl_iodtime(String _dnl_iodtime){
        this._dnl_iodtime = _dnl_iodtime;
    }
    public String get_dnm_iodtime(){
        return _dnm_iodtime;
    }

    public void set_dnm_iodtime(String _dnm_iodtime){
        this._dnm_iodtime = _dnm_iodtime;
    }
    public String get_se_officetel(){
        return _se_officetel;
    }

    public void set_se_officetel(String _se_officetel){
        this._se_officetel = _se_officetel;
    }
    public String get_ne_adtcode(){
        return _ne_adtcode;
    }

    public void set_ne_adtcode(String _ne_adtcode){
        this._ne_adtcode = _ne_adtcode;
    }
    public String get_ne_compare(){
        return _ne_compare;
    }

    public void set_ne_compare(String _ne_compare){
        this._ne_compare = _ne_compare;
    }

}
