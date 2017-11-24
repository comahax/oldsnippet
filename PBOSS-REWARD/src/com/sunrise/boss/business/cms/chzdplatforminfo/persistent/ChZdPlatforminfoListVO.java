/**
* auto-generated code
* Sat May 11 16:40:18 CST 2013
*/
package com.sunrise.boss.business.cms.chzdplatforminfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChZdPlatforminfoListVO</p>
 * <p>Description: Query Params Object for ChZdPlatforminfoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdPlatforminfoListVO extends BaseListVO {
    private String _ne_productid;
    private String _se_producttype;
    private String _se_zdplatform;
    private String _dnl_starttime;
    private String _dnm_endtime;
    private String _se_batchno;

    public String get_ne_productid(){
        return _ne_productid;
    }

    public void set_ne_productid(String _ne_productid){
        this._ne_productid = _ne_productid;
    }
    public String get_se_producttype(){
        return _se_producttype;
    }

    public void set_se_producttype(String _se_producttype){
        this._se_producttype = _se_producttype;
    }
    public String get_se_zdplatform(){
        return _se_zdplatform;
    }

    public void set_se_zdplatform(String _se_zdplatform){
        this._se_zdplatform = _se_zdplatform;
    }
    public String get_dnl_starttime(){
        return _dnl_starttime;
    }

    public void set_dnl_starttime(String _dnl_starttime){
        this._dnl_starttime = _dnl_starttime;
    }
    public String get_dnm_endtime(){
        return _dnm_endtime;
    }

    public void set_dnm_endtime(String _dnm_endtime){
        this._dnm_endtime = _dnm_endtime;
    }
    public String get_se_batchno(){
        return _se_batchno;
    }

    public void set_se_batchno(String _se_batchno){
        this._se_batchno = _se_batchno;
    }

}
