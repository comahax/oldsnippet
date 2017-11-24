/**
* auto-generated code
* Tue Apr 10 11:19:35 CST 2012
*/
package com.sunrise.boss.business.cms.reward.pwdictparam.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: PwDictparamListVO</p>
 * <p>Description: Query Params Object for PwDictparamDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class PwDictparamListVO extends BaseListVO {
    private String _se_dkey;
    private String _se_dvalue;
    private String _ne_state;
    private String _se_dicttype;
    private String _se_format;

    public String get_se_dkey(){
        return _se_dkey;
    }

    public void set_se_dkey(String _se_dkey){
        this._se_dkey = _se_dkey;
    }
    public String get_se_dvalue(){
        return _se_dvalue;
    }

    public void set_se_dvalue(String _se_dvalue){
        this._se_dvalue = _se_dvalue;
    }
    public String get_ne_state(){
        return _ne_state;
    }

    public void set_ne_state(String _ne_state){
        this._ne_state = _ne_state;
    }
    public String get_se_dicttype(){
        return _se_dicttype;
    }

    public void set_se_dicttype(String _se_dicttype){
        this._se_dicttype = _se_dicttype;
    }
    public String get_se_format(){
        return _se_format;
    }

    public void set_se_format(String _se_format){
        this._se_format = _se_format;
    }

}
