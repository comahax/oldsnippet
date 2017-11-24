/**
* auto-generated code
* Fri Feb 13 16:49:58 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChZjtyEmpltotalListVO</p>
 * <p>Description: Query Params Object for ChZjtyEmpltotalDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyEmpltotalListVO extends BaseListVO {
    private String _snm_yearmonth;
    private String _snl_yearmonth;
    private String _se_wayid;
    private String _se_yearmonth;
    public String get_snm_yearmonth(){
        return _snm_yearmonth;
    }

    public void set_snm_yearmonth(String _snm_yearmonth){
        this._snm_yearmonth = _snm_yearmonth;
    }
    public String get_snl_yearmonth(){
        return _snl_yearmonth;
    }

    public void set_snl_yearmonth(String _snl_yearmonth){
        this._snl_yearmonth = _snl_yearmonth;
    }

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_yearmonth() {
		return _se_yearmonth;
	}

	public void set_se_yearmonth(String _se_yearmonth) {
		this._se_yearmonth = _se_yearmonth;
	}

}
