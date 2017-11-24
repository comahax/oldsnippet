/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.business.cms.adjustment.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AdjustmentListVO</p>
 * <p>Description: Query Params Object for AdjustmentDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AdjustmentListVO extends BaseListVO {
    private String _se_countyid;
    private String _se_rewardmonth;
    private String _se_wayid;
    private String _sql_batchno;
    private String _se_upperopnid;

	public String get_se_upperopnid() {
		return _se_upperopnid;
	}

	public void set_se_upperopnid(String _se_upperopnid) {
		this._se_upperopnid = _se_upperopnid;
	}

	public String get_sql_batchno() {
		return _sql_batchno;
	}

	public void set_sql_batchno(String _sql_batchno) {
		this._sql_batchno = _sql_batchno;
	}

	public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

}
