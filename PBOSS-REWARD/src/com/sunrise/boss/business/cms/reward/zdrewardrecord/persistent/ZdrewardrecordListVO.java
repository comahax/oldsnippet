/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZdrewardrecordListVO</p>
 * <p>Description: Query Params Object for ZdrewardrecordDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ZdrewardrecordListVO extends BaseListVO {
    private String _se_calcmonth;
    private String _se_wayid;
    private String _se_oprcode;
    private String _se_mobile;
    private String _dnm_oprtime;
    private String _dnl_oprtime;
    private String _se_batchno;
    private String _se_bakinfo;
    private String _ne_noncyc;
    private String _se_zdreward;
    private String _se_repairmonth;

    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_dnm_oprtime(){
        return _dnm_oprtime;
    }

    public void set_dnm_oprtime(String _dnm_oprtime){
        this._dnm_oprtime = _dnm_oprtime;
    }
    public String get_dnl_oprtime(){
        return _dnl_oprtime;
    }

    public void set_dnl_oprtime(String _dnl_oprtime){
        this._dnl_oprtime = _dnl_oprtime;
    }
    public String get_se_batchno(){
        return _se_batchno;
    }

    public void set_se_batchno(String _se_batchno){
        this._se_batchno = _se_batchno;
    }
    public String get_se_bakinfo(){
        return _se_bakinfo;
    }

    public void set_se_bakinfo(String _se_bakinfo){
        this._se_bakinfo = _se_bakinfo;
    }
    public String get_ne_noncyc(){
        return _ne_noncyc;
    }

    public void set_ne_noncyc(String _ne_noncyc){
        this._ne_noncyc = _ne_noncyc;
    }

	public String get_se_zdreward() {
		return _se_zdreward;
	}

	public void set_se_zdreward(String _se_zdreward) {
		this._se_zdreward = _se_zdreward;
	}

	public String get_se_repairmonth() {
		return _se_repairmonth;
	}

	public void set_se_repairmonth(String seRepairmonth) {
		_se_repairmonth = seRepairmonth;
	}

}
