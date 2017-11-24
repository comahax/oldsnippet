/**
* auto-generated code
* Mon Apr 30 16:49:59 CST 2007
*/
package com.sunrise.boss.business.admin.logincase.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: LogincaseListVO</p>
 * <p>Description: Query Params Object for LogincaseDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class LogincaseListVO extends BaseListVO {
    private String _se_module;
    private String _sk_operid;
    private String _sk_wayid;
    private String _se_cityid;
    private String _se_roleid;

    public String get_se_module(){
        return _se_module;
    }

    public void set_se_module(String _se_module){
        this._se_module = _se_module;
    }
    public String get_sk_operid(){
        return _sk_operid;
    }

    public void set_sk_operid(String _sk_operid){
        this._sk_operid = _sk_operid;
    }
    public String get_sk_wayid(){
        return _sk_wayid;
    }

    public void set_sk_wayid(String _sk_wayid){
        this._sk_wayid = _sk_wayid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_se_roleid(){
        return _se_roleid;
    }

    public void set_se_roleid(String _se_roleid){
        this._se_roleid = _se_roleid;
    }

}
