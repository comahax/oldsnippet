/**
* auto-generated code
* Wed Dec 28 14:39:42 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtycompact.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyCompactListVO</p>
 * <p>Description: Query Params Object for ZjtyCompactDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyCompactListVO extends BaseListVO {
    private String _se_wayid;
    private String _ne_cityid;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

	public String get_ne_cityid() {
		return _ne_cityid;
	}

	public void set_ne_cityid(String neCityid) {
		_ne_cityid = neCityid;
	}

}
