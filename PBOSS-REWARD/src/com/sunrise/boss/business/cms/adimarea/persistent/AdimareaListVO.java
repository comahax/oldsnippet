/**
* auto-generated code
* Thu Apr 05 10:00:59 CST 2007
*/
package com.sunrise.boss.business.cms.adimarea.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AdimareaListVO</p>
 * <p>Description: Query Params Object for AdimareaDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class AdimareaListVO extends BaseListVO {
    private String _se_adacode;
    private String _sk_adaname;
    private String _ne_adatype;
    private String _ne_adalevel;
    private String _se_datayear;
    private String _ne_status;
    private String _se_uppercode;

    public String get_se_adacode(){
        return _se_adacode;
    }

    public void set_se_adacode(String _se_adacode){
        this._se_adacode = _se_adacode;
    }
    public String get_sk_adaname(){
        return _sk_adaname;
    }

    public void set_sk_adaname(String _sk_adaname){
        this._sk_adaname = _sk_adaname;
    }
    public String get_ne_adatype(){
        return _ne_adatype;
    }

    public void set_ne_adatype(String _ne_adatype){
        this._ne_adatype = _ne_adatype;
    }
    public String get_ne_adalevel(){
        return _ne_adalevel;
    }

    public void set_ne_adalevel(String _ne_adalevel){
        this._ne_adalevel = _ne_adalevel;
    }
    public String get_se_datayear(){
        return _se_datayear;
    }

    public void set_se_datayear(String _se_datayear){
        this._se_datayear = _se_datayear;
    }
    public String get_ne_status(){
        return _ne_status;
    }

    public void set_ne_status(String _ne_status){
        this._ne_status = _ne_status;
    }

	public String get_se_uppercode() {
		return _se_uppercode;
	}

	public void set_se_uppercode(String _se_uppercode) {
		this._se_uppercode = _se_uppercode;
	}

}
