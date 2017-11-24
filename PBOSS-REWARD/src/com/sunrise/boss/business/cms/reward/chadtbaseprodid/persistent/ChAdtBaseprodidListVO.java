/**
* auto-generated code
* Tue Jun 03 20:21:31 CST 2014
*/
package com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtBaseprodidListVO</p>
 * <p>Description: Query Params Object for ChAdtBaseprodidDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtBaseprodidListVO extends BaseListVO {
    private String _se_prodid;
    private String _se_cityid;
    private String _se_type;
    private String _se_oprtype;

    public String get_se_prodid(){
        return _se_prodid;
    }

    public void set_se_prodid(String _se_prodid){
        this._se_prodid = _se_prodid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_se_type(){
        return _se_type;
    }

    public void set_se_type(String _se_type){
        this._se_type = _se_type;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }

}
