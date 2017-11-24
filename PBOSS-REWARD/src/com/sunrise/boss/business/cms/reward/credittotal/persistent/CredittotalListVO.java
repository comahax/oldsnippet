/**
* auto-generated code
* Tue May 17 18:38:00 CST 2011
*/
package com.sunrise.boss.business.cms.reward.credittotal.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CredittotalListVO</p>
 * <p>Description: Query Params Object for CredittotalDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CredittotalListVO extends BaseListVO {
    private String _se_wayid;
    private String _ne_manageassess;
    private String _ne_assess;
    private String _se_calcmonth;
    
    

    public String get_ne_manageassess() {
		return _ne_manageassess;
	}

	public void set_ne_manageassess(String _ne_manageassess) {
		this._ne_manageassess = _ne_manageassess;
	}

	public String get_ne_assess() {
		return _ne_assess;
	}

	public void set_ne_assess(String _ne_assess) {
		this._ne_assess = _ne_assess;
	}

	public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

    
}
