/**
* auto-generated code
* Wed Dec 07 14:34:03 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: UnvrcfaildayListVO</p>
 * <p>Description: Query Params Object for UnvrcfaildayDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class UnvrcfaildayListVO extends BaseListVO {
    private String _se_rcno;
    private String _se_opnid;
    private String _dnm_rcdate;
    private String _dnl_rcdate;
    private String _se_wayid;
    private String _ne_empattr2;
    private String _sk_opnname;

    public String get_ne_empattr2() {
		return _ne_empattr2;
	}

	public void set_ne_empattr2(String _ne_empattr2) {
		this._ne_empattr2 = _ne_empattr2;
	}

	public String get_sk_opnname() {
		return _sk_opnname;
	}

	public void set_sk_opnname(String _sk_opnname) {
		this._sk_opnname = _sk_opnname;
	}

	public String get_se_rcno(){
        return _se_rcno;
    }

    public void set_se_rcno(String _se_rcno){
        this._se_rcno = _se_rcno;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_dnm_rcdate(){
        return _dnm_rcdate;
    }

    public void set_dnm_rcdate(String _dnm_rcdate){
        this._dnm_rcdate = _dnm_rcdate;
    }
    public String get_dnl_rcdate(){
        return _dnl_rcdate;
    }

    public void set_dnl_rcdate(String _dnl_rcdate){
        this._dnl_rcdate = _dnl_rcdate;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

}
