/**
* auto-generated code
* Sat Jan 12 10:23:04 CST 2013
*/
package com.sunrise.boss.business.cms.chadtwaymod.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtWaymodListVO</p>
 * <p>Description: Query Params Object for ChAdtWaymodDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtWaymodListVO extends BaseListVO {
    private String _se_wayid;
    private String _ne_cityid;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }

}
