/**
* auto-generated code
* Wed Sep 10 11:22:49 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulerel.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RulerelListVO</p>
 * <p>Description: Query Params Object for RulerelDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerelListVO extends BaseListVO {
    private String _se_ruleitemid;
    private String _se_ruleid;
    private String _se_cityid;
    private String _ne_state;
    private Long _ne_rulemodeid;

    public Long get_ne_rulemodeid() {
		return _ne_rulemodeid;
	}

	public void set_ne_rulemodeid(Long _ne_rulemodeid) {
		this._ne_rulemodeid = _ne_rulemodeid;
	}

	public String get_se_ruleitemid(){
        return _se_ruleitemid;
    }

    public void set_se_ruleitemid(String _se_ruleitemid){
        this._se_ruleitemid = _se_ruleitemid;
    }
    public String get_se_ruleid(){
        return _se_ruleid;
    }

    public void set_se_ruleid(String _se_ruleid){
        this._se_ruleid = _se_ruleid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_ne_state(){
        return _ne_state;
    }

    public void set_ne_state(String _ne_state){
        this._ne_state = _ne_state;
    }

}
