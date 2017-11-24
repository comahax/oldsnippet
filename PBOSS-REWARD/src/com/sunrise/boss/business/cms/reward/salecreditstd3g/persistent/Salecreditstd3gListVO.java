/**
* auto-generated code
* Tue Dec 11 09:30:18 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: Salecreditstd3gListVO</p>
 * <p>Description: Query Params Object for Salecreditstd3gDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class Salecreditstd3gListVO extends BaseListVO {
    private String _ne_busitype;
    private String _ne_cityid;

    public String get_ne_cityid() {
		return _ne_cityid;
	}

	public void set_ne_cityid(String _ne_cityid) {
		this._ne_cityid = _ne_cityid;
	}
	
    public String get_ne_busitype(){
        return _ne_busitype;
    }

    public void set_ne_busitype(String _ne_busitype){
        this._ne_busitype = _ne_busitype;
    }

}
