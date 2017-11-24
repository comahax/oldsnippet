/**
* auto-generated code
* Fri May 03 16:45:00 CST 2013
*/
package com.sunrise.boss.business.cms.dktersalereward.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: DktersalerewardListVO</p>
 * <p>Description: Query Params Object for DktersalerewardDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DktersalerewardListVO extends BaseListVO {
    private String _se_month;
    private String _se_ecpoperator;
    private String _se_wayname;
    private String _sk_wayname;
    private String _ne_cityid;

    public String get_se_month(){
        return _se_month;
    }

    public void set_se_month(String _se_month){
        this._se_month = _se_month;
    }
    public String get_se_ecpoperator(){
        return _se_ecpoperator;
    }

    public void set_se_ecpoperator(String _se_ecpoperator){
        this._se_ecpoperator = _se_ecpoperator;
    }
    public String get_sk_wayname(){
        return _sk_wayname;
    }

    public void set_sk_wayname(String _sk_wayname){
        this._sk_wayname = _sk_wayname;
    }
    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }

	public String get_se_wayname() {
		return _se_wayname;
	}

	public void set_se_wayname(String _se_wayname) {
		this._se_wayname = _se_wayname;
	}

}
