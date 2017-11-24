/**
* auto-generated code
* Thu Dec 29 14:47:31 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtyassess.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyAssessListVO</p>
 * <p>Description: Query Params Object for ZjtyAssessDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyAssessListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_calcmonth;
    private String _ne_cityid;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }

}
