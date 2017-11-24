/**
* auto-generated code
* Fri Sep 12 10:00:32 CST 2008
*/
package com.sunrise.boss.business.cms.waitaudit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WaitauditListVO</p>
 * <p>Description: Query Params Object for WaitauditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WaitauditListVO extends BaseListVO {
    private String _ne_taskid;
    private String _ne_subsystem;
    private String _ne_taskstate;
    private String _se_oprcode;
    private String _se_wayid;
    private String _dnl_createtime;
    private String _dnm_createtime;
    private String _se_auditoprcode;
    private String _se_auditwayid;
    private String _dnl_audittime;
    private String _dnm_audittime;

    public String get_ne_taskid(){
        return _ne_taskid;
    }

    public void set_ne_taskid(String _ne_taskid){
        this._ne_taskid = _ne_taskid;
    }
    public String get_ne_subsystem(){
        return _ne_subsystem;
    }

    public void set_ne_subsystem(String _ne_subsystem){
        this._ne_subsystem = _ne_subsystem;
    }
    public String get_ne_taskstate(){
        return _ne_taskstate;
    }

    public void set_ne_taskstate(String _ne_taskstate){
        this._ne_taskstate = _ne_taskstate;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_dnl_createtime(){
        return _dnl_createtime;
    }

    public void set_dnl_createtime(String _dnl_createtime){
        this._dnl_createtime = _dnl_createtime;
    }
    public String get_dnm_createtime(){
        return _dnm_createtime;
    }

    public void set_dnm_createtime(String _dnm_createtime){
        this._dnm_createtime = _dnm_createtime;
    }
    public String get_se_auditoprcode(){
        return _se_auditoprcode;
    }

    public void set_se_auditoprcode(String _se_auditoprcode){
        this._se_auditoprcode = _se_auditoprcode;
    }
    public String get_se_auditwayid(){
        return _se_auditwayid;
    }

    public void set_se_auditwayid(String _se_auditwayid){
        this._se_auditwayid = _se_auditwayid;
    }
    public String get_dnl_audittime(){
        return _dnl_audittime;
    }

    public void set_dnl_audittime(String _dnl_audittime){
        this._dnl_audittime = _dnl_audittime;
    }
    public String get_dnm_audittime(){
        return _dnm_audittime;
    }

    public void set_dnm_audittime(String _dnm_audittime){
        this._dnm_audittime = _dnm_audittime;
    }

}
