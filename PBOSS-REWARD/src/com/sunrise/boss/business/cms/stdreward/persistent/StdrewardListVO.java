/**
* auto-generated code
* Fri Feb 01 18:05:53 CST 2008
*/
package com.sunrise.boss.business.cms.stdreward.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: StdrewardListVO</p>
 * <p>Description: Query Params Object for StdrewardDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardListVO extends BaseListVO {
	
    private String _ne_rewardid;
    private String _sk_rewardname;
    private String _dnl_startdate;
    private String _dnm_startdate;
    private String _dnl_stopdate;
    private String _dnm_stopdate;
    private String _ne_rewardtype;
    private String _ne_rewardproj;
    
    public String get_ne_rewardproj() {
		return _ne_rewardproj;
	}

	public void set_ne_rewardproj(String _ne_rewardproj) {
		this._ne_rewardproj = _ne_rewardproj;
	}

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_ne_rewardid(){
        return _ne_rewardid;
    }

    public void set_ne_rewardid(String _ne_rewardid){
        this._ne_rewardid = _ne_rewardid;
    }
    public String get_sk_rewardname(){
        return _sk_rewardname;
    }

    public void set_sk_rewardname(String _sk_rewardname){
        this._sk_rewardname = _sk_rewardname;
    }
    public String get_dnl_startdate(){
        return _dnl_startdate;
    }

    public void set_dnl_startdate(String _dnl_startdate){
        this._dnl_startdate = _dnl_startdate;
    }
    public String get_dnm_stopdate(){
        return _dnm_stopdate;
    }

    public void set_dnm_stopdate(String _dnm_stopdate){
        this._dnm_stopdate = _dnm_stopdate;
    }

	public String get_dnm_startdate() {
		return _dnm_startdate;
	}

	public void set_dnm_startdate(String _dnm_startdate) {
		this._dnm_startdate = _dnm_startdate;
	}

	public String get_dnl_stopdate() {
		return _dnl_stopdate;
	}

	public void set_dnl_stopdate(String _dnl_stopdate) {
		this._dnl_stopdate = _dnl_stopdate;
	}


}
