/**
* auto-generated code
* Fri Jan 04 15:56:32 CST 2008
*/
package com.sunrise.boss.business.cms.resale.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ResaleListVO</p>
 * <p>Description: Query Params Object for ResaleDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResaleListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_mobile;
    private String _dnl_daytime;
    private String _dnm_daytime;
    private String _se_comresid;
    public String get_se_comresid() {
		return _se_comresid;
	}

	public void set_se_comresid(String _se_comresid) {
		this._se_comresid = _se_comresid;
	}

	public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_dnl_daytime(){
        return _dnl_daytime;
    }

    public void set_dnl_daytime(String _dnl_daytime){
        this._dnl_daytime = _dnl_daytime;
    }
    public String get_dnm_daytime(){
        return _dnm_daytime;
    }

    public void set_dnm_daytime(String _dnm_daytime){
        this._dnm_daytime = _dnm_daytime;
    }

}
