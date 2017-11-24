/**
* auto-generated code
* Sat Dec 08 10:23:53 CST 2012
*/
package com.sunrise.boss.business.cms.reward.creditstd3g.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: Creditstd3gListVO</p>
 * <p>Description: Query Params Object for Creditstd3gDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class Creditstd3gListVO extends BaseListVO {
    private String _ne_cityid;
    private String _se_wayattr;
    private String _sql_cityid;

    public String get_sql_cityid() {
		return _sql_cityid;
	}

	public void set_sql_cityid(String _sql_cityid) {
		this._sql_cityid = _sql_cityid;
	}

	public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_se_wayattr(){
        return _se_wayattr;
    }

    public void set_se_wayattr(String _se_wayattr){
        this._se_wayattr = _se_wayattr;
    }

}
