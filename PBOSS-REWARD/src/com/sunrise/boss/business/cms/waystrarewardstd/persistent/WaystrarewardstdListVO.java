/**
* auto-generated code
* Fri Jul 08 11:36:28 CST 2011
*/
package com.sunrise.boss.business.cms.waystrarewardstd.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WaystrarewardstdListVO</p>
 * <p>Description: Query Params Object for WaystrarewardstdDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class WaystrarewardstdListVO extends BaseListVO {
    private String _ne_cityid;
    private String _ne_rewardtype;
    private String _se_wayid;
    private String _ne_rewardstd;

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_rewardstd() {
		return _ne_rewardstd;
	}

	public void set_ne_rewardstd(String _ne_rewardstd) {
		this._ne_rewardstd = _ne_rewardstd;
	}

    
    
}
