/**
* auto-generated code
* Sat Nov 16 10:49:38 CST 2013
*/
package com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtWayspecialrewardListVO</p>
 * <p>Description: Query Params Object for ChAdtWayspecialrewardDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChAdtWayspecialrewardListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_wayspetype;
    private String _se_cityid;
    private String _dnm_createdate;
    private String _dnl_createdate;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_wayspetype(){
        return _se_wayspetype;
    }

    public void set_se_wayspetype(String _se_wayspetype){
        this._se_wayspetype = _se_wayspetype;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_dnm_createdate(){
        return _dnm_createdate;
    }

    public void set_dnm_createdate(String _dnm_createdate){
        this._dnm_createdate = _dnm_createdate;
    }
    public String get_dnl_createdate(){
        return _dnl_createdate;
    }

    public void set_dnl_createdate(String _dnl_createdate){
        this._dnl_createdate = _dnl_createdate;
    }

}
