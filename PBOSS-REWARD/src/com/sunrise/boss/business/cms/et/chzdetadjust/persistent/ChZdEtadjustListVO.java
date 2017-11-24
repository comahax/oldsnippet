/**
* auto-generated code
* Thu May 09 16:24:13 CST 2013
*/
package com.sunrise.boss.business.cms.et.chzdetadjust.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChZdEtadjustListVO</p>
 * <p>Description: Query Params Object for ChZdEtadjustDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdEtadjustListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_platform;
    private String _se_producttype;
    private String _se_batchno;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_platform(){
        return _se_platform;
    }

    public void set_se_platform(String _se_platform){
        this._se_platform = _se_platform;
    }
    public String get_se_producttype(){
        return _se_producttype;
    }

    public void set_se_producttype(String _se_producttype){
        this._se_producttype = _se_producttype;
    }
    public String get_se_batchno(){
        return _se_batchno;
    }

    public void set_se_batchno(String _se_batchno){
        this._se_batchno = _se_batchno;
    }

}
