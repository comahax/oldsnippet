/**
* auto-generated code
* Fri Feb 01 18:20:26 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpoolrlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardpoolrlogListVO</p>
 * <p>Description: Query Params Object for RewardpoolrlogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolrlogListVO extends BaseListVO {
    private String _dnl_optime;
    private String _dnm_optime;
    private String _se_oprcode;
    private String _se_oprtype;
    private String _se_success;

    public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
    }

}
