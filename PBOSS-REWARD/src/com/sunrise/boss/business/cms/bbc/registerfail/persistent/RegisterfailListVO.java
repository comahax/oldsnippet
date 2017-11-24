/**
* auto-generated code
* Fri Dec 09 10:19:02 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.registerfail.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RegisterfailListVO</p>
 * <p>Description: Query Params Object for RegisterfailDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegisterfailListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_opnid;
    private String _se_officetel;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_officetel(){
        return _se_officetel;
    }

    public void set_se_officetel(String _se_officetel){
        this._se_officetel = _se_officetel;
    }

}
