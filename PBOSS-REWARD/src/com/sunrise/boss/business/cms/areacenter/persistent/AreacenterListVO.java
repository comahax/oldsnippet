/**
* auto-generated code
* Tue Oct 24 12:04:42 CST 2006
*/
package com.sunrise.boss.business.cms.areacenter.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AreacenterListVO</p>
 * <p>Description: Query Params Object for AreacenterDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class AreacenterListVO extends BaseListVO {
    private String _se_centerid;
    private String _sk_centername;
    private String _ne_areatype;

    public String get_se_centerid(){
        return _se_centerid;
    }

    public void set_se_centerid(String _se_centerid){
        this._se_centerid = _se_centerid;
    }
    public String get_sk_centername(){
        return _sk_centername;
    }

    public void set_sk_centername(String _sk_centername){
        this._sk_centername = _sk_centername;
    }
    public String get_ne_areatype(){
        return _ne_areatype;
    }

    public void set_ne_areatype(String _ne_areatype){
        this._ne_areatype = _ne_areatype;
    }

}
