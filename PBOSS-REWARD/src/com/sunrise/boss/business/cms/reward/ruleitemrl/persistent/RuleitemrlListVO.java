/**
* auto-generated code
* Thu Sep 11 19:35:20 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitemrl.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RuleitemrlListVO</p>
 * <p>Description: Query Params Object for RuleitemrlDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemrlListVO extends BaseListVO {
    private String _se_ruleid;
    private String _ne_groupid;
    private String _se_ruleitemid;
    private String _ne_rltype;

    public String get_se_ruleid(){
        return _se_ruleid;
    }

    public void set_se_ruleid(String _se_ruleid){
        this._se_ruleid = _se_ruleid;
    }
    public String get_ne_groupid(){
        return _ne_groupid;
    }

    public void set_ne_groupid(String _ne_groupid){
        this._ne_groupid = _ne_groupid;
    }
    public String get_se_ruleitemid(){
        return _se_ruleitemid;
    }

    public void set_se_ruleitemid(String _se_ruleitemid){
        this._se_ruleitemid = _se_ruleitemid;
    }

	public String get_ne_rltype() {
		return _ne_rltype;
	}

	public void set_ne_rltype(String _ne_rltype) {
		this._ne_rltype = _ne_rltype;
	}

}
