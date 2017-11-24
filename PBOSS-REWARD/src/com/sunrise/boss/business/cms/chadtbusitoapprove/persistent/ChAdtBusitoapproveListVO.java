/**
* auto-generated code
* Tue Dec 20 12:00:28 CST 2011
*/
package com.sunrise.boss.business.cms.chadtbusitoapprove.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtBusitoapproveListVO</p>
 * <p>Description: Query Params Object for ChAdtBusitoapproveDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtBusitoapproveListVO extends BaseListVO {
    private String _se_approveid;
    private String _se_batchid;
    private String _se_opnid;
    private String _se_rewardtype;
    private String _se_region;
    private String _dnm_apptime;
    private String _dnl_apptime;


    public String get_se_approveid() {
		return _se_approveid;
	}

	public void set_se_approveid(String _se_approveid) {
		this._se_approveid = _se_approveid;
	}

	public String get_se_batchid(){
        return _se_batchid;
    }

    public void set_se_batchid(String _se_batchid){
        this._se_batchid = _se_batchid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_rewardtype(){
        return _se_rewardtype;
    }

    public void set_se_rewardtype(String _se_rewardtype){
        this._se_rewardtype = _se_rewardtype;
    }
    public String get_se_region(){
        return _se_region;
    }

    public void set_se_region(String _se_region){
        this._se_region = _se_region;
    }
    public String get_dnm_apptime(){
        return _dnm_apptime;
    }

    public void set_dnm_apptime(String _dnm_apptime){
        this._dnm_apptime = _dnm_apptime;
    }
    public String get_dnl_apptime(){
        return _dnl_apptime;
    }

    public void set_dnl_apptime(String _dnl_apptime){
        this._dnl_apptime = _dnl_apptime;
    }

}
