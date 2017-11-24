/**
* auto-generated code
* Tue Dec 18 19:10:45 CST 2007
*/
package com.sunrise.boss.business.cms.layout.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: LayoutListVO</p>
 * <p>Description: Query Params Object for LayoutDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LayoutListVO extends BaseListVO {
    private String _sk_layoutid;
    private String _sk_layoutname;
    private String _dnl_layouttime;
    private String _dnm_layouttime;
    private String _sk_wayname;
    private String _se_waytype;
    private String _ne_runmode;
    private String _nnk_connecttype;
    private String _ne_auditstate;

    public String get_sk_layoutid(){
        return _sk_layoutid;
    }

    public void set_sk_layoutid(String _sk_layoutid){
        this._sk_layoutid = _sk_layoutid;
    }
    public String get_sk_layoutname(){
        return _sk_layoutname;
    }

    public void set_sk_layoutname(String _sk_layoutname){
        this._sk_layoutname = _sk_layoutname;
    }
    public String get_dnl_layouttime(){
        return _dnl_layouttime;
    }

    public void set_dnl_layouttime(String _dnl_layouttime){
        this._dnl_layouttime = _dnl_layouttime;
    }
    public String get_dnm_layouttime(){
        return _dnm_layouttime;
    }

    public void set_dnm_layouttime(String _dnm_layouttime){
        this._dnm_layouttime = _dnm_layouttime;
    }
    public String get_sk_wayname(){
        return _sk_wayname;
    }

    public void set_sk_wayname(String _sk_wayname){
        this._sk_wayname = _sk_wayname;
    }
    public String get_se_waytype(){
        return _se_waytype;
    }

    public void set_se_waytype(String _se_waytype){
        this._se_waytype = _se_waytype;
    }
    public String get_ne_runmode(){
        return _ne_runmode;
    }

    public void set_ne_runmode(String _ne_runmode){
        this._ne_runmode = _ne_runmode;
    }
    public String get_nnk_connecttype(){
        return _nnk_connecttype;
    }

    public void set_nnk_connecttype(String _nnk_connecttype){
        this._nnk_connecttype = _nnk_connecttype;
    }
    public String get_ne_auditstate(){
        return _ne_auditstate;
    }

    public void set_ne_auditstate(String _ne_auditstate){
        this._ne_auditstate = _ne_auditstate;
    }

}
