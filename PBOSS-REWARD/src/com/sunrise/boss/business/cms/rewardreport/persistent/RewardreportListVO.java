/**
* auto-generated code
* Thu May 19 16:35:37 CST 2011
*/
package com.sunrise.boss.business.cms.rewardreport.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardreportListVO</p>
 * <p>Description: Query Params Object for RewardreportDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardreportListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_calcmonth;
    private String _de_sendtime;
    private String _se_countyid;
    private String audittype;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_de_sendtime(){
        return _de_sendtime;
    }

    public void set_de_sendtime(String _de_sendtime){
        this._de_sendtime = _de_sendtime;
    }

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

}
