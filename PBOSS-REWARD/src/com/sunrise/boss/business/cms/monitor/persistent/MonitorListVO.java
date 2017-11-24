/**
* auto-generated code
* Fri Aug 24 15:10:13 CST 2012
*/
package com.sunrise.boss.business.cms.monitor.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: Monitor2ListVO</p>
 * <p>Description: Query Params Object for Monitor2DAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class MonitorListVO extends BaseListVO {
    private String _ne_cityid;
    private String _dnm_conoptime;
    private String _dnl_conoptime;
    private String _se_countyid;
    
    private String _rewardmonth;
    private String _countyid;
    private String _upperopnid;
    private String _lastdate2;
    private String _paymonth;
    
    public String get_paymonth() {
		return _paymonth;
	}

	public void set_paymonth(String _paymonth) {
		this._paymonth = _paymonth;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_rewardmonth() {
		return _rewardmonth;
	}

	public void set_rewardmonth(String _rewardmonth) {
		this._rewardmonth = _rewardmonth;
	}

	public String get_countyid() {
		return _countyid;
	}

	public void set_countyid(String _countyid) {
		this._countyid = _countyid;
	}

	public String get_upperopnid() {
		return _upperopnid;
	}

	public void set_upperopnid(String _upperopnid) {
		this._upperopnid = _upperopnid;
	}

	public String get_lastdate2() {
		return _lastdate2;
	}

	public void set_lastdate2(String _lastdate2) {
		this._lastdate2 = _lastdate2;
	}

	public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_dnm_conoptime(){
        return _dnm_conoptime;
    }

    public void set_dnm_conoptime(String _dnm_conoptime){
        this._dnm_conoptime = _dnm_conoptime;
    }
    public String get_dnl_conoptime(){
        return _dnl_conoptime;
    }

    public void set_dnl_conoptime(String _dnl_conoptime){
        this._dnl_conoptime = _dnl_conoptime;
    }

}
