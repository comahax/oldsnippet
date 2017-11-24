/**
* auto-generated code
* Tue Jul 31 17:05:40 CST 2012
*/
package com.sunrise.boss.business.cms.et.chetadtrecord.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChEtAdtrecordListVO</p>
 * <p>Description: Query Params Object for ChEtAdtrecordDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChEtAdtrecordListVO extends BaseListVO {
    private String _se_opnid;
    private String _se_calcmonth;
    private String _se_wayid;
    private String _se_mobile;
    private String _ne_rewardtype;
    private String _ne_batchno;
    private String _ne_rewardid;
    private String _ne_adtflag;

    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
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
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }
    public String get_ne_batchno(){
        return _ne_batchno;
    }

    public void set_ne_batchno(String _ne_batchno){
        this._ne_batchno = _ne_batchno;
    }
    public String get_ne_rewardid(){
        return _ne_rewardid;
    }

    public void set_ne_rewardid(String _ne_rewardid){
        this._ne_rewardid = _ne_rewardid;
    }

	public String get_ne_adtflag() {
		return _ne_adtflag;
	}

	public void set_ne_adtflag(String _ne_adtflag) {
		this._ne_adtflag = _ne_adtflag;
	}

}
