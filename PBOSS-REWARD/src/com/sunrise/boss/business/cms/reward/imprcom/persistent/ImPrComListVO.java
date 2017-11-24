/**
* auto-generated code
* Wed Jun 05 16:14:15 CST 2013
*/
package com.sunrise.boss.business.cms.reward.imprcom.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ImPrComListVO</p>
 * <p>Description: Query Params Object for ImPrComDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ImPrComListVO extends BaseListVO {
    private String _ne_comid;
    private String _se_comname;
    private String _sk_comname;
    private String _se_cityid;

    public String get_ne_comid(){
        return _ne_comid;
    }

    public void set_ne_comid(String _ne_comid){
        this._ne_comid = _ne_comid;
    }
    public String get_se_comname(){
        return _se_comname;
    }

    public void set_se_comname(String _se_comname){
        this._se_comname = _se_comname;
    }
    public String get_sk_comname(){
        return _sk_comname;
    }

    public void set_sk_comname(String _sk_comname){
        this._sk_comname = _sk_comname;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

}
